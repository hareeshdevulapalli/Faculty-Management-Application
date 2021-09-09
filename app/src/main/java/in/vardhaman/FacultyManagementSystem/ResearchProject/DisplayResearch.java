package in.vardhaman.FacultyManagementSystem.ResearchProject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.ResearchModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayResearch extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_research);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayResearch.this));
        //LabTimeTableModel.executeQuery("create table if not exists LAB_TIME_TABLE_MODEL (DATE text, LECTURE text, SUBJECT text);");

        ResearchModel.executeQuery("create table if not exists RESEARCH_MODEL(DATE text,DEADLINE text,TITLE text,PERC text);");

        List<ResearchModel> researchModels=ResearchModel.listAll(ResearchModel.class);

        Log.d("size",researchModels.size()+"");

        SlimAdapter.create().register(R.layout.research_single_item, new SlimInjector<ResearchModel>() {
            @Override
            public void onInject(ResearchModel data, IViewInjector injector) {

                injector.text(R.id.txt_deadline,data.getDeadline())
                        .text(R.id.txt_title,data.getTitle())
                        .text(R.id.txt_perc,data.getPerc())
                        .text(R.id.txt_date,data.getDate());
            }
        }).attachTo(recyclerView).updateData(researchModels);
    }
}
