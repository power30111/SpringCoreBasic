package hello.core.singleton;

public class SingletonService {
    //SingletonService를 실행하면 instance는 전체에서 참조가능(static)하며 상속안되면서(final) 직접 접근안되는(private)객체생성
    private static final SingletonService instance = new SingletonService();

    //public으로 열어서 객체 인스턴스가 필요하면 static 메서드를 통홰서만 조회하도록 한다.
    public static SingletonService getInstance(){
        return instance;
    }
    //생성자를 private로 선언해서 외부에서 new 를 통한 객체생성을 막는다
    private SingletonService(){

    }
    public void login(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
