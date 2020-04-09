package amin.learn.mvvm.project_1.api;

import amin.learn.mvvm.project_1.model.EmployeeDBResponse;
import retrofit2.Call;
import retrofit2.http.GET;
public interface EmployeeDataService {
    @GET("list.json")
    Call<EmployeeDBResponse> getEmployees();
}
