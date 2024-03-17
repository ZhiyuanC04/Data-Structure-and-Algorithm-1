import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
/* program to determine if a file contains matched HTML tags using JCF Stack */

// there is problem, <h3> </h4> and it is removed.
public class HTMLMatch {
    public static boolean match(Scanner input) {
        // to read a single token from a file:
        String[] a = new String[30];
        int b = 0;
//        int c = 0;
        int result = 0;
        boolean yes = true;
        while(yes){
         String token = input.next();
//            System.out.println(token);
         if( token.equals("<html>") || token.equals("<body>")||
             token.equals("<h1>")   || token.equals("<h2>")  ||
             token.equals("<h3>")   ||token.equals("<h4>")   ||
             token.equals("<h5>")   ||token.equals("<h6>")   ||  token.equals("<p>")){
//             System.out.println("add runned");
             a[b] = token;
//             System.out.println(a[b]);
             b++;
         }
        if( token.equals("</html>") || token.equals("</body>")||
            token.equals("</h1>")   || token.equals("</h2>")  ||
            token.equals("</h3>")   ||token.equals("</h4>")   ||
            token.equals("</h5>")   ||token.equals("</h6>")   ||  token.equals("</p>")){
//            System.out.println("remove runned");
            a[b-1] = null;
            b--;
//            System.out.println(a[b]);
        }
        if(token.equals("</html>")){
             yes = false;
         }
//            System.out.println(b);
        }

        for(int i = 0; i < a.length; i++){
            if(!(a[i] == null)){
//                System.out.println("result + run");
//                System.out.println(a[i]);
                result++;
            }
        }
        if(result == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Program to determine if HTML tags are matched.");
        System.out.println("Enter filename");
//        String filename = scan.nextLine();
        String filename = "Lab6c.html";

        try {
            Scanner inFile = new Scanner(new File(filename));

            if (match(inFile)) {
                System.out.println("Tags are matched in " + filename);
            }
            else
                System.out.println("Tags are not matched in " + filename);

        }
        catch(FileNotFoundException fnf) {
            System.out.println("File not found");
        }
        catch(Exception e) {
            System.out.println("Exception thrown");
        }
    }
}