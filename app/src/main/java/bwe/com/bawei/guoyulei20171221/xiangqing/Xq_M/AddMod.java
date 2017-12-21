package bwe.com.bawei.guoyulei20171221.xiangqing.Xq_M;

import java.util.HashMap;
import java.util.Map;

import bwe.com.bawei.guoyulei20171221.utlis.Api;
import bwe.com.bawei.guoyulei20171221.xiangqing.Add_Bean;
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

public class AddMod {
    public void getAdddata(final getaddData1 getadd, String pid){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.listUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        Xqapi xqapi = retrofit.create(Xqapi.class);
        Map<String, String> map=new HashMap<>();
        map.put("uid","1758");
        map.put("pid",pid);
        map.put("token","72C032EA59A11A107C81D57047F2FF6E");
        Observable<Add_Bean> observable = xqapi.getAdddata(map);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Add_Bean>() {
                    @Override
                    public void accept(Add_Bean add_bean) throws Exception {
                        getadd.addData1(add_bean);
                    }
                });

    }
    public interface getaddData1{
       void addData1(Add_Bean add_bean);
    }
}
