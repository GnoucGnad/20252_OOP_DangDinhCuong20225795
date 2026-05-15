package hust.soict.dsai.aims.media;

public class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
 // Thêm 2 dòng này cùng với thư viện java.util.Comparator
    public static final java.util.Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final java.util.Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Constructor trống
    public Media() {
    }

    // Constructor có tham số
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // --- Các hàm Getter và Setter ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public float getCost() { return cost; }
    public void setCost(float cost) { this.cost = cost; }
    @Override
    public boolean equals(Object obj) {
        // Kiểm tra xem có trỏ cùng vào một vùng nhớ không
        if (this == obj) return true;
        
        // Kiểm tra null và kiểu của đối tượng để tránh lỗi ép kiểu (ClassCastException)
        if (obj == null || !(obj instanceof Media)) return false;
        
        // Ép kiểu Object sang Media
        Media other = (Media) obj;
        
        // So sánh tiêu đề
        return this.getTitle() != null && this.getTitle().equals(other.getTitle());
    }
}