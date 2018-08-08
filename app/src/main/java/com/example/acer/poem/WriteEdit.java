//problem:
// 1. 数据库问题。（需要。）
// 2. 校验。（需要。）
// 3. 提示。（未知。）

package com.example.acer.poem;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteEdit extends Activity implements OnClickListener {

    private TextView tv_date;
    private TextView tv_cipaiming;
    private EditText et_content;
    private EditText et_title;
    private Button btn_ok;
    private Button btn_cancel;
    private Button btn_check;
    private Button btn_hint;
    private PoemDataBaseHelper DBHelper;
    public int enter_state = 0;//用来区分是新建还是更改
    public String last_content;//用来获取内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        InitView();
    }

    private void InitView() {
        //tv_date = (TextView) findViewById(R.id.tv_date);
        tv_cipaiming = (TextView) findViewById(R.id.tv_cipaiming);
        et_content = (EditText) findViewById(R.id.et_content);
        et_title = (EditText) findViewById(R.id.et_title);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_check = (Button) findViewById(R.id.btn_check);
        btn_hint = (Button) findViewById(R.id.btn_hint);
        DBHelper = new PoemDataBaseHelper(this);

        //传递词牌名
        tv_cipaiming.setText("词牌名");

        //获取此时时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = sdf.format(date);
        //tv_date.setText(dateString);

/*导致崩溃：
        //接收内容和id
        Bundle myBundle = this.getIntent().getExtras();
        last_content = myBundle.getString("info");
        enter_state = myBundle.getInt("enter_state");
        et_content.setText(last_content);
*/
        //监听
        btn_cancel.setOnClickListener(this);
        btn_ok.setOnClickListener(this);
        btn_check.setOnClickListener(this);
        btn_hint.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_ok://将结果存入数据库
/*
                // 获取edittext内容
                SQLiteDatabase db = DBHelper.getReadableDatabase();
                String content = et_content.getText().toString();

                // 添加一个新的日志
                if (enter_state == 0) {
                    if (!content.equals("")) {
                        //获取此时时刻时间
                        Date date = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String dateString = sdf.format(date);

                        //向数据库添加信息
                        ContentValues values = new ContentValues();
                        values.put("content", content);
                        values.put("date", dateString);
                        db.insert("note", null, values);
                        finish();
                    } else {
                        Toast.makeText(WriteEdit.this, "请输入", Toast.LENGTH_SHORT).show();
                    }
                }
                // 查看并修改一个已有的作品
                else {
                    ContentValues values = new ContentValues();
                    values.put("content", content);
                    db.update("note", values, "content = ?", new String[]{last_content});
                    finish();
                }
*/
                break;

            case R.id.btn_cancel:
                Builder dialog = new AlertDialog.Builder(WriteEdit.this);
                dialog.setTitle("Exit without saving?");
                dialog.setPositiveButton("Yes",new okClick());
                dialog.setNegativeButton("No",new noClick());
                dialog.create();
                dialog.show();
                //finish();
                break;

            case R.id.btn_check://实现格律校验，希望按住不放时会跳出平仄以及检验结果？
                Toast.makeText(WriteEdit.this, "Sorry but this function will come soon in the future ~", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_hint://希望对选中词语搜索押韵、对仗等结果？
                Toast.makeText(WriteEdit.this, "Sorry but this function will come soon in the future ~", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //AlertDialog按钮监听（Yes = 退出）
    class okClick implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which){
            finish();
        }
    }
    class noClick implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which){
            dialog.cancel();
        }
    }
}