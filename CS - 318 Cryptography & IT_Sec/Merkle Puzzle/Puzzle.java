/**
 * @author Adrian Gozdziewski 986261
 * Class Puzzle that used to create each puzzle
 * */

import javax.crypto.SecretKey;

public class Puzzle {

    //
    private int puzzleNumber;
    private SecretKey secretKey;

    /**
     *
     * @param puzzleNumber - number of puzzle
     * @param secretKey - Secret key for this puzzle
     * Constructor that create puzzle with current number and Secret key for this puzzle
     */
    public Puzzle(int puzzleNumber, SecretKey secretKey){
        this.puzzleNumber = puzzleNumber;
        this.secretKey = secretKey;
    }

    /**
     *
     * @return number of current puzzle
     * Method that return puzzle's number
     */
    public int getPuzzleNumber(){
        return puzzleNumber;
    }

    /**
     *
     * @return puzzle's secret Key
     * Method that return current puzzle's secret Key
     */
    public SecretKey getKey() {
        return secretKey;
    }

    /**
     *
     * @return puzzle as Byte Array
     * Method that return current Puzzle as Byte array
     */
    public byte[] getPuzzleAsBytes() {
        //Create temporary byte array for number and secret key of this puzzle and put those variables into those arrays
        byte[] number = CryptoLib.smallIntToByteArray(getPuzzleNumber());
        byte[] key = getKey().getEncoded();
        byte[] puzzle = new byte[26];
        //Put data from temporary arrays to final byte array
        puzzle[16] = number[0];
        puzzle[17] = number[1];
        for(int i = 0; i < 8; i++){
            puzzle[i + 18] = key[i];
        }
        return puzzle;
    }
}
