package kiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MenuContext {
    // field
    private Map<String, List<Menu>> menus;
    private Map<String, List<Item>> menuItems;
    private List<Item> cart;
    private double totalPrice;
    private int orderNumber;

    public MenuContext() {
        menus = new HashMap<>();
        menuItems = new HashMap<>();
        cart = new ArrayList<>();
        totalPrice = 0.0;
        orderNumber = 0;

        initializeMenuItems();
    }

    private void initializeMenuItems() {

        // 매인메뉴
        List<Menu> mainMenus = new ArrayList<>();
        mainMenus.add(new Menu("coffee", "espresso-based coffee drink"));
        mainMenus.add(new Menu("Tea", "water with tea bag"));

        // 오더의 메뉴
        List<Menu> orderMenus = new ArrayList<>();
        orderMenus.add(new Menu("Order", "장바구니를 확인 후 주문합니다."));
        orderMenus.add(new Menu("Cancel", "진행중인 주문을 취소합니다."));
        orderMenus.add(new Menu("Order List", "대기/완료된 주문 목록을 조회합니다."));

        menus.put("Main", mainMenus);
        menus.put("Order", orderMenus);

        List<Item> coffeeMenus = new ArrayList<>();
        coffeeMenus.add(new Item("Americano", "two shots with water", 4.5));
        coffeeMenus.add(new Item("Latte", "two shots with milk", 5.5));
        coffeeMenus.add(new Item("Cappuccino", "two shots with steamed milk foam", 5.9));

        List<Item> teaMenus = new ArrayList<>();
        teaMenus.add(new Item("Chamomile Tea", "캐모마일 티", 4.5));
        teaMenus.add(new Item("Mint Tea", "민트 티", 4.5));
        teaMenus.add(new Item("Green Tea", "녹차", 4.5));

        menuItems.put("Coffee", coffeeMenus);
        menuItems.put("Tea", teaMenus);
    }

    /**
     * 메뉴 조회
     * @param key 조회할 메뉴 키 값
     * @return 조회된 메뉴 목록
     */
    public List<Menu> getMenus(String key) {
        return menus.get(key);
    }

    /**
     * 상품 메뉴 조회
     * @param key 조회할 상품 메뉴 키 값
     * @return 조회된 상품 메뉴 목록
     */
    public List<Item> getMenuItems(String key) {
        return menuItems.get(key);
    }

    public Map<String, List<Item>> getMenuItemMap() {
        return menuItems;
    }

    public List<Item> getCart() {
        return cart;
    }

    public void addMenu(String key, String description) {
        menus.get("Main").add(new Menu(key, description));
        menuItems.put(key, new ArrayList<>());
    }

    public void addMenuItem(String key, Item newItem) {
        menuItems.get(key).add(newItem);
    }

    // 매인 메뉴 이름 가져오기
    public String getMainMenuName(int id) {
        List<Menu> mainMenus = menus.get("Main");
        for (Menu mainMenu : mainMenus) {
            if (mainMenu.id == id) {
                return mainMenu.name;
            }
        }
        return "";
    }

    /**
     * 장바구니에 상품 메뉴 추가
     * @param menuItem 장바구니에 추가할 상품 메뉴
     */
    public void addToCart(Item menuItem) {
        cart.add(menuItem);
        totalPrice += menuItem.price;
    }

    public void displayAllItem() {
        System.out.println("[ 전체 상품 목록 ]");
        menuItems.forEach((key, value) -> {
            System.out.println(" [ " + key + " Menu ]");
            for(Item item: value) {
                System.out.println(item.id + ". " + item.name + "   | " + item.price + " | " + item.description);
            }
        });
    }

    public void displayCart() {
        for (Item item : cart) {
            System.out.println(item.name + "   | " + item.price + " | " + item.description);
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * 신규 주문번호 조회
     * @return 신규 주문번호
     */
    public int generateOrderNumber() {
        orderNumber++;
        return orderNumber;
    }

    /**
     * 장바구니 초기화
     */
    public void resetCart() {
        cart.clear();
        totalPrice = 0.0;
    }
}
