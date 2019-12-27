package RRP;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class L02_SingleSmaple {
    public static void main(String[] args) throws Exception{
        //Single 생성
        Single<DayOfWeek> single = Single.create(emitter -> {
            emitter.onSuccess(LocalDate.now().getDayOfWeek());
        });

        //구독
        single.subscribe(new SingleObserver<DayOfWeek>() {
            //구독 준비가 됐을 때 처리
            @Override
            public void onSubscribe(Disposable d) {
                //Do something...
            }

            //데이터 통지 받았을 때 처리
            @Override
            public void onSuccess(DayOfWeek dayOfWeek) {
                System.out.println(dayOfWeek);
            }

            //에러 통지 받았을 때 처리
            @Override
            public void onError(Throwable e) {
                System.out.println("Error : " + e);
            }
        });
    }
}
