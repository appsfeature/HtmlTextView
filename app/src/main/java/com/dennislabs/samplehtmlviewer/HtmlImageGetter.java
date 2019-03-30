package com.dennislabs.samplehtmlviewer;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class HtmlImageGetter implements Html.ImageGetter {

    final Resources resources;

    final Picasso pablo;
    final TextView textView;
    private final String imageSource;

    public HtmlImageGetter(String imageSource, final TextView textView, final Resources resources, final Picasso pablo) {
        this.textView = textView;
        this.resources = resources;
        this.pablo = pablo;
        this.imageSource = imageSource;
    }

    @Override
    public Drawable getDrawable(final String imageUrl) {

        final BitmapDrawablePlaceHolder result = new BitmapDrawablePlaceHolder();
        new AsyncTask<Void, Void, Bitmap>() {

            private boolean resizeApply;

            @Override
            protected Bitmap doInBackground(final Void... meh) {
                int[] size = new int[2];
                try {
                    size = ImageUtil.getWidthAndHeight(imageSource);
                    resizeApply = true;
                } catch (Exception e) {
                    resizeApply = false;
                    e.printStackTrace();
                }
                try {
                    if(resizeApply) {
                        return pablo.load(imageUrl)
                            .resize(size[0], size[1])
                                .get();
                    }else{
                        return pablo.load(imageUrl)
                                .get();
                    }
                } catch (Exception e) {
                    return null;
                }
            }

            @Override
            protected void onPostExecute(final Bitmap bitmap) {
                try {
                    final BitmapDrawable drawable = new BitmapDrawable(resources, bitmap);

//                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth()*2, drawable.getIntrinsicHeight()*2);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

                    result.setDrawable(drawable);
                    result.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

                    textView.setText(textView.getText()); // invalidate() doesn't work correctly...
                } catch (Exception e) {
                    /* nom nom nom*/
                }
            }

        }.execute((Void) null);

        return result;
    }

    static class BitmapDrawablePlaceHolder extends BitmapDrawable {

        protected Drawable drawable;

        @Override
        public void draw(final Canvas canvas) {
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }

        public void setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }

    }
}
