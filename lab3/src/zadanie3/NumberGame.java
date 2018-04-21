package zadanie3;

import java.util.Random;

public class NumberGame {
    private int correctNumber;

    public void generateNewNumber() {
        Random random = new Random();
        this.correctNumber = random.nextInt(101);
        System.out.println(this.correctNumber);
    }

    public int compareNumbers(int correctNumber, int playerNumber) {
        if (correctNumber < playerNumber)
            return 1;
        else if (correctNumber > playerNumber)
            return -1;
        else
            return 0;
    }

    public int getCorrectNumber() {
        return this.correctNumber;
    }
}
