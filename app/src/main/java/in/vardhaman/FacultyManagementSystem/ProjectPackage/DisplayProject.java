package in.vardhaman.FacultyManagementSystem.ProjectPackage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.ProjectModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayProject extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_project);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayProject.this));

        ProjectModel.executeQuery("create table if not exists PROJECT_MODEL (STUDENTID text, TITLE text, PERCENTAGE text, DATE text);");

        List<ProjectModel> projectModels=ProjectModel.listAll(ProjectModel.class);

        Log.d("size",projectModels.size()+"");

        SlimAdapter.create().register(R.layout.project_single_item, new SlimInjector<ProjectModel>() {
            @Override
            public void onInject(ProjectModel data, IViewInjector injector) {

                injector.text(R.id.txt_id,data.getStudentid())
                        .text(R.id.txt_title,data.getTitle())
                        .text(R.id.txt_perc,data.getPercentage())
                        .text(R.id.txt_date,data.getDate());
            }
        }).attachTo(recyclerView).updateData(projectModels);
    }
}
