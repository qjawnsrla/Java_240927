package 상속기본;
// 자식 클래스가 부모 클래스의 기능을 그대로 물려받는 것
// 상속받은 자식클래스는 부모클래스와 같거나 크다.
// 부모클래스가 먼저 생성되고 자식클래그가 생성됨, 소멸 시에는 자식 클래스가 사라지고 부모클래스가 소멸
// 사용하는 이유는 재사용성, 확장성, 다형성(오버라이딩, 상속받은 기능을 재정의하는 것)
// 자바는 다중 상속을 지원하지 않는다 (다중상속과 유사한 기능을 제공하기 위해서 인테페이스가 있음)
// 키워드 extends
// 상속을 받지 않은 클래스는 기본적으로 Object 클래스로부터 상속을 받음
// 오버라이딩은 부모가 물려준 기능 재정의 하는 것 (재정의 하지 않으면 부모의 메소드가 호출됨)

public class InheritanceBasicEx {
    public static void main(String[] args) {
        Animal animal = new Animal();
        // 부모 클래스에서 물려줬기때문에 dog클래스에서도 setName, getName 사용 가능
        Dog dog = new Dog();
        dog.setName("댕댕이");
        System.out.println(dog.getName());
        HouseDog houseDog = new HouseDog();
        houseDog.setName("멍멍이");
        houseDog.sleep();   // 만약 따로 재정의를 하지 않았다면 부모의 특성을 그대로 물려받아 사용한다.
        houseDog.sleep(4);
    }
}
// class Animal extends Object{
class Animal {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Dog extends Animal {
    void sleep(){
        System.out.println(name+" zzz");
    }
}

class HouseDog extends Dog {
    @Override       // @어노테이션, 문법적으로 오버라이딩 관계 성립 여부 체크
    // 오버라이딩 관계가 성립하려면 메소드의 이름과 반환 타입도 같아야함
    public void sleep(){
        System.out.println(name + " zzz in House");
    }
    // 오버라이딩 이후 오버로딩
    void sleep(int hour){
        System.out.println(name + " zzz in House for "+hour+"hour");

    }
}