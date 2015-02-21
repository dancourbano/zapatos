
package controllers;


/**
 * Created by DANIEL on 15/01/2015.
 */

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Usuarios.index;
import views.html.Usuarios.create;
import models.*;

/**
 * Created by DANIEL on 15/01/2015.
 */


public class Usuarios extends Controller {

    public static Result index() {
        return ok(index.render(Usuario.find.all()));
    }

    public static Result create() {
        Form<Usuario> formulario = form(Usuario.class);
        return ok(create.render(formulario));
    }

    public static Result save() {
        Form<Usuario> formulario = form(Usuario.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(create.render(formulario));
        }

        formulario.get().save();
        flash("success", "Usuario " + formulario.get().usuario + " creado con exito!");
        return redirect("/usuarios/index");
    }
}