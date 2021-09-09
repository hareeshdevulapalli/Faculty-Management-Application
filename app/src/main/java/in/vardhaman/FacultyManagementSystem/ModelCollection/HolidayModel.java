package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class HolidayModel extends SugarRecord
{
    String date, ocassion;

    public HolidayModel(String date, String ocassion) {
        this.date = date;
        this.ocassion = ocassion;
    }

    public HolidayModel() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOcassion() {
        return ocassion;
    }

    public void setOcassion(String ocassion) {
        this.ocassion = ocassion;
    }
}
