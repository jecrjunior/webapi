package br.ufs.dcomp.guia.webapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.ufs.dcomp.guia.dataaccess.FacadeDataAccess;
import br.ufs.dcomp.guia.dataaccess.IDataAccess;
import br.ufs.dcomp.guia.model.Guia;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("guia")
public class GuiaService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        IDataAccess dataAccess = FacadeDataAccess.getInstance();
        Guia guia = dataAccess.readGuia(1);
        return guia.getDescricao();
    }
}
