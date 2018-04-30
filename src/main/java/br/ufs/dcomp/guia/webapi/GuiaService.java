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
import br.ufs.dcomp.guia.model.Guia;
import java.util.List;

@Path("guia")
public class GuiaService {
    IDataAccess dataAccess;

    @PostConstruct
    private void init() {
        this.dataAccess = FacadeDataAccess.getInstance();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Guia get(@DefaultValue("-1") @QueryParam("id") Integer id) {
        return this.dataAccess.readGuia(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String post(Guia guia) {
        return this.dataAccess.createGuia(guia) ? "ok" : "error";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String put(Guia guia) {
        return this.dataAccess.updateGuia(guia) ? "ok" : "error";
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@DefaultValue("-1") @QueryParam("id") Integer id) {
        return this.dataAccess.deleteGuia(id) ? "ok" : "error";
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guia> getAll() {
        return this.dataAccess.readAllGuia();
    }

    @GET
    @Path("childsOf")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Guia> getChildsOf(@DefaultValue("-1") @QueryParam("idpai") Integer idpai) {
        return this.dataAccess.readChildsOf(idpai);
    }    
}
