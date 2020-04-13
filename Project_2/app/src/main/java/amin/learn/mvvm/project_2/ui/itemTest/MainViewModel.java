package amin.learn.mvvm.project_2.ui.itemTest;

import android.app.Application;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import amin.learn.mvvm.project_2.BaseViewModel;
import amin.learn.mvvm.project_2.api.ApiInterface;
import amin.learn.mvvm.project_2.api.ApiUtil;
import amin.learn.mvvm.project_2.model.UserModel;

public class MainViewModel extends BaseViewModel {
    private MutableLiveData<ArrayList<UserModel>> userLiveData;
    private ArrayList<UserModel> userArrayList;

    public MainViewModel(@NonNull Application application) {
        super(application);
        userLiveData = new MutableLiveData<>();
        userArrayList = new ArrayList<>();
        init();
    }

    public MutableLiveData<ArrayList<UserModel>> getUserMutableLiveData() {
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
            userArrayList.add(new UserModel(first_name,last_name,avatar));
        }
        userLiveData.setValue(userArrayList);

        android.os.Handler mSeekbarUpdateHandler = new Handler();
        mSeekbarUpdateHandler.postDelayed(() -> {
            try {
                JSONObject jsonObject2 = new JSONObject(RESPONE);
                JSONArray jsonArray2 = jsonObject2.getJSONArray("data");

                for (int i = 0; i < jsonArray2.length(); i++) {
                    JSONObject objectArray2 = jsonArray2.getJSONObject(i);
                    String first_name = objectArray2.getString("first_name");
                    String last_name = objectArray2.getString("last_name");
                    String avatar = objectArray2.getString("avatar");
                    userArrayList.add(new UserModel(first_name+"-2",last_name+"-2",avatar+"-2"));
                }
                userLiveData.setValue(userArrayList);
            }catch (Exception e){

            }
    },5000);

    }

}