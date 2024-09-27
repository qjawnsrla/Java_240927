package 상속TV;

import static 아이패드주문하기예제풀이.Common.PROTOTYPE_CHANNEL_MAX;


public class ProtoTypeTV {
    boolean isPower;        // 전원에 대한 설정값
    int channel;
    int volume;
    // public ProtoTypeTV() {}      // 기본 생성자 - 지우면 아래의 변수가 있는 생성자만 생기고 기본 생성자가 만들어지지 않는다.
    public ProtoTypeTV(boolean isPower, int channel, int volume) {
        this.isPower = isPower;
        this.channel = channel;
        this.volume = volume;
    }
    public void setChannel(int cnl) {
        if (cnl > 0 && cnl < PROTOTYPE_CHANNEL_MAX){
            channel = cnl;
        } else {
            System.out.println("채널 설정 범위가 아닙니다.");
        }
    }
}
