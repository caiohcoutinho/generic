package main.java.gurps;

import com.badlogic.gdx.ApplicationAdapter;
import main.java.gurps.states.MenuState;
import main.java.gurps.states.State;
import main.java.gurps.states.universe.UniverseGearState;
import main.java.gurps.states.universe.UniverseState;

public class Main extends ApplicationAdapter {

	private State state;
	
	@Override
	public void create () {
		this.setState(new UniverseGearState());
	}

	@Override
	public void render () {
		this.setState(this.getState().draw());
	}

	@Override
	public void resize (int width, int height) {
		// Permito o resize?
	}

	@Override
	public void pause () {

	}

	@Override
	public void dispose () {
		this.getState().quit();
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
