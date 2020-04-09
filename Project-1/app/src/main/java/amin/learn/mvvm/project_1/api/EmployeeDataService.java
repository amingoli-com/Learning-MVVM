package amin.learn.mvvm.project_1.api;

import amin.learn.mvvm.project_1.model.EmployeeDBResponse;
import retrofit2.Call;
import retrofit2.http.GET;
public interface EmployeeDataService {
    @GET("users/?per_page=12&page=1")
    Call<EmployeeDBResponse> getEmployees();
}
