package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {
	private Stage stage;
	private Label outputLabel;
	
/*	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		int Help_Guides = 12;
		int row_height = Gdx.graphics.getWidth() / 12;
		int col_width = Gdx.graphics.getWidth() / 12;

		Texture texture = new Texture(Gdx.files.absolute("image.jpg"));

		Image image1 = new Image(texture);
		image1.setPosition(Gdx.graphics.getWidth()/3-image1.getWidth()/2, Gdx.graphics.getHeight()*2/3-image1.getHeight()/2);
		stage.addActor(image1);

		Image image2 = new Image(texture);
		image2.setPosition(Gdx.graphics.getWidth()*2/3-image2.getWidth()/2,Gdx.graphics.getHeight()*2/3-image2.getHeight()/2);
		image2.setOrigin(image2.getWidth()/2,image2.getHeight()/2);
		image2.rotateBy(45);
		stage.addActor(image2);

		Image image3 = new Image(texture);
		image3.setSize(texture.getWidth()/2,texture.getHeight()/2);
		image3.setPosition(Gdx.graphics.getWidth()/3-image3.getWidth()/2,Gdx.graphics.getHeight()/3-image3.getHeight());
		stage.addActor(image3);

		texture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
		TextureRegion textureRegion = new TextureRegion(texture);
		textureRegion.setRegion(0,0,texture.getWidth()*8,texture.getHeight()*4);
		Image image4 = new Image(textureRegion);
		image4.setSize(200,100);
		image4.setPosition(Gdx.graphics.getWidth()*2/3-image4.getWidth()/2,Gdx.graphics.getHeight()/3-image4.getHeight());
		stage.addActor(image4);


		Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		Label label3 = new Label("This is a Label (skin) on  5 columns ",mySkin,"black");
		label3.setSize(Gdx.graphics.getWidth()/Help_Guides,row_height);
		label3.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*8);
		stage.addActor(label3);

		Label label4 = new Label("This is a Label (skin) with a 5 columns width but WITH wrap",mySkin,"black");
		label4.setSize(Gdx.graphics.getWidth()/Help_Guides*5,row_height);
		label4.setPosition(col_width*2,Gdx.graphics.getHeight()-row_height*9);
		label4.setWrap(true);
		stage.addActor(label4);
	}*/

/*	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		int Help_Guides = 12;
		int row_height = Gdx.graphics.getWidth() / 12;
		int col_width = Gdx.graphics.getWidth() / 12;

		Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		Label title = new Label("Buttons with Skins",mySkin,"big-black");
		title.setSize(Gdx.graphics.getWidth(),row_height*2);
		title.setPosition(0,Gdx.graphics.getHeight()-row_height*2);
		title.setAlignment(Align.center);
		stage.addActor(title);

		// Button
		Button button1 = new Button(mySkin,"small");
		button1.setSize(col_width*4,row_height);
		button1.setPosition(col_width,Gdx.graphics.getHeight()-row_height*3);
		button1.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Button");
				return true;
			}
		});
		stage.addActor(button1);

		// Text Button
		Button button2 = new TextButton("Text Button",mySkin,"small");
		button2.setSize(col_width*4,row_height);
		button2.setPosition(col_width*5,Gdx.graphics.getHeight()-row_height*3);
		button2.setTransform(true);
		button2.scaleBy(0.5f);
		button2.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Text Button");
				return true;
			}
		});
		stage.addActor(button2);

		// ImageButton
		ImageButton button3 = new ImageButton(mySkin);
		button3.setSize(col_width*4,(float)(row_height*2));
		button3.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_off.png"))));
		button3.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_on.png"))));
		button3.setPosition(col_width,Gdx.graphics.getHeight()-row_height*6);
		button3.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Image Button");
				return true;
			}
		});
		stage.addActor(button3);

		//ImageTextButton
		ImageTextButton button4 = new ImageTextButton("ImageText Btn",mySkin,"small");
		button4.setSize(col_width*4,(float)(row_height*2));
		button4.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_off.png"))));
		button4.getStyle().imageDown = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("switch_on.png"))));
		button4.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*6);
		button4.addListener(new InputListener(){
			@Override
			public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Press a Button");
			}
			@Override
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
				outputLabel.setText("Pressed Image Text Button");
				return true;
			}
		});
		stage.addActor(button4);

		outputLabel = new Label("Press a Button",mySkin,"black");
		outputLabel.setSize(Gdx.graphics.getWidth(),row_height);
		outputLabel.setPosition(0,row_height);
		outputLabel.setAlignment(Align.center);
		stage.addActor(outputLabel);
	}*/

	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

		Texture texture = new Texture(Gdx.files.absolute("image2.jpg"));

		int X_left= Gdx.graphics.getWidth()/3-texture.getWidth()/2;
		int X_right = Gdx.graphics.getWidth()*2/3-texture.getWidth()/2;
		int Y_top = Gdx.graphics.getHeight()*2/3-texture.getHeight()/2;
		int Y_bottom = Gdx.graphics.getHeight()/3-texture.getHeight()/2;

		Image image1 = new Image(texture);
		image1.setPosition(X_left,Y_top);
		image1.setOrigin(image1.getWidth()/2,image1.getHeight()/2);
		stage.addActor(image1);

		ParallelAction topLeftRightParallelAction = new ParallelAction();
		topLeftRightParallelAction.addAction(Actions.moveTo(X_right,Y_top,1, Interpolation.exp5Out));
		topLeftRightParallelAction.addAction(Actions.scaleTo(2,2,1,Interpolation.exp5Out));

		MoveToAction moveBottomRightAction = new MoveToAction();
		moveBottomRightAction.setPosition(X_right,Y_bottom);
		moveBottomRightAction.setDuration(1);
		moveBottomRightAction.setInterpolation(Interpolation.smooth);

		ParallelAction bottomLeftRightParallelAction = new ParallelAction();
		bottomLeftRightParallelAction.addAction(Actions.moveTo(X_left,Y_bottom,1,Interpolation.sineOut));
		bottomLeftRightParallelAction.addAction(Actions.scaleTo(1,1,1));

		ParallelAction leftBottomTopParallelAction = new ParallelAction();
		leftBottomTopParallelAction.addAction(Actions.moveTo(X_left,Y_top,1,Interpolation.swingOut));
		leftBottomTopParallelAction.addAction(Actions.rotateBy(90,1));

		SequenceAction overallSequence = new SequenceAction();
		overallSequence.addAction(topLeftRightParallelAction);
		overallSequence.addAction(moveBottomRightAction);
		overallSequence.addAction(bottomLeftRightParallelAction);
		overallSequence.addAction(leftBottomTopParallelAction);

		RepeatAction infiniteLoop = new RepeatAction();
		infiniteLoop.setCount(RepeatAction.FOREVER);
		infiniteLoop.setAction(overallSequence);
		image1.addAction(infiniteLoop);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();
	}

}
