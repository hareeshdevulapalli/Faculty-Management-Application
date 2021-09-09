package in.vardhaman.FacultyManagementSystem.ClassTimeTablePackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.ClassTimeTableModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayClassTimeTableActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_class_time_table);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayClassTimeTableActivity.this));
        ClassTimeTableModel.executeQuery("create table if not exists CLASS_TIME_TABLE_MODEL (DATE text, LECTURE text, SUBJECT text);");

        List<ClassTimeTableModel> classTimeTableModels=ClassTimeTableModel.listAll(ClassTimeTableModel.class);

        Log.d("size",classTimeTableModels.size()+"");

        SlimAdapter.create().register(R.layout.timetable_single_layout, new SlimInjector<ClassTimeTableModel>() {
            @Override
            public void onInject(ClassTimeTableModel data, IViewInjector injector) {

                injector.text(R.id.txt_date,data.getDate())
                        .text(R.id.txt_lecture,data.getLecture())
                        .text(R.id.txt_subject,data.getSubject());

            }
        }).attachTo(recyclerView).updateData(classTimeTableModels);
    }

}
