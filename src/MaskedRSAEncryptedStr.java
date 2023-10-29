import java.security.PublicKey;

public class MaskedRSAEncryptedStr extends RSAEncryptedStr{
    public MaskedRSAEncryptedStr(String value, PublicKey pubKey) {
        super(value, pubKey);
    }

    @Override
    public String getOriginalValue(){
        var stringLength = super.getOriginalValue().length();
        return "*".repeat(stringLength);
    }
}
