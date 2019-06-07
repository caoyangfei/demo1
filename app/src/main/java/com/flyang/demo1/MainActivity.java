package com.flyang.demo1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.OnClick;
import com.flyang.api.bind.FacadeBind;
import com.flyang.api.router.IntentRouter;

public class MainActivity extends AppCompatActivity {

    @BindView("btn1")
    Button btn1;
    @BindView("btn2")
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacadeBind.bind(this);
    }

    @OnClick(value = {"btn1", "btn2"})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                IntentRouter.build("moudle1").go(this);
                break;
            case R.id.btn2:
                IntentRouter.build(Uri.parse("test://filter/module2")).go(this);
                break;
        }
    }
}
