import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTests {

    @Test
    public void testClosestPairSmall() {
        // Малый массив для проверки
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0, 0),
                new ClosestPair.Point(1, 1),
                new ClosestPair.Point(2, 2),
                new ClosestPair.Point(3, 3)
        };
        double result = ClosestPair.closestPair(points);
        // Ожидаем 1.4142135623730951, но допускаем погрешность
        assertEquals(1.4142135623730951, result, 0.0001);  // Допускаем погрешность
    }

    @Test
    public void testClosestPairLarge() {
        // Большой массив для проверки с использованием быстрого алгоритма
        ClosestPair.Point[] points = new ClosestPair.Point[2000];
        for (int i = 0; i < points.length; i++) {
            points[i] = new ClosestPair.Point(i, i);  // Параллельные точки
        }
        double result = ClosestPair.closestPair(points);
        // Ожидаем 1.0, но допускаем погрешность
        assertEquals(1.0, result, 0.0001);  // Допускаем погрешность
    }
}
