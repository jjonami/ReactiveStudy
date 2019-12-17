## [RxJava 리액티브 프로그래밍 by.스다 토모유키], [RxJava 프로그래밍 by.유동환, 박정준]
### 1. RxJava의 기본
##### RxJava와 리액티브 프로그래밍
> + reactive programming은 데이터 흐름과 전달에 관한 programming paradigm
> + 데이터 흐름을 먼저 정의하고 데이터가 변경되었을 때 연관되는 함수나 수식이 업데이트되는 방식
> + RxJava는 Java에서 reactive programming을 구현하는 데 사용하는 라이브러리
> + 이벤트 처리와 같은 비동기 처리에 최적화
> + 2.0 버전부터 Reactive Streams 사양을 구현
> + 데이터 흐름 > 데이터 stream
> + Observer 패턴 확장 > 감시 대상 객체의 상태가 변하면 이를 관찰하는 객체에 알려주는 구조

##### Reactive Streams  
> + Publisher : 데이터를 통지하는 생산자  
> + Subscriber : 데이터를 받아 처리하는 소비자  
> + Subscriber가 Publisher를 subsribe(구독)  
> + Reactive Streams가 제공하는 protocol  
>   - onSubscribe : 데이터 통지가 준비됐음을 통지
>   - onNext : 데이터 통지
>   - onError : error(비정상 종료) 통지
>   - onComplete : 완료(정상 종료) 통지  
> + Reactive Streams의 interface  
>   - Publisher : 데이터를 생성하고 통지
>   - Subscriber : 통지된 데이터를 전달받아 처리
>   - Subscription : 데이터 개수를 요철, 구독을 해지
>   - Processor : Publisher와 Subscriber의 기능이 모두 있는 interface  
> + 기본 규칙
>   - onSubscribe()는 해단 stream에서 한 번만 발생한다.
>   - 통지는 순차적으로 이루어진다.
>   - null을 통지하지 않는다.
>   - Publisher의 처리는 onComplete() 또는 onError()를 통지해 종료한다.  
    
##### RxJava의 기본 구조  
##### 마블 다이어그램 
##### RxJava 예제  
##### RxJava의 전체 구성  


***
### 2. RxJava를 사용하는 데 필요한 배경 지식
##### 람다식
##### 비동기 처리


***
### 3. RxJava의 메커니즘
##### RxJava와 디자인 패턴
##### 비동기 처리
##### 에러 처리
##### 리소스 관리
##### 배압


***
### 4. Flowable과 Observable의 연산자
> + Observable class는 상황에 맞게 세분화해 각 Observable, Maybe, Flowable class로 구분해 사용
>   - Maybe : reduce(), firstElement()와 같이 데이터가 발행될 수 있거나 혹은 발행되지 않고도 완료되는 경우
>   - Flowable : 데이터가 발행되는 속도가 구독자가 처리하는 속도보다 현저하게 빠른 경우 발생하는 배압(Back pressure)이슈에 대응하는 기능을 추가로 제공
  
##### Flowable/Observable을 생성하는 연산자
##### 통지 데이터를 변환하는 연산자
##### 통지 데이터를 제어하는 연산자
##### Flowable/Observable을 결합하는 연산자
##### Flowable/Observable 상태를 통지하는 연산자
##### Flowable/Observable 데이터를 집계하는 연산자
##### 유틸리티 연산자

##### Observable class
> + Observable은 Observer pattern을 구현
> + 세 가지 알림을 구독자에게 전달
>   - onNext : 데이터 발행을 알림
>   - onComplete : 모든 데이터 발행을 완료했음을 알림. 단 한번만 발생, 발생 후 onNext를 발생해선 안됨
>   - onError : error가 발생했음을 알림. 이후 onNext, onComplete가 발하지 않음.
> + Single class : 오직 1개의 데이터만 발행하도록 한정 
>   - ex) 결과가 유일한 서버 API를 호출할 때
>   - 데이터 하나가 발행과 동시에 종료 (onSuccess)
> + Maybe class : 데이터를 0~1개 발행
> + Hot Observables
>   - 구독자 존재 여부와 관계없이 데이터 발행
>   - 배압(back pressure)을 고려해야 함
>   - ex) 마우스 이벤트, 키보드 이벤트, 시스템 이벤트, 센서 에이터, 주식 가격
> + Cold Observables (default)
>   - observer가 subscribe 하지 않으면 데이터 발행 안함
>   - 게으른(lazy) 접근법
>   - ex)웹 요청, DB쿼리, 파일 읽기


***
### 5. Processor와 Subject
> + Subject class 목적은 Cold Observable > Hot Observable
##### Precessor/Subject
##### PublishProcessor/PublishSubject
> + PublishSubject : subscribe() 호출 > 값 발행 시작
##### BehaviorProcessor/BehaviorSubject
> + BehaviorSubject : 가장 최근 값 or 기본값
##### ReplayProcessor/ReplaySubject
> + ReplaySubject 
>   - Cold a_observable 처럼 동작
>   - 구독자가 새로 생기면 항상 데이터의 처음부터 끝가지 발행하는 것을 보장
##### AsyncProcessor/AsyncSubject
> + AsyncSubject : 마지막 값
##### unicastProcessor/UnicastSubject


***
### 6. RxJava의 디버깅과 테스트
##### 디버깅과 테스트
##### 'do'로 시작하는 메서드
##### 'blocking'으로 시작하는 메서드
##### Testsubscriber/TestObserver
##### TestScheduler