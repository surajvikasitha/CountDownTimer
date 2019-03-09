package lk.ac.kln.countdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private int counter=99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDown();
    }

    private void countDown(){
        final TextView textView=findViewById(R.id.textView);

        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                    textView.setText(Integer.toString(counter));
                    counter--;
                    handler.postDelayed(this,1000);

                    if(counter==0){
                        counter=99;
                    }
            }
        });
    }

}
