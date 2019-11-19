package com.example.mvvm;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvm.databinding.ActivityMainBinding;

/**
 * @author war
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MainViewModel mMainViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mMainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        binding.setData(mMainViewModel);
        binding.setLifecycleOwner(this);

        if (savedInstanceState != null) {
            Log.i(TAG, "onCreate: --- > " + savedInstanceState.getString("KEY"));
        }

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

}
