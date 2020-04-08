package amin.mir.mvvm_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import amin.mir.mvvm_1.databinding.ActivityMainBinding;
import amin.mir.mvvm_1.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        UserViewModel userViewModel = new UserViewModel(this);
        activityMainBinding.setUser(userViewModel);
    }
}
