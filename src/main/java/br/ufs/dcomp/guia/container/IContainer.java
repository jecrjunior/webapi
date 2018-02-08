package br.ufs.dcomp.guia.container;

import java.util.List;

public interface IContainer {
	public List<Content> getChilds();
    public void setChilds(List<Content> childs);
    public IContentIterator getIterator();

	public String getTitle();
    public void setTitle(String title);
    public Integer getId();
    public void setId(Integer id);    
}