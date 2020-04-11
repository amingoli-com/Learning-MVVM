package amin.learn.mvvm.project_2.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

import amin.learn.mvvm.project_2.R;
import amin.learn.mvvm.project_2.adapter.RecyclerViewAdapter;
import amin.learn.mvvm.project_2.model.User;
import amin.learn.mvvm.project_2.viewModel.MainViewModel;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    MainActivity context;
    MainViewModel viewModel;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        recyclerView = findViewById(R.id.rv_main);
        viewModel = ViewModelProviders.of(context).get(MainViewModel.class);
        viewModel.getUserMutableLiveData().observe(context, userListUpdateObserver);




        String json = "{ 'name':'John', 'email':'john.doe@gmail.com', 'age':29, 'phone':5168161922, 'city':'NewYork', 'hasCreditCard':false }";

        Gson gson = new Gson();
        UserDetails user = gson.fromJson(json, UserDetails.class);

        Log.d("amingoli", "onCreate: "+user.city);

    }

    Observer<ArrayList<User>> userListUpdateObserver = new Observer<ArrayList<User>>() {
        @Override
        public void onChanged(ArrayList<User> userArrayList) {
            recyclerViewAdapter = new RecyclerViewAdapter(context,userArrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(recyclerViewAdapter);
        }
    };


    class UserDetails {
        private String name;
        private String email;
        private int age;
        private long phone;
        private String city;
        private boolean hasCreditCard;
    }


}
