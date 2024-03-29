package Game.GameStates;

import java.awt.Graphics;

import Main.Handler;
import Resources.Images;
import UI.UIImageButton;
import UI.UIManager;
import UI.ClickListlener;

/// **
// * Created by AlexVR on 7/1/2018.
// */
public class VictoryState extends State {

	private int count = 0;
	private UIManager uiManager;

	public VictoryState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUimanager(uiManager);

	}

	@Override
	public void tick() {
		handler.getMouseManager().setUimanager(uiManager);
		uiManager.tick();
		count += 1;
		if (count >= 30) {
			count = 30;
		}
//		if (handler.getKeyManager().pbutt && count >= 30) {
//			count = 0;
//
//			State.setState(handler.getGame().VictoryState);
//		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Images.Victory, 0, 0, 800, 600, null);
		uiManager.Render(g);
	}
}