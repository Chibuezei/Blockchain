package blockchain;

import java.security.MessageDigest;
import java.util.Date;


public class Block {

    private int id;
    private long timeStamp;
    private String previousHash;

    private String hash;
    private static int lastId;

    public Block() {
        this.timeStamp = new Date().getTime();
        this.hash = calculateBlockHash();
        this.id = ++lastId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return id + previousHash + timeStamp;
    }


    public long getTimeStamp() {
        return timeStamp;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Block:" + '\n' +
                "Id: " + id + '\n' +
                "Timestamp: " + timeStamp + '\n' +
                "Hash of the previous block: " + '\n' +
                previousHash + '\n' +
                "Hash of the block: " + '\n' +
                hash + '\n';
    }

    /*
    Block:
Id: 1
Timestamp: 1539810682545
Hash of the previous block:
0
Hash of the block:
     */
    private String calculateBlockHash() {
        return applySha256(this.toString());
    }

    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            /* Applies sha256 to our input */
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte elem : hash) {
                String hex = Integer.toHexString(0xff & elem);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
