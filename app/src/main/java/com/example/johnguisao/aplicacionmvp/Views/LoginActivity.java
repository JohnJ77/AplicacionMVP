package com.example.johnguisao.aplicacionmvp.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.johnguisao.aplicacionmvp.Interfaces.LoginActivityPresenter;
import com.example.johnguisao.aplicacionmvp.Interfaces.LoginActivityView;
import com.example.johnguisao.aplicacionmvp.Presenters.LoginActivityPresenterImpl;
import com.example.johnguisao.aplicacionmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginActivityView {

    private EditText etPass, etUser;
    private ProgressBar pbLogin;

    private LoginActivityPresenter presenterLoginActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser = (EditText) findViewById(R.id.et_username);
        etPass = (EditText) findViewById(R.id.et_password);
        pbLogin = (ProgressBar) findViewById(R.id.progb_login);
        presenterLoginActivity = new LoginActivityPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        pbLogin.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLogin.setVisibility(View.GONE);
    }

    @Override
    public void setErrorUser() {
        etUser.setError("Campo obligatorio");
    }

    @Override
    public void setErrorPass() {
        etPass.setError("Campo obligatorio");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, PrincipalMenuActivity.class));
    }

    public void validate() {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();
        presenterLoginActivity.validateUser(user, pass);
    }
}
