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
import br.ufs.dcomp.guia.model.ItemGuia;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("item_guia")
public class ItemGuiaService {
    IDataAccess dataAccess;

    @PostConstruct
    private void init() {
        this.dataAccess = FacadeDataAccess.getInstance();
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public ItemGuia get(@DefaultValue("-1") @QueryParam("id") Integer id) {
        return this.dataAccess.readItemGuia(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String post(ItemGuia itemGuia) {
        return this.dataAccess.createItemGuia(itemGuia) ? "ok" : "error";
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String put(ItemGuia itemGuia) {
        return this.dataAccess.createItemGuia(itemGuia) ? "ok" : "error";
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@DefaultValue("-1") @QueryParam("id") Integer id) {
        return this.dataAccess.deleteItemGuia(id) ? "ok" : "error";
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ItemGuia> getAll() {
        return this.dataAccess.readAllItemGuia();
    }
}
