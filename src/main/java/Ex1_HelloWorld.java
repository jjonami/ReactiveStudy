import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class Ex1_HelloWorld {
    public static void main(String[] args){
        Flowable<String> flowable = Flowable.just("Hello", "World");
        flowable.subscribe(data -> System.out.println(data));
    }

    /**
     *
    [생산자]
    public interface Publisher<T>{
        //Subscriber 등록
        public void subscribe(Subscriber<? super T> subscriber);
    }

    [소비자]
    public interface Subscriber<T>{
        //구독 시작 처리
        public void onSubscribe(Subscription subscription);
        //data 통지 처리
        public void onNext(T item);
        //Error 통지 처리
        public void onError(Throwable error);
        //완료 통지 처리
        public void onComplete();
    }

    [생산자-소비자 연결 interface]
    public interface Subscription{
        //통지받을 data 개수 요청
        public void request(long num);

        //구독 해지
        public void cancel();
    }

    [Publisher + Subscriber 기능이 모두 있는 interface]
    public abstract interface Processor<T, R> extends Subscriber<T>, Publisher<T>{ }
     *
     */


}
