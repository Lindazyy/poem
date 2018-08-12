package com.example.acer.poem;

import android.os.Bundle;

import android.app.Activity;
import android.database.Cursor;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyWorks extends Activity {

    private ListView listview;
    private SimpleAdapter simple_adapter;
    private List<Map<String, Object>> dataList;
    private Button addNote;
    private TextView tv_title;
    private TextView tv_content;
    private TextView tv_date;
    //private SQLiteDatabase db;
    private MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_works);

        Toast.makeText(MyWorks.this, "Sorry but this function will come soon in the future ~", Toast.LENGTH_SHORT).show();
        //全局变量：SQLite数据库
        app = (MyApplication) getApplication();
        app.wDBAdapter.open();

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_content = (TextView) findViewById(R.id.tv_content);
        tv_date = (TextView) findViewById(R.id.tv_date);
        listview = (ListView) findViewById(R.id.listview);
        dataList = new ArrayList<Map<String, Object>>();
/*
        addNote = (Button) findViewById(R.id.btn_editnote);
        listview.setOnItemClickListener(this);
        listview.setOnItemLongClickListener(this);
        addNote.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MyWorks.this, WriteEdit.class);
                Bundle bundle = new Bundle();
                bundle.putString("info", "");
                bundle.putInt("enter_state", 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
*/
    }

    //在activity显示的时候更新listview
    @Override
    protected void onStart() {
        super.onStart();
        //RefreshNotesList();
    }

    //刷新listview
    public void RefreshNotesList() {
        //如果dataList已经有的内容，全部删掉
        //并且更新simp_adapter
        int size = dataList.size();
        if (size > 0) {
            dataList.removeAll(dataList);
            simple_adapter.notifyDataSetChanged();
        }

        //从数据库读取信息
        Cursor cursor = app.wDBAdapter.queryAllData();
        startManagingCursor(cursor);
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            String date = cursor.getString(cursor.getColumnIndex("date"));
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("tv_title", title);
            map.put("tv_content", content);
            map.put("tv_date", date);
            dataList.add(map);
        }
        simple_adapter = new SimpleAdapter(this, dataList,
                R.layout.writing_item,
                new String[]{"tv_title","tv_content", "tv_date"},
                new int[]{R.id.tv_title, R.id.tv_content, R.id.tv_date});

        listview.setAdapter(simple_adapter);
    }

    /*
    // 点击listview中某一项的点击监听事件
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        //获取listview中此个item中的内容
        String content = listview.getItemAtPosition(arg2) + "";
        String content1 = content.substring(content.indexOf("=") + 1,
                content.indexOf(","));

        Intent myIntent = new Intent(MyWorks.this, WriteEdit.class);
        Bundle bundle = new Bundle();
        bundle.putString("info", content1);
        bundle.putInt("enter_state", 1);
        myIntent.putExtras(bundle);
        startActivity(myIntent);

    }

    // 点击listview中某一项长时间的点击事件
    @Override
    public boolean onItemLongClick(AdapterView<?> arg0, View arg1, final int arg2,
                                   long arg3) {
        Builder builder = new Builder(this);
        builder.setTitle("删除该日志");
        builder.setMessage("确认删除吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //获取listview中此个item中的内容
                //删除该行后刷新listview的内容
                String content = listview.getItemAtPosition(arg2) + "";
                String content1 = content.substring(content.indexOf("=") + 1,
                        content.indexOf(","));
                DB.delete("note", "content = ?", new String[]{content1});
                RefreshNotesList();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create();
        builder.show();
        return true;
    }
*/
}
