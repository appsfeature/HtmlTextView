package com.dennislabs.samplehtmlviewer;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebUtil {

    public static void setDataWebView(WebView webView, String data) {
        webView.loadDataWithBaseURL("file:///android_asset/", htmlData(data), "text/html", "UTF-8", null);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public static void setWebViewSetting(WebView webView) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
    }

    public static void setDataWebView(WebView webView, String data, String color) {
        webView.loadDataWithBaseURL("file:///android_asset/", htmlData(data, color), "text/html", "UTF-8", null);
        webView.loadData(htmlData(data, color), "text/html", "UTF-8");

    }

    public static String htmlData(String myContent) {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<html><head>" +
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"
                + "<style type=\"text/css\">body{color: #000; font-size:large; font-family:roboto_regular;"
                + " }"
                + "</style>"
                + "<head><body>" + myContent + "</body></html>";
        return s;
    }

    public static String htmlData(String myContent, String color) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" +
                "<html><head>" +
                "<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />"
                + "<style type=\"text/css\">body{color: #000; font-size:15px; font-family:roboto_regular;"
                + (TextUtils.isEmpty(color) ? "" : "background-color: " + color + ";")
                + " }"
                + "</style>"
                + "<head><body>" + myContent + "</body></html>";

    }
}
