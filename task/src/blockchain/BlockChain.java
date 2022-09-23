package blockchain;

import java.util.*;

public class BlockChain {
    private final int lengthOfPrefix;
    private Deque<Block> blockDeque = new ArrayDeque<>();

    public BlockChain(int lengthOfPrefix) {
        this.lengthOfPrefix = lengthOfPrefix;
    }

    public void addBlockToChain(Block block) {
        if (blockDeque.size() == 0) {
            block.setPreviousHash("0");
        } else {
            block.setPreviousHash(blockDeque.peek().getHash());//set it to the hash of the last element
        }
        blockDeque.push(block);
    }

    public void printBlocks() {
        Iterator<Block> blockIterator = blockDeque.descendingIterator();//iterate FIFO
        blockIterator.forEachRemaining(System.out::println);

    }
    public void createBlock(int numberOfBlocks){

        for (int i = 1; i<=numberOfBlocks;i++){
            addBlockToChain(new Block(lengthOfPrefix));
        }
    }

}
