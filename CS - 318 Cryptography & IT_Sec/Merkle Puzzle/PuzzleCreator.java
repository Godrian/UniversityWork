/**
 * @author Adrian Gozdziewski
 * Student number - 986261
 */

import javax.crypto.*;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

public class PuzzleCreator {
    private static Cipher cipher;
    private ArrayList<Puzzle> puzzlesList;

    /**
     * Constructor of Puzzle
     */
    public PuzzleCreator(){
    }

    /**
     *
     * @return ArrayList of created puzzles
     * Create puzzle pieces with DES encryption in it
     */
    public ArrayList<Puzzle> createPuzzles(){
        puzzlesList = new ArrayList<>();
        //loop that creates 4096 puzzle pieces and during creation it start from 1.
        try{
            for(int i = 0; i < 4096; i++){
                byte[] encodedKey = createRandomKey();
                SecretKey secretKey = CryptoLib.createKey(encodedKey);
                puzzlesList.add(new Puzzle(i+1, secretKey));
            }
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException e){ }
        return puzzlesList;
    }

    /**
     *
     * @return byte array of DES encryption secret key
     * Method that creates Random DES Key and pass it further as byte array
     */
    public byte[] createRandomKey(){
        byte[] key = new byte[0];
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();
            key = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e){ }
        for (int i = 2; i < 8; i++){
            key[i] = 0;
        }
        return key;
    }

    /**
     *
     * @param key byte array of key that is used to create Secret key for DES decryption
     * @param puzzle Puzzle Object
     * @return byte array of encrypted puzzle with DES encryption
     * Method that encrypt Puzzle with DES encrytption
     */
    public byte[] encryptPuzzle(byte[] key,Puzzle puzzle ) {
        byte[] encryptedPuzzle = new byte[0];
        byte[] puzzleAsBytes = puzzle.getPuzzleAsBytes();
        SecretKey secretKey;
        try {
            cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            secretKey = CryptoLib.createKey(key);
            //Initialise the cipher to be in encrypt mode, using the given key.
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //Perform the encryption
            encryptedPuzzle = cipher.doFinal(puzzleAsBytes);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException e){ }
        return encryptedPuzzle;
    }

    /**
     *
     * @param fileName String representing file name
     * Method that encrypts all 4096 puzzles and writes them to a binary file
     */
    public void encryptPuzzlesToFile(String fileName) {
        File file = new File(fileName);
        byte[] puzzleByteArray;
        try(FileOutputStream fos = new FileOutputStream(file)){
            for (int i = 0; i < 4096; i++) {
                puzzleByteArray = encryptPuzzle(createRandomKey(), puzzlesList.get(i));
                fos.write(puzzleByteArray);
            }
        } catch (IOException e){ }
    }

    /**
     *
     * @param puzzleNumber Number of puzzle required to find
     * @return Secret Key of puzzle that had to be found
     * Method that find secret key of required puzzle
     */
    public SecretKey findKey(int puzzleNumber){
        return puzzlesList.get(puzzleNumber-1).getKey();
    }
}
