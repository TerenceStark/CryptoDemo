package test;

import crypto.assymmetry.RC4CipherService;

import java.io.UnsupportedEncodingException;

public class RC4Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        RC4CipherService rc4CipherService = new RC4CipherService();
        String encryptedText = rc4CipherService.encrypt("testdatatestdatatestdatatestdata", "testkeytestkeytestkeytestkey");
        System.out.println(encryptedText);

        String decryptedText =rc4CipherService.decrypt(encryptedText,"testkeytestkeytestkeytestkey");
        System.out.println(decryptedText);
    }
}
