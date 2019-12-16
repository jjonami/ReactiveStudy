import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;

public class Ex3_ObservableCreate {
    public static void main(String[] args){
        basic();
    }

    public static void basic(){
        /**
         * Observable.create() 사용시 주의사항
         * 1. Observable이 구독 해지(dispose)되었을 때 등록된 callback을 모두 해제해야 한다.
         * 2. 구동하는 동안에만 onNext, onComplete 이벤트를 호출해야 한다.
         * 3. 오직 onError 이벤트로만 에러를 전달해야 한다.
         * 4. 배압(back pressure)을 직접 처리해야 한다.
         */
        //Cold Observable
        Observable<Integer> source = Observable.create(
            (ObservableEmitter<Integer> emitter) -> {
                emitter.onNext(100);
                emitter.onNext(200);
                emitter.onNext(300);
                emitter.onNext(400);
                emitter.onComplete();
            }
        );

        /**
         * subscribe()를 호출하지 않으면 아무것도 출력되지 않는다.
         */
//        source.subscribe(System.out::println);
        source.subscribe(data -> System.out.println("Result : " + data));

        /**
         * System.out::println : Method Reference
         * Method Reference를 사용할 때 고려해야 할 우선순위
         * 1. Method Reference로 축약할 수 있는지 확인
         * 2. 람다 표현식을 활용할 수 있는지 확인
         * 3. 1~2를 활용할 수 없으면 익명 객체나 멤버 변수로 표현
         */
    }

}
