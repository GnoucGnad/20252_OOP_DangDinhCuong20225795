package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import hust.soict.dsai.aims.media.Media;

public class Cart {
    // Thay thế mảng bằng ArrayList để chứa được cả Book, CD, DVD
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    // 1. Thêm một sản phẩm (Media) vào giỏ
    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("Đã thêm [" + media.getTitle() + "] vào giỏ hàng.");
        } else {
            System.out.println("Sản phẩm [" + media.getTitle() + "] đã có trong giỏ hàng rồi!");
        }
    }

    // 2. Xóa một sản phẩm khỏi giỏ
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa [" + media.getTitle() + "] khỏi giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm [" + media.getTitle() + "] để xóa.");
        }
    }

    // 3. Tính tổng tiền (Sử dụng vòng lặp duyệt ArrayList)
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // 4. In danh sách giỏ hàng (Tận dụng toString() đa hình)
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ". " + media.toString());
            i++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // 5. Tìm kiếm theo Tiêu đề (Search by Title)
    public void search(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println("Tìm thấy: " + media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sản phẩm nào có tiêu đề: " + title);
    }

    // 6. Sắp xếp giỏ hàng theo Tiêu đề rồi đến Giá
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp giỏ hàng theo Tiêu đề -> Giá.");
    }

    // 7. Sắp xếp giỏ hàng theo Giá rồi đến Tiêu đề
    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp giỏ hàng theo Giá -> Tiêu đề.");
    }
    
    // Hàm bổ trợ để lấy số lượng món hàng (Dùng cho Menu sau này)
    public int getQtyOrdered() {
        return itemsOrdered.size();
    }
    
    // Hàm xóa toàn bộ giỏ hàng (Sau khi đặt hàng thành công)
    public void clear() {
        itemsOrdered.clear();
        System.out.println("Giỏ hàng đã được làm trống.");
    }
}