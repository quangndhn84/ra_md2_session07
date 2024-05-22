package ra.session07.static_final;

public class RikkeiAcademy {
    public static void main(String[] args) {
        StaticVariable_Demo guest1 = new StaticVariable_Demo();
        guest1.visitWebsite();
        System.out.println("Số lượt thăm: " + StaticVariable_Demo.cntVisited);
        StaticVariable_Demo guest2 = new StaticVariable_Demo();
        guest2.visitWebsite();
        System.out.println("Số lượt thăm: " + guest2.cntVisited);
        StaticVariable_Demo guest3 = new StaticVariable_Demo();
        guest3.visitWebsite();
        System.out.println("Số lượt thăm: " + StaticVariable_Demo.cntVisited);
    }
}
