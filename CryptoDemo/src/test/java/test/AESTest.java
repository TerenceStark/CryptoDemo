package test;

import crypto.assymmetry.RSACipherService;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.SecureRandom;

public class AESTest {
    private final static SecureRandom secureRandom = new SecureRandom();

    @Test
    public void testAES() {
        int N = 1024;
        RSACipherService key = new RSACipherService(N);
        System.out.println(key);

        BigInteger message = new BigInteger(N - 1, secureRandom);
        BigInteger encrypt = key.encrypt(message);
        BigInteger decrypt = key.decrypt(encrypt);

        System.out.println("message   = " + message);
        System.out.println("encrypted = " + encrypt);
        System.out.println("decrypted = " + decrypt);
    }
}
