package br.com.cadernorapido.service;

import android.view.View;

import br.com.cadernorapido.interfaces.Message;

public class FeedBackManager {

    View view;

    public FeedBackManager(View view) {
        this.view = view;
    }

    public void showSpeclMessage(Message message){
        message.showMessage(view);
    }
}
