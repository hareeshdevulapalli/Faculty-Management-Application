package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class ProjectModel extends SugarRecord
{
    String studentid,title,percentage,date;

    public ProjectModel(String studentid, String title, String percentage, String date) {
        this.studentid = studentid;
        this.title = title;
        this.percentage = percentage;
        this.date = date;
    }

    public ProjectModel() {
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
