package pebuls.kata4;


import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void aSingleCellShouldHaveZeroNeighbours() throws Exception  {

        Board board = new Board();
        board.addCell(new Cell());

        List<Cell> neighbors = board.getNeighbors(new Cell());

        assertEquals(0, neighbors.size());
    }
}
