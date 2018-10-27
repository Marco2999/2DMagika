package Game.Entities.Creatures;

import Game.Inventories.*;


import Game.Entities.EntityBase;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * Created by Elemental on 2/7/2017.
 */
public class QuestHumanoid extends CreatureBase  {

    private Inventory questerinventory;
    private Rectangle SkelyCam;

    private int healthcounter =0;

    private Random randint;
    private int msgCooldown=0;
    public int displaycd =0;
    
    public int coinRemember=0;
    public static int neededCoins =3; 
    public static int neededKey=1;

    public QuestHumanoid(Handler handler, float x, float y) {
    	
    	
        super(handler, x, y, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT);
        bounds.x=8*2;
        bounds.y=18*2;
        bounds.width=16*2;
        bounds.height=14*2;
        speed=1.5f;
        health=500;

        SkelyCam= new Rectangle();
        randint = new Random();
        questerinventory= new Inventory(handler);
    }
    //Font stringfont = new Font("SansSerif",Font.PLAIN, 20);

    @Override
    public void tick() {
    	
    	if(this.health<500) {
    	this.health = this.health +5;
    	}
    	msgCooldown++;
        if(isBeinghurt()){// && msgCooldown>120 
        	
        	healthcounter++;
            msgCooldown =0;
            

            if(isBeinghurt()){
                healthcounter++;
                if(healthcounter>=120){
                    setBeinghurt(false);
                }
            }
            
            
            }

        	questerinventory.tick();
        	
        }
    public void checkattacks() {
    	//nothing
    }


    @Override
    public void render(Graphics g) {
    	
    	
    	if(isBeinghurt()) {
    		for(Item item : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()) {
    			if(item.getName()=="Coin") {    		
    				coinRemember = neededCoins;
    				neededCoins = neededCoins - item.getCount();
    				item.setCount(item.getCount()-coinRemember);
    				if(neededCoins < 0) {
    					neededCoins =0;
    				}
    			}else if(item.getName()=="Key") {    				
    				neededKey = neededKey - item.getCount();
    				item.setCount(0);
    				if(neededKey < 0) {
    					neededKey=0;
    				}
    			}  		
    		}

    		
    		
    		
    		//Draw quest coin
    		g.setColor(Color.WHITE);
    		g.drawImage(Item.Coin.getTexture(),(int) (x - handler.getGameCamera().getxOffset())-60, (int) (y - handler.getGameCamera().getyOffset())+28, 35, 35, null);	
    		g.drawRect((int) (x - handler.getGameCamera().getxOffset()-60), (int) (y - handler.getGameCamera().getyOffset())+28, 35, 35);
    		g.drawString(Integer.toString(neededCoins), (int) (x - handler.getGameCamera().getxOffset())-45, (int) (y - handler.getGameCamera().getyOffset())+75);
    		//Draw quest key
    		g.drawImage(Item.Key.getTexture(),(int) (x - handler.getGameCamera().getxOffset())+69, (int) (y - handler.getGameCamera().getyOffset())+30, 32, 32, null);
    		g.drawRect((int) (x - handler.getGameCamera().getxOffset()+68), (int) (y - handler.getGameCamera().getyOffset())+28, 35, 35);
    		g.drawString(Integer.toString(neededKey), (int) (x - handler.getGameCamera().getxOffset())+82, (int) (y - handler.getGameCamera().getyOffset())+75);
    		///Quest Text
    		g.drawString("Please deliver these items to me!",(int)(x-handler.getGameCamera().getxOffset())-68,(int)(y-handler.getGameCamera().getyOffset()-30));
    	}
        g.setColor(Color.BLUE);
        g.drawRect((int)(x-handler.getGameCamera().getxOffset()-1),(int)(y-handler.getGameCamera().getyOffset()-21),51,11);
        g.setColor(Color.WHITE);
        g.fillRect((int)(x-handler.getGameCamera().getxOffset()+0.5),(int)(y-handler.getGameCamera().getyOffset()-20),50,10);
        
        Font stringfont = new Font("Baghdad",Font.PLAIN, 10);
        g.setFont(stringfont);
        g.setColor(Color.BLACK);
      
        g.drawString("Hinata",(int)(x-handler.getGameCamera().getxOffset())+10,(int)(y-handler.getGameCamera().getyOffset()-11));
        
    }
    




    @Override
    public void die() {
    	handler.getWorld().getItemManager().addItem(Item.Coin.createNew((int)x + bounds.x,(int)y + bounds.y,1));
    	//handler.getWorld().getItemManager().addItem(Item.Key.createNew((int)x + bounds.x+50,(int)y + bounds.y,1));
    	
    }
}
