package in.vardhaman.FacultyManagementSystem.HolidayPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.HolidayModel;
import in.vardhaman.FacultyManagementSystem.R;

public class ViewHoliday extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_holiday);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewHoliday.this));

        HolidayModel.executeQuery("create table if not exists HOLIDAY_MODEL (DATE text, OCASSION text);");

        List<HolidayModel> holidayModels=HolidayModel.listAll(HolidayModel.class);

        holidayModels.add(new HolidayModel("12-03-2019","Ocassion A"));
        holidayModels.add(new HolidayModel("13-03-2019","Ocassion B"));
        holidayModels.add(new HolidayModel("25-03-2019","Ocassion C"));
        holidayModels.add(new HolidayModel("26-03-2019","Ocassion D"));
        holidayModels.add(new HolidayModel("28-03-2019","Ocassion E"));

        Log.d("size",holidayModels.size()+"");

        SlimAdapter.create().register(R.layout.holiday_single_item, new SlimInjector<HolidayModel>() {
            @Override
            public void onInject(HolidayModel data, IViewInjector injector) {

                injector.text(R.id.txt_date,data.getDate())
                        .text(R.id.txt_ocassion,data.getOcassion());
            }
        }).attachTo(recyclerView).updateData(holidayModels);
    }
}
