package in.vardhaman.FacultyManagementSystem.ExamTimeTablePackage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.ExamModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayExamActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_class_time_table);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayExamActivity.this));
        //ExamModel.executeQuery("create table if not exists EXAM_MODEL (DATE text, ROOMNO text, TIME text);");

        ExamModel.executeQuery("create table if not exists EXAM_MODEL (DATE text,TIME text,ROOMNO text);");

        List<ExamModel> examModelList=ExamModel.listAll(ExamModel.class);

        Log.d("size",examModelList.size()+"");

        SlimAdapter.create().register(R.layout.exam_single_layout, new SlimInjector<ExamModel>() {
            @Override
            public void onInject(ExamModel data, IViewInjector injector) {

                injector.text(R.id.txt_date,data.getDate())
                        .text(R.id.txt_room_no,data.getRoomno())
                        .text(R.id.txt_time,data.getTime());
            }
        }).attachTo(recyclerView).updateData(examModelList);
    }

}
