package blockchain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfBlocksNeeded = 5;
        int prefixLength = sc.nextInt();
        BlockChain blockChain = new BlockChain(prefixLength);
        blockChain.createBlock(numberOfBlocksNeeded);
        blockChain.printBlocks();
    }
}
