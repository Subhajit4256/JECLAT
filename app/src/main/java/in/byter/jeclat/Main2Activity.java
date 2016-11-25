package in.byter.jeclat;

import android.os.Handler;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final WorkingThread thread = new WorkingThread();
        thread.start();
        thread.getHandler().post(new Runnable() {
            @Override
            public void run() {
                Utils.counter++;
                VLog.d("p2", Process.myPid() + "");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    VLog.d("p2", e.getMessage());
                }
                thread.getHandler().post(this);
            }
        });




    }
}
