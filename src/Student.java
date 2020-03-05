import java.util.Comparator;

class Student implements Comparable<Student>{
    private String name;
    private String surname;
    private int exam1;
    private int exam2;
    private int exam3;
    private char grade;
    private double total;

    public Student(String name, String surname, int exam1, int exam2, int exam3) {
        this.name = name;
        this.surname = surname;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
        this.total=this.exam1*0.25+this.exam2*0.30+this.exam3*0.45 ;
        if(total>=90){
            this.grade='A';
        }
        else if(total>=80&&total<90)
        {
            this.grade='B';
        }
        else if(total>=70&&total<80)
        {
            this.grade='C';
        }
        else if(total>=60&&total<70)
        {
            this.grade='D';
        }
        else{
            this.grade='F';
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getExam1() {
        return exam1;
    }

    public void setExam1(int exam1) {
        this.exam1 = exam1;
    }

    public int getExam2() {
        return exam2;
    }

    public void setExam2(int exam2) {
        this.exam2 = exam2;
    }

    public int getExam3() {
        return exam3;
    }

    public void setExam3(int exam3) {
        this.exam3 = exam3;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int compareTo(Student o) {
        return Comparator.comparing(Student::getTotal).reversed().compare(this,o);
    }
}
