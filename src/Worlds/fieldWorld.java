package Worlds;
import Game.Entities.Creatures.BossEnemy;
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
//import Game.Entities.Statics.CactusBlock;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class fieldWorld extends BaseWorld{
    private Handler handler;
    private Player player;
    private BaseWorld fieldWorld;
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
        
        entityManager.addEntity(new Door2(handler, 400, 0,fieldWorld));
        
        entityManager.addEntity(new SecondQuestHumanoid(handler, 650, 50));
        entityManager.addEntity(new SkelyEnemy2(handler, 400, 400));
        entityManager.addEntity(new SkelyEnemy2(handler, 700, 600));
        entityManager.addEntity(new SkelyEnemy2(handler, 300, 370));
        entityManager.addEntity(new SkelyEnemy2(handler, 350, 300));
        entityManager.addEntity(new SkelyEnemy2(handler, 200, 700));
        entityManager.addEntity(new SkelyEnemy2(handler, 600, 600));
        entityManager.addEntity(new SkelyEnemy2(handler, 700, 600));
        entityManager.addEntity(new SkelyEnemy2(handler, 500, 600));
        entityManager.addEntity(new SkelyEnemy2(handler, 400, 600));
        


        entityManager.addEntity(new BossEnemy(handler, 1400, 500));;

        entityManager.addEntity(new Rock(handler, 1475, 770));

       
        
        
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