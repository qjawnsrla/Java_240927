package 메소드오버로딩;
// 같은 이름의 메소드를 중복하여 정의하는것 (정적 바인딩)
// 매개변수의 타입이나 개수로 구분 (오버로딩의 조건)
// 다형성을 구현하는 중요요소
// 반환값이나 접근제한자는 해당사항 없음

public class MethodOverloadingEx {
    public static void main(String[] args) {
        System.out.println(sum(10,20));             // 정수 반환값
        System.out.println(sum(10,20,30));          // 정수 반환값
        System.out.println(sum(10,3.33,4.55));      // 실수 반환값
        System.out.println(sum("SUM : ", 10, 20));  // 문자열 반환값
    }
    static int sum(int a,int b){
        return a+b;
    }
    static int sum(int x,int y,int z){
        return x+y+z;
    }
    static double sum(double x,double y,double z){
        return x+y+z;
    }
    static String sum(String a,int z,int w){
        return a+(z+w);
    }
}
