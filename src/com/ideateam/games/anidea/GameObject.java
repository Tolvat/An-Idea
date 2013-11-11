package com.ideateam.games.anidea;

import java.awt.Rectangle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class GameObject {
	protected int x, y;
	protected int type;
	
	public abstract void update(GameContainer gc, int delta);
	public abstract void render(GameContainer gc, Graphics g);
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public Rectangle getBounds() {
		int entityWidth = 32;
		int entityHeight = 32;
		
		return new Rectangle((int) ((int) x + (entityWidth / 2) - ((entityWidth /2) / 2)), (int) ((int) y + (entityHeight / 2)), (int) entityWidth / 2, (int) entityHeight / 2);
	}
}
