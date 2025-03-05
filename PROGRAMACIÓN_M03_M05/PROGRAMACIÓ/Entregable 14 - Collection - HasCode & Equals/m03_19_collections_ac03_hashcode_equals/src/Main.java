import player.enums.Sex;
import skin.*;
import skin.enums.*;
import player.*;
import player.enums.*;
import client.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Clientes: ");
        Set<Client> clients = new HashSet<>();
        clients.add(new Client("0000001", "BUGS", "BUNNY", "US", "1111111", "11111111A", (byte) 15));
        clients.add(new Client("0000002", "MARILYN", "MONROE", "US", "2222222", "22222222B", (byte) 27));
        clients.add(new Client("0000003", "PETER", "PAN", "UK", "3333333", "33333333C", (byte) 12));
        clients.add(new Client("0000004", "BART", "SIMPSON", "UK", "4444444", "44444444D", (byte) 10));
        clients.add(new Client("0000005", "MAFALDA", "SRTA.", "AR", "5555555", "55555555E", (byte) 8));
        clients.add(new Client("0000006", "LISA", "SIMPSON", "US", "6666666", "66666666F", (byte) 8));
        clients.add(new Client("0000007", "CHARLIE", "BROWN", "UK", "7777777", "77777777G", (byte) 8));
        clients.add(new Client("0000008", "SPONGEBOB", "SQUAREPANTS", "US", "8888888", "88888888H", (byte) 5));
        clients.add(new Client("0000009", "PATRICK", "STAR", "US", "9999999", "99999999I", (byte) 5));
        clients.add(new Client("0000010", "HOMER", "SIMPSON", "US", "1212121", "10101010J", (byte) 45));
        clients.add(new Client("0000010", "MAGGIE", "SIMPSON", "US", "1212121", "11111111K", (byte) 30));

        // Se puede observar que Homer y Maggie a pesar de tener el mismo accountName
        // como tiene distinto DNI, pueden ser registrados en la lista
        clients.forEach(System.out::println);

        System.out.println("\nJugadores: ");
        Set<Player> players = new HashSet<>();
        players.add(new Player("KYLIAN", "MBAPPÉ", 1.78f, 80.00f, (byte) 23, Sex.MAN, 100, Team.PSG, Position.FORWARD, true));
        players.add(new Player("SERGI", "BUSQUETS", 1.89f, 85.00f, (byte) 18, Sex.MAN, 100, Team.PSG, Position.FORWARD, true));
        players.add(new Player("MAPI", "LEON", 1.70f, 60.00f, (byte) 26, Sex.WOMAN, 100, Team.FCB, Position.DEFENDER, false));
        players.add(new Player("LEO", "MESSI", 1.70f, 70.00f, (byte) 18, Sex.NOTDEFINED, 100, Team.PSG, Position.FORWARD, true));
        players.add(new Player("GERARD", "PIQUE", 1.94f, 84.00f, (byte) 35, Sex.MAN, 100, Team.FCB, Position.DEFENDER, true));
        players.add(new Player("ALEXIA", "PUTELLAS", 1.65f, 58.00f, (byte) 28, Sex.WOMAN, 200, Team.FCB, Position.MIDFIELDER, true));
        players.add(new Player("ALEXIA", "PUTELLAS", 1.65f, 60.00f, (byte) 28, Sex.WOMAN, 100, Team.PSG, Position.DEFENDER, false));
        players.add(new Player("GERARD", "PIQUE", 1.94f, 85.00f, (byte) 35, Sex.MAN, 300, Team.FCB, Position.MIDFIELDER, true));

        // Aquí se puede ver que solo entrará la primera Alexia Putellas que venga, la segunda no podrá ser registrada
        // por tener los mismos credenciales, lo mismo ocurre con el segundo Gerard Pique
        players.forEach(System.out::println);

        System.out.println("\nSkins: ");
        Set<Skin> skins = new HashSet<>();
        skins.add(new Skin("SYNTH", Sexo.MAN, 1500));
        skins.add(new Skin("ORELIA", Sexo.WOMAN, 200));
        skins.add(new Skin("MIDAS REX", Sexo.MAN, 150));
        skins.add(new Skin("LACHLAN", Sexo.MAN, 3000));
        skins.add(new Skin("THE GREFG", Sexo.MAN, 400));
        skins.add(new Skin("BLASTOFF", Sexo.MAN, 450));
        skins.add(new Skin("HYPERSONIC", Sexo.MAN, 300));
        skins.add(new Skin("WANDERLUST", Sexo.MAN, 100));
        skins.add(new Skin("WANDERLUST", Sexo.WOMAN, 3500));
        skins.add(new Skin("POLARITY", Sexo.WOMAN, 400));
        skins.add(new Skin("LACHLAN", Sexo.MAN, 300));
        skins.add(new Skin("POLARITY", Sexo.WOMAN, 200));
        skins.add(new Skin("ORELIA", Sexo.WOMAN, 100));

        // Los 3 últimos Skins, tienen los mismos nombres y sexo de otros 3 anteriormente
        // registrados a la lista, por lo tanto no podrán ser agregados
        skins.forEach(System.out::println);
    }
}