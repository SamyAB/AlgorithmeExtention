package dz.oooo.rc;

import java.util.ArrayList;

public class Monde {
	private ArrayList<FormuleCNF> formules;
	
	public Monde(){
		this.formules=new ArrayList<FormuleCNF>();
	}
	public Monde(ArrayList<FormuleCNF> formules){
		this.formules=formules;
	}
	public Monde(short a){
		this();
		this.formules.add(new FormuleCNF(a));
	}
	
	public void setFormule(ArrayList<FormuleCNF> formules){
		this.formules=formules;
	}
	public ArrayList<FormuleCNF> getFormules(){
		return this.formules;
	}
	public void addFormule(FormuleCNF f){
		this.formules.add(f);
	}
}
