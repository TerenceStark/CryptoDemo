package test;

import crypto.CipherService;
import crypto.symmetry.AESCipherService;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class AESTest {

    @Test
    public void testAES() throws UnsupportedEncodingException {
        //128bits text and 128bits key
        String plaintext = "passwordTextCase", key = "simpleKeyCase123";
        CipherService aesCipherService = new AESCipherService();

        String encryptedText = aesCipherService.encrypt(plaintext, key);
        System.out.println(encryptedText);
//        aesCipherService.decrypt(encryptedText, key);
    }

}
