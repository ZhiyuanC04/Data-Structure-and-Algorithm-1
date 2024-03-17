// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: HW 2 - Calculator
// Resources used: https://stackoverflow.com/questions/8071363/calculating-powers-of-integers (I searched how to
// do the exponent and how to make the double from Math.pow() changed to int.)

public class HW02_Calculator {

    private int mem1;
    private int mem2;
    private String op;

    public HW02_Calculator() {
        mem1 = 0;
        mem2 = 0;
        op = " ";
    }
    public HW02_Calculator(int op1, int op2, String newOp) {
        setMem1(op1);
        setMem2(op2);
        setOp(newOp);
    }
    public int getMem1() {
    return mem1;
    }
    public int getMem2() {
    return mem2;
    }
    public String getOp() {
    return op;
    }
    public void setMem1(int op1) {
        mem1 = op1;
    }
    public void setMem2(int op2) {
        mem2 = op2;
    }
    public void setOp(String newOp) {
        if (newOp.equals("+")||newOp.equals("-")||newOp.equals("*")||newOp.equals("/")||newOp.equals("^")) {
            this.op = newOp;}
        else if (this.op == null) {
            this.op = " ";}
    }
    public String toString() {
    return (mem1 + " " + op + " " + mem2);
    }
    public int perform() {
        if (op.equals("+")) {
            mem2 = mem1 + mem2;}
        if (op.equals("-")) {
            mem2 = mem1 - mem2;}
        if (op.equals("*")) {
            mem2 = mem1 * mem2;}
        if (op.equals("/")) {
            if (mem2 == 0) {
                return 0;}
            else {
                mem2 = mem1 / mem2;}}
        if (op.equals("^")) {
            mem2 = (int) Math.pow(mem1, mem2);}
    return mem2;
    }
    public double performDiv() {
        double result = 0.0;
        if (op.equals("/") && mem2 != 0) {
           result = (mem1 * 1.0) / mem2;}
    return result;
    }
    public void swap() {
        int a = mem1;
        int b = mem2;
        mem1 = b;
        mem2 = a;
    }
    public static void main(String[] args){
    }
}