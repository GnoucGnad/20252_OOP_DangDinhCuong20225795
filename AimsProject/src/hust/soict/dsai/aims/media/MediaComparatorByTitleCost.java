package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        // So sánh theo Title (bảng chữ cái)
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        
        // Nếu Title khác nhau thì trả về kết quả luôn
        if (titleComparison != 0) {
            return titleComparison;
        }
        
        // Nếu Title giống nhau, so sánh theo Cost (Giá cao hơn xếp trước -> giảm dần)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}