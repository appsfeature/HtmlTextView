package com.dennislabs.samplehtmlviewer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.webkit.WebView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        webView = findViewById(R.id.webView);
        setSpannedText(getString(R.string.sample_data_image), textView);

        WebUtil.setDataWebView(webView, getString(R.string.sample_data_image));
    }

    private Spanned setSpannedText(String text, TextView textView) {
        Spanned spanned = Html.fromHtml(text, new HtmlImageGetter(text, textView, getResources(), Picasso.get()), null);
        textView.setText(spanned);
        return spanned;
    }


}
