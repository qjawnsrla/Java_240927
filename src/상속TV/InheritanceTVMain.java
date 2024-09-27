package 상속TV;
// 상속, 오버로딩, 오버라이딩 기본동작을 이용해 TV 만들기

public class InheritanceTVMain {
    public static void main(String[] args) {
        ProductTV lgTV = new ProductTV("우리집 TV");
        lgTV.setPower(true);
        lgTV.setVoulume(30);
        lgTV.setChannel(30, true);
        lgTV.tvInfo();

        // 부모 클래스의 참조변수로 자식객체를 참조
        ProtoTypeTV samTV = new ProductTV("남의집 TV");
        samTV.setChannel(1900);
    }
}
