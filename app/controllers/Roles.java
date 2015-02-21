package controllers;

/**
 * Created by DANIEL on 10/02/2015.
 */

import play.mvc.*;
import play.data.*;

import views.html.Admins.*;
import views.html.Admins.create2;
import views.html.Clientes.*;

import models.*;

public class Roles extends Controller{


    public static Result create() {
        Form<Role> formulario = form(Role.class);
        return ok(create2.render(formulario));
    }
    public static Result save() {
        Form<Role> formulario =form(Role.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(create2.render(formulario));
        }

        formulario.get().save();
        //formulario_usuario.get().save();
        //flash("success", "Tipo de Usuario " + formulario.get().nombre + " creado con exito!");
        return redirect("/admins/index");
    }
}
