package amin.mir.mvvm_1.viewmodel;


import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import amin.mir.mvvm_1.BR;
import amin.mir.mvvm_1.model.User;

public class UserViewModel extends BaseObservable {

    private String name;
    private String phone;

    private Context context;

    public UserViewModel(User user) {
        this.name = name;
        this.phone = phone;
    }

    public UserViewModel(Context context) {
        this.context = context;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
