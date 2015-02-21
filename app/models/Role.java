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
public class Role extends Model{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;


    @NotNull
    @Size(max=30)
    public String rol;

    public static Model.Finder<Long,Role> find = new Model.Finder<Long,Role>(Long.class, Role.class);

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Role r: Role.find.orderBy("rol").findList()) {
            options.put(r.id.toString(), r.rol);
        }
        return options;
    }

}
