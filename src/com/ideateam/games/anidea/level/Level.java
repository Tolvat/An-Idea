package com.ideateam.games.anidea.level;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.ideateam.games.anidea.Game;

public class Level {
	private int[][] backgroundTiles;
	private int[][] terrainTiles;
	private int[][] playerSpawn;
	
	private boolean isPlayerSpawned = false;
	private boolean generated = false;
	
	private int playerX;
	private int playerY;
	
	private Color levelColor;
	private int r = 0;
	
	public Level() {
		backgroundTiles = new int[Game.WIDTH][Game.HEIGHT];
		terrainTiles    = new int[Game.WIDTH][Game.HEIGHT * 4];
		playerSpawn     = new int[Game.WIDTH][Game.HEIGHT * 4];
		
		int color = new Random().nextInt(6);
		
		switch(color) {
			case 0:
				levelColor = Color.orange;
				break;
			case 1:
				levelColor = Color.red;
				break;
			case 2:
				levelColor = Color.cyan;
				break;
			case 3:
				levelColor = Color.blue;
				break;
			case 4:
				levelColor = Color.magenta;
				break;
			case 5:
				levelColor = Color.orange;
				break;
			case 6:
				levelColor = Color.red;
				break;
		}
		
		generateBackground();
		generateTerrain();
	}
	
	public void generateBackground() {
		for(int x = 0; x < Game.WIDTH; x += 32) {
			for(int y = 0; y < Game.HEIGHT; y += 32) {
				int id = new Random().nextInt(3);
				
				if(id == 0)
					backgroundTiles[x][y] = 0;
				if(id == 1)
					backgroundTiles[x][y] = 1;
				if(id == 2)
					backgroundTiles[x][y] = 2;
			}
		}
	}
	
	public void generateTerrain() {
		for(int x = 0; x < Game.WIDTH; x += 32) {
			for(int y = 0; y < Game.HEIGHT; y += 32) {
				int randY = new Random().nextInt(Game.HEIGHT - 32);
				int id = new Random().nextInt(4);
				
				if(id == 0)
					terrainTiles[x][randY] = 0;
				if(id == 1)
					terrainTiles[x][randY] = 1;
				if(id == 2)
					terrainTiles[x][randY] = 2;
				if(id == 3)
					playerSpawn[x][y] = 0;
			}
		}
		
		terrainTiles[Game.WIDTH - 32][32] = 5;
		terrainTiles[Game.WIDTH - 64][32] = 5;
		terrainTiles[Game.WIDTH - 32][64] = 5;
		terrainTiles[Game.WIDTH - 64][64] = 5;
	}
	
	public void update(GameContainer gc, int delta) {
		if(delta > 3 && r < 140) {
			generateTerrain();
			
			r++;
		}
		
		if(r >= 140 && !generated)
			generated = true;
		
		generateBackground();
	}
	
	public void render(GameContainer gc, Graphics g) {
		for(int x = 0; x < Game.WIDTH; x += 32) {
			for(int y = 0; y < Game.HEIGHT; y+= 32) {
				int id = backgroundTiles[x][y];
				
				if(id == 0) {
					g.setColor(Color.darkGray);
					g.drawRect(x, y, 32, 32);
				} else if(id == 1) {
					g.setColor(Color.black);
					g.drawRect(x, y, 32, 32);
				} else if(id == 2) {
					g.setColor(Color.gray);
					g.drawRect(x, y, 32, 32);
				}
			}
		}
		
		for(int x = 0; x < Game.WIDTH; x += 32) {
			for(int y = 0; y < Game.HEIGHT * 3; y += 32) {
				int id = terrainTiles[x][y];
				
				if(id == 0) {
					g.setColor(levelColor);
					g.drawRect(x, y, 32, 32);
				} else if(id == 5) {
					g.setColor(Color.red);
					g.drawRect(x, y, 64, 64);
				} else if(id == 6) {
					g.setColor(Color.black);
					g.drawRect(x, y, 32, 32);
				}
			}
		}
		
		if(!isPlayerSpawned)
			spawnPlayer(g);
		
		g.fillRect(playerX, playerY, 32, 32);
	}
	
	public void spawnPlayer(Graphics g) {
		int x = new Random().nextInt(playerSpawn.length);
		int y = new Random().nextInt(playerSpawn.length);
			
		playerX = x;
		playerY = y;
		
		isPlayerSpawned = true;
	}
}
