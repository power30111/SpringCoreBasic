package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter //Lombok으로 getter 랑 setter 자동생성.
@Setter
@ToString //출력형식 지정가능
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asd");

        System.out.println("helloLombok = " + helloLombok);

    }
}
