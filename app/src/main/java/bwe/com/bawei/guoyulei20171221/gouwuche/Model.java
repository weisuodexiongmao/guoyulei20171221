package bwe.com.bawei.guoyulei20171221.gouwuche;

import java.util.Map;

import io.reactivex.Flowable;

public class Model implements IModel {
    private NewsPresenter presenter;

    public Model(NewsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getData(Map<String, String> map) {
        Flowable<ShopCar> flowable = RetrofitUtils.getInstance().getApiService().getNews(map);
        presenter.get(flowable);
    }
}