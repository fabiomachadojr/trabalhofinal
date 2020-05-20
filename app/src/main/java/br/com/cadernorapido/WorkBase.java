package br.com.cadernorapido;

import android.app.ProgressDialog;

public class WorkBase {

    protected App app;

    private ProgressDialog progressDialog = null;

    public WorkBase(App app) {
        this.app = app;
    }

}
