package techkid.bachcx.homework2_299;

import android.content.Context;
import android.icu.util.Measure;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by bachc on 29/09/2017.
 */

public class ViewPicture extends View  {
    public ViewPicture(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentW = MeasureSpec.getSize(widthMeasureSpec);
        this.setMeasuredDimension(parentW,parentW/2);
        LinearLayout.LayoutParams ll_add = new LinearLayout.LayoutParams(parentW,parentW/2);
        ll_add.setMargins(5,15,5,15);
        this.setLayoutParams(ll_add);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
