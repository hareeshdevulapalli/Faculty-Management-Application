package in.vardhaman.FacultyManagementSystem.AssignmentPackage;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import in.vardhaman.FacultyManagementSystem.ModelCollection.AssignmentModel;
import in.vardhaman.FacultyManagementSystem.R;

public class InsertAssignmentActivity extends AppCompatActivity {

    TextView txt_date,txt_submission_date;
    EditText edt_title,edt_student_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_assignment);

        txt_submission_date = findViewById(R.id.txt_submission_date);
        txt_date = findViewById(R.id.txt_date);
        edt_title = findViewById(R.id.edt_title);
        edt_student_id = findViewById(R.id.edt_student_id);

        txt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int mYear,mMonth,mDay;

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertAssignmentActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        txt_submission_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int mYear,mMonth,mDay;

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertAssignmentActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txt_submission_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    public void submit(View view)
    {
        String subject = edt_title.getText().toString();
        String student_id = edt_student_id.getText().toString();
        String date=txt_date.getText().toString();
        String submission_date=txt_submission_date.getText().toString();

        if(date.equals("Click here to select date"))
        {
            Toast.makeText(InsertAssignmentActivity.this,"Select date",Toast.LENGTH_SHORT).show();
        }
        else if(submission_date.equals("Select Submission date"))
        {
            Toast.makeText(InsertAssignmentActivity.this,"Select submission date",Toast.LENGTH_SHORT).show();
        }
        else if(subject.equals("")){
            Toast.makeText(InsertAssignmentActivity.this,"Enter subject",Toast.LENGTH_SHORT).show();
        }
        else if(student_id.equals(""))
        {
            Toast.makeText(InsertAssignmentActivity.this,"Enter student ID",Toast.LENGTH_SHORT).show();
        }
        else {

            AssignmentModel.executeQuery("create table if not exists ASSIGNMENT_MODEL(DATE text,SUBMISSION_DATE text,TITLE text,STUDENT_ID text);");

            AssignmentModel model = new AssignmentModel(date,student_id,subject,submission_date);
            model.save();
            finish();
        }
    }
}
