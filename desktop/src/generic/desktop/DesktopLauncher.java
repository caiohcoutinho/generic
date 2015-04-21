package generic.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import main.java.gurps.Main;
import main.java.gurps.application.Configuration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.height = Configuration.HEIGHT;
		config.width = Configuration.WIDTH;
		new LwjglApplication(new Main(), config);
	}
}
