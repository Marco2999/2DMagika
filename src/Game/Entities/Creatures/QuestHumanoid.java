package Game.Entities.Creatures;

import Game.Entities.EntityBase;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Main.Handler;
import Resources.Animation;
import Resources.Images;

import java.awt.*;
import java.util.Random;

/**
 * Created by Elemental on 2/7/2017.
 */
public class QuestHumanoid extends CreatureBase  {

    private Inventory questerinventory;
    private Rectangle SkelyCam;

    private int healthcounter =0;

    private Random randint;
    private int questregencounter = 0;

    

    public QuestHumanoid(Handler handler, float x, float y) {
    	
    	
        super(handler, x, y, CreatureBase.DEFAULT_CREATURE_WIDTH, CreatureBase.DEFAULT_CREATURE_HEIGHT);
        bounds.x=8*2;
        bounds.y=18*2;
        bounds.width=16*2;
        bounds.height=14*2;
        speed=1.5f;
        health=5000;

        SkelyCam= new Rectangle();
        randint = new Random();
        questerinventory= new Inventory(handler);
    }
    //Font stringfont = new Font("SansSerif",Font.PLAIN, 20);

    @Override
    public void tick() {


        if(isBeinghurt()){
        	questregencounter = 0;
            healthcounter++;
            
            if(healthcounter>=120){
                setBeinghurt(false);
                System.out.print(isBeinghurt());
            }
        }
        if(healthcounter>=120&& !isBeinghurt()){
            healthcounter=0;
        }
        
        if(!isBeinghurt()) {
        	questregencounter++;
        	if(questregencounter >= 500 && health < 50) {
        		health++;
        	}
        	
        	
        }
        


        questerinventory.tick();
        
        


    }


    @Override
    public void render(Graphics g) {
        
        g.setColor(Color.BLACK);
        g.drawRect((int)(x-handler.getGameCamera().getxOffset()-1),(int)(y-handler.getGameCamera().getyOffset()-21),51,11);
        if(this.getHealth()>35){
            g.setColor(Color.GREEN);
            g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);

        }else if(this.getHealth()>=15 && getHealth()<=50){
            g.setColor(Color.YELLOW);
            g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);

        }else if(this.getHealth() < 15){
            g.setColor(Color.RED);
            g.fillRect((int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-20),getHealth(),10);

        }  
        Font stringfont = new Font("SansSerif",Font.PLAIN, 10);
        g.setFont(stringfont);
        g.setColor(Color.white);
      
        g.drawString("Health: " + getHealth(),(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()-11));
    }
    




    @Override
    public void die() {
    	handler.getWorld().getItemManager().addItem(Item.Coin.createNew((int)x + bounds.x,(int)y + bounds.y,1));
    	//handler.getWorld().getItemManager().addItem(Item.Key.createNew((int)x + bounds.x+50,(int)y + bounds.y,1));
    	
    }
}
