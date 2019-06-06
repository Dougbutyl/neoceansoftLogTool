package com.neocean.app.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.neocean.app.logutils.LogUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    CheckBox logCk;
    Button logBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logCk = (CheckBox) findViewById(R.id.ck);
        logCk.setOnCheckedChangeListener(this);
        logBtn = (Button) findViewById(R.id.btn_log);
        logBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        log();

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //建议全局只设置一次方便管理
        LogUtils.init(isChecked);

    }

    void log() {
        LogUtils.i("i 打印内容显示");
        LogUtils.il("il 带标签打印内容显示");
        LogUtils.e("e 打印内容显示");
        LogUtils.el("el 带标签打印内容显示");
        LogUtils.a("a 打印内容显示");
        LogUtils.al("al 带标签打印内容显示");
        LogUtils.d("d 打印内容显示");
        LogUtils.dl("dl 带标签打印内容显示");
        LogUtils.v("v 打印内容显示");
        LogUtils.vl("vl 带标签打印内容显示");
        LogUtils.w("w 打印内容显示");
        LogUtils.wl("wl 带标签打印内容显示");


    }
}
