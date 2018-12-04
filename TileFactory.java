import greenfoot.*;
/**
 *
 * @author R. Springer
 */
public class TileFactory {
    /**
     * Creates a Tile object based on the mapIcon number you give
     *
     * @param mapIcon number
     * @return Tile tile object
     */
    public Tile createTile(int mapIcon) {
        Tile tile;
        switch (mapIcon) {
            case 0:
            tile = new Tile("box.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 1:
            tile = new Tile("boxAlt.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 2:
            tile = new Tile("boxCoin.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 3:
            tile = new Tile("boxExplosive.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 4:
            tile = new Tile("boxItem.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 5:
            tile = new Tile("bridgeLogs.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.getImage().mirrorVertically();
            tile.isSolid = true;
            break;
            case 6:
            tile = new Tile("grassCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 7:
            tile = new Tile("grassLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 8:
            tile = new Tile("grassMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 9:
            tile = new Tile("grassRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 10:
            tile = new Tile("liquidWater.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 11:
            tile = new DangerousTiles("liquidWaterTop_mid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 12:
            tile = new Tile("signExit.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 13:
            tile = new Tile("signLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 14:
            tile = new Tile("signRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 26:
            tile = new Tile("bridge.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.getImage().mirrorVertically();
            tile.isSolid = true;
            break;
            case 28:
            tile = new Tile("castleCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 30:
            tile = new Tile("castleCliffLeft.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 32:
            tile = new Tile("castleCliffRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 45:
            tile = new Tile("castleMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 67:
            tile = new Tile("door_closedMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 68:
            tile = new Tile("door_closedTop.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break; 
            case 69:
            tile = new Doors("door_openMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break; 
            case 70:
            tile = new Doors("door_openTop.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break; 
            case 85:
            tile = new Tile("grassHillRight.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = false;
            break;
            case 86:
            tile = new Tile("grassHillRight2.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 91:
            tile = new Tile("hill_small.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 93:
            tile = new Tile("ladder_mid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 94:
            tile = new Tile("ladder_top.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 95:
            tile = new DangerousTiles("liquidLava.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;     
            case 97:
            tile = new DangerousTiles("liquidLavaTop_mid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break; 
            case 99:
            tile = new Locks("lock_blue.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 100:
            tile = new Locks("lock_green.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 101:
            tile = new Locks("lock_red.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 102:
            tile = new Locks("lock_yellow.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 105:
            tile = new Tile("ropeAttached.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 106:
            tile = new Tile("ropeHorizontal.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 107:
            tile = new Tile("ropeVertical.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 169:
            tile = new Tile("tochLit.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 173:
            tile = new Tile("grassCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 174:
            tile = new DangerousTiles("bomb.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 181:
            tile = new Buttons("buttonRed.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;    
            case 186:
            tile = new Tile("chain.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 191:
            tile = new Coins("coinGold.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 193:
            tile = new DangerousTiles("fireball.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 200:
            tile = new Checkpoints("flagRed2.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 206:
            tile = new Powerups("gemBlue.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 207:
            tile = new Powerups("gemGreen.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 208:
            tile = new Powerups("gemRed.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 209:
            tile = new Powerups("gemYellow.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 210:
            tile = new Keys("keyBlue.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 211:
            tile = new Keys("keyGreen.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 212:
            tile = new Keys("keyRed.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 213:
            tile = new Keys("keyYellow.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 215:
            tile = new Tile("mushroomRed.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 220:
            tile = new Tile("plant.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 224:
            tile = new DangerousTiles("spikes.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 226:
            tile = new Springboards("springboardUp.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 227:
            tile = new Springboards("springboardDown.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 232:
            tile = new Tile("weightChained.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 257:
            tile = new Tile("keyYellow.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 266:
            tile = new SecretWall("castleCenter.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
            case 267:
            tile = new Tile("Enemies/blockerMad.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 268:
            tile = new Tile("Enemies/flyFly1.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            case 273:
            tile = new Tile("Enemies/snailWalk1.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            break;
            default:
            tile = new Tile("grassMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT);
            tile.isSolid = true;
            break;
        }
        return tile;
    }
}
