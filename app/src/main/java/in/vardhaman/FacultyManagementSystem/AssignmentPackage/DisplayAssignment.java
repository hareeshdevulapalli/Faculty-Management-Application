package in.vardhaman.FacultyManagementSystem.AssignmentPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.AssignmentModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayAssignment extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_assignment);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayAssignment.this));
        //ClassTimeTableModel.executeQuery("create table if not exists CLASS_TIME_TABLE_MODEL (DATE text, LECTURE text, SUBJECT text);");

        AssignmentModel.executeQuery("create table if not exists ASSIGNMENT_MODEL(DATE text,SUBMISSION_DATE text,TITLE text,STUDENT_ID text);");
        List<AssignmentModel> assignmentModels = new ArrayList<>();
        try
        {
            assignmentModels=AssignmentModel.listAll(AssignmentModel.class);

            Log.d("size",assignmentModels.size()+"");

            SlimAdapter.create().register(R.layout.assignment_single_layout, new SlimInjector<AssignmentModel>() {
                @Override
                public void onInject(AssignmentModel data, IViewInjector injector) {

                    injector.text(R.id.txt_date,data.getDate())
                            .text(R.id.txt_title,data.getTitle())
                            .text(R.id.txt_id,data.getStudentId())
                            .text(R.id.txt_deadline,data.getSubmissionDate());

                }
            }).attachTo(recyclerView).updateData(assignmentModels);
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(DisplayAssignment.this,"No Data Available",Toast.LENGTH_SHORT).show();
        }
    }
}
