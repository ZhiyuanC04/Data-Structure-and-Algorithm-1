// Name: Zhiyuan Chang
// Computing ID: vgs3qt
// Homework Name: Quiz2A
// I don't know why the codepost constantly saying TIMEOUT.
// And the score is changing everytime though I put into the same file.
public class Student extends Person{
    double grade_point_average = 0.0;
    public Student(){
        grade_point_average = 0.0;
    }
    public Student(String n){
        setName(n);
    }
    public Student(String n, int y, int m, double g){
        setName(n);
        setBirthYear(y);
        setBirthMonth(m);
        setGPA(g);
    }
    public void setGPA(double grade){
        if(grade >= 0.0 && grade <= 4.00){
            grade_point_average = grade;
        }
    }
    public double getGPA(){
        return grade_point_average;
    }
    public String toString(){
        return (getName()+" born in month "+getBirthmonth()+" of "+getBirthyear()+"   "+"GPA="+getGPA());
    }
    public boolean equals(Object o){
        if (o == null) return false;
        if (this == o) return true;
        if (o instanceof Student) {
            Student p = (Student) o;
            if (p.getName().equals(getName()) &&
                    p.getBirthyear() == getBirthyear() &&
                    p.getBirthmonth() == getBirthmonth() &&
                    p.getGPA() <= getGPA() + 0.001  &&
                    p.getGPA() >= getGPA() - 0.001){
                return true;
            }
        }
        return false;
    }
    public int getGrade(){
        int ret = -1;
        if(getBirthmonth() <= 8){
            ret = (2017 - getBirthyear());
            if(ret > 16 || ret <= 0){
                ret = -1;
            }
            return ret;
        }
        if(getBirthmonth() > 8) {
            ret = (2016 - getBirthyear());
            if(ret > 16 || ret <= 0){
                ret = -1;
            }
            return ret;
        }
        return ret;
    }
}