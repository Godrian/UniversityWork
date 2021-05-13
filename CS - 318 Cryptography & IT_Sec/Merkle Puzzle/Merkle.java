import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Merkle {
    public static void main(String[] args) throws Exception {
        Cipher cipher;
        cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        PuzzleCreator puzzleCreator = new PuzzleCreator();
        puzzleCreator.createPuzzles();
        puzzleCreator.encryptPuzzlesToFile("puzzles.bin");
        System.out.println("Created encrypted puzzle file for Alice");

        PuzzleCracker puzzleCracker = new PuzzleCracker("puzzles.bin");
        /*
        Because I want to crack puzzle number 2000 I am looking for puzzle number 1999,
        due to fact that puzzles are counted from 1 not 0
        */
        puzzleCracker.crack(1999);
        System.out.println("Cracked puzzle number 2000 in Bob's puzzle");
        SecretKey secretKey = puzzleCreator.findKey(2000);
        System.out.println("Found secret key for puzzle number 2000 ");

        byte[] plainTextByte = "Testing Merkles Puzzles".getBytes();
        System.out.println("Put message into byte array");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedInfo = cipher.doFinal(plainTextByte);
        System.out.println("Encrypted message");
        puzzleCracker.decryptMessage(encryptedInfo);


    }
}
