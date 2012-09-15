package org.oep.pong;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class BokehView extends View {
	
	List<BokehGenerator> bokehs = new ArrayList<BokehGenerator>();

	public BokehView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}
	
	private void init() {
        setBackgroundColor(Color.parseColor("#00596c"));
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
	
	@Override
	protected void onDraw(Canvas canvas) {
    	for(BokehGenerator bg : bokehs) {
    		bg.draw(canvas);
    	}
    	setWillNotDraw(true);	// Just draw it once and quit.
	}

}
