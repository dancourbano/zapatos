package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.Zapatos.index;
import views.html.Zapatos.create;
import views.html.Zapatos.edit;

import models.*;

public class Zapatos extends Controller {

    public static Result index() {
        return ok(index.render(Zapato.find.all()));
    }

    // GET, formulario para un nuevo registro
    public static Result create() {
        Form<Zapato> formulario= form(Zapato.class);

        return ok(create.render(formulario));
    }

    // POST, se guarda el formaulario
    public static Result save() {

        //String name=request().body().asFormUrlEncoded().get("nombre").toString();
        //System.out.println(name);

        Form<Zapato> formulario = form(Zapato.class).bindFromRequest();

        if(formulario.hasErrors()) {
            return badRequest(create.render(formulario));
        }

        formulario.get().save();
        //formulario_usuario.get().save();
        //flash("success", "Tipo de Usuario " + formulario.get().nombre + " creado con exito!");
        return redirect("/zapatos/index");
    }

    /* GET, editar el registro ¨*/
    public static Result edit(Long id) {
        Form<Zapato> formulario = form(Zapato.class).fill(Zapato.find.byId(id));
        return ok(edit.render(id, formulario));
    }

    // POST, guardar el registro editado
    public static Result update(Long id) {
        Form<Zapato> formulario = form(Zapato.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(edit.render(id, formulario));
        }
        formulario.get().update(id);
        flash("success", "Zapato " + formulario.get().modelo+ " actualizado con exito!");
        return redirect("/zapatos/index");
    }

    // POST, elimina registro
    public static Result delete(Long id) {
        Zapato.find.ref(id).delete();
        flash("success", "/zapatos/index");
        return redirect("/zapatos/index");
    }

}