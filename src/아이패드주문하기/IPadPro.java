package 아이패드주문하기;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class IPadPro {
    private Scanner sc = new Scanner(System.in);    // 입력받기 위한 스캐너 참조변수 생성
    private int screen;     // 11인치, 13인치
    private int color;      // 스페이스 그레이, 실버
    private int memory;     // 256GB, 512GB, 1TB, 2TB
    private int network;    // Wi-Fi. Wi-Fi+Cellular
    private String name;    // 각인 서비스 이름 저장
    private String productDate;     // 제품생산 일자
    String serialNum;   // 제품에 대한 일련번호
    private int price;  // 제품 구매 가격
    private static int cnt = 0;     // 제품생산 대수, 클래스변수

    public IPadPro(String name) {   // 생성자는 클래스가 객체로 만들어질 때 호출
        this.sc = new Scanner(System.in);
        this.name = name;   // 생성자 호출 시 이름을 전달받아서 초기값 지정
        Date now = new Date();  // 현재 시간을 운영체제로부터 받아옴
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // 소문자 m은 '분'
        productDate = sdf.format(now);  // 지정된 format 형태로 시간정보가 가공되서 반환됨
        cnt++;
        productDate += cnt;     // 산술연산이 아니고 문자열을 연결함
    }

    public boolean continueOrder(){
        System.out.println("====== iPad Pro 구입하기 ======");
        System.out.println("구입을 진행하려면 yes / 종료는 no : ");
        String isContinue = sc.next();
        if (isContinue.equalsIgnoreCase("yes")) return true;
        else return false;
    }
    public void setScreen(){
        while (true){
            System.out.println("디스플레이 선택 [1]11인치 [2]13인치 : ");
            screen = sc.nextInt();
            if (screen == 1 || screen == 2) return ;
            System.out.println("디스플레이 선택이 잘못 되었습니다.");
        }
    }
    public void setColor(){
        while (true){
            System.out.println("색상 선택 [1]스페이스그레이 [2]실버 : ");
            color = sc.nextInt();
            if (color == 1 || color == 2) return ;
            System.out.println("색상 선택이 잘못 되었습니다.");
        }
    }
    public void setMemory(){
        while (true){
            System.out.println("메모리 크기 선택 [1]256GB [2]512GB [3]1TB [4]2TB : ");
            memory = sc.nextInt();
            if (memory == 1 || memory == 2 || memory == 3 || memory == 4) return ;
            System.out.println("색상 선택이 잘못 되었습니다.");
        }
    }
    public void setNetwork(){
        while (true){
            System.out.println("네트워크 선택 [1]Wi-Fi 모드 [2]Wi-Fi+Cellular 모드 : ");
            network = sc.nextInt();
            if (network == 1 || network == 2) return ;
            System.out.println("네트워크 선택이 잘못 되었습니다.");
        }
    }
    public void setName(){
        System.out.println("제품 이름 입력 : ");
        name = sc.next();
    }
    // 일렬번호 만들기
    public void setSerialNum(){
        String screenStr = (screen ==1) ? "11" : "13";
        String [] memoryStr = {"","256","512","1024","2048"};
        String networkStr = (network ==1) ? "W" : "C";
        serialNum = "iPadPro" + screenStr + memoryStr[memory] + networkStr + productDate;
        System.out.println(serialNum);
    }
    // 제품 옵션 선택이 완료되면 출고까지 30초 동안 제품생산 진행상황을 보여주고 출고
    public void progressIPadPro() throws InterruptedException {
        int cnt = 0;
        while (true){
            //sleep(300);     // 0.3초를 의미
            cnt++;
            System.out.printf("<< iPadPro 제작 중 : [%d%%] >>\n",cnt);
            if(cnt >= 100) break;
        }
    }
    // 제품에 대한 선택 옵션과 일련번호, 총 가격
    public void iPadProInfo() throws InterruptedException {
        continueOrder();
        setScreen();
        setColor();
        setMemory();
        setNetwork();
        setName();
        setSerialNum();
        progressIPadPro();
        iPadProCalPrice();
    }
    // 선택한 옵션을 포함한 제품가격 구하기
    public void iPadProCalPrice(){
        price = 1499000;
        if (this.screen == 2){
            price += 500000;
        }
        if(this.memory == 2){
            price += 300000;
        } else if (this.memory == 3){
            price += 900000;
        } else if (this.memory == 4){
            price += 1500000;
        }
        if(this.network == 2){
            price += 300000;
        }
        System.out.println("선택한 사양의 제품 가격은"+price+" 입니다.");
    }
}