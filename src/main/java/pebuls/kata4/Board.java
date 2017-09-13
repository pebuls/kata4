package pebuls.kata4;


import java.util.*;

public class Board {

    private Set<Cell> cells = new HashSet<>();

    public void addCell(Cell cell){
        cells.add(cell);
    }

    public Set<Cell> getNeighbors(Cell cell) {
        Set<Cell> neighbors = new HashSet<>();
        Set<Cell> neighborhood = getNeighborhood(cell);

        for (Cell c : neighborhood) {
            if (isAlive(c)) {
                neighbors.add(c);
            }
        }
        neighbors.remove(cell);

        return neighbors;
    }

    private Set<Cell> getNeighborhood(Cell cell) {
        Set<Cell> neighbors = new HashSet<>();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                Cell c = new Cell(cell.x + dx, cell.y + dy);
                if (isAlive(c) && !c.equals(cell)) {
                    neighbors.add(c);
                }
            }
        }

        return neighbors;
    }

    private boolean isAlive(Cell c) {
        return cells.contains(c);
    }
}
