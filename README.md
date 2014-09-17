ProgressVolley
==============
NetworkView is an extension of NetworkImageView that allows a layout to contain any type of ImageView and a ProgressBar.

NetworkView is declared in the layout. The layout must contain two children a NetworkImageView and a ProgressBar. The first child must always be the NetworkImageView while the second child
must always be the second child.  NetworkView is declared in the activity and the image is set using the setImageURL method.

    <com.android.volley.toolbox.NetworkView
        android:id="@+id/profile_image"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:scaleType="fitCenter"
        android:gravity="center" >
        
       <com.android.volley.toolbox.NetworkImageView
        android:id="@+id/network_image"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:scaleType="fitCenter"
        android:gravity="center" />

    	<ProgressBar
        android:id="@+id/network_progress"
        style="?android:attr/progressBarStyleLarge"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:layout_marginBottom="8dp"
        android:visibility="gone" />
        
    </com.android.volley.toolbox.NetworkView>
