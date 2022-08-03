package samples;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;


@Slf4j
public class NestedLoopWithStream {

    public static final String result = "Result: {}";

    public static void main(String[] args){
        naturalSortExample();
    }

    private static void findAnyExample() {
        Integer[] empIds = {1,2,3,4};
        Integer val = Stream.of(empIds)
                .findAny()
                .orElse(null);
        log.info(result,val);
    }

    private static void findFirstExample() {
        Integer[] empIds = {1,2,3,4};
        Integer val = Stream.of(empIds)
                .findFirst()
                .orElse(null);
        log.info(result,val);
    }

    private static void peekExample() {
        List<Integer> list = new ArrayList<>();
        List<Integer> val = Stream.of(1, 2, 3, 4)
                .peek(list::add)
                .map(x -> x * 2)
                .filter(x->x>8)
                .toList();

        long count = Stream.of(1, 2, 3, 4)
                .peek(list::add)
                .count();

        log.info(result,list);
        log.info(result,val);
        log.info(result,count);
    }

    private static void naturalSortExample() {
        List<Integer> val = Stream.of(1, 2, 3, 4, 6, 8, 10)
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .toList();
        log.info(result,val);
        List<Integer> val1 = Stream.of(1, 2, 3, 4, 6, 8, 10)
                .sorted((e1,e2)-> e2 - e1)
                .toList();
        log.info(result,val1);
    }

    private static void flatMapExample() {
        List<List<List<Integer>>> list = List.of(List.of(List.of(111,112,113,114,115),List.of(1111,1112,1113),List.of(1,2,3,4,5),List.of(11,12,13)));
        list.stream().flatMap(Collection::stream).flatMap(Collection::stream).forEach(val -> log.info(result,val));
    }

}
