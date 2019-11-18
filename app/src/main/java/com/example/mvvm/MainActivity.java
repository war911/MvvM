package com.example.mvvm;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author war
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MainViewModel mMainViewModel;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.buttonLogin);
        Log.d(TAG, "onCreate: ---- > ");
//        if (savedInstanceState != null) {
//            Log.i(TAG, "onCreate: 00 >"+savedInstanceState.get("KEY"));
//        }
        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        btn.setText(mMainViewModel.number+"");

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(TAG, "onSaveInstanceState: ---> ");
        outState.putString("KEY", "war ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ---- > ");
    }

    public void onclick(View view) {
        mMainViewModel.number++;
        btn.setText(mMainViewModel.number+"");

    }
}
