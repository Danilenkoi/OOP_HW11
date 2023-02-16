import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import java.util.stream.Stream;
public class Main {

    // Задание 1

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }
    public static void main(String[] args) {

        Stream<Integer> stream = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12)).stream();

        findMinMax(stream,(x, y) -> x.compareTo(y), (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y)));

        stream.close();

        // Задание 2

        List <Integer> someNumbers = Arrays.asList(20, 21, 22, 23, 24, 25, 26, 27, 28, 29);

        List <Integer> evenNumbers = someNumbers.stream().filter(Objects::nonNull).filter(number -> number % 2 == 0).collect(Collectors.toList());
        System.out.println("Четные числа из списка : " + evenNumbers);

    }
}