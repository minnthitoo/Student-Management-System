package mto.models;

public class Timetable {

    private int id;
    private String mon_first, mon_second, mon_third, mon_forth, tue_first, tue_second, tue_third, tue_forth, wed_first, wed_second, wed_third, wed_forth, thu_first, thu_second, thu_third, thu_forth, fri_first, fri_second, fri_third, fri_forth, major;

    public Timetable(int id, String mon_first, String mon_second, String mon_third, String mon_forth, String tue_first, String tue_second, String tue_third, String tue_forth, String wed_first, String wed_second, String wed_third, String wed_forth, String thu_first, String thu_second, String thu_third, String thu_forth, String fri_first, String fri_second, String fri_third, String fri_forth, String major) {
        this.id = id;
        this.mon_first = mon_first;
        this.mon_second = mon_second;
        this.mon_third = mon_third;
        this.mon_forth = mon_forth;
        this.tue_first = tue_first;
        this.tue_second = tue_second;
        this.tue_third = tue_third;
        this.tue_forth = tue_forth;
        this.wed_first = wed_first;
        this.wed_second = wed_second;
        this.wed_third = wed_third;
        this.wed_forth = wed_forth;
        this.thu_first = thu_first;
        this.thu_second = thu_second;
        this.thu_third = thu_third;
        this.thu_forth = thu_forth;
        this.fri_first = fri_first;
        this.fri_second = fri_second;
        this.fri_third = fri_third;
        this.fri_forth = fri_forth;
        this.major = major;
    }

    public Timetable(String mon_first, String mon_second, String mon_third, String mon_forth, String tue_first, String tue_second, String tue_third, String tue_forth, String wed_first, String wed_second, String wed_third, String wed_forth, String thu_first, String thu_second, String thu_third, String thu_forth, String fri_first, String fri_second, String fri_third, String fri_forth, String major) {
        this.mon_first = mon_first;
        this.mon_second = mon_second;
        this.mon_third = mon_third;
        this.mon_forth = mon_forth;
        this.tue_first = tue_first;
        this.tue_second = tue_second;
        this.tue_third = tue_third;
        this.tue_forth = tue_forth;
        this.wed_first = wed_first;
        this.wed_second = wed_second;
        this.wed_third = wed_third;
        this.wed_forth = wed_forth;
        this.thu_first = thu_first;
        this.thu_second = thu_second;
        this.thu_third = thu_third;
        this.thu_forth = thu_forth;
        this.fri_first = fri_first;
        this.fri_second = fri_second;
        this.fri_third = fri_third;
        this.fri_forth = fri_forth;
        this.major = major;
    }

    public Timetable(String mon_first, String mon_second, String mon_third, String mon_forth, String tue_first, String tue_second, String tue_third, String tue_forth, String wed_first, String wed_second, String wed_third, String wed_forth, String thu_first, String thu_second, String thu_third, String thu_forth, String fri_first, String fri_second, String fri_third, String fri_forth) {
        this.mon_first = mon_first;
        this.mon_second = mon_second;
        this.mon_third = mon_third;
        this.mon_forth = mon_forth;
        this.tue_first = tue_first;
        this.tue_second = tue_second;
        this.tue_third = tue_third;
        this.tue_forth = tue_forth;
        this.wed_first = wed_first;
        this.wed_second = wed_second;
        this.wed_third = wed_third;
        this.wed_forth = wed_forth;
        this.thu_first = thu_first;
        this.thu_second = thu_second;
        this.thu_third = thu_third;
        this.thu_forth = thu_forth;
        this.fri_first = fri_first;
        this.fri_second = fri_second;
        this.fri_third = fri_third;
        this.fri_forth = fri_forth;
    }

    public Timetable(int id, String mon_first, String mon_second, String mon_third, String mon_forth, String tue_first, String tue_second, String tue_third, String tue_forth, String wed_first, String wed_second, String wed_third, String wed_forth, String thu_first, String thu_second, String thu_third, String thu_forth, String fri_first, String fri_second, String fri_third, String fri_forth) {
        this.id = id;
        this.mon_first = mon_first;
        this.mon_second = mon_second;
        this.mon_third = mon_third;
        this.mon_forth = mon_forth;
        this.tue_first = tue_first;
        this.tue_second = tue_second;
        this.tue_third = tue_third;
        this.tue_forth = tue_forth;
        this.wed_first = wed_first;
        this.wed_second = wed_second;
        this.wed_third = wed_third;
        this.wed_forth = wed_forth;
        this.thu_first = thu_first;
        this.thu_second = thu_second;
        this.thu_third = thu_third;
        this.thu_forth = thu_forth;
        this.fri_first = fri_first;
        this.fri_second = fri_second;
        this.fri_third = fri_third;
        this.fri_forth = fri_forth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMon_first() {
        return mon_first;
    }

    public void setMon_first(String mon_first) {
        this.mon_first = mon_first;
    }

    public String getMon_second() {
        return mon_second;
    }

    public void setMon_second(String mon_second) {
        this.mon_second = mon_second;
    }

    public String getMon_third() {
        return mon_third;
    }

    public void setMon_third(String mon_third) {
        this.mon_third = mon_third;
    }

    public String getMon_forth() {
        return mon_forth;
    }

    public void setMon_forth(String mon_forth) {
        this.mon_forth = mon_forth;
    }

    public String getTue_first() {
        return tue_first;
    }

    public void setTue_first(String tue_first) {
        this.tue_first = tue_first;
    }

    public String getTue_second() {
        return tue_second;
    }

    public void setTue_second(String tue_second) {
        this.tue_second = tue_second;
    }

    public String getTue_third() {
        return tue_third;
    }

    public void setTue_third(String tue_third) {
        this.tue_third = tue_third;
    }

    public String getTue_forth() {
        return tue_forth;
    }

    public void setTue_forth(String tue_forth) {
        this.tue_forth = tue_forth;
    }

    public String getWed_first() {
        return wed_first;
    }

    public void setWed_first(String wed_first) {
        this.wed_first = wed_first;
    }

    public String getWed_second() {
        return wed_second;
    }

    public void setWed_second(String wed_second) {
        this.wed_second = wed_second;
    }

    public String getWed_third() {
        return wed_third;
    }

    public void setWed_third(String wed_third) {
        this.wed_third = wed_third;
    }

    public String getWed_forth() {
        return wed_forth;
    }

    public void setWed_forth(String wed_forth) {
        this.wed_forth = wed_forth;
    }

    public String getThu_first() {
        return thu_first;
    }

    public void setThu_first(String thu_first) {
        this.thu_first = thu_first;
    }

    public String getThu_second() {
        return thu_second;
    }

    public void setThu_second(String thu_second) {
        this.thu_second = thu_second;
    }

    public String getThu_third() {
        return thu_third;
    }

    public void setThu_third(String thu_third) {
        this.thu_third = thu_third;
    }

    public String getThu_forth() {
        return thu_forth;
    }

    public void setThu_forth(String thu_forth) {
        this.thu_forth = thu_forth;
    }

    public String getFri_first() {
        return fri_first;
    }

    public void setFri_first(String fri_first) {
        this.fri_first = fri_first;
    }

    public String getFri_second() {
        return fri_second;
    }

    public void setFri_second(String fri_second) {
        this.fri_second = fri_second;
    }

    public String getFri_third() {
        return fri_third;
    }

    public void setFri_third(String fri_third) {
        this.fri_third = fri_third;
    }

    public String getFri_forth() {
        return fri_forth;
    }

    public void setFri_forth(String fri_forth) {
        this.fri_forth = fri_forth;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
