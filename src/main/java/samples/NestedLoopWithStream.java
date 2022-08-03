package samples;

import java.util.List;

public class NestedLoopWithStream {
    static List<List<Integer>> list = List.of(List.of(1,2,3,4,5),List.of(11,12,13,14,15));
    public static void main(String[] args){
        list.stream().flatMap(e->e.stream()).forEach(System.out::println);
    }

}
