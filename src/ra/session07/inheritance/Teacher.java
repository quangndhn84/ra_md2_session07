package ra.session07.inheritance;

public class Teacher extends Person{
    //Thuộc tính kế thừa từ Person: name, age, sex, address
    //Thuộc tính riêng của lớp con
    private String specialize;
    private String schoolName;

    //Constructor kế thừa từ person
    //Constructor riêng của lớp con

    public Teacher() {
    }

    public Teacher(String name, int age, boolean sex, String address, String specialize, String schoolName) {
        super(name, age, sex, address);
        this.specialize = specialize;
        this.schoolName = schoolName;
    }

    public Teacher(String name, int age, boolean sex, String address) {
        super(name, age, sex, address);
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void intro(){
        //Chào mọi người
        super.hello();
        //Giới thiệu bản thân
        System.out.println("Tôi là Thúy, là một hotgirl, mong làm quen với các bạn");
    }
}
