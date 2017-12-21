package bwe.com.bawei.guoyulei20171221.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwe.com.bawei.guoyulei20171221.R;
import bwe.com.bawei.guoyulei20171221.register.bean.reg_Bean;
import bwe.com.bawei.guoyulei20171221.register.presenter.Presenter;
import bwe.com.bawei.guoyulei20171221.register.vview.V_View;

public class Main2Activity extends AppCompatActivity implements V_View {

    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.editText3)
    EditText editText3;
    @BindView(R.id.editText4)
    EditText editText4;
    @BindView(R.id.button3)
    Button button3;
    private String name;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

    }

    @Override
    public void regdata(reg_Bean reg_bean) {
        Toast.makeText(this,reg_bean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String pass() {
        return pass;
    }

    @OnClick(R.id.button3)
    public void onViewClicked() {
        name = editText.getText().toString();
        pass = editText2.getText().toString();
        Presenter presenter=new Presenter(this);
        presenter.presen();
         finish();
    }
}
