package br.com.cadernorapido.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import br.com.cadernorapido.model.Usuarios;

//Thred background

public class SynchronizationService extends Service {
    private Handler handler;
    private Runnable runnable;

    private int runTime;

    public SynchronizationService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        HandlerThread handlerThread = new HandlerThread("SynchronizationService", Thread.NORM_PRIORITY);
        handlerThread.start();

        handler = new Handler(handlerThread.getLooper());

        runnable = new Runnable() {
            @Override
            public void run() {

                runTime = 5000;

                verificarDataLoginUsuario();

                handler.postDelayed(runnable, runTime);
            }
        }

        ;
        handler.post(runnable);
    }


    private void verificarDataLoginUsuario() {
        Usuarios usuarios = Usuarios.getUsuarioAtivo();

        if(usuarios != null){
            if (!getDataLogin(usuarios).equals(getData())) {
                Usuarios.deslogarUsuario();
            }
        }
    }

    private String getData() {
        return LocalDate.now().toString();
    }

    private String getDataLogin(Usuarios usuarios) {
        SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
        return formatador.format(usuarios.getDataLogin());
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
}


