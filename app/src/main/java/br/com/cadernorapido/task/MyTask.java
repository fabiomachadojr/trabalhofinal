package br.com.cadernorapido.task;

        import android.os.AsyncTask;
        import android.widget.Toast;


public class MyTask extends AsyncTask<String, Void, String> {

       public interface OnFinishListener {
        void onFinishListener();
    }

    private OnFinishListener onFinishListener;

    public MyTask(OnFinishListener onFinishListener){
        this.onFinishListener = onFinishListener;
        execute();
    }

    @Override
    protected String doInBackground(String... params) {

        return "Sincroniza algo!!";
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        this.onFinishListener.onFinishListener();
    }
}