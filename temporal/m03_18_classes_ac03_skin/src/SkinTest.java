import enums.Modes;
import enums.Sex;
import enums.Status;
import skin.Mode;
import skin.Skin;
import skin.Zombi;

public class SkinTest {
    public static void main(String[] args) {
        // TODO: TEST 1
        Skin skin1 = new Skin("Juan", Sex.MAN, 20);
        System.out.println(skin1.toString());
        System.out.println(skin1.loseLife());
        System.out.println(skin1.loseLife());
        System.out.println(skin1.loseLife());
        System.out.println(skin1.loseLife());
        System.out.println(skin1.increaseLife());
        System.out.println(skin1.increasePoints(20));

        Skin skin2 = new Skin("Fran", Sex.MAN, 30);
        System.out.println(skin2.toString());
        System.out.println(skin2.increaseLife());
        System.out.println(skin2.increaseLife());
        System.out.println(skin2.increaseLife());
        System.out.println(skin2.increasePoints(100));
        System.out.println(skin2.getPoints() + " points");
        System.out.println(skin2.decreasePoints(50));
        System.out.println(skin2.getPoints() + " points");
        System.out.println(skin2.decreasePoints(150));
        System.out.println(skin2.getPoints() + " points");
        System.out.println(skin2.battling());
        System.out.println(skin2.resting());
        System.out.println(skin2.eating());
        System.out.println(skin2.getSword());
        System.out.println(skin2.getGun());
        System.out.println(skin2.getRope());
        System.out.println(skin2.battling());

        // TODO: TEST 2
        Skin[] skins = {
                new Skin("Orelia", Sex.WOMAN, 100),
                new Skin("Midas Rex", Sex.MAN, 100),
                new Skin("Lachlan", Sex.MAN, 100),
                new Skin("The Grefg", Sex.MAN, 100),
                new Skin("Blastoff", Sex.MAN, 100),
                new Skin("Hypersonic", Sex.MAN, 100),
                new Skin("Wanderlust", Sex.MAN, 100),
                new Skin("Hunter", Sex.MAN, 100),
                new Skin("The Mighty Volt", Sex.MAN, 100),
                new Skin("Backlash", Sex.NOTDEFINED, 100)
        };

        Mode mode1 = new Mode(Modes.SAVE_THE_WORLD, skins, 500);
        System.out.println(mode1.toString());
        for (Skin skin : mode1.getSkins())
        {
            System.out.println(skin.toString());
        }

        for (Zombi zombi : mode1.getZombis())
        {
            System.out.println(zombi.toString());
        }

        Mode mode2 = new Mode(Modes.BATTLE_ROYALE, skins, 20);
        System.out.println(mode2.toString());
        for (Skin skin : mode2.getSkins())
        {
            System.out.println(skin.toString());
        }

        for (Zombi zombi : mode2.getZombis())
        {
            System.out.println(zombi.toString());
        }

        Mode mode3 = new Mode(Modes.BATTLE_ROYALE, skins, 50);
        System.out.println(mode3.toString());
        for (Skin skin : mode3.getSkins())
        {
            System.out.println(skin.toString());
        }

        for (Zombi zombi : mode3.getZombis())
        {
            System.out.println(zombi.toString());
        }
    }
}