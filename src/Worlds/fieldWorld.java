package Worlds;
import Game.Entities.Creatures.BossEnemy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.QuestHumanoid;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.CoinBlock;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class fieldWorld extends BaseWorld{
    private Handler handler;
    private Player player;

    public fieldWorld(Handler handler, String path, Player player){
        super(handler,path,player);
        this.handler = handler;

        entityManager.addEntity(new Tree(handler, 200, 250));
        entityManager.addEntity(new Rock(handler, 300, 450));
        entityManager.addEntity(new Tree(handler, 633, 276));
        entityManager.addEntity(new Rock(handler, 784, 1370));
        entityManager.addEntity(new Tree(handler, 565, 888));
        entityManager.addEntity(new Rock(handler, 188, 1345));
        entityManager.addEntity(new Tree(handler, 657, 700));
        entityManager.addEntity(new Rock(handler, 300, 150));       
        entityManager.addEntity(new Rock(handler, 1350, 770));
        entityManager.addEntity(new Rock(handler, 1412, 770));
        entityManager.addEntity(new Rock(handler, 1475, 770));
        //entityManager.addEntity(new Door(handler, 100, 0,caveWorld));
        entityManager.addEntity(new BossEnemy(handler, 1400, 500));
        
        
        
        
        // Coin Blocks
        entityManager.addEntity(new CoinBlock(handler, 400, 250));
        entityManager.addEntity(new CoinBlock(handler, 650, 300));
        entityManager.addEntity(new CoinBlock(handler, 550, 500));
        entityManager.addEntity(new CoinBlock(handler, 732, 528));
        entityManager.addEntity(new CoinBlock(handler, 990, 900));
        

        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    


}