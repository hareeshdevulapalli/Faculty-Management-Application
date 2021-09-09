package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class FacultyModel extends SugarRecord
{
    String facultyId,password;

    public FacultyModel() {
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
