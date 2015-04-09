package com.example.weblauncher;

import com.example.weblauncher.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.KeyEvent;
//import android.view.Menu;
//import android.view.MenuItem;

public class MainActivity extends Activity {
	private WebView mWebView;
	private String url;
	
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		url = "www.gamefaqs.com";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		mWebView = (WebView) findViewById(R.id.activity_main_webview);
		mWebView.setWebViewClient(new MyWebViewClient());
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		mWebView.loadUrl("http://"+url);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if(event.getAction() == KeyEvent.ACTION_DOWN){
	        switch(keyCode)
	        {
	        case KeyEvent.KEYCODE_BACK:
	            if(mWebView.canGoBack()){
	                mWebView.goBack();
	            }else{
	                finish();
	            }
	            return true;
	        }

	    }
	    return super.onKeyDown(keyCode, event);
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
}
