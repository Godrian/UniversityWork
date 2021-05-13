import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DES {
    static Cipher cipher;

    public DES() throws Exception {
        cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
    }

    public String encrypt(String plainText, SecretKey secretKey) throws Exception {

        //Convert plaintext into byte representation
        byte[] plainTextByte = plainText.getBytes();

        //Initialise the cipher to be in encrypt mode, using the given key.
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        //Perform the encryption
        byte[] encryptedByte = cipher.doFinal(plainTextByte);

        //Get a new Base64 (ASCII) encoder and use it to convert ciphertext back to a string
        Base64.Encoder encoder = Base64.getEncoder();
        String encryptedText = encoder.encodeToString(encryptedByte);
        //String encryptedText = new String(encryptedByte);

        return encryptedText;
    }

    public String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
        //Get a new Base64 (ASCII) decoder and use it to convert ciphertext from a string into bytes
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] encryptedTextByte = decoder.decode(encryptedText);
        //byte[] encryptedTextByte = encryptedText.getBytes();

        //Initialise the cipher to be in decryption mode, using the given key.
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        //Perform the decryption
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);

        //Convert byte representation of plaintext into a string
        String decryptedText = new String(decryptedByte);

        return decryptedText;
    }


    public SecretKey generateRandomKey() throws NoSuchAlgorithmException{
        //Use java's key generator to produce a random key.
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecretKey secretKey = keyGenerator.generateKey();

        //print the key
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println(encodedKey);

        return secretKey;
    }
}