package amin.learn.mvvm.project_2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class BaseViewModel<T> extends AndroidViewModel {
    private MutableLiveData<Boolean> isFailed ;
    private MutableLiveData<Boolean> isLoaded ;
    private MutableLiveData<Boolean> isEmpty;
    private MutableLiveData<String> txtError;
    private MutableLiveData<T> liveData;
    private MutableLiveData<List<T>> listLiveData;
    public BaseViewModel(@NonNull Application application) {
        super(application);
        isFailed=new MutableLiveData<>(false);
        isLoaded = new MutableLiveData<>(true);
        isEmpty = new MutableLiveData<>(false);
        txtError = new MutableLiveData<>();
        liveData=new MutableLiveData<>();
        listLiveData=new MutableLiveData<>();
    }


    public MutableLiveData<Boolean> getIsFailed() {
        return isFailed;
    }

    public MutableLiveData<Boolean> getIsLoaded() {
        return isLoaded;
    }

    public MutableLiveData<Boolean> getIsEmpty() {
        return isEmpty;
    }

    public MutableLiveData<String> getTxtError() {
        return txtError;
    }

    public MutableLiveData<T> getLiveData() {
        return liveData;
    }

    public MutableLiveData<List<T>> getListLiveData() {
        return listLiveData;
    }
}
