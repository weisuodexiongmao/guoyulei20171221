package bwe.com.bawei.guoyulei20171221.login.loginmod;

import java.util.HashMap;
import java.util.Map;

import bwe.com.bawei.guoyulei20171221.login.bean.Login_Bean;
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

public class login_Mod {
    public void loginData1(final Logindata logindata, String name, String pass){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        loginapi loginapi = retrofit.create(loginapi.class);
        Map<String, String> map=new HashMap<>();
        map.put("mobile",name);
        map.put("password",pass);
        Observable<Login_Bean> observable = loginapi.logData(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Login_Bean>() {
                    @Override
                    public void accept(Login_Bean login_bean) throws Exception {
                        logindata.data(login_bean);
                    }
                });
    }
    public interface Logindata{
        void data(Login_Bean login_bean);
    }
}
