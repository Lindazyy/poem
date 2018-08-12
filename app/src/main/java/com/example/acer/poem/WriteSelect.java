//暂时是从tab3到WriteEdit的直接过渡
package com.example.acer.poem;
import android.app.Activity;
//import android.app.AlertDialog.Builder;
//import android.content.DialogInterface;
import android.content.Intent;
//import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

//import java.util.ArrayList;
//import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class WriteSelect extends Activity {
/*
    private ListView listview;
    private SimpleAdapter simple_adapter;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab3_layout);

        InitView();
    }

    private void InitView() {
        WriteTest = (Button) findViewById(R.id.btn_WriteTest);
        DbHelper = new DBOpenHelper(this);
        DB = DbHelper.getReadableDatabase();

        //listview.setOnItemClickListener(this);
        //listview.setOnItemLongClickListener(this);
        WriteTest.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(WriteSelect.this, WriteEdit.class);
                Bundle bundle = new Bundle();
                bundle.putString("info", "");
                bundle.putInt("enter_state", 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });
    }*/
}