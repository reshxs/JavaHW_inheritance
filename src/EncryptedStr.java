public abstract class EncryptedStr {
    private final String originalValue;

    public EncryptedStr(String value) {
        this.originalValue = value;
    }

    protected abstract String encryptValue(String value);

    public String getEncryptedValue() {
        return encryptValue(originalValue);
    }

    @Override
    public String toString(){
        return getEncryptedValue();
    }

    public String getOriginalValue(){
        return originalValue;
    }
}
