package mto.models;

public class Classes {
    private int id;
    private String class_name, duration, startdate;

    public Classes(int id, String class_name, String duration, String startdate) {
        this.id = id;
        this.class_name = class_name;
        this.duration = duration;
        this.startdate = startdate;
    }

    public Classes(String class_name, String duration, String startdate) {
        this.class_name = class_name;
        this.duration = duration;
        this.startdate = startdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
}
