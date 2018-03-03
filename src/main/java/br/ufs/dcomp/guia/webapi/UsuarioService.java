package br.ufs.dcomp.guia.webapi;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.ufs.dcomp.guia.dataaccess.FacadeDataAccess;
import br.ufs.dcomp.guia.dataaccess.IDataAccess;
import br.ufs.dcomp.guia.model.usuario.Usuario;
import java.util.List;

@Path("usuario")
public class UsuarioService {
    IDataAccess dataAccess;

    @PostConstruct
    private void init() {
        this.dataAccess = FacadeDataAccess.getInstance();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)     
    public Usuario get(@DefaultValue("-1") @QueryParam("id") Integer id) {
        return this.dataAccess.readUsuario(id);
    }


    @GET
    @Path("login")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)     
    public Usuario get(@DefaultValue("") @QueryParam("email") String email,
    @DefaultValue("") @QueryParam("senha") String senha) {
        return this.dataAccess.readUsuario(email, senha);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)        
    public String post(Usuario usuario) {
        return this.dataAccess.createUsuario(usuario) ? "ok" : "error";
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)        
    public String put(Usuario usuario) {
        return this.dataAccess.createUsuario(usuario) ? "ok" : "error";
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)    
    public String delete(@DefaultValue("-1") @QueryParam("id") Integer id) {
        return this.dataAccess.deleteUsuario(id) ? "ok" : "error";
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAll() {
        return this.dataAccess.readAllUsuario();
    }
}
