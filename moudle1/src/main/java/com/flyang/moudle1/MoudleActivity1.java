package com.flyang.moudle1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.OnClick;
import com.flyang.annotation.apt.Router;
import com.flyang.api.bind.FacadeBind;
import com.flyang.api.router.IntentRouter;

/**
 * @author yangfei.cao
 * @ClassName demo1
 * @date 2019/6/7
 * ------------- Description -------------
 */
@Router("moudle1")
public class MoudleActivity1 extends AppCompatActivity {

    @BindView("btn1")
    Button btn1;
    @BindView("btn2")
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_moudle1);
        FacadeBind.bind(this);


        Fragment fragment = (Fragment) IntentRouter.build("fragment2").with("test1", 111).getFragment(this);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().add(R.id.fragment1, fragment).commit();
        }
    }

    @OnClick(value = {"btn1", "btn2"})
    public void onClick(View view) {

    }
}
