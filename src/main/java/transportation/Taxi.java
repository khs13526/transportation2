package transportation;

import transportation.transportationImpl.*;

public class Taxi extends transportation implements changeState, changeVelocity, getStart, takePassenger, changeGasAmount, payPrice {

    String destination;
    int distance;
    int baseDistance;
    int pricePerDistance;

    int income;

    int payPrice;

    public Taxi(int id) {
        super(id, "일반", 4, 3000);
        this.destination = "";
        this.distance = 0;
        this.baseDistance = 1;
        this.pricePerDistance = 1000;
        System.out.println(this.id + "번 택시");
        System.out.println("주유량 = " + this.gasAmount);
        System.out.println("상태 = " + this.state);
    }

    public Taxi(int id, String state, int maxPassenger, int price) {
        super(id, state, maxPassenger, price);
    }

    @Override
    public void changeState(String state) {
        this.state = state;
    }

    @Override
    public void changeVelocity(int velocity) {
        this.velocity += velocity;
    }

    @Override
    public void getStart() {
        if (this.gasAmount < 10) {
            System.out.println("운행 불가");
            this.state = "운행불가";
        } else {
            this.prevState = "일반";
            System.out.println(this.id + "번 운행 시작");
        }
    }
    @Override
    public void takePassenger(int passenger) {
    }

    @Override
    public void takePassenger(int passenger, String destination, int distance) {
        if(this.state.equals("일반")){
            if(this.maxPassenger - passenger >0) {
                this.state = "운행중";
                this.payPrice = (this.price + (distance -this.baseDistance)*this.pricePerDistance);
                System.out.println("탑승 승객 수 = " + passenger);
                System.out.println("잔여 승객 수 = " + (this.maxPassenger - passenger));
                System.out.println("기본 요금 확인 = " + this.price);
                System.out.println("목적지 = " + destination);
                System.out.println("목적지까지 거리 = " + distance + "km");
                System.out.println("지불할 요금 = " + payPrice);
                if(!this.prevState.equals(this.state)) {
                    System.out.println("상태 = " + this.state);
                }
                this.prevState = this.state;
            } else {
                System.out.println("최대 승객 수 초과");
            }
        } else if (this.state.equals("운행불가")){
                    System.out.println("탑승 불가");
        }


    }

    @Override
    public void changeGasAmount(int gasAmount) {
        if(this.gasAmount - gasAmount < 10) {
            this.state = "운행불가";
            this.prevState = this.state;
        } else {
            this.gasAmount += gasAmount;
        }
    }

    @Override
    public void payPrice() {
        if (this.gasAmount < 10){
            this.state = "운행불가";
        } else {
            this.state = "일반";
        }
        this.income += payPrice;
        System.out.println("주유량 = " + this.gasAmount);
        if (this.state.equals("운행불가")){
            System.out.println("상태 = " + this.state);
        }
        System.out.println("누적요금 = " + this.income);
        if (this.gasAmount < 10){
            System.out.println("주유 필요");
        }
    }
}
