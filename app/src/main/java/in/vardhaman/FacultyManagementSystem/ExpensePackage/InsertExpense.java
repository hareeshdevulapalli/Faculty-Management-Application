package in.vardhaman.FacultyManagementSystem.ExpensePackage;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import in.vardhaman.FacultyManagementSystem.ModelCollection.ExpenseModel;
import in.vardhaman.FacultyManagementSystem.R;

public class InsertExpense extends AppCompatActivity {

    EditText edt_amount;
    TextView txt_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_expense);

        edt_amount = findViewById(R.id.edt_amount);
        txt_date = findViewById(R.id.txt_date);

        txt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int mYear,mMonth,mDay;

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertExpense.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    public void submit(View view) {
        String amount = edt_amount.getText().toString();
        String date = txt_date.getText().toString();

        if(date.equals("Click here to select date") || amount.equals(""))
        {
            Toast.makeText(InsertExpense.this,"Enter data",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ExpenseModel.executeQuery("create table if not exists EXPENSE_MODEL (DATE text, AMOUNT text);");

            ExpenseModel model = new ExpenseModel(date, amount);
            model.save();
            finish();

        }
    }
}
