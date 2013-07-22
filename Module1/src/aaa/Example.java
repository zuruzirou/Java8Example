package aaa;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by zuruzirou on 2013/07/21.
 */
public class Example {
    public static void main(String[] args) {
        Consumer<String> p = System.out::println;
        p.accept("aaa");
        p.accept("aaa2");

        Function<Integer, Integer> f3 = i -> i * 2;
        int ret = f3.apply(1);
        System.out.println("ret=" + ret);

        BiFunction<Integer, Integer, String> f4 = (i, j) -> "hoge:" + i + j;
        String ret2 = f4.apply(10, 20);

        p.accept(f4.apply(10, 30));

        Consumer<Integer> g1 = Example::gogo1;
        g1.accept(10);
        g1.chain(g1).accept(10);

        Example main = new Example();
        Consumer<Integer> g2 = main::gogo2;

        Arrays.asList(1, 2, 3, 4)
                .stream()
                .filter(i -> i > 2)
                .forEach(System.out::println);
//        Seq.apply(1, 2, 3, 4, 5).filter( i -> i > 2 );
//        System.out.println("eeee"+args);
    }

    public static String gogo1(int i) {
        String s = "aaa" + i;
        return s;
    }

    public String gogo2(int i) {
        return "aa:" + i;
    }

}
