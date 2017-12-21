package bwe.com.bawei.guoyulei20171221.register.model;

import java.util.Map;

import bwe.com.bawei.guoyulei20171221.register.bean.reg_Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public interface serviceApi {
    @GET("reg")
    Observable<reg_Bean>regData(@QueryMap Map<String,String> map);
}
