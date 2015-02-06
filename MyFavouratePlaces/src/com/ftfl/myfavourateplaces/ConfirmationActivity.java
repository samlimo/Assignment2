package com.ftfl.myfavourateplaces;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ConfirmationActivity extends Activity {
	ImageView ivPhotoView;
	long mLatitude;
	long mLongitude;
	EditText mRemarks;
	Button btSave;
	Intent mIntent;
	Bitmap mImageBitmap;
	LocationManager locManager;
	double latitude;
	double longitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_confirmation);

		setImageView();

		locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L,
				500.0f, locationListener);
		Location location = locManager
				.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		if (location != null) {
			latitude = location.getLatitude();
			longitude = location.getLongitude();
		}

	}

	private void updateWithNewLocation(Location eLocation) {
		TextView myLocationText = (TextView) findViewById(R.id.textViewPosition);
		String latLongString = "";
		if (eLocation != null) {
			double lat = eLocation.getLatitude();
			double lng = eLocation.getLongitude();
			latLongString = "Latitude: " + lat + "\nLongitude: " + lng;
		} else {
			latLongString = "No location found";
		}
		myLocationText.setText("Your Current Position is:\n" + latLongString);
	}

	private final LocationListener locationListener = new LocationListener() {

		public void onLocationChanged(Location location) {
			updateWithNewLocation(location);
		}

		public void onProviderDisabled(String provider) {
			updateWithNewLocation(null);
		}

		public void onProviderEnabled(String provider) {
		}

		public void onStatusChanged(String provider, int status, Bundle extras) {
		}
	};

	public void setImageView() {
		Bundle mBundle = getIntent().getExtras();
		mImageBitmap = mBundle.getParcelable("PIC_ID");
		ivPhotoView = (ImageView) findViewById(R.id.imageViewThumb);
		ivPhotoView.setImageBitmap(mImageBitmap);

		mImageBitmap = (Bitmap) this.getIntent().getParcelableExtra("PIC_ID");
		ivPhotoView.setImageBitmap(mImageBitmap);

	}

	public void Save() {

	}
}