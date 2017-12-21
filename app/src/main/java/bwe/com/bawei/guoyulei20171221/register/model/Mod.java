package bwe.com.bawei.guoyulei20171221.register.model;

import java.util.HashMap;
import java.util.Map;

import bwe.com.bawei.guoyulei20171221.register.bean.reg_Bean;
import bwe.com.bawei.guoyulei20171221.utlis.Api;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public class Mod {
public void regData(final Data1 data, String name, String pass){
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(Api.Url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    serviceApi serviceApi = retrofit.create(serviceApi.class);
    Map<String, String> map=new HashMap<>();
    map.put("mobile",name);
    map.put("password",pass);
    Observable<reg_Bean> observable = serviceApi.regData(map);
    observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<reg_Bean>() {
                @Override
                public void accept(reg_Bean reg_bean) throws Exception {
                    data.data1(reg_bean);
                }
            });
}
public interface Data1{
    void data1(reg_Bean reg_bean);
}
}
