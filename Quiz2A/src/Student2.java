public class Student2 {
    private String name;
    private int[] quizScores;
    public Student2(String n) {name = n;}
    public void setQuizScores(int[] scores) { quizScores = scores; }
    public void setName(String n) {
        name = n;
    }
    public int[] getQuizScores() {
        return quizScores;
    }
}
