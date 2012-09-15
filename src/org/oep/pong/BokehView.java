package org.oep.pong;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class BokehView extends SurfaceView {
	
	List<BokehGenerator> bokehs = new ArrayList<BokehGenerator>();
	private Bitmap background;
	private Canvas canvas;

	public BokehView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init() {
		// quantity, maxSize, minSize, color, maxAlpha (0 - 255), minAlpha, maxBlur, minBlur, maxX, maxY   ffccad
		bokehs.add(new BokehGenerator(5, 70, 35, Color.parseColor("#fffdd4"), 170, 70, 10, 3, 400, 800)); // prominent yellow
		bokehs.add(new BokehGenerator(5, 70, 35, Color.parseColor("#ffad89"), 170, 70, 10, 5, 400, 800)); // orangish done
		bokehs.add(new BokehGenerator(10, 70, 50, Color.parseColor("#5ed4b9"), 100, 30, 35, 30, 400, 800)); // greenish done
		bokehs.add(new BokehGenerator(6, 70, 40, Color.parseColor("#ff4559"), 100, 70, 30, 25, 400, 800));	// red done
		bokehs.add(new BokehGenerator(15, 80, 60, Color.parseColor("#abf8e8"), 100, 90, 25, 20, 400, 800)); // turquoise done
		bokehs.add(new BokehGenerator(1, 300, 250, Color.parseColor("#abf8e8"), 100, 90, 25, 20, 400, 800)); // big turq
		bokehs.add(new BokehGenerator(1, 300, 250, Color.parseColor("#ff4559"), 100, 90, 25, 20, 400, 800)); // big red
		bokehs.add(new BokehGenerator(1, 300, 250, Color.parseColor("#fffdd4"), 100, 90, 25, 20, 400, 800)); // big yellow 
		bokehs.add(new BokehGenerator(1, 300, 250, Color.parseColor("#0bd4ff"), 100, 90, 25, 20, 400, 800)); // big blue
	}
	
	private void createBitmap() {
		super.onDraw(canvas);
    	for(BokehGenerator bg : bokehs) {
    		bg.draw(canvas);
    	}
	}
	
	@Override
	 protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld){
	     super.onSizeChanged(xNew, yNew, xOld, yOld);

		//Create bitmap to match the size of the window whenever it's changed
		Bitmap.Config conf = Bitmap.Config.ARGB_8888;
		background = Bitmap.createBitmap(xNew, yNew, conf);
		canvas = new Canvas(background);
		createBitmap();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(background, 0, 0, null);
	}

}
