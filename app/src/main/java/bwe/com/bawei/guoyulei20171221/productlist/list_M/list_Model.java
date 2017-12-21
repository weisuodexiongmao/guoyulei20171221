package bwe.com.bawei.guoyulei20171221.productlist.list_M;

import bwe.com.bawei.guoyulei20171221.productlist.listbean.list_Bean;
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

public class list_Model {
public void listData(final getData data){
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(Api.listUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    listDataapi listDataapi = retrofit.create(listDataapi.class);
    Observable<list_Bean> observable = listDataapi.listData1();
    observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<list_Bean>() {
                @Override
                public void accept(list_Bean list_bean) throws Exception {
                    data.data(list_bean);
                }
            });

}
public interface getData{
    void data(list_Bean list_bean);
}
}
