import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

public class RSAEncryptedStr extends EncryptedStr{
    private final PublicKey pubKey;

    public RSAEncryptedStr(String value, PublicKey pubKey) {
        super(value);
        this.pubKey = pubKey;
    }

    @Override
    protected String encryptValue(String value) {
        Cipher cipher = getCipher(pubKey);

        byte[] result;
        try {
            result = cipher.doFinal(value.getBytes());
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException(e);
        }

        if (result == null) {
            return null;
        }
        
        return encodeEncryptedBytes(result);
    }

    private static Cipher getCipher(PublicKey publicKey) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("RSA");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }

        try {
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        return cipher;
    }

    private static String encodeEncryptedBytes(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
