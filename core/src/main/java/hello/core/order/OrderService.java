package hello.core.order;

public interface OrderService {
    //주문생성시 회원id,물품이름,가격을 리턴한다.
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
