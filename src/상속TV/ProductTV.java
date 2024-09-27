package 상속TV;

public class ProductTV extends ProtoTypeTV{
    String name;
    boolean isInternet;     // 인터넷 기능을 켜고 끄고 하는것

    // ProtoTypeTV class에 있는 부모의 생성자가 기본생성자가 없기 때문에 부모의 생성자를 아래와같이 불러주어야 한다. 아니면 에러 발생
    // 따라서 부모 클래스에 기본 생성자가 있으면 따로 아래처럼 안불러주어도 된다.
    // 생성자란 클래스가 객체로 만들어질때 불려지는 것이다.
    public ProductTV(boolean isPower, int channel, int volume) {
        super(isPower, channel, volume);    // super() 부모의 생성자를 호출
    }
}
