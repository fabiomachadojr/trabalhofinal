package br.com.cadernorapido.dialogos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import br.com.cadernorapido.SimDialogo;


public class BaseAlertDialogo implements SimDialogo {

    public void baseDialogo(String titulo, String mensagem, Context context, final SimDialogo simDialogo, final NaoDialogo naoDialogo){
        final android.app.AlertDialog alerta;
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Cancelamento");
        builder.setMessage("Tem certeza que deseja cancelar?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                simDialogo.onclickSim();
            }
        });
        builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                naoDialogo.onclickNao();
            }
        });
        alerta = builder.create();
        alerta.show();
    }

    @Override
    public void onclickSim() {

    }

    public interface NaoDialogo{
        void onclickNao();
    }


}
