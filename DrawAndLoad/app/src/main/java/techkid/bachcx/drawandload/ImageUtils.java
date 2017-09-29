package techkid.bachcx.drawandload;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/**
 * Created by bachc on 29/09/2017.
 */

public class ImageUtils {

    private static final String TAG = MainActivity.class.toString() ;

    public static void saveImage(Bitmap bitmap, Context context){
        String root = Environment.getExternalStorageDirectory().toString();
        File myFolder = new File(root + "/DrawingNotes");
        myFolder.mkdirs();

        String imageName = Calendar.getInstance().getTime().toString() + ".png";
        Log.d(TAG, "saveImage: " + imageName);

        File imageFile = new File(myFolder.toString(), imageName);

        try{
            FileOutputStream fout = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fout);
            fout.flush();
            fout.close();
        }catch (IOException ex){

        }
    }
}
