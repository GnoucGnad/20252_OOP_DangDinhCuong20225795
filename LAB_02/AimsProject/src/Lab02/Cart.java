package Lab02;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20; // Sức chứa tối đa
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0; // Số lượng đĩa đang có

    // Thêm đĩa vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đã thêm đĩa '" + disc.getTitle() + "' vào giỏ hàng.");
        } else {
            System.out.println("Giỏ hàng đã đầy! Không thể thêm.");
        }
    }

    // Xóa đĩa khỏi giỏ (Logic dồn mảng)
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) { // Tìm thấy đĩa cần xóa
                // Dồn các đĩa phía sau lên trước 1 bậc để lấp chỗ trống
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; // Xóa phần tử thừa ở cuối
                qtyOrdered--; // Giảm số lượng đi 1
                System.out.println("Đã xóa đĩa '" + disc.getTitle() + "' khỏi giỏ hàng.");
                return; // Thoát hàm sau khi xóa xong
            }
        }
        System.out.println("Không tìm thấy đĩa trong giỏ hàng.");
    }

    // Tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}