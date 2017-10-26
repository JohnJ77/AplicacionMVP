package com.example.johnguisao.aplicacionmvp.Interactors;

import android.os.Handler;

import com.example.johnguisao.aplicacionmvp.Interfaces.LoginActivityInteractor;
import com.example.johnguisao.aplicacionmvp.Interfaces.OnLoginActivityFinishListener;


/**
 * Created by Johnguisao on 24/10/2017.
 */

public class LoginActivityInteractorImpl implements LoginActivityInteractor {

    @Override
    public void validateUser(final String username, final String password, final OnLoginActivityFinishListener listener) {
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if(!username.equals("") &&!password.equals("")){
                    listener.operationSuccess();
                }
                else {
                    if(username.equals("")){
                        listener.usernameError();
                    }
                    if(password.equals("")){
                        listener.passwordError();
                    }
                }
            }
        }, 2000);
    }
}
