package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo Cost (Giá cao hơn xếp trước -> giảm dần)
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        
        // Nếu Cost khác nhau thì trả về kết quả luôn
        if (costComparison != 0) {
            return costComparison;
        }
        
        // Nếu Cost giống nhau, so sánh theo Title (bảng chữ cái)
        return m1.getTitle().compareTo(m2.getTitle());
    }
}