package models;

/**
 * Created by DANIEL on 10/01/2015.
 */
import java.util.*;
import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;
import javax.persistence.*;
import javax.validation.constraints.*;

//import com.avaje.ebean.validation.*;

import play.data.format.*;
import play.data.validation.*;

@Entity
public class Usuario extends Model {
    @Id
    public Long id_usuario;

    @Constraints.Required(message="debe ingresar usuario")
    @Size(max=30)
    public String usuario;

    @Constraints.Required(message="debe ingresar contraseña")
    public String password;




    // Generic query helper for entity with id Long
    public static Model.Finder<Long,Usuario> find = new Model.Finder<Long,Usuario>(Long.class, Usuario.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Usuario c: Usuario.find.orderBy("usuario").findList()) {
            options.put(c.id_usuario.toString(), c.usuario);
        }
        return options;
    }
}
