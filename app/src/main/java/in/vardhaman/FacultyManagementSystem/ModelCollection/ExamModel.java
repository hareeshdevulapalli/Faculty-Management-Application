package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class ExamModel extends SugarRecord {
    String date,roomno,time;


    public ExamModel() {
    }

    public ExamModel(String date, String roomno, String time) {
        this.date = date;
        this.roomno = roomno;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
