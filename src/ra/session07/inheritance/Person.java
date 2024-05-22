package ra.session07.inheritance;

public class Person extends Object{
    /*
    * important: Tất cả các lớp người dùng xây dựng mặc định kế thừa từ lớp Object
    * */
    private String name;
    private int age;
    private boolean sex;
    private String address;

    public Person() {
    }

    public Person(String name, int age, boolean sex, String address) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void hello() {
        System.out.println("Xin chào các bạn");
    }
}
