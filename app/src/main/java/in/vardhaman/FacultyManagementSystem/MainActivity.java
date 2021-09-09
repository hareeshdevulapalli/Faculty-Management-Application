package in.vardhaman.FacultyManagementSystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yalantis.guillotine.animation.GuillotineAnimation;

import in.vardhaman.FacultyManagementSystem.AssignmentPackage.DisplayAssignment;
import in.vardhaman.FacultyManagementSystem.AssignmentPackage.InsertAssignmentActivity;
import in.vardhaman.FacultyManagementSystem.ClassTimeTablePackage.DisplayClassTimeTableActivity;
import in.vardhaman.FacultyManagementSystem.ClassTimeTablePackage.InsertClassTimeTableDetail;
import in.vardhaman.FacultyManagementSystem.ConsellingData.DisplayCounselling;
import in.vardhaman.FacultyManagementSystem.ConsellingData.InsertCounselling;
import in.vardhaman.FacultyManagementSystem.EvaluationPackage.DisplayEvaluation;
import in.vardhaman.FacultyManagementSystem.EvaluationPackage.InsertEvaluationActivity;
import in.vardhaman.FacultyManagementSystem.ExamTimeTablePackage.DisplayExamActivity;
import in.vardhaman.FacultyManagementSystem.ExamTimeTablePackage.InsertExamTimeTable;
import in.vardhaman.FacultyManagementSystem.ExpensePackage.DisplayExpense;
import in.vardhaman.FacultyManagementSystem.ExpensePackage.InsertExpense;
import in.vardhaman.FacultyManagementSystem.HolidayPackage.ViewHoliday;
import in.vardhaman.FacultyManagementSystem.LabTimeTablePackage.DisplayLabTimeTableActivity;
import in.vardhaman.FacultyManagementSystem.LabTimeTablePackage.InsertLabTimeTableDetail;
import in.vardhaman.FacultyManagementSystem.ProjectPackage.DisplayProject;
import in.vardhaman.FacultyManagementSystem.ProjectPackage.InsertProject;
import in.vardhaman.FacultyManagementSystem.ResearchProject.DisplayResearch;
import in.vardhaman.FacultyManagementSystem.ResearchProject.InsertResearch;
import in.vardhaman.FacultyManagementSystem.Utils.CommonString;
import in.vardhaman.FacultyManagementSystem.Utils.SharedPref;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        FrameLayout frameLayout = findViewById(R.id.root);
        ImageView contentHamburger = findViewById(R.id.content_hamburger);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.gullotine_menu, null);
        frameLayout.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(200)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();

        guillotineMenu.findViewById(R.id.txt_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SharedPref(MainActivity.this).setData(CommonString.IS_LOGGED_IN_KEY,"no");

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                finish();
            }
        });
    }

    public void openInsertTimeTable(View view){
        startActivity(new Intent(MainActivity.this, InsertClassTimeTableDetail.class));
    }
    public void viewTimeTable(View view){
        startActivity(new Intent(MainActivity.this, DisplayClassTimeTableActivity.class));
    }
    public void openInsertLabTimeTable(View view){
        startActivity(new Intent(MainActivity.this, InsertLabTimeTableDetail.class));
    }
    public void viewLabTimeTable(View view){
        startActivity(new Intent(MainActivity.this, DisplayLabTimeTableActivity.class));
    }
    public void openExamTable(View view){
        startActivity(new Intent(MainActivity.this, InsertExamTimeTable.class));
    }
    public void viewExamTable(View view){
        startActivity(new Intent(MainActivity.this, DisplayExamActivity.class));
    }
    public void openEvaluation(View view){
        startActivity(new Intent(MainActivity.this, InsertEvaluationActivity.class));
    }
    public void displayEvaluation(View view){
        startActivity(new Intent(MainActivity.this, DisplayEvaluation.class));
    }
    public void openAssignment(View view) {
        startActivity(new Intent(MainActivity.this, InsertAssignmentActivity.class));
    }
    public void DisplayAssignment(View view) {
        startActivity(new Intent(MainActivity.this, DisplayAssignment.class));
    }
    public void openProject(View view) {
        startActivity(new Intent(MainActivity.this, InsertProject.class));
    }
    public void displayProject(View view) {
        startActivity(new Intent(MainActivity.this, DisplayProject.class));
    }
    public void openCounselling(View view) {
        startActivity(new Intent(MainActivity.this, InsertCounselling.class));
    }
    public void displayCounselling(View view) {
        startActivity(new Intent(MainActivity.this, DisplayCounselling.class));
    }
    public void openResearch(View view) {
        startActivity(new Intent(MainActivity.this, InsertResearch.class));
    }
    public void displayResearch(View view) {
        startActivity(new Intent(MainActivity.this, DisplayResearch.class));
    }

    public void viewHoliday(View view) {
        startActivity(new Intent(MainActivity.this, ViewHoliday.class));
    }

    public void InsertExpense(View view) {
        startActivity(new Intent(MainActivity.this, InsertExpense.class));
    }

    public void displayExpense(View view) {
        startActivity(new Intent(MainActivity.this, DisplayExpense.class));
    }
}
