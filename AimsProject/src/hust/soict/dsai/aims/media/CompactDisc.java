package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    // Thuộc tính riêng của CD
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    // Constructor gọi super() để truyền dữ liệu lên cho Disc và Media
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    // Thêm bài hát vào đĩa
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Đã thêm bài hát: " + track.getTitle());
        } else {
            System.out.println("Bài hát " + track.getTitle() + " đã tồn tại trong CD.");
        }
    }

    // Xóa bài hát khỏi đĩa
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Đã xóa bài hát: " + track.getTitle());
        } else {
            System.out.println("Không tìm thấy bài hát " + track.getTitle() + " trong CD.");
        }
    }

    // Ghi đè hàm getLength(): Tổng độ dài CD bằng tổng độ dài các bài hát cộng lại
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() {
        System.out.println("Đang phát CD: " + this.getTitle());
        System.out.println("Nghệ sĩ: " + this.getArtist());
        System.out.println("Tổng độ dài CD: " + this.getLength());
        System.out.println("--- Bắt đầu phát các bài hát ---");
        
        // Dùng vòng lặp duyệt qua từng bài hát (track) và gọi hàm play() của bài hát đó
        for (Track track : tracks) {
            track.play();
        }
    }
    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + " $";
    }
}