import javax.crypto.SecretKey;

public class lab3 {

    public static void main(String[] args) throws Exception {

        String message = "Cryptography and Network Security";
        String password = "Poland";

        AES aes = new AES();

        System.out.println("My AES key encryption:");
        SecretKey secretKey = aes.generateKeyFromPassword(password);
        String encryptedMessage = aes.encrypt(message, secretKey);
        String decryptedMessage = aes.decrypt(encryptedMessage,secretKey);
        System.out.println("Message before encryption: " + message);
        System.out.println("Encrypted message: " + encryptedMessage);
        System.out.println("Message after encryption: " + decryptedMessage);

        System.out.println("\nRandom AES key encryption:");
        SecretKey randomKey = aes.generateRandomKey();
        String randomEncryptedMessage = aes.encrypt(message,randomKey);
        String randomDecryptedMessage = aes.decrypt(randomEncryptedMessage, randomKey);
        System.out.println("Message before encryption: " + message);
        System.out.println("Encrypted message: " + randomEncryptedMessage);
        System.out.println("Message after encryption: " + randomDecryptedMessage);

        DES des = new DES();

        System.out.println("\n\nMy DES key encryption:");
        SecretKey desSecretKey = des.generateRandomKey();
        String desEncryptedMessage = des.encrypt(message, desSecretKey);
        String desDecryptedMessage = des.decrypt(desEncryptedMessage,desSecretKey);
        System.out.println("Message before encryption: " + message);
        System.out.println("Encrypted message: " + desEncryptedMessage);
        System.out.println("Message after encryption: " + desDecryptedMessage);

    }
}
