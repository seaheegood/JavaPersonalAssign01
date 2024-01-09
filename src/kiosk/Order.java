package kiosk;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    int orderNumber;
    String message;
    List<Item> cart; // 장바구니
    Double totalPrice; // 장바구니 items -> total price
    Boolean complete = false; // 초기화 및 선언 -> default value 를 false 로
    LocalDateTime orderDate;
    LocalDateTime completeDate;

    public Order(int orderNumber, String message, List<Item> cart, Double totalPrice) {
        this.orderNumber = orderNumber;
        this.message = message;
        this.cart = cart;
        this.totalPrice = totalPrice;
        this.orderDate = LocalDateTime.now();
    }

    // 오더넘버 Getter
    public int getOrderNumber() {
        return this.orderNumber;
    }

    // 완료되었는지 기본값 false 를 true 로 바꾸면서 완료된 시간을 동시에 가져오는 Setter
    public void setComplete(Boolean complete) {
        this.complete = complete;
        this.completeDate = LocalDateTime.now();
    }

    // 화면 출력 method
    public void display() {
        System.out.println("\t주문번호 : " + this.orderNumber);
        System.out.println("\t요구사항 : " + this.message);
        System.out.println("\t주문시각 : " + this.orderDate);
        System.out.println("\t주문상품 목록 : ");

        for (Item item: cart) {
            System.out.println("\t\t" + "  | " + item.price + " | " + item.description);
        }

        System.out.println("\t총 가격 : " + this.totalPrice);
    }
}
