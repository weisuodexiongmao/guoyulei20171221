package bwe.com.bawei.guoyulei20171221.login.loginmod;

import java.util.Map;

import bwe.com.bawei.guoyulei20171221.login.bean.Login_Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public interface loginapi {
    @GET("login")
    Observable<Login_Bean>logData(@QueryMap Map<String , String>map);

}
