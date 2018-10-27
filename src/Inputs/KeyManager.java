package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys,justPressed,cantPress;
	public boolean up=false, down=false, left=false, right=false, walkSpeed=false;
	public boolean attbut=false;
	public boolean fattbut=false;
	public boolean pbutt=false;

	public boolean regenHP=false;
	public boolean appleHeal=false;

	public boolean nextWorldKey=false;
	public boolean OneofEach=false;
	
	public boolean appearDoor=false;
	
	public boolean summonCompanion=false;




	public KeyManager(){

		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];

	}

	public void tick(){
		for(int i =0; i < keys.length;i++){
			if(cantPress[i] && !keys[i]){
				cantPress[i]=false;

			}else if(justPressed[i]){
				cantPress[i]=true;
				justPressed[i] =false;
			}
			if(!cantPress[i] && keys[i]){
				justPressed[i]=true;
			}
		}

		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];

		attbut = keys[KeyEvent.VK_E];
		fattbut = keys[KeyEvent.VK_C];
		pbutt = keys[KeyEvent.VK_ESCAPE];

		walkSpeed = keys[KeyEvent.VK_CONTROL];//Key for sprint		
		regenHP = keys[KeyEvent.VK_SHIFT];//Key for healing HP
		appleHeal = keys[KeyEvent.VK_F];//Key for healing with apple item
		
		summonCompanion = keys[KeyEvent.VK_G];//Summons companion
		
		


		//Sprint Button
		walkSpeed = keys[KeyEvent.VK_CONTROL];
		
		//Next World
		nextWorldKey = keys[KeyEvent.VK_TAB];
		
		//HP Regeneration
		regenHP = keys[KeyEvent.VK_SHIFT];
		
		//Summon Door test
		appearDoor = keys[KeyEvent.VK_Y];
	
		// One of Each "X" Key
		OneofEach = keys[KeyEvent.VK_X];

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	public boolean keyJustPressed(int keyCode){
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}

}
