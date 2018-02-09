package br.ufs.dcomp.guia.dataaccess;

import br.ufs.dcomp.guia.model.*;
import br.ufs.dcomp.guia.model.usuario.Usuario;
import java.util.List;

public interface IDataAccess {
    public boolean createGuia(Guia guia);
    public Guia readGuia(Integer id);
    public boolean updateGuia(Guia guia);
    public boolean deleteGuia(Integer id);

    public boolean createItemGuia(ItemGuia itemGuia);
    public ItemGuia readItemGuia(Integer id);
    public boolean updateItemGuia(ItemGuia itemGuia);
    public boolean deleteItemGuia(Integer id);

    public boolean createUsuario(Usuario usuario);
    public Usuario readUsuario(Integer id);
    public List<Usuario> readAllUsuario();
    public boolean updateUsuario(Usuario usuario);
    public boolean deleteUsuario(Integer id);


    public boolean createAcesso(Acesso acesso);
    public Acesso readAcesso(Integer acesso);
    public boolean updateAcesso(Acesso acesso);
    public boolean deleteAcesso(Integer acesso);
}