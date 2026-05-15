package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    
    // Biến static đếm tổng số lượng đĩa
    private static int nbDigitalVideoDiscs = 0; 

    // 1. Constructor chỉ có title
    public DigitalVideoDisc(String title) {
        // Truyền thêm 0 (cho length) và null (cho director) lên lớp cha
        super(++nbDigitalVideoDiscs, title, null, 0.0f, 0, null);
    }

    // 2. Constructor có category, title, cost
    public DigitalVideoDisc(String category, String title, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, 0, null);
    }

    // 3. Constructor đầy đủ tham số
    public DigitalVideoDisc(String director, String category, String title, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        return getTitle().toLowerCase().contains(title.toLowerCase());
    }

    // Thực thi hợp đồng Playable
    @Override
    public void play() {
        System.out.println("Đang phát DVD: " + this.getTitle());
        System.out.println("Độ dài DVD: " + this.getLength());
    }
}