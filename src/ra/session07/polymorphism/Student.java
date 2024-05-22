package ra.session07.polymorphism;

public class Student {
    private String studentId;
    private String studentName;
    private int age;

    public Student() {
    }

    public Student(String studentId, String studentName, int age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //Phương thức nạp chồng (overloading)
    /*
     * Điều kiện để nạp chồng:
     *   1. Cùng tên phương thức
     *   2. Thỏa mãn 1 trong 3 điều kiện sau:
     *       - Khác số lượng tham số
     *       - Khác thứ tự tham số
     *       - Khác kiểu dữ liệu của tham số    *
     * */

    public int addNumber(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    public float addNumber(float firstNumber, float secondNumber) {
        return firstNumber + secondNumber;
    }

    public int addNumber(int firstNumber, int secondNumber, int thirtNumber) {
        return firstNumber + secondNumber + thirtNumber;
    }

    public void printData(int number, String str) {

    }

    public void printData(String str, int number) {


    }

    public void hello() {
        System.out.println("Xin chào các bạn bằng tiếng miền Bắc");
    }
}
