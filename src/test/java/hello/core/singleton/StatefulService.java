package hello.core.singleton;

public class StatefulService {
    private int price;

    // 한개 한개의 thread라 보자
    public int order(String name, int price) {
        System.out.println("name = " + name + "price = " + price);
        //this.price = price; //문제 코드
        return price;
    }

    // 한개 한개의 쓰레드
    //public int getPrice() {
        //return price;
    //}
}
