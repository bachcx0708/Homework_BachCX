package techkid.bachcx.drawandload;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class DrawActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.toString();
    private ImageView ivPickColor;
    private ImageView ivSave;
    private RadioGroup rdGroup;
    private DrawingView drawingView;

    public static int currentColor = 0xFF3F51B5;
    public static int currentsize = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        SetupUI();

        addDrawingView();
        addListener();
    }

    private void addDrawingView() {
        RelativeLayout relativelayout = (RelativeLayout) findViewById(R.id.re_drawing);

        drawingView = new DrawingView(this);
        drawingView.setLayoutParams(new ActionBar.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)));
        relativelayout.addView(drawingView);
    }

    private void addListener() {
        ivPickColor.setOnClickListener(this);
        ivSave.setOnClickListener(this);

        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.thin:{
                        currentsize=5;
                        break;
                    }
                    case R.id.medium :{
                        currentsize=10;
                        break;
                    }
                    case R.id.big:{
                        currentsize=15;
                        break;
                    }
                }
                Log.d(TAG, "onCheckedChanged: "+currentsize);
            }
        });
    }

    private void SetupUI() {
        ivPickColor = (ImageView) findViewById(R.id.changecolor);
        ivPickColor.setColorFilter(currentColor);

        ivSave = (ImageView) findViewById(R.id.save);

        rdGroup = (RadioGroup) findViewById(R.id.radiogroup);
        rdGroup.check(R.id.medium);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:{
                saveImage();
                Log.d(TAG, "onClick: save");
                break;
            }
            case R.id.changecolor:{
                Log.d(TAG, "onClick: changecolor");
                pickcolor();
                break;
            }
        }

    }

    private void saveImage() {
        drawingView.setDrawingCacheEnabled(true);
        drawingView.buildDrawingCache();
        Bitmap bitmap = drawingView.getDrawingCache();

        Log.d(TAG, "saveImage: "+ bitmap.getWidth());

        ImageUtils.saveImage(bitmap, this);
    }

    private void pickcolor() {
        ColorPickerDialogBuilder.with(this)
                .setTitle("choose your color")
                .initialColor(currentColor)
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(12)
                .setPositiveButton("OK", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, Integer[] integers) {

                        ivPickColor.setColorFilter(i);
                        currentColor = i;
                    }
                })
                .build()
                .show();
    }
}
