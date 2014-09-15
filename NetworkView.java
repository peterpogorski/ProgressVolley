package com.android.volley.toolbox;

import com.android.volley.R;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.ImageLoader.ImageContainer;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class NetworkView extends RelativeLayout {

	private View progressBar;
	private View picture;
	private boolean landscapeGallery;
	private ImageLoader mImageLoader;
	private boolean progress;
	
	public NetworkView(Context context) {
		super(context);
	}
	
	public NetworkView(Context context, AttributeSet attrs) {
		super(context,attrs);
		progressBar = (View) findViewById(R.id.progress_placeholder);
		picture = (View) findViewById(R.id.result_placeholder);
	}
	
	public void setImageUrl(String requestUrl ,ImageLoader mImageLoader){
		setResultView();
		setProgressBar();
		picture.setVisibility(View.GONE);
		((NetworkImageView) picture).setImageUrl(requestUrl, mImageLoader);
		if(progress){
			progressBar.setVisibility(View.VISIBLE);
		}
		loadingListener(mImageLoader, requestUrl);
	}
	
	private void loadingListener(ImageLoader mImageLoader, String requestUrl){
		mImageLoader.get(requestUrl, new ImageListener() {
			
			@Override
			public void onErrorResponse(VolleyError error) {
				onLoadedView();
			}
			
			@Override
			public void onResponse(ImageContainer response, boolean isImmediate) {	
    			Bitmap bitmap = response.getBitmap();
    			if(bitmap != null){
    				onLoadedView();
    			}
			}
		});
	}
	
	private void onLoadedView(){
		progressBar.setVisibility(View.GONE);
		picture.setVisibility(View.VISIBLE);
	}
	
	public NetworkImageView getResultView(){
		return (NetworkImageView) picture;
	}
	
	public ProgressBar getProgressBar(){
		return (ProgressBar) progressBar;
	}

	public void setProgressBar(){
		if(getChildAt(1) != null){
			progress = true;
			progressBar = getChildAt(1);
		}
	}
	
	public void setResultView(){
		if(getChildAt(0) != null){
			picture = getChildAt(0);
		}
	}	
}
