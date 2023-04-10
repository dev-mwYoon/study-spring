package com.example.ex00.dependency;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data // 롬복에서 초기화 생성자를 만드니까
//@NoArgsConstructor // 기본 생성자를 만들어서 오류내려고 붙인 어노테이션
@RequiredArgsConstructor //final 키워드 혹은 nonnull 키워드가 붙어있는 필드만 초기화 생성자로 만들어주는 애
public class Coding {
    /*강사님 필기*/
//    필드 주입
//    사용 방법이 매우 편하다는 장점이 있다.
//    주입된 객체를 불변(imutable)상태로 만들 수 없기 때문에 외부에서 수정될 위험이 있다.
//    순환 참조 발생 시 Application 동작 시점과 Runtime 시점 중 필드 주입(injection)은 Runtime 시점에 해당하기 때문에
//    메모리에 계속 할당되고 StackOverFlow가 발생했다. 하지만 2.6버전 이상부터는 Application 동작 시점에서 잡힌다.
//    Spring이 아니면 해당 필드에 주입할 수 있는 방법이 없다.
//    생성 후 주입. 생성 시점에서는 순환 참조의 여부를 알 수 없다.


    /*나*/
//    private Computer computer/* = new Computer() 생성자 대신 injection(주입)을 받는다 */;
//    final을 붙이는 이유는 injection할 때 주소 값이 변형되면 안될 때
//    근데 아래에서 오류나는 이유는 초기 값이 없는데 외부에서 값 변형을 못하게 final로 막았기 때문에
//    즉, 외부에서 초기화 생성자를 사용하게 되면 기존 주소값이 변형되기 때문에 그걸 막기 위해 final을 사용하는데
//    아래와 같이 초기 값이 없는 경우 final을 사용 시, 오류가 난다.
//    생성 후 주입. 생성 시점에서는 순환 참조의 여부를 알 수 없다.
//

//    @Autowired
//    private final Computer computer;

//    Setter 주입
//    주입받는 객체가 변경될 가능성이 있는 경우에 사용한다.
//    OCP(Open-Closed Principle, 개방-폐쇄 원칙)를 위반하기 때문에 변경 가능성을 배제하고 불변성을 보장하는 것이 좋다.
//    생성 후 주입. 생성 시점에서는 순환 참조의 여부를 알 수 없다.
    
//    private Computer computer;
//
//    @Autowired
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

//    생성자 주입
//    불변성을 가지기 때문에 해당 필드에 final 키워드를 작성할 수 있다.
//    컴파일 시점에서 주입 문제 발생을 확인할 수 있으며, 객체를 생성하는 시점에서 
//    Bean객체를 필수로 초기화하기 때문에 NPE를 방어할 수 있다.
//    순환 ㅊ마조 발생 시 Runtime 시점(필드를 올리기) 이전에 감지가 되기 때문에 안전하다.
//    주입 후 생성. 생성 시 순환참조 발생 여부를 알 수 있기 때문에 Application 실행 시점에서 순환참조 오류를 발견할 수 있다.
    
//    결론은 생성자 주입만 사용
    
    private final Computer computer;

//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}
