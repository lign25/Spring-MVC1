package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    //스프링 빈은 항상 무상태로 설계.
    //공유필드는 조심해야한다.
    public int order(String name, int price) {
        System.out.println("name = " + name + "price" + price);
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
