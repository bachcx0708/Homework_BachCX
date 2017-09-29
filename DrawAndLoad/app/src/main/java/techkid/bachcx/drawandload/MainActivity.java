package techkid.bachcx.drawandload;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private FloatingActionButton fbNewNote;
    private SubActionButton btcamera;
    private SubActionButton brush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();

        addListener();

    }

    private void addListener() {
        btcamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: camera");
                Intent intent = new Intent(); //camera
            }
        });
        brush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: brush");
                Intent intent = new Intent(MainActivity.this,DrawActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupUI() {
        fbNewNote = (FloatingActionButton) findViewById(R.id.flab);

        SubActionButton.Builder sabBuilder =  new SubActionButton.Builder(this);
        btcamera = sabBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_camera_alt_black_24dp)).build();
        brush = sabBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_brush_black_24dp)).build();

        FloatingActionMenu floatingActionMenu = new FloatingActionMenu.Builder(this).addSubActionView(btcamera).addSubActionView(brush).attachTo(fbNewNote).build();



    }
}
