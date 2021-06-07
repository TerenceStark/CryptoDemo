package test;

import crypto.CipherService;
import crypto.assymmetry.RSACipherService;
import crypto.symmetry.AESCipherService;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class TestCommunicate {
    public static void main(String[] args) throws UnsupportedEncodingException {

        CipherService aesCipherService = new AESCipherService();
        String plaintextTerence = "testdatatestdata";
        String aesKeyTerence = "simpleKeyCaseabc";
        String encryptText = aesCipherService.encrypt(plaintextTerence, aesKeyTerence);

        System.out.println("Terence: aseKey = " + aesKeyTerence + "\n");
        System.out.println("Terence: plaintext = " + plaintextTerence);

        String encryptedText = aesCipherService.encrypt(plaintextTerence, aesKeyTerence);
        System.out.println("Terence: encryptedText = " + encryptedText);

        byte[] bytes = aesKeyTerence.getBytes(StandardCharsets.UTF_8);
    /*    StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append(bytes[i]);
        }
        String string = stringBuilder.toString();
        System.out.println(string);*/

        BigInteger bigInteger = new BigInteger(bytes);
        System.out.println("Terence: aesKeyBytes = " + bigInteger);

        RSACipherService rsaCipherServiceTerence = new RSACipherService(2 << 10);
        System.out.println("Terence: public key = " + rsaCipherServiceTerence.getPublicKey());
        System.out.println("Terence: private key = " + rsaCipherServiceTerence.getPrivateKey());
        System.out.println("Terence: modulus = " + rsaCipherServiceTerence.getModulus() + "\n");

        RSACipherService rsaCipherServiceStark = new RSACipherService(2 << 10);
        System.out.println("Stark: public key = " + rsaCipherServiceStark.getPublicKey());
        System.out.println("Stark: private key = " + rsaCipherServiceStark.getPrivateKey());
        System.out.println("Stark: modulus = " + rsaCipherServiceStark.getModulus() + "\n");

        BigInteger encrypt1 = rsaCipherServiceTerence.privateKey(bigInteger);
        System.out.println("Terence: encrypt using Terence's private key = " + encrypt1);
        BigInteger encrypt2 = rsaCipherServiceStark.publicKey(encrypt1);
        System.out.println("Terence: encrypt using Stark's public key = " + encrypt2);

        BigInteger encrypt3 = rsaCipherServiceStark.privateKey(encrypt2);
        System.out.println("Terence: decrypt using Stark's private key = " + encrypt3);
        BigInteger encrypt4 = rsaCipherServiceTerence.publicKey(encrypt3);
        System.out.println("Terence: decrypt using Terence's public key = " + encrypt4);

        byte[] bytes1 = encrypt4.toByteArray();
        String aesKeyStark = new String(bytes1);
        System.out.println("Stark: aesKeyStark = " + aesKeyStark);

        String decryptTest = aesCipherService.decrypt(encryptText, aesKeyStark);
        System.out.println("decryptTest = " + decryptTest);
    }
}
