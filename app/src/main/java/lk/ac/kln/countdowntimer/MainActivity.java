package lk.ac.kln.countdowntimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private int countDown = 99;
    private static final String CURRENT_COUNTER = "countDown" ;
    private boolean wasRunning = false;
    private boolean running = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            countDown = savedInstanceState.getInt(CURRENT_COUNTER);
        }
        CountDown();
        running= true;
    }
    // 11-03-2019
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState );
        savedInstanceState.putInt(CURRENT_COUNTER,countDown);
    }
    private void CountDown() {
        final TextView textView = findViewById(R.id.textView);
        //  textView.setText("Hello"); Use this to Check for initial checking
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(Integer.toString(countDown));
                // If u put the if condition in here U'll have to replace -1 with 0
                if (running == true) {
                    countDown--;
                }
                handler.postDelayed(this, 1000);
                //---
                if (countDown == -1) {
                    countDown = 100; // Resetting the Counter
                }
            }
        });
    }
    protected void StartCount (View view ){
        running = true;
    }
    protected void StopCount (View view){
        running = false;
    }
    // 13-03-2019
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public void onStart(){ // You can use onRestart as well
        super.onStart();
        running=false;
    }
    @Override
    public void onStop(){
        super.onStop();
        wasRunning = true;
        running= false;
    }
}