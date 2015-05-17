package dz.oooo.rc;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public Monde clone(){
		Monde m=new Monde();
		for(int i=0;i<formules.size();i++){
			m.formules.add(this.formules.get(i).clone());
		}
		return m;
	}
	
	public boolean coherent(){
		Iterator<FormuleCNF> formulesIterator=this.formules.iterator();
		while(formulesIterator.hasNext()){
			if(this.formules.contains(formulesIterator.next().negation())){
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Monde m){
		Iterator<FormuleCNF> mIterator=m.formules.iterator();
		while(mIterator.hasNext()){
			if(!this.formules.contains(mIterator.next())){
				return false;
			}
		}
		return true;
	}
	
	public String toString(){
		String s="";
		Iterator<FormuleCNF> fIterator=this.formules.iterator();
		while(fIterator.hasNext()){
			s+=fIterator.next().toString();
		}
		return s;
	}
}
