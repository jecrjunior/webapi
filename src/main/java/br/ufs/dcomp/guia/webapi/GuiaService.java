package br.ufs.dcomp.guia.webapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.ufs.dcomp.guia.dataaccess.DataModule;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
        String res = "";
        try {
            ResultSet r = DataModule.getInstance().executeQuery("SELECT * FROM public.tb_guia");
            ResultSetMetaData rsm = r.getMetaData();
            while (r.next()) {
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    String campo = "";
                    switch (rsm.getColumnType(i)) {
                    case 93: // Campos de data
                        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
    
                        if (r.getTimestamp(i) != null)
                            campo = fmt.format(r.getTimestamp(i));
                        
                        campo = String.format("%1$-" + 29 + "s", campo);
    
                        res += campo + "\t";
                        break;
                    default:
                        campo = r.getString(i);
                        int size = (rsm.getColumnDisplaySize(i) < 50) ? rsm.getColumnDisplaySize(i) : 50;
                        campo = String.format("%1$-" + size + "s", campo);
    
                        res += campo + "\t";
                    }
                }
                System.out.println();
            }
            } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return res;
    }
}
