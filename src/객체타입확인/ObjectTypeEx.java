package 객체타입확인;
// 객체 타입 확인 : instanceof
// 반환값(true/false) = 좌항(객체) instanceof 우항(클래스)
// 객체가 특정 클래스의 인스턴스인지를 확인하기 위해 사용
public class ObjectTypeEx {
    public static void main(String[] args) {
        Parent parent = new Parent("부모");
        Child child = new Child("자식");

        System.out.println(parent instanceof Parent);   // 출력결과 : true
        System.out.println(child instanceof Child);     // 출력결과 : true , 부모 클래스를 가지고 자식객체를 바라보기 때문에 상속관계가 존재하며 접근가능 (단, 오버라이딩 관계가 성립되어야한다.)
        System.out.println(child instanceof Parent);    // 출력결과 : true
        System.out.println(parent instanceof Child);    // 출력결과 : false, 자식 클래스를 가지고 부모객체를 바라볼 수 없다.
    }
}
class Parent{
    String name;

    public Parent(String name){
        this.name = name;
    }
}
class Child extends Parent{
    String name;
    public Child(String name){
        super(name);
        this.name = name;
    }
}
