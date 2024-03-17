
public class StringHashFunc {

    public static int hashCode(String str) {
        int hash = 7;
        for (int i = 0; i < str.length(); i++) {
            hash = hash * 31 + (int) str.charAt(i);
        }
        return hash;
    }
}
