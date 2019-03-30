package com.dennislabs.samplehtmlviewer;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class ImageUtil {
    private static final String IMG_HEIGHT_SIZE_TAG_1 = "height=\"";
    private static final String IMG_WIDTH_SIZE_TAG_1 = "width=\"";
    private static final String IMG_HEIGHT_SIZE_TAG_2 = "height:";
    private static final String IMG_WIDTH_SIZE_TAG_2 = "width:";

    public static int[] getScreenWidthAndHeight(Activity context) throws Exception {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int screenWidth = displaymetrics.widthPixels;
        int screenHeight = displaymetrics.heightPixels;
        return new int[]{screenWidth,screenHeight};
    }

    public static int dpToPx(int dp) throws Exception {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int pxToDp(int px)  throws Exception{
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }


    public static int[] getWidthAndHeight(String source) throws Exception {
        String height = null,width = null;
        if(source.contains(IMG_HEIGHT_SIZE_TAG_1)){
            height = source.substring(source.indexOf(IMG_HEIGHT_SIZE_TAG_1));
            height = height.substring(IMG_HEIGHT_SIZE_TAG_1.length());
            height = height.substring(0, height.indexOf("\""));

            width = source.substring(source.indexOf(IMG_WIDTH_SIZE_TAG_1));
            width = width.substring(IMG_WIDTH_SIZE_TAG_1.length());
            width = width.substring(0, width.indexOf("\""));
        }else if(source.contains("height:")){
            height = source.substring(source.indexOf(IMG_HEIGHT_SIZE_TAG_2));
            height = height.substring(IMG_HEIGHT_SIZE_TAG_2.length());
            height = height.substring(0, height.indexOf("px"));

            width = source.substring(source.indexOf(IMG_WIDTH_SIZE_TAG_2));
            width = width.substring(IMG_WIDTH_SIZE_TAG_2.length());
            width = width.substring(0, width.indexOf("px"));
        }

        int imgWidth = ImageUtil.dpToPx(Integer.parseInt(width));
        int imgHeight = ImageUtil.dpToPx(Integer.parseInt(height));

        return new int[]{imgWidth,imgHeight};
    }

}
