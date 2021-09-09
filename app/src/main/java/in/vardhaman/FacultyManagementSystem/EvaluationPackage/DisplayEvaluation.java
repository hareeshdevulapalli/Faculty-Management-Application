package in.vardhaman.FacultyManagementSystem.EvaluationPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.EvaluationModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayEvaluation extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_evaluation);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayEvaluation.this));

        EvaluationModel.executeQuery("create table if not exists EVALUATION_MODEL (DATE text, SUBJECT text, TIME text);");

        List<EvaluationModel> evaluationModels=EvaluationModel.listAll(EvaluationModel.class);

        Log.d("size",evaluationModels.size()+"");

        SlimAdapter.create().register(R.layout.evaluation_single, new SlimInjector<EvaluationModel>() {
            @Override
            public void onInject(EvaluationModel data, IViewInjector injector) {

                injector.text(R.id.txt_date,data.getDate())
                        .text(R.id.txt_subject,data.getSubject())
                        .text(R.id.txt_time,data.getTime());
            }
        }).attachTo(recyclerView).updateData(evaluationModels);
    }
}
