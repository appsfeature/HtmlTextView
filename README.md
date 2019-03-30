# HtmlTextView
HtmlTextView is an extended TextView component for Android, which can load HTML and converts it into Spannable for displaying it. It is a replacement for usage of the WebView component, which behaves strange on some Android versions, flickers while loading, etc.
Android TextView and Image loading from URL . Displaying <img> tag from remote URL.

Displaying <img> tag with style attribute from remote URL. 

Sample Html code
```html
 <img alt="" src="https://www.android.com/static/2016/img/logo-android-green_1x.png" style="height:51px; width:208px" />
```

```java 
    private Spanned setSpannedText(String htmlText, TextView textView) {
        Spanned spanned = Html.fromHtml(htmlText, new HtmlImageGetter(htmlText, textView, getResources(), Picasso.get()), null);
        textView.setText(spanned);
        return spanned;
    }

```
##Supported HTML tags
Tags supported by Android (history of Html class)
```html
<p>
<div> handled exactly like <p>
<br>
<b>
<i>    
<img src="..." style="height:51px; width:208px">
<img src="..." height="51"; width="08">
<strong> (bug on some Android versions: generates italic)
<em> (bug on some Android versions: generates bold)
<u>
<tt>
<dfn>
<sub>
<sup>
<blockquote>
<cite>
<big>
<small>
<font size="..." color="..." face="...">
<h1>, <h2>, <h3>, <h4>, <h5>, <h6>
<a href="...">
 ```
