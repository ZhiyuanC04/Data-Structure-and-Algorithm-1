// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Quiz1A: Quad
public class Quiz1A_Quad {
    public static void main(String[] args) {
    }
    public static int[] calcQuad(int[] integers) {
        int fix = 1;
        int position = 0;
        int length;
        int[] result;
        length = integers.length/2;
        result = new int[length]; // make sure that the array is in proper length.
        for(int i = 0; i < integers.length; i++){
            fix = i + 1; // go to the next interger.
            if(integers[i] == 0 || integers[fix] == 0){
                result[position] = 0;}
            if(integers[i] > 0 && integers[fix] > 0){
                result[position] = 1;} // Quad 1
            if(integers[i] < 0 && integers[fix] > 0){
                result[position] = 2;} // Quad 2
            if(integers[i] < 0 && integers[fix] < 0){
                result[position] = 3;} // Quad 3
            if(integers[i] > 0 && integers[fix] < 0){
                result[position] = 4;} // Quad 4
            position += 1; // position + 1 becasue you will add the second quad info to next one.
            i += 1;} // i + another 1 becasue you don't want it to run the next integer.
        return result;
    }
}
