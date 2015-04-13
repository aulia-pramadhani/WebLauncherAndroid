package com.example.weblauncher;

import com.example.weblauncher.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private WebView mWebView;
	private String url;
	
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		
		loadSetting();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		loadWebView();
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		  
		Intent intent = new Intent();
		intent.setClass(MainActivity.this, SettingsActivity.class);
		startActivityForResult(intent, 0); 
		
		return true;
	}
	
	 @Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		//super.onActivityResult(requestCode, resultCode, data);
		  
		/*
		 * To make it simple, always re-load Preference setting.
		 */
		
		loadSetting();
		loadWebView();
	 }
	 
	 private void loadSetting(){
		  SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

		  this.url = mySharedPreferences.getString("webUrl", "google.co.id");

	}
	 
	 private void loadWebView(){
		mWebView = (WebView) findViewById(R.id.activity_main_webview);
		mWebView.setWebViewClient(new MyWebViewClient(this.url));
		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		mWebView.loadUrl("http://"+this.url);
	 }
}
