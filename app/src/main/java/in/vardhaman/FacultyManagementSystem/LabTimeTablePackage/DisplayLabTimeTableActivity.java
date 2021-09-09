package in.vardhaman.FacultyManagementSystem.LabTimeTablePackage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.LabTimeTableModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayLabTimeTableActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_class_time_table);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayLabTimeTableActivity.this));
        LabTimeTableModel.executeQuery("create table if not exists LAB_TIME_TABLE_MODEL (DATE text, LECTURE text, SUBJECT text);");

        List<LabTimeTableModel> labTimeTableModels=LabTimeTableModel.listAll(LabTimeTableModel.class);

        Log.d("size",labTimeTableModels.size()+"");

        SlimAdapter.create().register(R.layout.timetable_single_layout, new SlimInjector<LabTimeTableModel>() {
            @Override
            public void onInject(LabTimeTableModel data, IViewInjector injector) {

                injector.text(R.id.txt_date,data.getDate())
                        .text(R.id.txt_lecture,data.getLecture())
                        .text(R.id.txt_subject,data.getSubject());
            }
        }).attachTo(recyclerView).updateData(labTimeTableModels);
    }

}
