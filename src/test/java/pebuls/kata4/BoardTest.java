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

    @Test
    public void twoCellsNextToEachOtherShouldBeNeighbors() throws Exception  {

        Board board = new Board();
        board.addCell(new Cell(0,0));
        board.addCell(new Cell(0,1));

        List<Cell> neighbors = board.getNeighbors(new Cell(0,0));
        List<Cell> neighbors = board.getNeighbors(new Cell(0,1));

        ssertArrayEquals(new Cell[] { new Cell(0, 1) }, neighborsOfFirstCell.toArray());
        ssertArrayEquals(new Cell[] { new Cell(0, 0) }, neighborsOfFirstCell.toArray());
    }
}
