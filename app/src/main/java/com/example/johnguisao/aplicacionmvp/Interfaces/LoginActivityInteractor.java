package com.example.johnguisao.aplicacionmvp.Interfaces;

/**
 * Created by Johnguisao on 24/10/2017.
 */

public interface LoginActivityInteractor {
    void validateUser(String username, String password, OnLoginActivityFinishListener listener);
}
