package com.example.msi.fragmentdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
    boolean status = false;
    Button btn_load;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_load = (Button)findViewById(R.id.btn_load);
        btn_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(!status){
                    FragmentOne f1 = new FragmentOne();
                    fragmentTransaction.add(R.id.fragment_container, f1);
                    fragmentTransaction.commit();
                    btn_load.setText("LOAD FRAGMENT TWO");
                    status = true;
                }
                else{
                    FragmentTwo f2 = new FragmentTwo();
                    fragmentTransaction.add(R.id.fragment_container,f2);
                    fragmentTransaction.commit();
                    btn_load.setText("LOAD FRAGMENT ONE");
                    status = false;
                }
            }
        });
    }


}
