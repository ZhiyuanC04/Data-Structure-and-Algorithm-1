public class Person {
    private String name;
    private int birthyear;
    private int birthmonth;

    public Person(){
        name = "";
    }
    public Person(String nm) {
        setName(nm);
    }
    public Person(String nm, int yr, int month) {
        name = "";
        setName(nm);
        setBirthYear(yr);
        setBirthMonth(month);
    }

    public String getName() { return name;}
    public int getBirthyear() { return birthyear;}
    public int getBirthmonth() { return birthmonth;}

    public void setName(String nm) {
        if (nm.length() >= 0)
            name = nm;
    }

    public void setBirthYear(int yr) {
        if (yr > 1900 && yr < 2023)
            birthyear = yr;
    }

    public void setBirthMonth(int month) {
        if (1 <= month && month <= 12)
            birthmonth = month;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (o instanceof Person) {
            Person p = (Person) o;
            if (p.name.equals(name) &&
                p.birthyear == birthyear &&
                p.birthmonth == birthmonth)
                return true;
        }
        return false;
    }
    public String toString() {
        return name + " born in month " + birthmonth + " of " + birthyear;
    }

}
