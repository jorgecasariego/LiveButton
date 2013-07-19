package com.jc.livebutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

public class MainActivity extends Activity {

	DecelerateInterpolator sDecelerator = new DecelerateInterpolator();
	OvershootInterpolator sOvershooter = new OvershootInterpolator(10f);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button clickMeButton = (Button) findViewById(R.id.bBoton);
		clickMeButton.animate().setDuration(200);

		clickMeButton.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					clickMeButton.animate().setInterpolator(sDecelerator)
							.scaleX(.7F).scaleY(.7F);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					clickMeButton.animate().setInterpolator(sOvershooter)
							.scaleX(1f).scaleY(1f);
				}

				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
