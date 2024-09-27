package 상속과오버라이딩;
// final 키워드 : 클래스, 필드, 메소드 선인 시 사용할 수 있음
// 메소드에 사용하는 경우 상속하면 오버라이딩을 금지할 수 있음

public class OverrideEx {
    public static void main(String[] args) {

    }
}

class Car{
    int speed;
    String name;
    String color;

    void accelerator(){
        System.out.println("차의 속도가 증가합니다.");
    }
    void brakePanel(){
        System.out.println("차의 속도가 감소합니다.");
    }

}
class SportsCar extends Car{
    boolean isTurbo;
    SportsCar(String name){
        isTurbo = false;
        speed = 280;
        this.name = name;
        color = "red";
    }

    @Override
    final void accelerator() {
        System.out.println("차가 하늘을 날읍니다");
    }
    @Override
    void brakePanel() {
        System.out.println("차가 물속으로 갑니다.");
    }

    int getSpeed(){
        if (isTurbo) return speed *= 1.2;
        return speed;
    }
    void setTurbo(boolean isTurbo){
        this.isTurbo = isTurbo;
    }
    void infoCar(){
        System.out.println("이름 : " + name);
        System.out.println("속도 : " + getSpeed());
        System.out.println("색상 : " + color);
        System.out.println("터보 : " + isTurbo);
    }
}