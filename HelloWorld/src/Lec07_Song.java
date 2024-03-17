public class Lec07_Song {
    private String title = "";
    private String artist = "";
    private int minutes = 0;
    private int seconds = 0;

    public Lec07_Song() {

    }

    public Lec07_Song(String title, String artist, int minutes, int seconds) {
        setTitle(title);
        setArtist(artist);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
       // if (artist != null)
            this.artist = artist;
    }

    public double getLength() {
        return minutes + seconds*1.0/60;
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0) this.seconds = seconds;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0)
            this.minutes = minutes;
    }
/*
    @Override
    public String toString() {
        return "" + title + " by " + artist + " : " + getLength() + " minutes";

    } */
}