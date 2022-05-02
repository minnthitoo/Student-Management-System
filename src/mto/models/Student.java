package mto.models;

public class Student {
    private int id;
    private String name, nrc, s_class, phone, email, address, password;

    public Student(int id, String name, String nrc, String s_class, String phone, String email, String address) {
        this.id = id;
        this.name = name;
        this.nrc = nrc;
        this.s_class = s_class;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Student(String name, String nrc, String s_class, String phone, String email, String address) {
        this.name = name;
        this.nrc = nrc;
        this.s_class = s_class;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Student(String name, String nrc, String s_class, String phone, String email, String address, String password) {
        this.name = name;
        this.nrc = nrc;
        this.s_class = s_class;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public Student(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getS_class() {
        return s_class;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nrc='" + nrc + '\'' +
                ", s_class='" + s_class + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
