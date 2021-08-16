package com.example.mvp.ui;

import static com.example.mvp.R.layout.activity_main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.mvp.R;
import com.example.mvp.pojo.MoiveModel;
// model --> view model --> view
/** view asks view model about the data
 *  view model gets the data from model / database
 *  view model sets the value of mutablelivedata to the data
 *  view model notifies that the data has changed
 *  view listens for the changes in mutablelivedata and get the value of it
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView moiveNameTv;
    Button getMoiveButton;
    MoiveViewModel moiveViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        moiveNameTv = findViewById(R.id.textView);
        getMoiveButton = findViewById(R.id.button);
        getMoiveButton.setOnClickListener(this);

        /**
         * this : refers to current view which listens for live data
         * view model : is MoiveViewModel
         */
        moiveViewModel = ViewModelProviders.of(this).get(MoiveViewModel.class);
        moiveViewModel.moiveNameMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                // when there is a change in the data do this
                moiveNameTv.setText(s);
            }
        });

    }

    // asks view model about data
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button){
            moiveViewModel.getMoiveName();
        }
    }

}