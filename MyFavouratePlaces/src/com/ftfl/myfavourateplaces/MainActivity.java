package com.ftfl.myfavourateplaces;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btRegister = (Button) findViewById(R.id.register);
		btRegister.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						RegisterActivity.class);
				startActivity(intent);
				finish();
			}
		});

		Button btRetrieved = (Button) findViewById(R.id.retrieved);
		btRetrieved.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						RetrievedActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

}
