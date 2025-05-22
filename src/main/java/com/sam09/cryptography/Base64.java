package com.sam09.cryptography;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * This Base64 class provides the functionality to encode/decode a byte array to/from a Base64 String.<br>
 * This Base64 class does NOT follow the RFC 3548 or RFC 4648 specification of Base64 as the used charset can be specified
 * and no padding characters are used.<br>
 * So only the characters provided by the user by calling the {@link #init(String)} will appear in the encoded String and no other characters
 * like equal signs '=' (sometimes used for padding in Base64) will appear.
 *
 *
 * @author Soumyabrata09
 *
 */

public class Base64 {
    private static final Logger Log = LoggerFactory.getLogger(Base64.class);

    private String base64Charset;
    private char[] base64Characters;
    private Map<Character,Integer> positionMap;

    public Base64(){
        Log.info("Standard Alphabet : " + CryptographyConstants.STANDARD_ALPHABET);
        init(CryptographyConstants.STANDARD_ALPHABET);
    }

    /**
     * The base64Charset must be a String containing exactly 64 distinct characters.<br>
     * If it does not a {@link CryptographyConstants} is thrown.
     * @param charSet
     */
    private void init(String charSet){
        if(charSet.length() != CryptographyConstants.BASE){
            Log.info("Standard Alphabet : " + CryptographyConstants.STANDARD_ALPHABET + " Base " + CryptographyConstants.BASE);
            throw new CryptographyException("The character set should be of base 64");
        }
        this.base64Charset = charSet;
        base64Characters = charSet.toCharArray();
        this.positionMap = new HashMap<Character,Integer>();
        IntStream.range(0, this.base64Characters.length)
                .forEach(i -> this.positionMap.put(this.base64Characters[i], i));

        if(CryptographyConstants.BASE != this.positionMap.size()){
           throw new CryptographyException("The charset must be 64 characters");
        }
    }

    public String encode(byte[] byteArray) throws UnsupportedEncodingException {
        StringBuffer buffer = new StringBuffer();

        int nextBit = 2;
        byte remainder = 0;

        for (int i = 0; i < byteArray.length; i++) {
            byte bit = byteArray[i];
            if (nextBit == 2) {
                bit = (byte) ((byteArray[i] >> 2) & 0x3f);
                remainder = (byte) ((byteArray[i] << (8 - 4)) & 0x3f);
            } else if (nextBit == 4) {
                bit = (byte) ((byteArray[i] >> 4) & 0x0f);
                bit = (byte) (bit | remainder);
                remainder = (byte) ((byteArray[i] << (8 - 6)) & 0x3f);
            } else if (nextBit == 6) {
                bit = (byte) ((byteArray[i] >> 6) & 0x03);
                bit = (byte) (bit | remainder);
                remainder = (byte) (byteArray[i] & 0x3f);
            } else if (nextBit == 0) {
                bit = remainder;
                remainder = 0;
            }
            nextBit = (nextBit + 2) % 8;
            if (nextBit == 0)
                i--;

            buffer.append(base64Characters[bit]);
        }

        if (remainder != 0) {
            buffer.append(base64Characters[remainder]);
        } else if (buffer.length() < (int) Math.ceil(byteArray.length * 8d / 6d)) {
            buffer.append(byteArray[0]);
        }

        return buffer.toString();
    }

    public byte[] decode(String encodedString) {
        byte[] decodedBytes = new byte[(int) Math.floor(encodedString.length() * 6d / 8d)];

        int missingBits = 2;
        int position = 0;
        for (int i = 0; i < decodedBytes.length; i++) {

            decodedBytes[i] = (byte) (int) positionMap.get(encodedString.charAt(position));
            decodedBytes[i] = (byte) (decodedBytes[i] << missingBits);
            byte b = (byte) (int) positionMap.get(encodedString.charAt(position + 1));
            b = (byte) (b >> (6 - missingBits));
            decodedBytes[i] = (byte) (decodedBytes[i] | b);

            missingBits = (missingBits + 2) % 8;
            if (missingBits == 0) {
                position++;
                missingBits += 2;
            }
            position++;
        }

        return decodedBytes;
    }

    public String getBase64Charset() {
        return base64Charset;
    }
}
