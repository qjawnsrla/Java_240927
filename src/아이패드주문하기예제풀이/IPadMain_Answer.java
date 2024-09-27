package 아이패드주문하기예제풀이;

public class IPadMain_Answer {
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            IPadPro_Answer iPadPro = new IPadPro_Answer("iPad Pro");
            if (!iPadPro.continueOrder()) break;
            iPadPro.setScreen();
            iPadPro.setColor();
            iPadPro.setMemory();
            iPadPro.setNetwork();
            iPadPro.setName();
            iPadPro.progressIPadPro();
            iPadPro.iPadProInfo();
        }
    }
}
