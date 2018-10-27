package Worlds;
import Game.Entities.Creatures.BossEnemy;
import Game.Entities.Creatures.CompanionEntity;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.QuestHumanoid;
import Game.Entities.Creatures.SecondQuestHumanoid;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Creatures.SkelyEnemy2;
import Game.Entities.Statics.CoinBlock;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Door2;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Game.GameStates.State;
import Game.Items.Item;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private BaseWorld fieldWorld;
//    private Player player;
    public int checkdoor=0;
    private int alreadymade=0;
    public boolean playerHasSeal=false;

    public CaveWorld(Handler handler, String path, Player player){
        super(handler,path,player);
        this.handler = handler;
        fieldWorld = new fieldWorld(handler,"res/Maps/fieldMap.map",player);


        entityManager.addEntity(new Rock(handler, 684, 1370));
        entityManager.addEntity(new Tree(handler, 765, 888));
        entityManager.addEntity(new Rock(handler, 88, 1345));
        entityManager.addEntity(new Tree(handler, 77, 700));
        entityManager.addEntity(new Rock(handler, 700, 150));       
        entityManager.addEntity(new Rock(handler, 1350, 770));
        entityManager.addEntity(new Rock(handler, 1412, 770));
        entityManager.addEntity(new Rock(handler, 1475, 770));


        entityManager.addEntity(new SecondQuestHumanoid(handler, 650, 50));
        //entityManager.addEntity(new SkelyEnemy(handler, 200, 300));

        entityManager.addEntity(new Door2(handler, 100, 0, fieldWorld));
        entityManager.addEntity(new SkelyEnemy2(handler, 400, 400));
        entityManager.addEntity(new SkelyEnemy2(handler, 700, 600));
        entityManager.addEntity(new SkelyEnemy2(handler, 300, 370));
        entityManager.addEntity(new SkelyEnemy2(handler, 350, 300));
        entityManager.addEntity(new SkelyEnemy2(handler, 200, 700));
        entityManager.addEntity(new SkelyEnemy2(handler, 600, 600));
        entityManager.addEntity(new SkelyEnemy2(handler, 700, 600));
        entityManager.addEntity(new SkelyEnemy2(handler, 500, 600));
        entityManager.addEntity(new SkelyEnemy2(handler, 400, 600));
       // entityManager.addEntity(new BossEnemy(handler, 1400, 500));;
        
        
        // Coin Blocks
        entityManager.addEntity(new CoinBlock(handler, 200, 250));
        entityManager.addEntity(new CoinBlock(handler, 350, 400));
        entityManager.addEntity(new CoinBlock(handler, 500, 700));
        entityManager.addEntity(new CoinBlock(handler, 832, 128));
        entityManager.addEntity(new CoinBlock(handler, 1000, 900));


        //entityManager.addEntity(new Door(handler, 100, 0, fieldWorld));
        
        
        



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
