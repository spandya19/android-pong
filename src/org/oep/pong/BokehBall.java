package org.oep.pong;

import android.graphics.*;

public class BokehBall {
	protected Paint paint;
	protected int radius;
	protected int x;
	protected int y;
	
	
	public BokehBall(Paint paint, int radius, int x, int y) {
		this.paint = paint;
		this.radius = radius;
		this.x = x;
		this.y = y;
	}
	
	public void draw(Canvas canvas) {
		canvas.drawCircle(x, y, radius, paint);
	}
}
