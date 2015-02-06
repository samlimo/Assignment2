package com.ftfl.myfavourateplaces;

import android.R.integer;
import android.R.string;

public class Place {
	private integer mId;
	private string mLatitude;
	private string mLongitude;
	private string mDescription;
	private string mDate;
	private string mTime;

	// ========= Constructor ===========
	public Place(integer mId, string mLatitude, string mLongitude,
			string mDescription, string mDate, string mTime) {
		super();
		this.mId = mId;
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
		this.mDescription = mDescription;
		this.mDate = mDate;
		this.mTime = mTime;
	}

	public Place(string mLatitude, string mLongitude, string mDescription,
			string mDate, string mTime) {
		super();
		this.mLatitude = mLatitude;
		this.mLongitude = mLongitude;
		this.mDescription = mDescription;
		this.mDate = mDate;
		this.mTime = mTime;
	}

	// ========= Getter - Setter Methods ===========
	public integer getmId() {
		return mId;
	}

	public void setmId(integer mId) {
		this.mId = mId;
	}

	public string getmLatitude() {
		return mLatitude;
	}

	public void setmLatitude(string mLatitude) {
		this.mLatitude = mLatitude;
	}

	public string getmLongitude() {
		return mLongitude;
	}

	public void setmLongitude(string mLongitude) {
		this.mLongitude = mLongitude;
	}

	public string getmDescription() {
		return mDescription;
	}

	public void setmDescription(string mDescription) {
		this.mDescription = mDescription;
	}

	public string getmDate() {
		return mDate;
	}

	public void setmDate(string mDate) {
		this.mDate = mDate;
	}

	public string getmTime() {
		return mTime;
	}

	public void setmTime(string mTime) {
		this.mTime = mTime;
	}

}
