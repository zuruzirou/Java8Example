package aaa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: zuruzirou
 * Date: 2013/08/08
 * Time: 6:37
 * To change this template use File | Settings | File Templates.
 */
public class SearchRecursive {
    private static String path = "/Users/zuruzirou/phonegap/hello";

    public static void main(String[] args) throws IOException {
//        list(Paths.get(path));
        Files.list(Paths.get(path))
                .flatMap(SearchRecursive::list)
                .forEach(p -> System.out.println(p));
    }

    public static Stream<Path> list(Path p) {
        try {
            return Files.list(p).flatMap(SearchRecursive::list2);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public static Stream<Path> list2(Path p) {
        if (p.toFile().isDirectory()) {
            return list(p);
        } else {
            return Stream.of(p);
        }
    }
}
