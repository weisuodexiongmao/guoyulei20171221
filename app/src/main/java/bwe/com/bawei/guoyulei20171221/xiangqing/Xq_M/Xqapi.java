package bwe.com.bawei.guoyulei20171221.xiangqing.Xq_M;

import java.util.Map;

import bwe.com.bawei.guoyulei20171221.xiangqing.Add_Bean;
import bwe.com.bawei.guoyulei20171221.xiangqing.Xqbean.Xq_Bean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public interface Xqapi {
    //product/getProductDetail?pid=45&source=android
    @GET("product/getProductDetail")
    Observable<Xq_Bean>XqgetData(@QueryMap Map<String, String>map);
    //http://120.27.23.105/product/addCart?uid=1758&pid=30&token=72C032EA59A11A107C81D57047F2FF6E
    @GET("product/addCart")
    Observable<Add_Bean>getAdddata(@QueryMap Map map);

}
