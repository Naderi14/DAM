import enums.Position;
import enums.Sex;
import enums.Team;
import player.Player;

public class PlayerTest {
    public static void main(String[] args) {
        //1. Constructor 1
        Player player1 = new Player("El bicho", "pelao", 180f, 85f, (byte) 30, Sex.MAN, 125, Team.RM, Position.FORWARD, true);
        //2. Constructor 2
        Player player2 = new Player("Madona", "Jimenez", 160f, 60f, Team.PSG, Position.DEFENDER);
        //3. Constructor 3
        Player player3 = new Player("Daniel", "Gomez", Sex.MAN, Team.FCB, Position.GOALKEEPER);
        //4. Constructor 4
        Player player4 = new Player("Titu", "El cuiner", (byte) 28, Sex.MAN, Team.FCB, Position.MIDFIELDER);
        //5. Test increasePoints with 100 for an active player, it should be TRUE
        //Check points after calling the method
        System.out.println(player1.decreasePoints(20));
        System.out.println("Player 1: " + player1.getPoints() + " points");

        //6. Test increasePoints for an inactive player, it should be FALSE
        //Check points of player are the same before and after calling the method
        System.out.println("Player 2: " + player2.getPoints() + " points");
        System.out.println(player2.decreasePoints(-20));
        System.out.println("Player 2: " + player2.getPoints() + " points");

        //7. Test decreasePoints (5 points) for a player with enough points (100)
        //Check points of player are 95 after calling the method;
        System.out.println(player3.decreasePoints(5));
        System.out.println("Player 3: " + player3.getPoints() + " points");

        //8. Test decreasePoints (150 points) for a player with (95 points), it should be TRUE
        //Check points of player are 0 after calling the method;
        System.out.println(player3.decreasePoints(150));
        System.out.println("Player 3: " + player3.getPoints() + " points");

        //9. Test decreasePoints of a player with negative number (-15), it should be FALSE
        //Check points of player are the same before and after calling the method
        System.out.println("Player 1: " + player1.getPoints() + " points");
        System.out.println(player1.decreasePoints(-15));
        System.out.println("Player 1: " + player1.getPoints() + " points");

        //10. Test decrease points of an inactive player, it should be FALSE
        //Check points of player has not changed after calling the method
        player2.setActive(false);
        System.out.println("Player 2: " + player2.getPoints() + " points");
        System.out.println(player2.decreasePoints(15));
        System.out.println("Player 2: " + player2.getPoints() + " points");

        //11. Test giveCard() to an active player with 0 cards, it should be true
        //Check cards after calling method
        System.out.println(player3.giveCard());
        System.out.println("Player 3: " + player2.getCards() + " cards");

        //12. Test giveCard() to an active player with 1 cards, it should be true
        //Check cards after calling method
        System.out.println(player3.giveCard());
        System.out.println("Player 3: " + player2.getCards() + " cards");

        //13. Test giveCard() to an active player with 2 cards, it should be false
        //Check cards after calling method
        System.out.println(player3.giveCard());
        System.out.println("Player 3: " + player2.getCards() + " cards");

        //Getters
        //14. getName
        System.out.println(player4.getName());
        //15. getSurname
        System.out.println(player4.getSurname());
        //16. getHeight
        System.out.println(player4.getName());
        //17. getWeight
        System.out.println(player4.getWeight());
        //18. getAge
        System.out.println(player4.getAge());
        //19. getSex
        System.out.println(player4.getSex());
        //20. getTeam
        System.out.println(player4.getTeam());
        //21. getTeam -> getName
        System.out.println(player4.getTeam().getName());
        //22. getTeam -> getCountry
        System.out.println(player4.getTeam().getCountry());
        //23. getPosition
        System.out.println(player4.getPosition());
        //24. getPoints
        System.out.println(player4.getPoints());
        //25. getCards
        System.out.println(player4.getCards());
        //26. isActive
        System.out.println(player4.isActive());
        //Setters
        //27. setName
        player4.setName("Manel");
        //28. setSurname
        player4.setSurname("Jaeckel");
        //29. setHeight
        player4.setHeight(180f);
        //30. setWeight
        player4.setWeight(80f);
        //31. setAge
        player4.setAge((byte)28);
        //32. setTeam
        player4.setTeam(Team.BNF);
        //33. setPosition
        player4.setPosition(Position.DEFENDER);
        //34. setPoints
        player4.setPoints(160);
        //35. setActive
        player4.setActive(false);
    }
}