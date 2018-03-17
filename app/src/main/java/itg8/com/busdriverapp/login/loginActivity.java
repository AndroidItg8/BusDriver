package itg8.com.busdriverapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import itg8.com.busdriverapp.R;
import itg8.com.busdriverapp.home.HomeActivity;

public class loginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rl_custom)
    RelativeLayout rlCustom;
    @BindView(R.id.lbl_login)
    TextView lblLogin;
    @BindView(R.id.input_number)
    EditText inputNumber;
    @BindView(R.id.input_layout_number)
    TextInputLayout inputLayoutNumber;
    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.input_layout_password)
    TextInputLayout inputLayoutPassword;
    @BindView(R.id.lbl_forget)
    TextView lblForget;
    @BindView(R.id.rl_login)
    RelativeLayout rlLogin;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        init();
    }

    private void init() {
        setOnClickedListner();
    }

    private void setOnClickedListner() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_login:
                startActivity(new Intent(loginActivity.this, HomeActivity.class));
                break;
        }
    }


}
