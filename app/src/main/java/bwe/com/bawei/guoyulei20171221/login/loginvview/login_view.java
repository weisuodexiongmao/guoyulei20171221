package bwe.com.bawei.guoyulei20171221.login.loginvview;

import bwe.com.bawei.guoyulei20171221.login.bean.Login_Bean;

/**
 * Created by 猥琐的熊猫 on 2017/12/21.
 */

public interface login_view {
    void loginData(Login_Bean login_bean);
    String loginname();
    String loginpass();
}
