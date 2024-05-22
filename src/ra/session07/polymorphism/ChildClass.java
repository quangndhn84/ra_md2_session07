package ra.session07.polymorphism;

public class ChildClass extends Student{
    /*
    * Điều kiện để ghi đè (Overriding)
    *   1. Có quan hệ kế thừa
    *   2. Cùng kiểu dữ liệu trả, cùng tên phương thức, cùng tham số
    *   2. Bổ từ truy cập của phương thức ghi đè có phạm vi lớn hơn hoăc bằng phương thức bị ghi đè
    * */
    public void hello(){
        System.out.println("Xin chào các bạn bằng tiếng miền Nam");
    }
    //Phương thức ghi đè phương thức toString của lớp Object
    public String toString(){
        return "Chuỗi đã bị ghi đè";
    }
}
