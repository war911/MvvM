package com.example.mvvm;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvm.databinding.ActivityMainBinding;

/**
 * @author war
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MainViewModel mMainViewModel;
    ActivityMainBinding binding;

    public final static String KEY_A = "A";
    public final static String KEY_B = "B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mMainViewModel = ViewModelProviders.of(this, new SavedStateVMFactory(this)).get(MainViewModel.class);

        binding.setData(mMainViewModel);
        binding.setLifecycleOwner(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: ---- > ");
    }

}
