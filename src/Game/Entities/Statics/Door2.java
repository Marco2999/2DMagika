package Game.Entities.Statics;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.QuestHumanoid;
import Game.Entities.Creatures.SecondQuestHumanoid;
import Game.GameStates.State;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

import java.awt.*;

/**
 * Created by Elemental on 2/2/2017.
 */


public class Door2 extends StaticEntity {

    private Rectangle ir = new Rectangle();
    public Boolean EP = false;
    private int alreadymade=0;
    private BaseWorld world;
    
  //World Check
    public int whatworld;

    public Door2(Handler handler, float x, float y,BaseWorld world2) {
        super(handler, x, y, 64, 100);
        this.world=world2;
        health=10000000;
        bounds.x=0;
        bounds.y=0;
        bounds.width = 100;
        bounds.height = 64;

        ir.width = bounds.width;
        ir.height = bounds.height;
        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
        int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
        ir.y=iry;
        ir.x=irx;
    }

    @Override
    public void tick() {

        if(isBeinghurt()){
            setHealth(10000000);
        }

        if(handler.getKeyManager().attbut){
            EP=true;

        }else if(!handler.getKeyManager().attbut){
            EP=false;
        }
    }

    @Override
    public void render(Graphics g) {


       	    if(QuestHumanoid.neededCoins==0 && QuestHumanoid.neededKey==0 && alreadymade==0) {
            	g.drawImage(Images.door,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
            	g.setColor(Color.RED);
            	checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
            }
       	    if(SecondQuestHumanoid.neededCoins==0 && SecondQuestHumanoid.neededRamen==0 && alreadymade==0) {
	         	g.drawImage(Images.door,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
	         	g.setColor(Color.RED);
	         	checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
         }
    }

        
    	

    private void checkForPlayer(Graphics g, Player p) {
        Rectangle pr = p.getCollisionBounds(0,0);

        if(ir.contains(pr) && !EP){
            g.drawImage(Images.E,(int) x+width,(int) y+10,32,32,null);
        }else if(ir.contains(pr) && EP){
            g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);
            g.drawImage(Images.loading,0,0,800,600,null);
            handler.setWorld(world);
            whatworld++;
        }
 
        if(handler.getKeyManager().nextWorldKey) {
        	handler.setWorld(world);
        	whatworld++;
        }
    }

    @Override
    public void die() {

    }
}
