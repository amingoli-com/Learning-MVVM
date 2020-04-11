package amin.learn.mvvm.project_2.api;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import amin.learn.mvvm.project_2.ApplicationManage;

public class ApiUtil {
    public static void GetItem(String url,ApiInterface listener){
        StringRequest request = new StringRequest
                (Request.Method.GET, url, listener::onResult, e -> listener.onFiled());
        request.setRetryPolicy(new DefaultRetryPolicy(
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        ApplicationManage.getInstance().addToRequestQueue(request);
    }
}
