import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static List<Integer> list = new ArrayList<>(List.of(1, 2, 6, 2, 89, 45, 5, 23, 34, 100));
    public static Stream<Integer> stream = list.stream();
    public static Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer
    ) {

        List<? extends T> list1 = stream.sorted(order)
                .collect(Collectors.toList());
        System.out.println(list1);
        if (!list1.isEmpty()) {
            minMaxConsumer.accept(list1.get(0), list1.get(list1.size() - 1));
        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public static void intNumber(List<Integer> list){
        List<Integer> collect = list.stream()
                .filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println( "Количество четных чисел в коллекции " + collect.size() + "\n"
                + collect.toString());
    }

    public static void main(String[] args) {

        findMinMax(stream, comparator, (x, y) -> System.out.println("min = " + x + " || max= " + y));
        intNumber(list);
    }
}