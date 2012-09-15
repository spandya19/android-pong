package org.oep.pong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class BokehGenerator {

	private List<BokehBall> bokeh = new ArrayList<BokehBall>();
	private static Random random = new Random();
	
	
	private int quantity;	// the number of bokeh balls
	
	private int maxSize;	// size range
	private int minSize;
	private int color;
	private int maxAlpha;	// transparency range
	private int minAlpha;
	private int maxBlur;	// blur range
	private int minBlur;
	private int maxX;	// location range
	private int maxY;
	
	public BokehGenerator(int quantity, int maxSize, int minSize, int color,
						  int maxAlpha, int minAlpha, int maxBlur, int minBlur,
						  int maxX, int maxY) {
		this.quantity = quantity;
		this.maxSize = maxSize;
		this.minSize = minSize;
		this.color = color;
		this.maxAlpha = maxAlpha;
		this.minAlpha = minAlpha;
		this.maxBlur = maxBlur;
		this.minBlur = minBlur;
		this.maxX = maxX;
		this.maxY = maxY;
		populate();
	}
	
	// Fills up the bokeh list with bokeh balls of selected size
	private void populate() {
		int size, alpha, blur, x, y = 0;
		Paint paint = new Paint();
		for(int i = 0; i < quantity; i++) {
			size = random.nextInt(maxSize - minSize) + minSize;
			alpha = random.nextInt(maxAlpha - minAlpha) + minAlpha;
			blur = random.nextInt(maxBlur - minBlur) + minBlur;
			x = random.nextInt(maxX);
			y = random.nextInt(maxY);
			paint.setStyle(Paint.Style.FILL);
			paint.setColor(color);
			paint.setAlpha(alpha);
			paint.setMaskFilter(new BlurMaskFilter(blur, BlurMaskFilter.Blur.NORMAL));
			bokeh.add(new BokehBall(paint, size, x, y));
		}
	}
	
	public void draw(Canvas canvas) {
		for(BokehBall bb : bokeh) {
			bb.draw(canvas);
		}
	}
	
}
