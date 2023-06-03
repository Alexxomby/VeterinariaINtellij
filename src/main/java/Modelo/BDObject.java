package Modelo;
/**
 *
 * @author Alexxomby
 */
public class BDObject {

    private int id = -1;

    public BDObject() {
    }

    public BDObject(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
