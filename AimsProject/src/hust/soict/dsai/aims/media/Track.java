package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    public void play() {
        System.out.println("Đang phát bài hát: " + this.getTitle());
        System.out.println("Độ dài bài hát: " + this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Track)) return false;
        
        // Ép kiểu Object sang Track
        Track other = (Track) obj;
        
        // So sánh cả tiêu đề và độ dài
        return this.length == other.length && this.title != null && this.title.equals(other.title);
    }
}