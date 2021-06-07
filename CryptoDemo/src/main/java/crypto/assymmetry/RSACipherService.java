package crypto.assymmetry;

import lombok.Data;
import lombok.ToString;

import java.math.BigInteger;
import java.security.SecureRandom;

@Data
@ToString
public class RSACipherService {

    private final static BigInteger one = new BigInteger("1");
    private final static SecureRandom secureRandom = new SecureRandom();

    private final BigInteger privateKey;
    private final BigInteger publicKey;
    private final BigInteger modulus;

    /**
     * 密钥生成:
     * 1.选择两个大素数p,q。（例如:每个1024位)2．计算n = pq, phi=(p - 1)(q- 1)。
     * 3.随机选取e(其中e <n)，e与phi没有公因数。(e,phi 互为质数)
     * 4.选取d.使得ed-1能够被phi完全整除。(ed mod phi=1)
     * 5.公钥是(n, e)。私钥是(n,d)。
     */
    public RSACipherService(int N) {
        BigInteger p = BigInteger.probablePrime(N / 2, secureRandom);
        BigInteger q = BigInteger.probablePrime(N / 2, secureRandom);

        BigInteger phi = (p.subtract(one)).multiply((q.subtract(one)));

        modulus = p.multiply(q);

        publicKey = BigInteger.valueOf(65537);
        //modInverse(BigInteger m) Returns a BigInteger whose value is (this^-1 mod m).
        privateKey = publicKey.modInverse(phi);
    }

    public BigInteger publicKey(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    public BigInteger privateKey(BigInteger encrypted) {
        return encrypted.modPow(privateKey, modulus);
    }

}
