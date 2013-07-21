package aaa;

import java.util.function.Consumer;

/**
 * Created by zuruzirou on 2013/07/21.
 */
public class Example2 {
    private String s = "first";
    public static void main(String[] args) {
        Example2 main = new Example2();
        Consumer<Integer> h1 = main::hoge1;
        h1.accept(3);
        main.s = "second";
        h1.accept(4);
    }

    public String hoge1(int i) {
        System.out.println(s + i);
        return "ret=" + i;
    }

}
