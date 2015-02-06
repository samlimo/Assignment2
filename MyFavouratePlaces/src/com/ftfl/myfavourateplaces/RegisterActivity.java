package com.ftfl.myfavourateplaces;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class RegisterActivity extends Activity {
	Bitmap mImageBitmap = null;
	ImageView ivPhotoPreview;
	Button btTakePhoto;
	Button btRegister;

	static final int REQUEST_IMAGE_CAPTURE = 123;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		ivPhotoPreview = (ImageView) findViewById(R.id.imageViewPlace);

		btRegister = (Button) findViewById(R.id.btRegister);
		btRegister.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
					Intent mIntent = new Intent(RegisterActivity.this,
							ConfirmationActivity.class);
					mIntent.putExtra("PIC_ID", mImageBitmap);
					startActivity(mIntent);
			}
		});

		btTakePhoto = (Button) findViewById(R.id.btTakePhoto);
		btTakePhoto.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				dispatchTakePictureIntent();
			}
		});
	}

	private void dispatchTakePictureIntent() {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			mImageBitmap = (Bitmap) extras.get("data");
			ivPhotoPreview.setImageBitmap(mImageBitmap);
		}
	}

}
