package amin.learn.mvvm.project_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import amin.learn.mvvm.project_1.databinding.ActivityMainBinding;
import amin.learn.mvvm.project_1.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        UserViewModel userViewModel = new UserViewModel(this);
        activityMainBinding.setUser(userViewModel);
    }
}
