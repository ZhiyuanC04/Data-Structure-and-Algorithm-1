public class Lec07_SongDriver {

    public static void main(String [] args) {

        Lec07_Song blank = new Lec07_Song();
        Lec07_Song favorite = new Lec07_Song("Anti-Hero", "Taylor Swift", 3, 52);

        System.out.println(blank);
        System.out.println(favorite);

        blank.setTitle("Apologize");
        blank.setArtist("OneRepublic");
        System.out.println(favorite.getLength());
        System.out.println(blank);

        blank.setSeconds(-50);
        System.out.println(blank);

        String empty = null;
        Lec07_Song test = new Lec07_Song(empty, empty, 0, 0);

        System.out.println(test.toString());
    }
}
