package hust.soict.dsai.aims;

import java.util.Scanner;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu
        initSetup();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    store.print();
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cart.print();
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    // ---------------- MENU HIỂN THỊ ----------------

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        int choice;
        do {
            System.out.println("\nStore Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Xem chi tiết
                    System.out.print("Nhập tiêu đề sản phẩm: ");
                    String title = scanner.nextLine();
                    Media found = store.fetchMedia(title);
                    if (found != null) {
                        System.out.println(found.toString());
                        mediaDetailsMenu(found);
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;
                case 2: // Thêm vào giỏ
                    System.out.print("Nhập tiêu đề để thêm vào giỏ: ");
                    String tAdd = scanner.nextLine();
                    Media mAdd = store.fetchMedia(tAdd);
                    if (mAdd != null) {
                        cart.addMedia(mAdd);
                        System.out.println("Số lượng sản phẩm trong giỏ: " + cart.getQtyOrdered());
                    } else {
                        System.out.println("Không tìm thấy sản phẩm!");
                    }
                    break;
                case 3: // Chạy thử (Play)
                    System.out.print("Nhập tiêu đề để Play: ");
                    String tPlay = scanner.nextLine();
                    Media mPlay = store.fetchMedia(tPlay);
                    if (mPlay instanceof Playable) {
                        ((Playable) mPlay).play();
                    } else {
                        System.out.println("Sản phẩm này không thể Play!");
                    }
                    break;
                case 4:
                    cart.print();
                    cartMenu();
                    break;
            }
        } while (choice != 0);
    }

    public static void mediaDetailsMenu(Media media) {
        int choice;
        do {
            System.out.println("\nMedia Details Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) ((Playable) media).play();
                    break;
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        int choice;
        do {
            System.out.println("\nCart Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Filter
                    System.out.println("1. Lọc theo ID | 2. Lọc theo Tiêu đề");
                    int fType = scanner.nextInt(); scanner.nextLine();
                    if (fType == 2) {
                        System.out.print("Nhập tiêu đề: ");
                        cart.search(scanner.nextLine());
                    }
                    break;
                case 2: // Sort
                    System.out.println("1. Tiêu đề -> Giá | 2. Giá -> Tiêu đề");
                    int sType = scanner.nextInt(); scanner.nextLine();
                    if (sType == 1) cart.sortByTitleCost(); else cart.sortByCostTitle();
                    cart.print();
                    break;
                case 3: // Remove
                    System.out.print("Nhập tiêu đề muốn xóa: ");
                    String tRem = scanner.nextLine();
                    // Tìm trong giỏ (giả định dùng tạm search để lấy ref hoặc viết hàm fetch tương tự store)
                    // Ở đây để đơn giản ta có thể bổ sung fetchMedia cho Cart hoặc tìm trực tiếp
                    break;
                case 4: // Play
                    System.out.print("Nhập tiêu đề: ");
                    // Logic tương tự Store Menu
                    break;
                case 5: // Place order
                    System.out.println("Đơn hàng đã được tạo! Tổng tiền: " + cart.totalCost() + " $");
                    cart.clear();
                    break;
            }
        } while (choice != 0);
    }

    public static void updateStoreMenu() {
        System.out.println("Chức năng thêm/xóa sản phẩm khỏi cửa hàng (Store) thực hiện tại đây.");
    }

    public static void initSetup() {
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 124, 24.95f);
        Book book = new Book(3, "Java Programming", "Education", 15.0f);
        CompactDisc cd = new CompactDisc(4, "Greatest Hits", "Music", 20.0f, 60, "Various Artists", "Multiple");

        store.addMedia(dvd);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(cd);
    }
}