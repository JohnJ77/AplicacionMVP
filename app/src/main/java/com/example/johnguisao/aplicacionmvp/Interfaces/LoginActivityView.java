package com.example.johnguisao.aplicacionmvp.Interfaces;

/**
 * Created by Johnguisao on 24/10/2017.
 */

public interface LoginActivityView {
    void showProgress();
    void hideProgress();
    void setErrorUser();
    void setErrorPass();
    void navigateToHome();
}
