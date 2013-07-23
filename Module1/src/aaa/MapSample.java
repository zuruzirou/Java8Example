package aaa;

import javax.xml.transform.stream.StreamSource;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by zuruzirou on 2013/07/22.
 */
public class MapSample {
    private static IntConsumer ci = System.out::println;
    private static Consumer<String> cs = System.out::println;
    private static Consumer<String> cs2 = s -> ci.accept(s.hashCode());
    private static List<String> list = Arrays.asList("abc", "abc1", "abc12", "abc123");
    private static List<String> list2 = Arrays.asList("AA", "BB", "CC", "DD");
    private static List<Clone1> clList = Arrays.asList(new Clone1(), new Clone1(), new Clone1());

    public static void hoge(String str) {

    }

    public static void main(String[] args) {
        MapSample main = new MapSample();

        list.stream().forEach(System.out::println);

//        Streams

        System.out.println("------");
    }

    public static void flatMapSample() {
        // 総当り
        list.stream().flatMap(s -> IntStream.range(95, 99).mapToObj(i -> s + i)).forEach(cs);
        System.out.println("------");
        // map内ではflatMap/map両方の変数が参照でき、戻り値はstreamとなる
        list.stream().flatMap(
                fn -> list2.stream().filter(s -> s.length() > 1).map(
                        sn -> String.join(" ", fn, sn))
        ).forEach(cs);
    }

    public static void matchSample() {
        // 全ての要素が条件に一致するかチェック
        System.out.println(list.stream().allMatch(s -> s.contains("a")));
        // 条件に一致する要素が１件でもあるかチェック
        System.out.println(list.stream().anyMatch(s -> s.contains("12")));
    }

    public static void peekSample() {
        cs.accept("---- gogo1");
        // peek内に記載した処理はforEachを実行しないと実行されない
        list.stream().peek(s -> System.out.println("[" + s + "]")).peek(s -> System.out.print("{" + s + "}"));
        list.stream().peek(s -> System.out.println("[" + s + "]")).peek(s -> System.out.print("{" + s + "}")).
                forEach(MapSample::hoge);
        cs.accept("---- gogo2");
//        list.stream().peek(s -> System.out.println(s)).distinct().peek(cs2);

        // ネットで見かけたサンプル
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
    }
}
