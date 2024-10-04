import components.map.Map;
import components.map.Map1L;

/**
 * Cell time.
 *
 * @author Elliott Simpson
 */
public final class Cell {

    /**
     * the map for relational data.
     */
    private Map relation;

    /**
     * the data stored in the cell node.
     */
    private T data;

    /**
     * does thing.
     */
    public Cell(T data) {
        this.data = data;
        this.creatRep();
    }

    /**
     * Blank instantiation of cell.
     */
    private void creatRep() {
        this.relation = new Map1L<T, Cell>();
    }

    // Kernel Methods

    /**
     * Checks that there are things related to this node.
     *
     * @return true if stuff in relation map, false if nothing
     */
    public boolean hasRelation() {
        return this.relation.size() > 0;
    }

    /**
     * Adds this cell to the relation map.
     *
     * @param item
     *            an existing cell that needs to be added to the relation.
     */
    public void addCell(Cell item) {
        this.relation.add(item.getData(), item);
    }

    /**
     * Removes a specific cell from the relation map if it exists.
     *
     * @param item
     *            the cell to remove
     */
    public void removeCell(Cell item) {
        this.relation.remove(item.getData());
    }

    /**
     * returns the map of relations. Might make this returned value immutable if possible so it doesn't mess with all other cells.
     */
    public Map getCells(){
        return this.relation;
    }

    /**
     * Just returns the data stored in the cell.
     *
     * @return the data in the cell.
     */
    public T getData() {
        return this.data;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Cell a = new Cell("a");
        Cell ab = new Cell("ab");
        a.addCell(ab);

        if (!ab.hasRelation()){
            ab.addCell(new Cell("abc"));
        }

        a.add(new Cell("ad"));
        a.remove(new Cell("ad"));

        System.out.println(a.hasRelation());

       //I didn't make the secondary methods because I felt like it would be best to leave that for a abstract class like we do in our convention. In the case for this design, if I were to implement the secondary method next cell, this would just return like the first thing that the map pulls from random or if I were to implement or sell, I would basically take that map that it provides me by doing cell.get map and then do some data calculation on that map.
    }
}
