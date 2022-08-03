package samples;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.*;

public class NestedLoopWithStream {

    public static void main(String[] args){
        flatMapExample();
    }

    private static void findAnyExample() {
        Integer[] empIds = {1,2,3,4};
        Integer val = Stream.of(empIds)
                .findAny()
                .orElse(null);
        out.println(val);
    }

    private static void findFirstExample() {
        Integer[] empIds = {1,2,3,4};
        Integer val = Stream.of(empIds)
                .findFirst()
                .orElse(null);
        out.println(val);
    }

    private static void flatMapExample() {
        List<List<List<Integer>>> list = List.of(List.of(List.of(111,112,113,114,115),List.of(1111,1112,1113),List.of(1,2,3,4,5),List.of(11,12,13)));
        list.stream().flatMap(Collection::stream).flatMap(Collection::stream).forEach(out::println);
    }


}
