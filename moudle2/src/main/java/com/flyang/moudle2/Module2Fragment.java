package com.flyang.moudle2;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyang.annotation.apt.Router;
import com.flyang.api.router.IntentRouter;

/**
 * A simple {@link Fragment} subclass.
 */
@Router("fragment2")
public class Module2Fragment extends Fragment {

    public Module2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_module2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getView().findViewById(R.id.btn_go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentRouter.build(Uri.parse("test://filter/module2")).go(Module2Fragment.this);
                getActivity().finish();
            }
        });
    }
}
