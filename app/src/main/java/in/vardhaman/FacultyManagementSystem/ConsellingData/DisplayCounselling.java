package in.vardhaman.FacultyManagementSystem.ConsellingData;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.CounsellingModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayCounselling extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_counselling);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayCounselling.this));

        CounsellingModel.executeQuery("create table if not exists COUNSELLING_MODEL(STUDENTID text,DATE text,MARKS text,DESC text);");

        List<CounsellingModel> counsellingModels=CounsellingModel.listAll(CounsellingModel.class);

        Log.d("size",counsellingModels.size()+"");

        SlimAdapter.create().register(R.layout.counselling_single_layout, new SlimInjector<CounsellingModel>() {
            @Override
            public void onInject(CounsellingModel data, IViewInjector injector) {

                injector.text(R.id.txt_date,data.getDate())
                        .text(R.id.txt_marks,data.getMarks())
                        .text(R.id.txt_desc,data.getDesc())
                        .text(R.id.txt_student_id,data.getStudentid());
            }
        }).attachTo(recyclerView).updateData(counsellingModels);

    }
}
