import io.reactivex.rxjava3.subjects.ReplaySubject;

public class Ex9_ReplaySubject {
    public static void main(String[] args){
        /**
         * 구독자가 새로 생기면 항상 데이터의 처음부터 끝가지 발행하는 것을 보장
         */
        ReplaySubject<String> subject = ReplaySubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("Joey");
        subject.onNext("Chandler");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("Ross");
        subject.onComplete();
    }
}
