package br.com.cadernorapido.service;

import android.view.View;
import android.widget.Toast;

import br.com.cadernorapido.interfaces.Message;

public class CustomToast implements Message {

    @Override
    public void showMessage(View view) {
        Toast.makeText(view.getContext(), "toast...", Toast.LENGTH_SHORT).show();
    }
}
