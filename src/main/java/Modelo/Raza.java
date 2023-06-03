
package Modelo;

/**
 *
 * @author user
 */
public class Raza extends BDObject{

    private String nombre;

    public Raza(){

    }

    public Raza(String nombre) {
        super();
        this.nombre = nombre;
    }

    public Raza( int id,String nombre) {
        super(id);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
