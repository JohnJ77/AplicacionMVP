package com.example.johnguisao.aplicacionmvp.Presenters;

import com.example.johnguisao.aplicacionmvp.Interactors.LoginActivityInteractorImpl;
import com.example.johnguisao.aplicacionmvp.Interfaces.LoginActivityInteractor;
import com.example.johnguisao.aplicacionmvp.Interfaces.LoginActivityPresenter;
import com.example.johnguisao.aplicacionmvp.Interfaces.LoginActivityView;
import com.example.johnguisao.aplicacionmvp.Interfaces.OnLoginActivityFinishListener;
import com.example.johnguisao.aplicacionmvp.Views.LoginActivity;

/**
 * Created by Johnguisao on 24/10/2017.
 */

public class LoginActivityPresenterImpl implements LoginActivityPresenter, OnLoginActivityFinishListener {
    private LoginActivityView viewLoginActivity;
    private LoginActivityInteractor interactorLoginActivity;

    public LoginActivityPresenterImpl(LoginActivityView viewLoginActivity) {
        this.viewLoginActivity = viewLoginActivity;
        interactorLoginActivity = new LoginActivityInteractorImpl();
    }

    @Override
    public void validateUser(String name, String pass) {
        if(viewLoginActivity != null){
            viewLoginActivity.showProgress();
        }
        interactorLoginActivity.validateUser(name, pass, this);
    }

    @Override
    public void usernameError() {
        if(viewLoginActivity != null){
            viewLoginActivity.hideProgress();
            viewLoginActivity.setErrorUser();
        }

    }

    @Override
    public void passwordError() {
        if(viewLoginActivity != null){
            viewLoginActivity.hideProgress();
            viewLoginActivity.setErrorPass();
        }

    }

    @Override
    public void operationSuccess() {
        if(viewLoginActivity != null){
            viewLoginActivity.hideProgress();
            viewLoginActivity.navigateToHome();
        }

    }
}
