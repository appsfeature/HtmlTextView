# HtmlTextView

Android TextView and Image loading from URL . Displaying <img> tag from remote URL.

Displaying <img> tag with style attribute from remote URL. 

```java

    private Spanned setSpannedText(String htmlText, TextView textView) {
        Spanned spanned = Html.fromHtml(htmlText, new HtmlImageGetter(htmlText, textView, getResources(), Picasso.get()), null);
        textView.setText(spanned);
        return spanned;
    }

```
