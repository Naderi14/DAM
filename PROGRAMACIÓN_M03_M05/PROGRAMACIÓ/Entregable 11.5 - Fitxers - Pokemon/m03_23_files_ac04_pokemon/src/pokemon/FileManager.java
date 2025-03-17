package pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public List<Pokemon> getPokemonListByFile(String fileInput) throws IOException
    {
        List<Pokemon> pokemonList = new ArrayList<>();

        BufferedReader buffer = new BufferedReader(new FileReader(fileInput));
        buffer.readLine();
        String linea;
        while ((linea = buffer.readLine()) != null)
        {
            String[] stringValues = linea.split(";");

            pokemonList.add(new Pokemon(
                    Integer.parseInt(stringValues[0]),
                    stringValues[1],
                    stringValues[2],
                    stringValues[3],
                    Integer.parseInt(stringValues[4]),
                    Integer.parseInt(stringValues[5]),
                    Integer.parseInt(stringValues[6]),
                    Integer.parseInt(stringValues[7]),
                    Integer.parseInt(stringValues[8]),
                    Integer.parseInt(stringValues[9]),
                    Byte.parseByte(stringValues[10]),
                    Boolean.parseBoolean(stringValues[11])
            ));
        }

        return pokemonList;
    }

    public String readTotals(String fileInput, String type1, String type2)
    {
        String result = "";

        try
        {
            List<Pokemon> pokemonList = getPokemonListByFile(fileInput);

            for (Pokemon pokemon : pokemonList)
            {
                if ((pokemon.getType1().equalsIgnoreCase(type1) || pokemon.getType1().equalsIgnoreCase(type2)) &&
                        (pokemon.getType2().equalsIgnoreCase(type1) || pokemon.getType2().equalsIgnoreCase(type2)))
                {
                    int totalPoints = pokemon.getHealthPoints() + pokemon.getAttack() + pokemon.getDefense() + pokemon.getSpecialAttack() + pokemon.getSpecialDefense() + pokemon.getSpeed();
                    result += pokemon + " | Total Points: " + totalPoints + "\n";
                }
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return result;
    }

    public void write(String text, String fileOutput) throws IOException
    {
        FileWriter writer = new FileWriter(fileOutput);
        writer.write(text);
        writer.flush();
        writer.close();
        System.out.println(String.format("<- %s has been created correctly", fileOutput));
    }
}
