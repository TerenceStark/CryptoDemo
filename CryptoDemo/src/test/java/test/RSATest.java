package test;

import crypto.assymmetry.RSACipherService;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.security.SecureRandom;


public class RSATest {
    private final static SecureRandom random = new SecureRandom();

    @Test
    public void test() {
        int N = 2 << 10;
        RSACipherService rsaCipherService = new RSACipherService(N);

        // create random message, encrypt and decrypt
        BigInteger message = new BigInteger(N - 1, random);
        BigInteger encrypt = rsaCipherService.publicKey(message);
        BigInteger decrypt = rsaCipherService.privateKey(encrypt);

        System.out.println("public key  = " + rsaCipherService.getPublicKey());
        System.out.println("private key =:" + rsaCipherService.getPrivateKey());
        System.out.println("modulus     = " + rsaCipherService.getModulus() + "\n");
        System.out.println("message     = " + message);
        System.out.println("encrypted   = " + encrypt);
        System.out.println("decrypted   = " + decrypt);
    }

}
