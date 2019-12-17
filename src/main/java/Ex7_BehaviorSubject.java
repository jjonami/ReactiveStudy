import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class Ex7_BehaviorSubject {
    public static void main(String[] args){
        exam();
    }

    /**
     * BehaviorSubject : 가장 최근 값 혹은 기본값을 넘겨주는 class
     */
    public static void exam(){
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("Home");
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("Work");
        subject.onNext("Pub");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("Home");
        subject.onComplete();
    }
}
