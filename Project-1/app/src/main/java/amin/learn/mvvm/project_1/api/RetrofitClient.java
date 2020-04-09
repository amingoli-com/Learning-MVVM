package amin.learn.mvvm.project_1.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://raw.githubusercontent.com/amingoli78/Learning-MVVM/master/Project-1/";
    public static EmployeeDataService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(EmployeeDataService.class);
    }
}