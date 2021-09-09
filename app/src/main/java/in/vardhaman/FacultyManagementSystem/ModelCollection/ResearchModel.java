package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class ResearchModel extends SugarRecord
{
    String deadline,title,perc,date;

    public ResearchModel(String deadline, String title, String perc, String date) {
        this.deadline = deadline;
        this.title = title;
        this.perc = perc;
        this.date = date;
    }

    public ResearchModel() {
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerc() {
        return perc;
    }

    public void setPerc(String perc) {
        this.perc = perc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
