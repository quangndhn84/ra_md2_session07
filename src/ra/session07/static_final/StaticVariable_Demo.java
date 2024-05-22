package ra.session07.static_final;

public class StaticVariable_Demo {
    /*
     * Xây dựng chức năng đếm số người truy câập vào Website RikkeiAcademy
     * */
    public static int cntVisited = 0;


    public void visitWebsite() {
        cntVisited++;
    }
}
