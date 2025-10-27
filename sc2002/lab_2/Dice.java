import java.util.Random;

public class Dice {
    private int valueOfDice;

    // Constructor
    public Dice() {
        valueOfDice = 1; // default value
    }

    // Simulate rolling the dice
    public void setDiceValue() {
        Random rand = new Random();
        valueOfDice = rand.nextInt(6) + 1; // 1 to 6
    }

    // Return the current dice value
    public int getDiceValue() {
        return valueOfDice;
    }

    // Print the current dice value
    public void printDiceValue() {
        System.out.println("Current Value is " + valueOfDice);
    }
}
