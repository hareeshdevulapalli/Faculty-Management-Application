package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class AssignmentModel extends SugarRecord
{
    String date, studentId, title, submissionDate;
    String facid;

    public AssignmentModel() {
    }

    public AssignmentModel(String date, String studentId, String title, String submissionDate) {
        this.date = date;
        this.studentId = studentId;
        this.title = title;
        this.submissionDate = submissionDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }
}
