package models;

/**
 * Created by DANIEL on 03/02/2015.
 */
import play.mvc.*;
import play.db.*;
import play.db.ebean.*;
import play.data.validation.*;
import play.data.format.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;


@Entity
public class Zapato extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id_zapato;

    @NotNull
    @Size(max=100)
    public String modelo;

    @NotNull
    @Size(max=10)
    public String talla;

    public static Model.Finder<Long, Zapato> find = new Model.Finder<Long,Zapato>(Long.class, Zapato.class);

    // Para usar en select list
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Zapato z: Zapato.find.orderBy("modelo").findList()) {
            options.put(z.id_zapato.toString(), z.modelo);
        }
        return options;
    }

}
