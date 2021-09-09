package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class CounsellingModel extends SugarRecord
{
    String studentid, marks, desc, date;

    public CounsellingModel() {
    }

    public CounsellingModel(String studentid, String marks, String desc, String date) {
        this.studentid = studentid;
        this.marks = marks;
        this.desc = desc;
        this.date = date;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
