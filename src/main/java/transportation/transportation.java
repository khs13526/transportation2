package transportation;

public class transportation {
    int id;
    int velocity;
    String state;
    String prevState;
    int maxPassenger;
    int gasAmount;



    int price;

    public transportation(int id, String state, int maxPassenger, int price) {
        this.id = id;
        this.velocity = 0;
        this.state = state;
        this.prevState = state;
        this.maxPassenger = maxPassenger;
        this.price = price;
        this.gasAmount = 100;
    }

}
