package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import views.html.Clientes.*;

import models.*;

public class Clientes extends Controller {

    public static Result index() {
        return ok(index.render(Cliente.find.all()));
    }

    // GET, formulario para un nuevo registro
    public static Result create() {
        Form<Cliente> formulario_cliente = form(Cliente.class);
        Form<Usuario> formulario_usuario = form(Usuario.class);
        return ok(create.render(formulario_cliente,formulario_usuario));
    }

    // POST, se guarda el formaulario
    public static Result save() {

        String name=request().body().asFormUrlEncoded().get("nombre").toString();
        System.out.println(name);

        Form<Cliente> formulario_cliente = form(Cliente.class).bindFromRequest();
        Form<Usuario> formulario_usuario =form(Usuario.class).bindFromRequest();
        if(formulario_cliente.hasErrors() && formulario_usuario.hasErrors()) {
            return badRequest(create.render(formulario_cliente,formulario_usuario));
        }

        formulario_cliente.get().save();
        //formulario_usuario.get().save();
        //flash("success", "Tipo de Usuario " + formulario.get().nombre + " creado con exito!");
        return redirect("/clientes/index");
    }

    // GET, editar el registro
    public static Result edit(Long id) {
        Form<Cliente> formulario = form(Cliente.class).fill(Cliente.find.byId(id));
        return ok(edit.render(id, formulario));
    }

    // POST, guardar el registro editado
    public static Result update(Long id) {
        Form<Cliente> formulario = form(Cliente.class).bindFromRequest();
        if(formulario.hasErrors()) {
            return badRequest(edit.render(id, formulario));
        }
        formulario.get().update(id);
        flash("success", "Tipo de Usuario " + formulario.get().nombre + " actualizado con exito!");
        return redirect("/clientes/index");
    }

    // POST, elimina registro
    public static Result delete(Long id) {
        Cliente.find.ref(id).delete();
        flash("success", "Cliente ha sido eliminado!");
        return redirect("/clientes/index");
    }

}