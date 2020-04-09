package amin.learn.mvvm.project_1.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import amin.learn.mvvm.project_1.api.EmployeeRepository;
import amin.learn.mvvm.project_1.model.Employee;

public class MainViewModel extends AndroidViewModel {
    private EmployeeRepository employeeRepository;
    public MainViewModel(@NonNull Application application) {
        super(application);
        employeeRepository = new EmployeeRepository();
    }
    public LiveData<List<Employee>> getAllEmployee() {
        return employeeRepository.getMutableLiveData();
    }
}