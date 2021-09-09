package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class ClassTimeTableModel extends SugarRecord {

    String date, lecture, subject;

    public ClassTimeTableModel() {
    }

    public ClassTimeTableModel(String date, String lecture, String subject) {
        this.date = date;
        this.lecture = lecture;
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
