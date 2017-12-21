package bwe.com.bawei.guoyulei20171221.xiangqing.Xq_M;

import java.util.HashMap;
import java.util.Map;

import bwe.com.bawei.guoyulei20171221.utlis.Api;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xqbean.Xq_Bean;
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

public class XqMod {
public void XqData1(final getxqData datad, String pid){
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(Api.listUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    Xqapi xqapi = retrofit.create(Xqapi.class);
    Map<String, String> map=new HashMap<>();
    map.put("pid",pid);
    Observable<Xq_Bean> observable = xqapi.XqgetData(map);
    observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Xq_Bean>() {
                @Override
                public void accept(Xq_Bean xq_bean) throws Exception {
                    datad.xqdata(xq_bean);
                }
            });

}
public interface getxqData{
    void xqdata(Xq_Bean xq_bean);
}
}
