package in.vardhaman.FacultyManagementSystem.EvaluationPackage;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import in.vardhaman.FacultyManagementSystem.ModelCollection.EvaluationModel;
import in.vardhaman.FacultyManagementSystem.R;

public class InsertEvaluationActivity extends AppCompatActivity {

    TextView txt_date;
    CheckBox check1,check2;
    EditText edt_subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_evaluation);

        txt_date = findViewById(R.id.txt_date);
        check1 = findViewById(R.id.chc1);
        check2 = findViewById(R.id.chc2);

        edt_subject = findViewById(R.id.edt_subject);

        txt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int mYear,mMonth,mDay;

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertEvaluationActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        String subject = edt_subject.getText().toString();
        String date=txt_date.getText().toString();

        if(date.equals("Click here to select date"))
        {
            Toast.makeText(InsertEvaluationActivity.this,"Select date",Toast.LENGTH_SHORT).show();
        }
        else if(subject.equals("")){
            Toast.makeText(InsertEvaluationActivity.this,"Enter subject",Toast.LENGTH_SHORT).show();
        }
        else {

            String time="";

            String time_1 = check1.isChecked()? "Morning":"";
            String time_2 = check2.isChecked()? "After Noon":"";

            String[] time_array = { time_1,time_2 };

            for(String s : time_array){
                if(!s.equals("")){
                    if(time.length() >= 1)
                        time = time.concat(","+s);
                    else
                        time = time.concat(s);
                }
            }

            Log.d("time",time);

            EvaluationModel.executeQuery("create table if not exists EVALUATION_MODEL (DATE text, SUBJECT text, TIME text);");

            EvaluationModel model = new EvaluationModel(date,subject,time);
            model.save();
            finish();
        }
    }
}
