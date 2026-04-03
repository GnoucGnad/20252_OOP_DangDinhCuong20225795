package Lab02;

public class DigitalVideoDisc {
    // 1. Khai báo các thuộc tính (Attributes) - Giống hệt trong Astah
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // 2. Các hàm khởi tạo (Constructors) - Giúp tạo ra đĩa với nhiều thông tin khác nhau
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
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
}