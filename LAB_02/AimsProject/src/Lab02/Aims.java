package Lab02;

public class Aims {
    public static void main(String[] args) {
        // 1. Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // 2. Tạo các đĩa DVD mới
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // 3. Thêm đĩa vào giỏ
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // 4. In ra tổng tiền
        System.out.println("Tổng tiền hóa đơn: " + anOrder.totalCost());

        // 5. Thử xóa 1 đĩa và in lại tổng tiền
        anOrder.removeDigitalVideoDisc(dvd2); // Xóa Star Wars
        System.out.println("Tổng tiền sau khi xóa: " + anOrder.totalCost());
    }
}