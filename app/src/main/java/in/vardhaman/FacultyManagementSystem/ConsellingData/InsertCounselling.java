package in.vardhaman.FacultyManagementSystem.ConsellingData;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import in.vardhaman.FacultyManagementSystem.ModelCollection.CounsellingModel;
import in.vardhaman.FacultyManagementSystem.R;

public class InsertCounselling extends AppCompatActivity {

    EditText edt_student_id, edt_marks, edt_desc;
    TextView txt_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_counselling);

        edt_student_id = findViewById(R.id.txt_id);
        edt_marks = findViewById(R.id.txt_marks);
        edt_desc = findViewById(R.id.txt_desc);
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


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertCounselling.this, new DatePickerDialog.OnDateSetListener() {
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

        String date= txt_date.getText().toString();

        String student_id =edt_student_id.getText().toString();
        String txt_marks = edt_marks.getText().toString();
        String txt_desc = edt_desc.getText().toString();

        if(date.equals("Click here to select date"))
        {
            Toast.makeText(InsertCounselling.this,"Enter date",Toast.LENGTH_SHORT).show();
        }
        else if(student_id.equals("") || txt_marks.equals("") || txt_desc.equals(""))
        {
            Toast.makeText(InsertCounselling.this,"Enter all details",Toast.LENGTH_SHORT).show();
        }
        else
        {
            CounsellingModel.executeQuery("create table if not exists COUNSELLING_MODEL(STUDENTID text,DATE text,MARKS text,DESC text);");

            CounsellingModel model = new CounsellingModel(student_id, txt_marks,txt_desc, date);
            model.save();
            finish();
        }
    }
}
