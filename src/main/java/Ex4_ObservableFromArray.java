import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Ex4_ObservableFromArray {
    public static void main(String[] args){
        System.out.println("arrayInteger()");
        arrayInteger();
        System.out.println("\narrayInt()");
        arrayInt();
        System.out.println("\nlistExam()");
        listExam();
        System.out.println("\nsetExam()");
        setExam();
    }

    public static void arrayInteger(){
        Integer[] arr = {100, 200, 300};
        Observable<Integer> source = Observable.fromArray(arr);
        source.subscribe(System.out::println);
    }

    public static void arrayInt(){
        int[] arr = {400, 500, 600};
        Observable<Integer> source = Observable.fromArray(toIntegerArray(arr));
        source.subscribe(System.out::println);
    }

    private static Integer[] toIntegerArray(int[] arr){
        return IntStream.of(arr).boxed().toArray(Integer[]::new);
    }

    public static void listExam(){
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("John");
        names.add("Alice");

        Observable<String> source = Observable.fromIterable(names);
        source.subscribe(System.out::println);
    }

    public static void setExam(){
        Set<String> cities = new HashSet<>();
        cities.add("Seoul");
        cities.add("Paris");
        cities.add("New York");

        Observable<String> source = Observable.fromIterable(cities);
        source.subscribe(System.out::println);
    }
}

