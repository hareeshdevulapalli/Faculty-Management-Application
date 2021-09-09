package in.vardhaman.FacultyManagementSystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.FacultyModel;
import in.vardhaman.FacultyManagementSystem.Utils.CommonString;
import in.vardhaman.FacultyManagementSystem.Utils.SharedPref;

public class LoginActivity extends AppCompatActivity {

    EditText edt_username, edt_password;
    Button btn_login;
    Boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_username= findViewById(R.id.edt_faculty);
        edt_password= findViewById(R.id.edt_password);
        btn_login= findViewById(R.id.btn_login);

        FacultyModel.executeQuery("create table if not exists FACULTY_MODEL(PASSWORD text,FACULTY_ID text);");



        for(FacultyModel m : FacultyModel.listAll(FacultyModel.class))
        {
            if(!(m.getFacultyId().equals("fac123") && m.getPassword().equals("12345678")))
            {
                FacultyModel model=new FacultyModel();
                model.setFacultyId("fac123");
                model.setPassword("12345678");
                model.save();
            }
        }

        move();
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id= edt_username.getText().toString();
                String pass= edt_password.getText().toString();

                List<FacultyModel> facultyModelList = FacultyModel.listAll(FacultyModel.class);

                for(FacultyModel model : facultyModelList) {

                    if(Id.equals(model.getFacultyId()) && pass.equals(model.getPassword()))
                        flag = true;
                }

                if(flag)
                {
                    new SharedPref(LoginActivity.this).setData(CommonString.LOGGED_IN_FACULTY_KEY,Id);
                    new SharedPref(LoginActivity.this).setData(CommonString.IS_LOGGED_IN_KEY,"yes");
                    move();
                }
                else{
                    Toast.makeText(LoginActivity.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
                    new SharedPref(LoginActivity.this).setData(CommonString.IS_LOGGED_IN_KEY,"no");
                }
            }
        });
    }

    private void move() {

        if(new SharedPref(LoginActivity.this).getData(CommonString.IS_LOGGED_IN_KEY).equals("yes")){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
    }

    public void moveToRegister(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
}
