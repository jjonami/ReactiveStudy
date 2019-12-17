import io.reactivex.rxjava3.subjects.PublishSubject;

public class Ex8_PublishSubject {

    public static void main(String[] args){
        /**
         * PublishSubject : subscribe() 호출 > 값 발행 시작
         */
        PublishSubject<String> subject = PublishSubject.create();
        subject.subscribe(data -> System.out.println("Subscriber #1 => " + data));
        subject.onNext("Car");
        subject.onNext("Train");
        subject.subscribe(data -> System.out.println("Subscriber #2 => " + data));
        subject.onNext("Airport");
        subject.onComplete();
    }
}
