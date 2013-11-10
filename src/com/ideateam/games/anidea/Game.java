package com.ideateam.games.anidea;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.ideateam.games.anidea.level.Level;

public class Game extends BasicGame {
	public static final String GAME_NAME = "An Idea";
	public static final String GAME_VER  = "1.0.0";
	
	public static final int WIDTH  = 800;
	public static final int HEIGHT = WIDTH * 9 / 12;
	public static final boolean FULLSCREEN = false;
	
	private Level level;
	
	public Game(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		level = new Level();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		level.update(gc, delta);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		level.render(gc, g);
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer agc = new AppGameContainer(new Game(GAME_NAME + " " + GAME_VER));
			
			agc.setVSync(false);
			agc.setDisplayMode(WIDTH, HEIGHT, FULLSCREEN);
			agc.setUpdateOnlyWhenVisible(false);
			agc.setAlwaysRender(true);
			agc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
