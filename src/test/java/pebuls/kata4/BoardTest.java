package pebuls.kata4;


import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BoardTest {

    @Test
    public void aSingleCellShouldHaveZeroNeighbours() throws Exception  {

        Board board = new Board();
        board.addCell(new Cell(0, 0));

        Set<Cell> neighbors = board.getNeighbors(new Cell(0, 0));

        assertEquals(0, neighbors.size());
    }

    @Test
    public void twoCellsNextToEachOtherShouldBeNeighbors() throws Exception  {

        Cell first = new Cell(0, 0);
        Cell second = new Cell(0, 1);

        Board board = new Board();
        board.addCell(first);
        board.addCell(second);

        Set<Cell> neighborsOfFirstCell = board.getNeighbors(first);
        Set<Cell> neighborsOfSecondCell = board.getNeighbors(second);

        assertArrayEquals(new Cell[] {second}, neighborsOfFirstCell.toArray());
        assertArrayEquals(new Cell[] {first}, neighborsOfSecondCell.toArray());
    }


    @Test
    public void aTwoSingleCellsFarFromEachOtherShouldHaveZeroNeighbors() throws Exception  {

        Board board = new Board();
        board.addCell(new Cell(0, 0));
        board.addCell(new Cell(0, 100));

        Set<Cell> neighbors = board.getNeighbors(new Cell(0, 0));

        assertEquals(0, neighbors.size());
    }

    @Test
    public void middleCellOf3x3BlockShouldHaveEightNeighbors() throws Exception {

        Board board = createBlockBoard(3, 3);

        Set<Cell> neighbors = board.getNeighbors(new Cell(1, 1));

        assertEquals(8, neighbors.size());
    }

    private Board createBlockBoard(int w, int h) {
        Board board = new Board();
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                board.addCell(new Cell(i, j));
            }
        }
        return board;
    }

}
