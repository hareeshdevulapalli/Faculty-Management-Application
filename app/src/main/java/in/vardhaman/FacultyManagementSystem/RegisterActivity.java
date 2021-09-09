package in.vardhaman.FacultyManagementSystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import in.vardhaman.FacultyManagementSystem.ModelCollection.FacultyModel;

public class RegisterActivity extends AppCompatActivity {

    EditText edt_id,edt_pass,edt_pass_2;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edt_id = findViewById(R.id.edt_faculty);
        edt_pass = findViewById(R.id.edt_password);
        edt_pass_2 = findViewById(R.id.edt_password_2);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edt_id.getText().toString();

                String pass =edt_pass.getText().toString();
                String pass2 = edt_pass_2.getText().toString();

                if(id.equals("") || pass.equals("") || pass2.equals("")){
                    Toast.makeText(RegisterActivity.this,"Enter all details",Toast.LENGTH_SHORT).show();
                }
                else if(!pass.equals("") && !pass.equals(pass2))
                {
                    Toast.makeText(RegisterActivity.this,"Enter valid password",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    FacultyModel facultyModel = new FacultyModel();
                    facultyModel.setFacultyId(id);
                    facultyModel.setPassword(pass);
                    facultyModel.save();

                    Toast.makeText(RegisterActivity.this,"Registration successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    public void goLogin(View view) {
        finish();
    }
}
