import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Ex5_Single {
    public static void main(String[] args){
        Single<String> source = Single.just("Hello Single");
        source.subscribe(System.out::println);

        fromObservable();
    }

    /**
     * Single : 오직 1개의 data만 발행하도록 한정
     * Observable class에서 Single class 활용하는 방법
     */
    private static void fromObservable(){
        //1. Observable > Single
        Observable<String> source = Observable.just("Hello World");
        Single.fromObservable(source)
                .subscribe(System.out::println);

        //2. single() 호출로 Single 객체 생성
        Observable.just("Chicken")
                .single("default item")
                .subscribe(System.out::println);

        //3. first() 호출로 Single 객체 생성
        String[] colors = {"Red", "Green", "Blue"};
        Observable.fromArray(colors)
                .first("default value")
                .subscribe(System.out::println);

        //4. empty Observable에서 Single 객체 생성
        Observable.empty()
                .single("default item")
                .subscribe(System.out::println);

        //5. take() 호출로 Single 객체 생성
        Observable.just(new Something("first"), new Something("second"))
                .take(1)
                .single(new Something("default something"))
                .subscribe(System.out::println);
    }

}

class Something{
    private String name;

    public Something(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "observable.Something{" +
                "name='" + name + '\'' +
                '}';
    }
}