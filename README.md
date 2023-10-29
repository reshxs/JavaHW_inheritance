# Домашнее задание по наследованию

**ДИСКЛЕЙМЕР**: все, что вы видите в этом коде - плод моей больной фантазии, а не инструмент, 
который претендует на реальное исплоьзование в коде.  

Я решил пофантазировать и сделать иерархию классов, шифрующих строку.
Например, чтобы можно было удобно передавать ее в параметры API.

```java
public class SomeClass {
    public void SomeMethod() {
        var superSecretStr = "Hello, World!";

        ApiClient client = ApiClient.get_client();

        PublicKey pubKey = client.getPubKey();
        client.sendSecretStr(RSAEncryptedStr(superSecretStr, pubKey));
    }
}
```

Классы, которые получились:
1. `EncryptedStr` - Базовый абстракный класс, который описывает интерфейс и реализует базовые методы.
2. `RSAEncryptedStr` - Реализация, шифруящая строку с помощью RSA
3. `MaskedEncryptedStr` - Ведет себя как `RSAEncryptedStr`, но возвращает оригинальное значение в виде строки из 
"звездочек". Может быть полезно, например, чтобы не засветить оригинальное значение в логах.