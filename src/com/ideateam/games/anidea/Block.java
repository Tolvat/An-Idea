package com.ideateam.games.anidea;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Block extends GameObject {
	public Block(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) {
		g.setColor(Color.white);
		g.fillRect(100, 100, 32, 32);
	}
}
