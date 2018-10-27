package Worlds;
import Game.Entities.Creatures.BossEnemy;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.QuestHumanoid;
import Game.Entities.Creatures.SecondQuestHumanoid;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.CoinBlock;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Rock;
import Game.Entities.Statics.Tree;
import Game.GameStates.State;
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

    public CaveWorld(Handler handler, String path, Player player){
        super(handler,path,player);
        this.handler = handler;
        fieldWorld = new fieldWorld(handler,"res/Maps/fieldMap.map",player);

//        entityManager.addEntity(new Tree(handler, 100, 250));
//        entityManager.addEntity(new Rock(handler, 100, 450));
//        entityManager.addEntity(new Tree(handler, 533, 276));
        entityManager.addEntity(new Rock(handler, 684, 1370));
        entityManager.addEntity(new Tree(handler, 765, 888));
        entityManager.addEntity(new Rock(handler, 88, 1345));
        entityManager.addEntity(new Tree(handler, 77, 700));
        entityManager.addEntity(new Rock(handler, 700, 150));       
        entityManager.addEntity(new Rock(handler, 1350, 770));
        entityManager.addEntity(new Rock(handler, 1412, 770));
        entityManager.addEntity(new Rock(handler, 1475, 770));
//        entityManager.addEntity(new CactusBlock(handler, 400, 20));
//        entityManager.addEntity(new Door(handler, 100, 0, fieldWorld));
        entityManager.addEntity(new SecondQuestHumanoid(handler, 650, 50));
        entityManager.addEntity(new SkelyEnemy(handler, 200, 300));
        
        
        
        // Coin Blocks
        entityManager.addEntity(new CoinBlock(handler, 200, 250));
        entityManager.addEntity(new CoinBlock(handler, 350, 400));
        entityManager.addEntity(new CoinBlock(handler, 500, 700));
        entityManager.addEntity(new CoinBlock(handler, 832, 128));
        entityManager.addEntity(new CoinBlock(handler, 1000, 900));


        entityManager.addEntity(new Door(handler, 100, 0, fieldWorld));

        



        entityManager.getPlayer().setX(spawnX);
        entityManager.getPlayer().setY(spawnY);
    }
    
//    public CaveWorld(Handler handler, String path, Player player) {
//        super(handler,path,player);
//        this.handler = handler;
//        this.player=player;

}
