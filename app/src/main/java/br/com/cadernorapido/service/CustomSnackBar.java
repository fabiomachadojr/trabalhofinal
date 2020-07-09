package br.com.cadernorapido.service;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class CustomSnackBar implements Message{
    @Override
    public void showMessage(View view) {
        Snackbar.make(view, "snack...", 1000).show();
    }
}
