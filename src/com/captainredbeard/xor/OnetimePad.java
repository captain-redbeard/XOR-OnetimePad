package com.captainredbeard.xor;

import java.security.SecureRandom;

/**
 * One-time pad implementation using random unicode characters.
 *
 * @author captain-redbeard
 * @version 1.00
 * @since 31/12/16
 */
public class OnetimePad {
    private SecureRandom random = new SecureRandom();

    /**
     * Generate a One-time pad.
     *
     * @param length - Pad length
     * @return
     */
    public char[] generate(int length) {
        char[] key = new char[length];

        for(int i = 0; i < length; i++) {
            key[i] = getRandUnicode();
        }

        return key;
    }

    /**
     * Get a VALID random unicode character.
     *
     * @return char
     */
    private char getRandUnicode() {
        char c;

        while(!Character.isDefined(c = getRandomUnicode()));

        return c;
    }

    /**
     * Get a random unicode character.
     * This character may or may not be invalid.
     *
     * @return char
     */
    private char getRandomUnicode() {
        return (char) (random.nextInt() & 0xFFFF);
    }

    /**
     * Encode the data by XORing the data to the pad.
     *
     * @param data - Data to be encoded
     * @param pad - Pad to use
     * @return byte[]
     */
    public byte[] encode(byte[] data, char[] pad) {
        final byte[] encoded = new byte[data.length];

        for (int i = 0; i < data.length; i++) {
            encoded[i] = (byte) (data[i] ^ pad[i]);
        }

        return encoded;
    }

    /**
     * Decode the data by XORing the encoded data to
     * the pad.
     *
     * @param encoded - Data to be decoded
     * @param pad - Pad to use
     * @return byte[]
     */
    public byte[] decode(byte[] encoded, char[] pad) {
        final byte[] decoded = new byte[encoded.length];

        for (int i = 0; i < encoded.length; i++) {
            decoded[i] = (byte) (encoded[i] ^ pad[i]);
        }

        return decoded;
    }

}
