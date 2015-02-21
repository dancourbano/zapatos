package models;

/**
 * Created by DANIEL on 13/01/2015.
 */

import java.util.*;
import javax.persistence.*;
import javax.swing.text.html.HTML;
import javax.validation.constraints.*;

//import com.avaje.ebean.validation.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Cliente extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id_cliente;

    @NotNull
    @Size(max=30)
    public String nombre;

    @NotNull
    @Size(max=50)
    public String apellido;

    @NotNull
    @Size(max=120)
    public String direccion;
    @Size(max=1)
    public String estado;
    @Size(max=20)
    public String telefono;
    @Constraints.Email
    public String email;

    @Constraints.Required(message="Debe ingresar el tipo de usuario")
    @OneToOne(cascade=CascadeType.ALL)
    public Usuario usuario;

    public Usuario getUsuario(Long id_usuario) {
        return Usuario.find.where().idEq(id_usuario).findUnique();
    }

    public static Model.Finder<Long, Cliente> find = new Model.Finder <Long,Cliente> (Long.class, Cliente.class);

    // Para usar en select list
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Cliente c: Cliente.find.orderBy("nombre").findList()) {
            options.put(c.id_cliente.toString(), c.nombre);
        }
        return options;
    }

    public String getEstado(String estado){
        if(estado.equals("1")){
            return "<span class='label label-success'>Activo</span>";
        }
        else return "<span class='label label-important'>Inactivo</span>";
    }






}
