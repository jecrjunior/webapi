package br.ufs.dcomp.guia.dataaccess;

import br.ufs.dcomp.guia.model.*;
import br.ufs.dcomp.guia.model.usuario.Experiencia;
import br.ufs.dcomp.guia.model.usuario.Formacao;
import br.ufs.dcomp.guia.model.usuario.Setor;
import br.ufs.dcomp.guia.model.usuario.Tipo;
import br.ufs.dcomp.guia.model.usuario.Usuario;
import br.ufs.dcomp.guia.model.usuario.Vinculo;
import java.util.List;

public interface IDataAccess {
    public boolean createGuia(Guia guia);
    public Guia readGuia(Integer id);
    public List<Guia> readAllGuia();
    public List<Guia> readChildsOf(Integer idPai);    
    public boolean updateGuia(Guia guia);
    public boolean deleteGuia(Integer id);

    public boolean createItemGuia(ItemGuia itemGuia);
    public ItemGuia readItemGuia(Integer id);
    public List<ItemGuia> readAllItemGuia();
    public boolean updateItemGuia(ItemGuia itemGuia);
    public boolean deleteItemGuia(Integer id);

    public boolean createUsuario(Usuario usuario);
    public Usuario readUsuario(Integer id);
    public Usuario readUsuario(String email, String senha);
    public List<Usuario> readAllUsuario();
    public boolean updateUsuario(Usuario usuario);
    public boolean deleteUsuario(Integer id);
    public List<Experiencia> readAllExperiencia();
    public List<Formacao> readAllFormacao();
    public List<Setor> readAllSetor();
    public List<Tipo> readAllTipo();
    public List<Vinculo> readAllVinculo();


    public boolean createAcesso(Acesso acesso);
    public Acesso readAcesso(Integer acesso);
    public List<Acesso> readAllAcesso();
    public boolean updateAcesso(Acesso acesso);
    public boolean deleteAcesso(Integer acesso);
}