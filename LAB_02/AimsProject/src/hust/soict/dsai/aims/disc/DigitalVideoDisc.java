package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    // 1. Khai báo các thuộc tính (Attributes) - Giống hệt trong Astah
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
 // 1. THÊM 2 BIẾN NÀY VÀO DƯỚI CÁC THUỘC TÍNH
    // Biến static dùng chung để đếm tổng số đĩa
    private static int nbDigitalVideoDiscs = 0; 
    // Biến instance lưu mã ID riêng của từng đĩa
    private int id; 

    // 2. CẬP NHẬT LẠI TẤT CẢ CÁC CONSTRUCTOR
    public DigitalVideoDisc(String title) {
        this.title = title;
        // Mỗi lần tạo 1 đĩa, tăng bộ đếm lên 1
        nbDigitalVideoDiscs++; 
        // Lấy số bộ đếm hiện tại gán làm ID cho đĩa này
        this.id = nbDigitalVideoDiscs; 
    }
    public DigitalVideoDisc(String category, String title, float cost) {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.length = length;
        this.cost = cost;
    }

    // 3. Các hàm Getter (Lấy thông tin) - Vì thuộc tính là private
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getDirector() { return director; }
    public int getLength() { return length; }
    public float getCost() { return cost; }
    public int getId() { return id; }
    public void setTitle(String title) { this.title = title; }
 // Hàm toString() để in thông tin đĩa đẹp mắt
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }

    // Hàm kiểm tra xem tiêu đề có khớp không
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
}