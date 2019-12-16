import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Ex2_ObservableNotifications {
    public static void main(String[] args){
        Observable<String> source = Observable.just("RED", "GREEN", "BLUE", "YELLOW");

        Disposable d =  source.subscribe(
                v -> System.out.println("onNext() : value : " + v),
                err -> System.err.println("onError() : err : " + err.getMessage()),
                () -> System.out.println("onComplete()")
        );

        System.out.println("isDisposed() : " + d.isDisposed());
    }
}
