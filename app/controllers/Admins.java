package controllers;

import play.*;
import play.mvc.*;
import play.data.*;



import models.*;
import views.html.Admins.create;
import views.html.Admins.index;
/**
 * Created by DANIEL on 10/02/2015.
 */
public class Admins extends Controller {

    public static Result index() {

        return ok(index.render(Admin.find.all()));
    }

    public static Result create() {
        Form<Admin> formulario = form(Admin.class);
        return ok(create.render(formulario));
    }
    public static Result save() {
        Form<Admin> formulario =form(Admin.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(create.render(formulario));
        }

        formulario.get().save();
        //formulario_usuario.get().save();
        //flash("success", "Tipo de Usuario " + formulario.get().nombre + " creado con exito!");
        return redirect("/admins/index");
    }
}
