package in.vardhaman.FacultyManagementSystem.ModelCollection;

import com.orm.SugarRecord;

public class ExpenseModel extends SugarRecord
{
    String date, amount;

    public ExpenseModel(String date, String amount) {
        this.date = date;
        this.amount = amount;
    }

    public ExpenseModel() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
