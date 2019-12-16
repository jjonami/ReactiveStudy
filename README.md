## [RxJava 리액티브 프로그래밍 by.스다 토모유키], [RxJava 프로그래밍 by.유동환, 박정준]
### 1. RxJava의 기본
#### RxJava와 리액티브 프로그래밍
> + reactive programming은 data 흐름과 전달에 관한 programming paradigm
> + data 흐름을 먼저 정의하고 data가 변경되었을 때 연관되는 함수나 수식이 업데이트되는 방식
> + RxJava는 Java에서 reactive programming을 구현하는 데 사용하는 라이브러리
> + 이벤트 처리와 같은 비동기 처리에 최적화
> + 2.0 버전부터 Reactive Streams 사양을 구현
> + data 흐름 > data stream
> + Observer 패턴 확장 > 감시 대상 객체의 상태가 변하면 이를 관찰하는 객체에 알려주는 구조

#### Reactive Streams  
> + Publisher : data를 통지하는 생산자  
> + Subscriber : data를 받아 처리하는 소비자  
> + Subscriber가 Publisher를 subsribe(구독)  
> + Reactive Streams가 제공하는 protocol  
    - onSubscribe : data 통지가 준비됐음을 통지  
    - onNext : data 통지  
    - onError : error(비정상 종료) 통지  
    - onComplete : 완료(정상 종료) 통지  
> + Reactive Streams의 interface  
    - Publisher : data를 생성하고 통지  
    - Subscriber : 통지된 data를 전달받아 처리  
    - Subscription : data 개수를 요철, 구독을 해지  
    - Processor : Publisher와 Subscriber의 기능이 모두 있는 interface  
> + 기본 규칙  
    - onSubscribe()는 해단 stream에서 한 번만 발생한다.  
    - 통지는 순차적으로 이루어진다.  
    - null을 통지하지 않는다.  
    - Publisher의 처리는 onComplete() 또는 onError()를 통지해 종료한다.  
    
#### RxJava의 기본 구조  
#### 마블 다이어그램  
#### RxJava 예제  
#### RxJava의 전체 구성  


***
### 2. RxJava를 사용하는 데 필요한 배경 지식
#### 람다식
#### 비동기 처리


***
### 3. RxJava의 메커니즘
#### RxJava와 디자인 패턴
#### 비동기 처리
#### 에러 처리
#### 리소스 관리
#### 배압


***
### 4. Flowable과 Observable의 연산자
#### Flowable/Observable을 생성하는 연산자
#### 통지 데이터를 변환하는 연산자
#### 통지 데이터를 제어하는 연산자
#### Flowable/Observable을 결합하는 연산자
#### Flowable/Observable 상태를 통지하는 연산자
#### Flowable/Observable 데이터를 집계하는 연산자
#### 유틸리티 연산자


***
### 5. Processor와 Subject
#### Precessor/Subject
#### PublishProcessor/Publishsubject
#### BehaviorProcessor/Behaviorsubject
#### ReplayProcessor/ReplaySubject
#### AsyncProcessor/asyncSubject
#### unicastProcessor/UnicastSubject


***
### 6. RxJava의 디버깅과 테스트
#### 디버깅과 테스트
#### 'do'로 시작하는 메서드
#### 'blocking'으로 시작하는 메서드
#### Testsubscriber/TestObserver
#### TestScheduler
