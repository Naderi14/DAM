import enums.Modes;
import enums.Sex;
import enums.Status;
import skin.Skin;

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
        System.out.println(skin2.getPoints() + "points");
        System.out.println(skin2.decreasePoints(50));
        System.out.println(skin2.getPoints() + "points");
        System.out.println(skin2.decreasePoints(150));
        System.out.println(skin2.getPoints() + "points");
        System.out.println(skin2.battling());
        System.out.println(skin2.resting());
        System.out.println(skin2.eating());
        System.out.println(skin2.getSword());
        System.out.println(skin2.getGun());
        System.out.println(skin2.getRope());
        System.out.println(skin2.battling());

        // TODO: TEST 2
    }
}