package techkid.bachcx.homework2_299;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ScrollView sv;
    private FloatingActionButton buttonadd;
    private ViewPicture viewPicture;
    int image[] = {R.drawable.food_1,R.drawable.food_2,R.drawable.food_3,R.drawable.food_4,R.drawable.food_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonadd = (FloatingActionButton) findViewById(R.id.fab_button);
        addrandombutton();
    }

    private void addrandombutton() {
        final LinearLayout ll_layout = (LinearLayout) findViewById(R.id.LL_in);
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rd = new Random();
                int i = rd.nextInt(4);
                viewPicture = new ViewPicture(MainActivity.this);
                viewPicture.setBackgroundResource(image[i]);
                ll_layout.addView(viewPicture);
                sv = (ScrollView) findViewById(R.id.scrollV);
                sv.fullScroll(view.FOCUS_DOWN);
            }
        });
    }
}
