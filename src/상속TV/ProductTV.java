package 상속TV;

import static 아이패드주문하기예제풀이.Common.*;

public class ProductTV extends ProtoTypeTV{
    String name;
    boolean isInternet;     // 인터넷 기능을 켜고 끄고 하는것

    // ProtoTypeTV class에 있는 부모의 생성자가 기본생성자가 없기 때문에 부모의 생성자를 아래와같이 불러주어야 한다. 아니면 에러 발생
    // 따라서 부모 클래스에 기본 생성자가 있으면 따로 아래처럼 안불러주어도 된다.
    // 생성자란 클래스가 객체로 만들어질때 불려지는 것이다.
//    public ProductTV(boolean isPower, int channel, int volume) {
//        super(isPower, channel, volume);    // super() 부모의 생성자를 호출
//
//    }

    public ProductTV(String name){
        super(false,10,10);     // super() 부모의 생성자를 호출
        this.name = name;
    }
    void setPower(boolean isPower){
        this.isPower = isPower;
    }
    void setVoulume(int vol){
        if(vol >= MIN_VOLUME && vol <= MAX_VOLUME){
            this.volume = vol;
        } else{
            System.out.println("볼륨의 설정 범위를 벗어났습니다.");
        }
    }
    @Override
    public void setChannel(int cnl){
        if (cnl > 0 && cnl < PRODUCT_CHANNEL_MAX){
            channel = cnl;
            System.out.println("채널을 "+channel+"변경 했습니다.");
        } else{
            System.out.println("채널 설정 범위가 아닙니다.");
        }
    }
    // 오버로딩
    public void setChannel(int cnl, boolean isInternet){
        if(isInternet){
            System.out.println("인터넷 모드 입니다.");
            this.isInternet = true;
        } else{
            this.isInternet = false;
            if(cnl >0 && cnl < PRODUCT_CHANNEL_MAX){
                channel = cnl;
                System.out.println("채널을 " + channel + "변경 했습니다.");
            } else{
                System.out.println("채널 설정 범위가 아닙니다.");
            }
        }
    }
    void tvInfo(){
        System.out.println("이름 : " + name);
        System.out.println("전원 : " + isPower);
        System.out.println("채널 : " + channel);
        System.out.println("볼륨 : " + volume);
        System.out.println("인터넷모드 : " + isInternet);
    }
}
