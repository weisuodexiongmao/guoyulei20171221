package bwe.com.bawei.guoyulei20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.guoyulei20171221.login.bean.Login_Bean;
import bwe.com.bawei.guoyulei20171221.login.loginpressenter.login_presenter;
import bwe.com.bawei.guoyulei20171221.login.loginvview.login_view;
import bwe.com.bawei.guoyulei20171221.productlist.productlist_Activity;
import bwe.com.bawei.guoyulei20171221.register.Main2Activity;

public class MainActivity extends AppCompatActivity implements login_view {

    @BindView(R.id.name_editText)
    EditText nameEditText;
    @BindView(R.id.pass_editText2)
    EditText passEditText2;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    private String name;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                name = nameEditText.getText().toString();
                pass = passEditText2.getText().toString();
                login_presenter presenter=new login_presenter(this);
                presenter.presen();
               startActivity(new Intent(MainActivity.this, productlist_Activity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                break;
        }
    }

    @Override
    public void loginData(Login_Bean login_bean) {
        Toast.makeText(MainActivity.this,login_bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public String loginname() {
        return name;
    }

    @Override
    public String loginpass() {
        return pass;
    }


}
