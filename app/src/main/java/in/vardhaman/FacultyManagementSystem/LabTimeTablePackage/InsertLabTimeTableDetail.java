package in.vardhaman.FacultyManagementSystem.LabTimeTablePackage;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import in.vardhaman.FacultyManagementSystem.ModelCollection.LabTimeTableModel;
import in.vardhaman.FacultyManagementSystem.R;

public class InsertLabTimeTableDetail extends AppCompatActivity {

    TextView txt_date;
    CheckBox check1,check2,check3,check4,check5,check6,check7;
    EditText edt_subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_class_time_table_detail);

        txt_date = findViewById(R.id.txt_date);
        check1 = findViewById(R.id.chc1);
        check2 = findViewById(R.id.chc2);
        check3 = findViewById(R.id.chc3);
        check4 = findViewById(R.id.chc4);
        check5 = findViewById(R.id.chc5);
        check6 = findViewById(R.id.chc6);
        check7 = findViewById(R.id.chc7);
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


                DatePickerDialog datePickerDialog = new DatePickerDialog(InsertLabTimeTableDetail.this, new DatePickerDialog.OnDateSetListener() {
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
            Toast.makeText(InsertLabTimeTableDetail.this,"Select date",Toast.LENGTH_SHORT).show();
        }
        else if(subject.equals("")){
            Toast.makeText(InsertLabTimeTableDetail.this,"Enter subject",Toast.LENGTH_SHORT).show();
        }
        else {

            String lecture="";

            String lec_1 = check1.isChecked()? "1":"";
            String lec_2 = check2.isChecked()? "2":"";
            String lec_3 = check3.isChecked()? "3":"";
            String lec_4 = check4.isChecked()? "4":"";
            String lec_5 = check5.isChecked()? "5":"";
            String lec_6 = check6.isChecked()? "6":"";
            String lec_7 = check7.isChecked()? "7":"";

            String[] lec_array = { lec_1,lec_2,lec_3,lec_4,lec_5,lec_6,lec_7 };

            for(String s : lec_array){
                if(!s.equals("")){

                    if(lecture.length() >= 1)
                        lecture = lecture.concat(","+s);
                    else
                        lecture = lecture.concat(s);

                }
            }

            Log.d("lecture",lecture);

            LabTimeTableModel.executeQuery("create table if not exists LAB_TIME_TABLE_MODEL (DATE text, LECTURE text, SUBJECT text);");

            LabTimeTableModel model = new LabTimeTableModel(date, lecture, subject);
            model.save();
            finish();
        }
    }
}
