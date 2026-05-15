package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    // Thay vì dùng mảng DVD[], ta dùng ArrayList<Media> để chứa được cả Book, CD, DVD
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    // Hàm thêm một sản phẩm bất kỳ (Book, CD, DVD) vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Đã thêm [" + media.getTitle() + "] vào cửa hàng.");
        } else {
            System.out.println("Sản phẩm [" + media.getTitle() + "] đã có sẵn trong cửa hàng.");
        }
    }

    // Hàm xóa một sản phẩm bất kỳ khỏi cửa hàng
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xóa [" + media.getTitle() + "] khỏi cửa hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm [" + media.getTitle() + "] trong cửa hàng.");
        }
    }
 // Hàm in danh sách sản phẩm trong cửa hàng ra màn hình
    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Các sản phẩm đang có trong cửa hàng:");
        for (Media media : itemsInStore) {
            System.out.println("- " + media.toString());
        }
        System.out.println("***************************************************");
    }

    // Hàm tìm kiếm và trả về một sản phẩm dựa vào Tiêu đề (Title)
    public Media fetchMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                return media; // Trả về sản phẩm nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }
}