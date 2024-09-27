package 아이패드주문하기예제풀이;


import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Thread.sleep;

import static 아이패드주문하기예제풀이.Common.*;

public class IPadPro_Answer {
    private final Scanner sc; // 입력 받기 위한 스캐너 참조 변수 생성
    private int screen;  // 11인치, 13인치
    private int color;   // 스페이스그레이, 실버
    private int memory;  // 256GB, 512GB, 1TB, 2TB
    private int network; // Wi-Fi, Wi-Fi+Cellular
    private String name; // 각인 서비스 이름 저장
    private String productDate;  // 제품 생산 일자
    String serialNum;  // 제품에 대한 일련번호
    private int price;   // 제품 구매 가격
    private static int cnt = 0;  //  제품 생산 대수, 클래스 변수
    public IPadPro_Answer(String name) {  // 생성자는 클래스가 객체로 만들어 질 때 호출
        this.sc = new Scanner(System.in);
        this.name = name;  // 생성자 호출 시 이름을 전달 받아서 초기값 지정
        Date now = new Date(); // 현재 시간을 운영체제로 부터 받아 옴
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        productDate = sdf.format(now); // 지정된 format 형태로 시간정보가 가공되서 반환 됨
        cnt++;
        productDate += cnt;   // 산술연산이 아니고 문자열을 연결 함
    }
    public boolean continueOrder() {
        System.out.println("====== iPad Pro 구입하기 =====");
        System.out.print("구입을 진행하려면 yes / 종료는 no : ");
        String isContinue = sc.next();
        if (isContinue.equalsIgnoreCase("yes")) return true;
        else return false;
    }
    public void setScreen() {
        while (true) {
            System.out.print("디스플레이 선택 [1]11인치 [2]13인치 : ");
            screen = sc.nextInt();
            if (screen == 1 || screen == 2) return;
            System.out.println("디스플레이 선택이 잘 못 되었습니다.");
        }

    }
    public void setColor() {
        while (true) {
            System.out.print("컬러 선택 [1]스페이스그레이 [2]실버 : ");
            color = sc.nextInt();
            if (color == 1 || color == 2) return;
            System.out.println("컬러 선택이 잘 못 되었습니다.");
        }
    }

    public void setMemory() {
        while (true) {
            System.out.print("메모리 선택 [1]256GB [2]512GB [3]1TB [4]2TB : ");
            memory = sc.nextInt();
            if (memory > 0 && memory < 5) return;
            System.out.println("메모리 선택이 잘 못 되었습니다.");
        }
    }

    public void setNetwork() {
        while (true) {
            System.out.print("네트워크 선택 : [1]WiFI [2]WiFi+Cellular : ");
            network = sc.nextInt();
            if (network == 1 || network == 2) return;
            System.out.println("네트워크 선택 이 잘 못 되었습니다.");
        }
    }
    public void setName() {
        System.out.print("각인 서비스를 신청 하시겠습니까? (yes / no) : ");
        String nameService = sc.next();
        sc.nextLine();
        if (nameService.equalsIgnoreCase("yes")) {
            System.out.print("이름을 입력 하세요 : ");
            name = sc.nextLine();
        }
    }

    // 일련번호 만들기
    public void setSerialNum() {
        String screenStr = (screen == 1) ? "11" : "13";
        String[] memoryStr = {"", "256","512", "1024", "2048"};
        String networkStr = (network == 1) ? "W" : "C";
        serialNum = "iPadPro" + screenStr + memoryStr[memory] + networkStr + productDate;
    }
    // 제품 옵션 선택이 완료되면 출고까지 30초 동안 제품 생산 진행 상황을 보여주고 출고
    public void progressIPadPro() throws InterruptedException {
        int cnt = 0;
        setSerialNum();  // 시리얼 넘버 생성
        while (true) {
            sleep(300); // 0.3초를 의미
            cnt++;
            System.out.printf("<< iPadPro 제작 중 : [%d%%] >>\r", cnt);
            if (cnt >= 100) break;
        }
    }
    // 제품 선택 옵션과 일련번호, 총 가격
    public void iPadProInfo() {
        Common common = new Common();
        //common.screenType;
        final String[] screenType = {"", "11인치", "13인치"};
        final String[] colorType = {"", "스페이스 그레이", "실버"};
        final String[] memoryType = {"", "256GB", "512GB", "1TB", "2TB"};
        final String[] networkType = {"", "WiFI", "WiFi+Cellular"};
        System.out.println("============== iPad Pro 출고 =============");
        System.out.println("화면 : " + screenType[screen]);
        System.out.println("색상 : " + colorType[color]);
        System.out.println("용량 : " + memoryType[memory]);
        System.out.println("네트워크 : " + networkType[network]);
        System.out.println("이름 : " + name);
        System.out.println("일련번호 : " + serialNum);
        System.out.println("제품 가격 : " + iPadProCalcPrice() + "원");
        System.out.println("-----------------------------------------");
    }

    // 선택한 옵션을 포함한 제품 가격 구하기
    public String iPadProCalcPrice() {
        NumberFormat numberFormat = NumberFormat.getInstance();  // 숫자 형식 지정 객체 생성
        int[] screenPrice = {0, 1499000, 1999000};
        int[] memoryPrice = {0, 0, 300000, 900000, 1500000};
        int[] networkPrice = {0, 0, 300000};

        price += screenPrice[screen];
        price += memoryPrice[memory];
        price += networkPrice[network];
        return numberFormat.format(price);
    }
}