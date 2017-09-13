package pebuls.kata4;


import org.junit.Test;

public class BoardTest {

    @Test
    public void aSingleCellShouldHaveZeroNeighbours() throws Exception  {

        Board board = new Board();
        board.addCell(new Cell(0,0));

        Set<Cell> neighbours = board.getNeighbours(newCell(0,0));

        assertEquals(0, neighbours.size());
    }
}
