import transportation.Bus;
import transportation.Taxi;
import transportation.transportation;

public class Main {
    public static void main(String[] args) {
        System.out.println("================버스 인스턴스 생성===============");
        Bus bus1 = new Bus(1994,0);
        Bus bus2 = new Bus(2004,0);
        bus2.getStart();
        bus2.takePassenger(2);
        System.out.println("==============================================");
        bus2.changeGasAmount(-50);
        System.out.println("==============================================");
        bus2.changeState("차고지행");
        bus2.changeGasAmount(10);
        System.out.println("==============================================");
        bus2.changeState("운행중");
        bus2.takePassenger(45);
        System.out.println("==============================================");
        bus2.takePassenger(5);
        System.out.println("==============================================");
        bus2.changeGasAmount(-55);
        System.out.println("================택시 인스턴스 생성===============");
        Taxi taxi1 = new Taxi(4875);
        Taxi taxi2 = new Taxi(7845);
        System.out.println("==============================================");
        taxi2.getStart();
        System.out.println("==============================================");
        taxi2.takePassenger(2,"서울역",2);
        System.out.println("==============================================");
        taxi2.changeGasAmount(-80);
        taxi2.payPrice();
        taxi2.takePassenger(5,"어린이대공원",5);
        System.out.println("==============================================");
        taxi2.takePassenger(3,"구로디지털단지역",12);
        System.out.println("==============================================");
        taxi2.changeGasAmount(-20);
        taxi2.payPrice();

    }
}
