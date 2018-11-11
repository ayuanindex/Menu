package com.ayuan.menu;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewById = (Button) findViewById(R.id.btn_jump);
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        //第二种方式添加菜单（groupId：作用时分组；itemId：给选项设置id；order：给菜单选项设置排序；title：菜单项上显示的名称）
        menu.add(0, 1, 0, "联系我们");
        menu.add(0, 2, 0, "关于");
        return super.onCreateOptionsMenu(menu);
    }

    //判断点击的是menu菜单的哪个条目需要重写这个方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                Log.i(TAG, "这里是设置");
                break;
            case R.id.action_player:
                Log.i(TAG, "这里是显示");
                break;
            case 1:
                Log.i(TAG, "这里是联系我们");
                break;
            case 2:
                Log.i(TAG, "这里是关于");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //当用户点menu按键的执行这个方法
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        //弹出一个对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("Your Network Is Abnorma！！！");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //点击确定
                Log.i(TAG, "点击了确定");
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //点击取消
                Log.i(TAG, "点击了取消");
            }
        });
        //使用对话框一定要让他显示出来
        builder.show();
        return false;
    }
}
