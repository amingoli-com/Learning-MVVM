package amin.learn.mvvm.project_2.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import amin.learn.mvvm.project_2.model.User;
import amin.learn.mvvm.project_2.api.ApiInterface;
import amin.learn.mvvm.project_2.api.ApiUtil;

public class MainViewModel extends ViewModel {
    private MutableLiveData<ArrayList<User>> userLiveData;
    private ArrayList<User> userArrayList;

    public MainViewModel() {
        userLiveData = new MutableLiveData<>();
        userArrayList = new ArrayList<>();
        init();
    }

    public MutableLiveData<ArrayList<User>> getUserMutableLiveData() {
        return userLiveData;
    }

    private void init(){
        ApiUtil.GetItem("https://raw.githubusercontent.com/amingoli78/Learning-MVVM/master/Project-1/list.json", new ApiInterface() {
            @Override
            public void onResult(String respone) {
                if (respone.length()>10) {
                    try {
                        populateList(respone);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFiled(){}
        });
    }

    private void populateList(String RESPONE) throws JSONException {
        JSONObject jsonObject = new JSONObject(RESPONE);
        JSONArray jsonArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject objectArray = jsonArray.getJSONObject(i);
            String first_name = objectArray.getString("first_name");
            String last_name = objectArray.getString("last_name");
            String avatar = objectArray.getString("avatar");
            userArrayList.add(new User(first_name,last_name,avatar));
        }
        userLiveData.setValue(userArrayList);
    }

}