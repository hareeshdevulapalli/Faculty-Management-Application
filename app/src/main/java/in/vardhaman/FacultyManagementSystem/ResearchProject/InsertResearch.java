package in.vardhaman.FacultyManagementSystem.ResearchProject;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import in.vardhaman.FacultyManagementSystem.ModelCollection.ResearchModel;
import in.vardhaman.FacultyManagementSystem.R;

public class InsertResearch extends AppCompatActivity {

    TextView txt_date,txt_deadline;
    EditText edt_perc, edt_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_research);

        txt_date = findViewById(R.id.txt_date);
        txt_deadline = findViewById(R.id.txt_date_deadline);
        edt_perc = findViewById(R.id.txt_percentage);
        edt_title = findViewById(R.id.txt_title);

        txt_deadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear,mMonth,mDay;

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertResearch.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        txt_deadline.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        txt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mYear,mMonth,mDay;

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertResearch.this, new DatePickerDialog.OnDateSetListener() {
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
        String perc = edt_perc.getText().toString();
        String title = edt_title.getText().toString();

        String date = txt_date.getText().toString();
        String date_deadline = txt_deadline.getText().toString();

        if(date.equals("Click here to select date") || date_deadline.equals("Click here to select date"))
        {
            Toast.makeText(InsertResearch.this,"Enter date",Toast.LENGTH_SHORT).show();
        }
        else
        {
            ResearchModel.executeQuery("create table if not exists RESEARCH_MODEL(DATE text,DEADLINE text,TITLE text,PERC text);");

            ResearchModel model = new ResearchModel(date_deadline,title,perc,date);
            model.save();
            finish();
        }
    }
}
