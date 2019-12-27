package RRP;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class L01_FlowableSample {
    public static void main(String[] args) throws Exception{

        //Flowable 생성
        Flowable<String> flowable = Flowable.create(emitter -> {
            String[] datas = {"Hello, World!", "My RxJava Study"};

            for(String data: datas){
                //구독이 해지되면 처리를 중단
                if(emitter.isCancelled()) return;
                //데이터 통지
                emitter.onNext(data);
            }

            //완료 통지
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER); //초과 데이터는 버퍼링

        flowable
            //Subscriber 처리를 개별 스레드에서 실행
            .observeOn(Schedulers.computation())
            //구독
            .subscribe(new Subscriber<String>(){
                //데이터 개수 요청, 구독 해지 객체
                private Subscription subscription;

                //구독 시작 시 처리
                @Override
                public void onSubscribe(Subscription s) {
                    //Subscription을 Subscriber에 보관
                    this.subscription = s;
                    //받을 데이터 개수 요청
                    this.subscription.request(1L);
                }

                //데이터 받을 때 처리
                @Override
                public void onNext(String s) {
                    //실행 중 스레드 이름 얻기
                    String threadName = Thread.currentThread().getName();
                    //받은 데이터 출력
                    System.out.println(threadName + ": " + s);
                    //다음에 받을 데이터 개수 요청
                    this.subscription.request(1L);
                }

                //완료 통지 시 처리
                @Override
                public void onComplete() {
                    //실행 중 스레드 이름 얻기
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + ": Fin.");
                }

                //에러 통지 시 처리
                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }
            });
            Thread.sleep(500L);
    }
}

