import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMap {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result = list.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        result.forEach(System.out::println);

    }

    @Test
    public void test2() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);

        List<int[]> list = list1.stream()
                .flatMap(i -> list2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
