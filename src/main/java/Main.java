import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//        String a = "String";
//        String b = "bbbbbb";
//
//        String s = (a + b).intern();
//        String d = (a + b).intern();
//        System.out.print(s==d);
        d().forEach(i -> System.out.print(i + ", "));

    }

    private static List<Integer> d(){
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4,5);
        Stream<Integer> stream2 = Stream.of(  6, 5,1);
        Stream<Integer> stream3 = Stream.of(18, 15, 36, 2,6,3);

        return Stream.concat(Stream.concat(stream1, stream2), stream3)
                .distinct()
                .collect(Collectors.toList());
    }
}
