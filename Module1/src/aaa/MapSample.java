package aaa;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by zuruzirou on 2013/07/22.
 */
public class MapSample {
    public static void main(String[] args) {
        IntConsumer ci = System.out::println;
        Consumer<String> cs = System.out::println;
        MapSample main = new MapSample();
        Consumer<String> cs2 = s -> ci.accept(s.hashCode());

        List<String> list = Arrays.asList("abc", "abc1", "abc12", "abc123");
        list.stream().forEach(System.out::println);
        System.out.println(list.stream().allMatch(s -> s.contains("a")));
        System.out.println(list.stream().anyMatch(s -> s.contains("12")));

        List<Clone1> clList = Arrays.asList(new Clone1(), new Clone1(), new Clone1());
//        System.out.println("--- hashCode");
//        clList.stream().map(s -> s.toString()).forEach(cs);
//        System.out.println("--- hashCode");
//        clList.stream().map(s -> s.toString()).forEach(cs);
//        System.out.println("--- hashCode");
//        clList.stream().distinct().map(s -> s.toString()).forEach(cs);
//
//        cs.accept("---");
//        list.stream().filter(s -> s.length() >= 5).distinct().forEach(cs);

        cs.accept("---- gogo");
//        list.stream().peek(s -> System.out.println(s)).forEach();
        cs.accept("---- gogo");
//        list.stream().peek(s -> System.out.println(s)).distinct().peek(cs2);

        Stream<String> stream = Stream.of("Java", "Groovy", "Scala", "Clojure", "Kotlin", "Jython", "JRuby");

        stream.peek(s -> System.out.println("[" + s + "]"))    // デバッグのための表示
                .peek(s -> {
                    assert s.length() == 1;
                })    // テスト
                .map(s -> s + " ")
                .peek(s -> {
                    assert s.length() == 2 && s.endsWith(" ");
                })    // テスト
                .forEach(System.out::print);


        System.out.println("------");
//        list.stream().flatMap(s -> IntStream.range(95, 99).mapToObj(i -> s + i)).forEach(System.out::println);
        System.out.println("------");
//        list.stream().flatMap(
//                fn -> Arrays.asList("A", "AB", "ABC").stream().filter(s -> s.length() > 1).map(
//                        sn -> String.join(" ", fn, sn))
//        ).forEach(System.out::println);
    }

}
