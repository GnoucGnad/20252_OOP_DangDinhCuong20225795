package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    
    // CHỈ giữ lại thuộc tính riêng của Book
    private List<String> authors = new ArrayList<String>();

    // Constructor: Chuyển các thuộc tính chung lên cho lớp cha (Media) xử lý bằng chữ "super"
    public Book(int id, String title, String category, float cost, List<String> authors) {
        super(id, title, category, cost); 
        this.authors = authors;
    }

    // (Tùy chọn) Thêm một Constructor khác không cần truyền sẵn danh sách tác giả
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // CHỈ CẦN Getter/Setter cho thuộc tính riêng
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    // Phương thức thêm tác giả
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Đã thêm tác giả: " + authorName);
        } else {
            System.out.println("Tác giả " + authorName + " đã tồn tại trong danh sách!");
        }
    }

    // Phương thức xóa tác giả
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Đã xóa tác giả: " + authorName);
        } else {
            System.out.println("Không tìm thấy tác giả " + authorName + " trong danh sách!");
        }
    }    
    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getCost() + " $";
    }
}