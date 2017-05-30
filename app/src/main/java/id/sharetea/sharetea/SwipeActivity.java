package id.sharetea.sharetea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

public class SwipeActivity extends AppCompatActivity {

    SwipeButton swipeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        swipeButton = (SwipeButton) findViewById(R.id.swipe_btn);
        swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(boolean active) {
                Toast.makeText(SwipeActivity.this, "swiped", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
