package in.byter.jeclat;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StrictMode;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        startService(new Intent(getApplicationContext(), MyService.class));


        /*Button button = (Button)findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

        final WorkingThread thread = new WorkingThread();
        thread.start();
        thread.getHandler().post(new Runnable() {
            @Override
            public void run() {
                Utils.counter++;
                VLog.d("p1", Process.myPid() + "");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    VLog.d("p1", e.getMessage());
                }
                thread.getHandler().post(this);
            }
        });

*/



    }

}

class WorkingThread extends Thread {
    private Handler handler;

    public void run() {
        Looper.prepare();
        handler = new Handler();
        Looper.loop();
    }

    public Handler getHandler() {
        while (handler == null) {}
        return handler;
    }
}



