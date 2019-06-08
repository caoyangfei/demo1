package com.flyang.moudle1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.flyang.annotation.apt.BindView;
import com.flyang.annotation.apt.InjectParam;
import com.flyang.annotation.apt.OnClick;
import com.flyang.annotation.apt.Router;
import com.flyang.api.bind.FacadeBind;
import com.flyang.api.router.IntentRouter;


@Router("fragment1")
public class Module1Fragment extends Fragment {
    // Test param inject, not been used.
    @InjectParam
    int test1 = 123; // test default value
    @InjectParam(key = "test22")
    char[] test2;

    @BindView("btn_go")
    Button btn_go;

    public Module1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        FacadeBind.bind(this);
        IntentRouter.injectParams(Module1Fragment.this);
        Log.d(Module1Fragment.class.getSimpleName(), "test1=" + this.test1);
    }

    @OnClick(value = {"btn_go"})
    public void onCLick(View view) {
        IntentRouter.build("moudle1").go(Module1Fragment.this);
        getActivity().finish();
    }
}
