package com.pfariasmunoz.libgdx.bludbourne;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;
import com.pfariasmunoz.libgdx.bludbourne.screens.MainGameScreen;

public class BludBourne extends Game {

	public static final MainGameScreen _mainGameScreen = new MainGameScreen();
	
	@Override
	public void create () {
		setScreen(_mainGameScreen);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	}
	
	@Override
	public void dispose () {
		_mainGameScreen.dispose();
	}
}
