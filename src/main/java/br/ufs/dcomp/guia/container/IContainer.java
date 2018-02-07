package br.ufs.dcomp.guia.container;

import java.util.List;

public interface IContainer {
	public List<Content> getChilds();
	public void setChilds(List<Content> childs);
}