package com.actionbar;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Toast.makeText(MainActivity.this, "Giriþ Ekranýna Dönülüyor", Toast.LENGTH_LONG).show();
			Intent intent=new Intent(this,MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		case R.id.ara:
			Toast.makeText(MainActivity.this, "Ara Seçildi", Toast.LENGTH_LONG).show();
			return true;
		case R.id.yenile:
			Toast.makeText(MainActivity.this, "Yenile Seçildi", Toast.LENGTH_LONG).show();
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.options_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final String[] actions=getResources().getStringArray(R.array.actions);
		ActionBar actionBar=getActionBar();
		actionBar.setTitle("Piyasa Bilgisi");
		actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_LIST);
		actionBar.setHomeButtonEnabled(true);
		
		SpinnerAdapter adapter=ArrayAdapter.createFromResource(MainActivity.this, R.array.actions, android.R.layout.simple_spinner_dropdown_item);
        
		actionBar.setListNavigationCallbacks(adapter, new OnNavigationListener() {
			
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				Toast.makeText(MainActivity.this, actions[itemPosition]+" seçildi", Toast.LENGTH_LONG).show();
				return true;
			}
		});
		
		
	}
}
