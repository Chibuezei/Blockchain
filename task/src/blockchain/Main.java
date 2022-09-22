package blockchain;

public class Main {
    public static void main(String[] args) {
        Block block1 = new Block();
        Block block2 = new Block();
        Block block3 = new Block();
        Block block4 = new Block();
        Block block5 = new Block();
        BlockChain blockChain = new BlockChain();
        blockChain.addBlockToChain(block1);
        blockChain.addBlockToChain(block2);
        blockChain.addBlockToChain(block3);
        blockChain.addBlockToChain(block4);
        blockChain.addBlockToChain(block5);
        blockChain.printBlocks();
    }
}
