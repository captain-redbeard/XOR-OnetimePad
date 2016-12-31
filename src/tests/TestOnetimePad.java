package tests;

import com.captainredbeard.xor.OnetimePad;

import java.util.Arrays;

/**
 * @author captain-redbeard
 * @version 1.00
 * @since 31/12/16
 */
public class TestOnetimePad {

    public static void main(String[] args) {
        String message = "Testing the implementation. " +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ " +
                "abcdefghijklmnopqrstuvwxyz " +
                "0123456789 " +
                "`~!@#$%^&*()-_=+[{]}\\|/?.>,<";

        OnetimePad onetimePad = new OnetimePad();

        final byte[] secret = message.getBytes();
        final char[] pad = onetimePad.generate(secret.length);
        final byte[] encoded = onetimePad.encode(secret, pad);
        final byte[] decoded = onetimePad.decode(encoded, pad);

        System.out.println("Secret: " + message);
        System.out.println("Pad size: " + pad.length);
        System.out.println("Secret size: " + secret.length);
        System.out.println("Pad: " + new String(pad));
        System.out.println("Encoded: " + new String(encoded));
        System.out.println("Decoded: " + new String(decoded));
        System.out.println("Secret == decoded: " + Arrays.equals(secret, decoded));
    }
}
