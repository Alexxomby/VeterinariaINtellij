package Modelo;

/**
 *
 * @author user
 */
public class Documento extends BDObject{

    private int mascota_id;
    private String nombre;
    private String descripcion;
    private byte[] archivo;

    public Documento() {
    }

    public Documento(int mascota_id, String nombre, String descripcion, byte[] archivo) {
        super();
        this.mascota_id = mascota_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }


    public Documento(int mascota_id, String nombre, String descripcion, byte[] archivo, int id) {
        super(id);
        this.mascota_id = mascota_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.archivo = archivo;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public int getMascota_id() {
        return mascota_id;
    }

    public void setMascota_id(int mascota_id) {
        this.mascota_id = mascota_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
