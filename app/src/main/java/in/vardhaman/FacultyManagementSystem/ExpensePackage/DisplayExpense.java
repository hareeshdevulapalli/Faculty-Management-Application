package in.vardhaman.FacultyManagementSystem.ExpensePackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import in.vardhaman.FacultyManagementSystem.ModelCollection.ExpenseModel;
import in.vardhaman.FacultyManagementSystem.R;

public class DisplayExpense extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_expense);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayExpense.this));


        ExpenseModel.executeQuery("create table if not exists EXPENSE_MODEL (DATE text, AMOUNT text);");

        List<ExpenseModel> expenseModels=ExpenseModel.listAll(ExpenseModel.class);

        Log.d("size",expenseModels.size()+"");

        SlimAdapter.create().register(R.layout.expense_single_item, new SlimInjector<ExpenseModel>() {
            @Override
            public void onInject(ExpenseModel data, IViewInjector injector) {

                injector.text(R.id.txt_date,data.getDate())
                        .text(R.id.txt_amount,data.getAmount());
            }
        }).attachTo(recyclerView).updateData(expenseModels);
    }
}
