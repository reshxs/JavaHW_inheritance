import java.security.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(); // Добавил отступ для красивости

        var pubKey = genPubKey();

        RSAEncryptedStr encryptedStr = new RSAEncryptedStr("Hello, World!", pubKey);
        MaskedRSAEncryptedStr maskedEncryptedStr = new MaskedRSAEncryptedStr("Hello, World!", pubKey);

        EncryptedStr[] encryptedStrings = {encryptedStr, maskedEncryptedStr};

        System.out.println("Выведем на экран закодированные значения:");
        Arrays.stream(encryptedStrings).forEach(System.out::println);

        System.out.println(); // Добавил отступ для красивости
        System.out.println("Выведем на экран оригинальные значения:");
        Arrays.stream(encryptedStrings).forEach(str -> {
            System.out.println(str.getOriginalValue());
        });
    }

    public static PublicKey genPubKey() {
        KeyPairGenerator keyPairGenerator;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        return keyPair.getPublic();
    }
}