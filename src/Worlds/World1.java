package Worlds;

import Game.Entities.Creatures.BossEnemy;
import Game.Entities.Creatures.CompanionEntity;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.QuestHumanoid;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.*;
import Game.GameStates.State;
import Game.Items.Item;
import Main.Handler;

/**
 * Created by Elemental on 1/2/2017.
 */
public class World1 extends BaseWorld{
    private Handler handler;
    private BaseWorld CaveWorld;
    public int checkdoor=0;
    public boolean playerHasSeal = false;

    public World1(Handler handler, String path, Player player){
        super(handler,path,player);
        this.handler = handler;
        CaveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",player);

        entityManager.addEntity(new Tree(handler, 100, 250));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Tree(handler, 533, 276));
        entityManager.addEntity(new Rock(handler, 684, 1370));
        entityManager.addEntity(new Tree(handler, 765, 888));
        entityManager.addEntity(new Rock(handler, 88, 1345));
        entityManager.addEntity(new Tree(handler, 77, 700));
        entityManager.addEntity(new Rock(handler, 700, 150));
        entityManager.addEntity(new Rock(handler, 1350, 770));
        entityManager.addEntity(new Rock(handler, 1412, 770));
        entityManager.addEntity(new Rock(handler, 1475, 770));




        entityManager.addEntity(new QuestHumanoid(handler, 650, 50));
        entityManager.addEntity(new SkelyEnemy(handler, 200, 300));
        entityManager.addEntity(new SkelyEnemy(handler, 400, 300));
        
        
        // Coin Blocks
        entityManager.addEntity(new CoinBlock(handler, 200, 250));
        entityManager.addEntity(new CoinBlock(handler, 350, 400));
        entityManager.addEntity(new CoinBlock(handler, 500, 700));
        entityManager.addEntity(new CoinBlock(handler, 832, 128));
        entityManager.addEntity(new CoinBlock(handler, 1000, 900));


        entityManager.addEntity(new Door(handler, 300, 0,CaveWorld));
        

        



        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    public void tick(){
    	for (Item j : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()) {
			if (j.getName() == "Seal") {
				playerHasSeal = true;
			}
		}
    	if(handler.getKeyManager().summonCompanion&&playerHasSeal) {
    		entityManager.addEntity(new CompanionEntity(handler, 400, 600));
			
			for (Item j : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()) {
				if (j.getName() == "Seal") {
					playerHasSeal = false;
					j.setCount(j.getCount() - 1);
					//stopFollowingMeSans++;
					Item.Seal.setCount(0);

					break;
				}
			}
		}
        entityManager.tick();
        itemManager.tick();
        countP++;
        if(countP>=30){
            countP=30;
        }

        if(handler.getKeyManager().pbutt && countP>=30){
            handler.getMouseManager().setUimanager(null);
            countP=0;
            State.setState(handler.getGame().pauseState);
        }
    }

}