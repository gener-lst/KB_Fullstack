package ch07.sec03.exam1;

public class SmartPhone extends Phone {
    // 필드 선언
   public boolean wifi;

   // 생성자 선언
   public SmartPhone(String model, String color) {
       // super 키워드로 부모의 기본 생성자를 호출해줌
       // 해당 코드 없어도 기본적으로 동작함
       super();
       this.model = model;
       this.color = color;
       System.out.println("SmartPhone(String model, String color) 생성자 실행됨");
   }

   // 메소드 선언
   public void setWifi(boolean wifi) {
       this.wifi = wifi;
       System.out.println("와이파이 상태를 변경했습니다.");
   }

   public void internet() {
       System.out.println("인터넷에 연결합니다.");
   }
}
