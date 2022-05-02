package mto.models;

public class Teacher {
    private int id;
    private String name, nrc, major, email, phone, address, password;

    public Teacher(int id, String name, String nrc, String major, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.nrc = nrc;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Teacher(String name, String nrc, String major, String email, String phone, String address) {
        this.name = name;
        this.nrc = nrc;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Teacher(String name, String nrc, String major, String email, String phone, String address, String password) {
        this.name = name;
        this.nrc = nrc;
        this.major = major;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public Teacher(int id, String email, String password) {
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nrc='" + nrc + '\'' +
                ", major='" + major + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
