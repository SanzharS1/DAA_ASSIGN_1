import java.io.FileWriter;
import java.io.IOException;

public class Metrics {

    private static int comparisons = 0;
    private static int depth = 0;

    public static void resetCounters() {
        comparisons = 0;
        depth = 0;
    }

    public static void incrementComparisons() {
        comparisons++;
    }

    public static void incrementDepth() {
        depth++;
    }

    public static void writeToCSV(String algorithm, int n, long time) {
        try (FileWriter writer = new FileWriter("metrics.csv", true)) {
            writer.append(algorithm + "," + n + "," + time + "," + comparisons + "," + depth + "\n");
        } catch (IOException e) {
            System.out.println("Error entry in file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static int getComparisons() {
        return comparisons;
    }

    public static int getDepth() {
        return depth;
    }

    public static void main(String[] args) {
        resetCounters();

        incrementComparisons();
        incrementDepth();

        writeToCSV("MergeSort", 7, 1500);
    }
}
