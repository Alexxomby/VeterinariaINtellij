
package data_acces_bd;

import Modelo.Perro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MascotaDAO {

    private Connection connection;

    private PreparedStatement insertStatement,updateStatement,
            selectAllStatement, selectByIdStatement;

    private final String insertQuery =
            "INSERT INTO mascotas (propietario_id, raza_id, "
                    + "nacimiento, nombre, imagen, tamano, sexo, peso) "
                    +"VALUES (?,?,?,?,?,?,?,?)";

    private final String updateQuery =
            "UPDATE mascotas SET propietario_id = ?, raza_id = ?, "
                    + "nacimiento = ?, nombre = ?, imagen = ?, tamano = ?, "
                    + "sexo = ?, peso = ? where id= ? ";

    private final String selectAllQuery =
            "SELECT * FROM mascotas";

    private final String selectByIdQuery =
            "SELECT  * FROM mascotas where id =?";

    public MascotaDAO(Connection connection) {
        this.connection = connection;


        try{
            this.insertStatement =
                    this.connection.prepareStatement(
                            this.insertQuery,
                            Statement.RETURN_GENERATED_KEYS);

            this.updateStatement =
                    this.connection.prepareStatement(this.updateQuery);

            this.selectAllStatement =
                    this.connection.prepareStatement(this.selectAllQuery);

            this.selectByIdStatement =
                    this.connection.prepareStatement(this.selectByIdQuery);



        }catch(Exception e){

            System.out.println("Error en el crud");
            System.out.println("Error : " + e.getMessage());
        }

    }

    public Perro save(Perro perro)throws Exception{
        if (perro.getId()==-1){
            //Pues que sse inserte
            this.insertStatement.setInt(1, perro.getPropietario_id());
            this.insertStatement.setInt(2, perro.getRaza_id());
            this.insertStatement.setTimestamp(3, perro.getNacimiento());
            this.insertStatement.setString(4, perro.getNombre());
            this.insertStatement.setBlob(5, perro.getImagen());
            this.insertStatement.setInt(6, perro.getTamano());
            this.insertStatement.setString(7, perro.getSexo());
            this.insertStatement.setInt(8, perro.getPeso());

            int idPerro = this.insertStatement.executeUpdate();
            perro.setId(idPerro);

            return perro;
        }else{
            //La logica es si es perro ya tiene un id no lo va acrear
            //lo va a traer
            this.updateStatement.setInt(1, perro.getPropietario_id());
            this.updateStatement.setInt(2, perro.getRaza_id());
            this.updateStatement.setTimestamp(3, perro.getNacimiento());
            this.updateStatement.setString(4, perro.getNombre());
            this.updateStatement.setBlob(5, perro.getImagen());
            this.updateStatement.setInt(6, perro.getTamano());
            this.updateStatement.setString(7, perro.getSexo());
            this.updateStatement.setInt(8, perro.getPeso());

            this.updateStatement.executeUpdate();

            return perro;
        }
    }

    //Consulta general

    public List<Perro>getAll() throws Exception{
        List<Perro> perroLista = new ArrayList<>();

        ResultSet rs = this.selectAllStatement.executeQuery();

        while (rs.next()){
            Perro perro = new Perro (
                    rs.getInt("id"),
                    rs.getInt("propietario_id"),
                    rs.getInt("raza_id"),
                    rs.getTimestamp("nacimineto"),
                    rs.getString("nombre"),
                    rs.getBlob("imagen"),
                    rs.getInt("tamano"),
                    rs.getInt("peso"),
                    rs.getString("sexo")

            );
            perroLista.add(perro);
        }
        return perroLista;
    }

    public Perro getbyId(int idMascota) throws Exception{

        this.selectByIdStatement.setInt(1, idMascota);


        ResultSet rs = this.selectByIdStatement.executeQuery();

        if (rs.next()) {
            Perro perro =  new Perro(
                    rs.getInt("id"),
                    rs.getInt("propietario_id"),
                    rs.getInt("raza_id"),
                    rs.getTimestamp("nacimiento"),
                    rs.getString("nombre"),
                    rs.getBlob("imagen"),
                    rs.getInt("tamano"),
                    rs.getInt("peso"),
                    rs.getString("sexo")
            );

            return perro;
        }
        return null;
    }

}
