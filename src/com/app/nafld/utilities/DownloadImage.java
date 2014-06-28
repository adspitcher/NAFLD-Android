package com.app.nafld.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

public class DownloadImage {

	public final static String APP_PATH_SD_CARD = "/elsevierpoc/algorithms";

	public static boolean saveImageToExternalStorage(Context context, String fileName, Bitmap image) {
	String fullPath = Environment.getExternalStorageDirectory().getAbsolutePath() + APP_PATH_SD_CARD;

	try {
	File dir = new File(fullPath);
	if (!dir.exists()) {
		dir.mkdirs();
	}

	OutputStream fOut = null;
	File file = new File(fullPath, fileName);
	file.createNewFile();
	fOut = new FileOutputStream(file);

	// 100 means no compression, the lower you go, the stronger the compression
	image.compress(Bitmap.CompressFormat.PNG, 100, fOut);
	fOut.flush();
	fOut.close();

	MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());

	return true;

	} catch (Exception e) {
		Log.e("saveToExternalStorage()", e.getMessage());
	return false;
	}
	}

}
