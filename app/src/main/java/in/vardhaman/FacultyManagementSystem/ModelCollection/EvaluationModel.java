package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class EvaluationModel extends SugarRecord
{
    String date,subject,time;

    public EvaluationModel(String date, String subject, String time) {
        this.date = date;
        this.subject = subject;
        this.time = time;
    }

    public EvaluationModel() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
