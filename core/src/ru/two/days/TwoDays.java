package ru.two.days;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class TwoDays extends Game {
	//static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SCR_WIDTH = 2560, SCR_HEIGHT = 1440;

	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;
	BitmapFont font, fontLarge, fontRuna, fontPoliam, fontKaiden, fontValo, fontMassovka;
	boolean soundOn = true;

	ScreenGame roomOfRuna, roomOfValo, classRoom;
	ScreenIntro screenIntro;
	ScreenSettings screenSettings;
	ScreenAbout screenAbout;
	Paper screenPaper;

	@Override
	public void create () {
		// создание системных объектов
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		touch = new Vector3();
		generateFont();

		screenIntro = new ScreenIntro(this);
		screenSettings = new ScreenSettings(this);
		screenAbout = new ScreenAbout(this);
        roomOfRuna = new RoomOfRuna(this);
		setScreen(screenIntro);

	}

	void generateFont(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("MainScreen.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		// создание фонта для игры
		parameter.color = new Color(0.51f, 0.4f, 0.65f, 1);
		parameter.size = 60;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 2;
		parameter.borderStraight = true;
		parameter.shadowColor = new Color(0.1f, 0.1f, 0.1f, 0.8f);
		parameter.shadowOffsetX = parameter.shadowOffsetY = 3;
		String str = "";
		for (char i = 0x20; i < 0x7B; i++) str += i;
		for (char i = 0x401; i < 0x452; i++) str += i;
		parameter.characters = str;
		fontLarge = generator.generateFont(parameter);
		parameter.size = 45;
		font = generator.generateFont(parameter);

		generator = new FreeTypeFontGenerator(Gdx.files.internal("speech.ttf"));
		parameter.size = 30;

		//создание фонта для Руны
		parameter.color = new Color(0.66f, 0.412f, 1, 1);
		fontRuna = generator.generateFont(parameter);

		//создание фонта для Полиама
		parameter.color = new Color(0.196f, 0.557f, 0.941f, 1);
		fontPoliam = generator.generateFont(parameter);

		//создание фонта для Кайден
		parameter.color = new Color(0.196f, 0.941f, 0.643f, 1);
		fontKaiden = generator.generateFont(parameter);

		//создание фонта для Вало
		parameter.color = new Color(0.941f, 0.518f, 0.196f, 1);
		fontValo = generator.generateFont(parameter);

		//создание фонта для массовки
		parameter.color = new Color(1, 1, 1, 1);
		fontMassovka = generator.generateFont(parameter);

		generator.dispose();
	}
	
	@Override
	public void dispose () {
		fontRuna.dispose();
		fontLarge.dispose();
		font.dispose();
		fontMassovka.dispose();
		fontPoliam.dispose();
		fontValo.dispose();
		fontKaiden.dispose();
		batch.dispose();
	}
}
