package br.com.cadernorapido;

import android.view.View;

public class FeedBackManager {

    View view;

    public FeedBackManager(View view) {
        this.view = view;
    }

    public void showSpeclMessage(Message message){
        message.showMessage(view);
    }
}
