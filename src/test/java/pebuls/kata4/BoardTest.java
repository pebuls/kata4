package pebuls.kata4;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void aSingleCellShouldHaveZeroNeighbours() throws Exception  {

        Board board = new Board();
        board.addCell(new Cell(0, 0));

        List<Cell> neighbors = board.getNeighbors(new Cell(0, 0));

        assertEquals(0, neighbors.size());
    }

    @Test
    public void twoCellsNextToEachOtherShouldBeNeighbors() throws Exception  {

        Cell first = new Cell(0, 0);
        Cell second = new Cell(0, 1);

        Board board = new Board();
        board.addCell(first);
        board.addCell(second);

        List<Cell> neighborsOfFirstCell = board.getNeighbors(first);
        List<Cell> neighborsOfSecondCell = board.getNeighbors(second);

        assertArrayEquals(new Cell[] {second}, neighborsOfFirstCell.toArray());
        assertArrayEquals(new Cell[] {first}, neighborsOfSecondCell.toArray());
    }


    @Test
    public void aTwoSingleCellsFarFromEachOtherShouldHaveZeroNeighbors() throws Exception  {

        Board board = new Board();
        board.addCell(new Cell(0, 0));
        board.addCell(new Cell(0, 100));

        List<Cell> neighbors = board.getNeighbors(new Cell(0, 0));

        assertEquals(0, neighbors.size());
    }

    @Test
    public void middleCellOf3x3BlockShouldHaveEightNeighbors() throws Exception {

        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.addCell(new Cell(i, j));
            }
        }

        List<Cell> neighbors = board.getNeighbors(new Cell(1, 1));

        assertEquals(8, neighbors.size());
    }
}
