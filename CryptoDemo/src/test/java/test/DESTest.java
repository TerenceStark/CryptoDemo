package test;

import crypto.symmetry.DESCipherService;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

public class DESTest {

    @Test
    public void testDES() throws UnsupportedEncodingException {
        String plaintext = "123456789";
        String key = "eqDWAD21escipherServicewe214551fcQDW";
        DESCipherService descipherService = new DESCipherService(true);
        descipherService.setWorkingMode("ECB");
        String encrypt = descipherService.encrypt(plaintext, key);

        String decrypt = descipherService.decrypt(encrypt, key);
    }
}