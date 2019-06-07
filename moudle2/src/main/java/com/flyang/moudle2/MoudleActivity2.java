package com.flyang.moudle2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.OnClick;
import com.flyang.annotation.apt.Router;
import com.flyang.api.bind.FacadeBind;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/6/7
 * ------------- Description -------------
 */
@Router("test://filter/module2")
public class MoudleActivity2 extends AppCompatActivity {

    @BindView("btn1")
    Button btn1;
    @BindView("btn2")
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_moudle2);
        FacadeBind.bind(this);
    }

    @OnClick(value = {"btn1", "btn2"})
    public void onClick(View view) {

    }
}