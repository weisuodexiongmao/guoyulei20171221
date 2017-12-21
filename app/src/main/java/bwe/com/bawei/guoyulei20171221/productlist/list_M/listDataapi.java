package bwe.com.bawei.guoyulei20171221.productlist.list_M;

import bwe.com.bawei.guoyulei20171221.productlist.listbean.list_Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public interface listDataapi {
    @GET("product/getProducts?pscid=39")
    Observable<list_Bean>listData1();
}
