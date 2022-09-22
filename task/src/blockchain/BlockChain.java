package blockchain;

import java.util.*;

public class BlockChain {
    private Deque<Block> blockDeque = new ArrayDeque<>();

    public void addBlockToChain(Block block) {
        if (blockDeque.size() == 0) {
            block.setPreviousHash("0");
        } else {
            block.setPreviousHash(blockDeque.peek().getHash());//set it to the hash of the last element
        }
        blockDeque.push(block);
    }

    public void printBlocks() {
        Iterator<Block> blockIterator = blockDeque.descendingIterator();
        blockIterator.forEachRemaining(System.out::println);


    }
}
