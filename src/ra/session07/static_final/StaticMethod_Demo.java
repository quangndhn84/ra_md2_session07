package ra.session07.static_final;

public class StaticMethod_Demo {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println("Tổng 2 số 5 và 10 do sinh viên 1 tính: "+student1.sumTwoNumbers(5,10));
        Student student2 = new Student();
        System.out.println("Tổng 2 số 5 và 10 do sinh viên 2 tính: "+Student.sumTwoNumbers(5,10));
    }
}
