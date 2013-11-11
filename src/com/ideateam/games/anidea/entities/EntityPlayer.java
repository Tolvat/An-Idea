package com.ideateam.games.anidea.entities;

import java.awt.Rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import com.ideateam.games.anidea.Game;
import com.ideateam.games.anidea.GameObject;

public class EntityPlayer {
	private String username;
	private int x, y;

	private boolean canMove = true;
	
	public EntityPlayer(String username) {
		this.username = username;
		
		x = 32;
		y = Game.HEIGHT - 128;
	}
	
	public void checkForCollision() {
		for(GameObject go : Game.objects) {
			if(go.getBounds().intersects(getBounds())) {
				y = go.getY();
				canMove = false;
			}
			else
			{
				canMove = true;
			}
			
			//System.out.println(go.getBounds() + ", " + getBounds());
		}
	}
	
	public void update() {
		checkForCollision();
		
//		if(isFalling) {
//			y += 2;
//		}
		
		if(canMove)
		{
			if(Game.input.isKeyPressed(Input.KEY_SPACE)) {
				y -= 7;
			}
			
			if(Game.input.isKeyDown(Input.KEY_A)) {
				x -= 2;
			}
			
			if(Game.input.isKeyDown(Input.KEY_D)) {
				x += 2;
			}
		}
	}
	
	public void render(GameContainer gc, Graphics g) {
		g.setColor(Color.white);
		g.drawString(Game.player.getUsername(), Game.player.getX() - (Game.player.getUsername().length()), Game.player.getY() - 16);
		
		g.setColor(Game.level.getRandomColor());
		g.fillRect(Game.player.getX(), Game.player.getY(), 32, 32);
	}
	
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
	
	public String getUsername() {
		return username;
	}
	
	public Rectangle getBounds() {
		int entityWidth = 32;
		int entityHeight = 32;
		
		return new Rectangle((int) ((int) x + (entityWidth / 2) - ((entityWidth /2) / 2)), (int) ((int) y + (entityHeight / 2)), (int) entityWidth / 2, (int) entityHeight / 2);
	}
}
