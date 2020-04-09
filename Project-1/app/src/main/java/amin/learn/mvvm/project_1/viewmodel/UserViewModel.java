package amin.learn.mvvm.project_1.viewmodel;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import amin.learn.mvvm.project_1.BR;
import amin.learn.mvvm.project_1.model.User;
import amin.learn.mvvm.project_1.view.UserAdaptor;

public class UserViewModel extends BaseObservable {

    private MutableLiveData<ArrayList<UserViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<UserViewModel> arrayListHolder = new ArrayList<>();
    //    ---------------

    private String name,phone;
    private Context context;

    public UserViewModel(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
    }

    public UserViewModel(Context context) {
        this.context = context;
        for (int i = 0; i < 5; i++) {
            User user = new User("amin-"+i,"090"+i);
            UserViewModel userViewModel = new UserViewModel(user);
            arrayListHolder.add(userViewModel);
        }
        arrayListMutableLiveData.setValue(arrayListHolder);
    }

    @BindingAdapter("bind:recyclerViewUser")
    public static void recyclerViewBinder(final RecyclerView recyclerView, final MutableLiveData<ArrayList<UserViewModel>> liveData){
        liveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<UserViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<UserViewModel> userViewModels) {
                UserAdaptor userAdaptor = new UserAdaptor(userViewModels);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(userAdaptor);

            }
        });
    }


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR._all);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Bindable
    public MutableLiveData<ArrayList<UserViewModel>> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }
}
