package models;

/**
 * Created by DANIEL on 10/02/2015.
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
public class Admin extends Model{
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

    @Constraints.Required
    public String usuario;
    @Constraints.Required
    public String contra;
    @Constraints.Required
    @ManyToOne
    public Role role;

    public Role getRole(Long id) {
        return Role.find.where().idEq(id).findUnique();
    }

    public static Model.Finder<Long, Admin> find = new Model.Finder <Long,Admin> (Long.class, Admin.class);

    public String getEstado(String estado){
        if(estado.equals("1")){
            return "<span class='label label-success'>Activo</span>";
        }
        else return "<span class='label label-important'>Inactivo</span>";
    }


}
