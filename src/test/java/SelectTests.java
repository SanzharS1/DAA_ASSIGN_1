import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class SelectTests {

    @Test
    public void testDeterministicSelect() {
        // Случайные данные
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        Arrays.sort(arr); // Для правильной проверки, сортируем массив
        int k = 3; // Например, ищем 3-й минимальный элемент
        int expected = arr[k]; // Это значение должно быть равно тому, что вернет ваш алгоритм

        // Используем алгоритм Deterministic Select
        int selectResult = DeterministicSelect.deterministicSelect(arr, 0, arr.length - 1, k);

        // Сравниваем с результатом, который возвращает Arrays.sort
        assertEquals(expected, selectResult);
    }
}
