package br.com.cadernorapido;

import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class CustomSnackBar implements Message{
    @Override
    public void showMessage(View view) {
        Snackbar.make(view, "sdfds", 1000).show();
    }
}
