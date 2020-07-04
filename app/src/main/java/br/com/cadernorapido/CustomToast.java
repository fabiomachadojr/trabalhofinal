package br.com.cadernorapido;

import android.view.View;
import android.widget.Toast;

public class CustomToast implements Message{

    @Override
    public void showMessage(View view) {
        Toast.makeText(view.getContext(), "sfgrfg", Toast.LENGTH_SHORT).show();
    }
}
