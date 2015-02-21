package controllers;

/**
 * Created by DANIEL on 30/01/2015.
 */
import play.*;
import play.mvc.*;
import views.html.index;


public class Home extends Controller{
    public static Result index(){
        return ok(index.render());
    }

}
