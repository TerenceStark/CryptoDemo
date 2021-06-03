package test;

import crypto.assymmetry.RC4CipherService;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;


public class RC4Test {
    @Test
    public void testRC4() throws UnsupportedEncodingException {
        RC4CipherService rc4CipherService = new RC4CipherService();
        String encryptedText = rc4CipherService.encrypt("testdatatestdatatestdatatestdata", "testkeytestkeytestkeytestkey");
        System.out.println(encryptedText);

        String decryptedText = rc4CipherService.decrypt(encryptedText, "testkeytestkeytestkeytestkey");
        System.out.println(decryptedText);
    }
}
