package com.example.vantrantrucphuong.kiemtragiuaki.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ContextMenu;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vantrantrucphuong.kiemtragiuaki.Adapter.ListViewAdapterBL;
import com.example.vantrantrucphuong.kiemtragiuaki.Model.CustomListViewBL;
import com.example.vantrantrucphuong.kiemtragiuaki.R;

import java.util.ArrayList;

public class BienLaiActivity extends AppCompatActivity {

    ListView listView;
    Button btn;
    ArrayList<CustomListViewBL> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_lai);
        setControl();
        registerForContextMenu(listView);
        setEvent();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
        getMenuInflater().inflate(R.menu.popup, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_1:
                Toast.makeText(this, "Xóa", Toast.LENGTH_SHORT).show();

            case R.id.option_2:
                Intent intent = new Intent(getApplicationContext(), ChiTietBienLaiActivity.class);
                startActivity(intent);

            default:
                return super.onContextItemSelected(item);
        }
    }
    private void setControl(){
        listView = (ListView) findViewById(R.id.listView);

    }
    private void setEvent() {
        khoiTao();
        ListViewAdapterBL listViewAdapter = new ListViewAdapterBL(this,R.layout.row_listview_bienlai, data);
        listView.setAdapter(listViewAdapter);

//        click item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ChiTietBienLaiActivity.class);
                startActivity(intent);
            }
        });
    }
    private void khoiTao() {
        data.add(new CustomListViewBL("BILL_01", "19/03/2019" ));
        data.add(new CustomListViewBL("BILL_02", "16/05/2019"));
        data.add(new CustomListViewBL("BILL_03", "17/04/2019"));
        data.add(new CustomListViewBL("BILL_04", "18/01/2019" ));
    }
}
