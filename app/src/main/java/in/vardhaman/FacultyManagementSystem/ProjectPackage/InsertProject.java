package in.vardhaman.FacultyManagementSystem.ProjectPackage;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import in.vardhaman.FacultyManagementSystem.ModelCollection.ProjectModel;
import in.vardhaman.FacultyManagementSystem.R;

public class InsertProject extends AppCompatActivity {

    EditText edt_student_id,edt_title,edt_project_completion;
    TextView txt_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_project);

        edt_title = findViewById(R.id.txt_title);
        edt_student_id = findViewById(R.id.txt_id);
        edt_project_completion = findViewById(R.id.txt_percentage);
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


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertProject.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }

    public void submit(View view)
    {
        String title=edt_title.getText().toString();
        String student_id=edt_student_id.getText().toString();
        String project_perc=edt_project_completion.getText().toString();
        String date=txt_date.getText().toString();

        if(title.equals("") || student_id.equals("") || project_perc.equals(""))
        {
            Toast.makeText(InsertProject.this,"Enter details",Toast.LENGTH_SHORT).show();
        }
        else if(date.equals("Click here to select date"))
        {
            Toast.makeText(InsertProject.this,"Select date",Toast.LENGTH_SHORT).show();
        }
        else {

            ProjectModel.executeQuery("create table if not exists PROJECT_MODEL(DATE text,TITLE text,PERCENTAGE text,STUDENTID text);");

            ProjectModel model = new ProjectModel(student_id,title,project_perc,date);
            model.save();
            finish();
        }
    }
}
