package com.alatheer.anwaralfyaha.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.alatheer.anwaralfyaha.R;

public class WebViiew extends AppCompatActivity {
    private String postUrl = "http://anwaralfyaha.com";
    private WebView webView;
    private ProgressBar progressBar;
    private ImageView imgHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_viiew);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //imgHeader = (ImageView) findViewById(R.id.backdrop);

        // initializing toolbar
        initCollapsingToolbar();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(postUrl);
        webView.setHorizontalScrollBarEnabled(false);
    }

    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar txtPostTitle on scroll
     */
    private void initCollapsingToolbar() {
//        final CollapsingToolbarLayout collapsingToolbar =
//                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        collapsingToolbar.setTitle(" ");
//        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
//        appBarLayout.setExpanded(true);

        // hiding & showing the txtPostTitle when toolbar expanded & collapsed
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbar.setTitle("Web View");
//                    isShow = true;
//                } else if (isShow) {
//                    collapsingToolbar.setTitle(" ");
//                    isShow = false;
//                }
//            }
     //   });

        // loading toolbar header image
//        Glide.with(getApplicationContext()).load("http://api.androidhive.info/webview/nougat.jpg")
//                .thumbnail(0.5f)
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imgHeader);
    }
}