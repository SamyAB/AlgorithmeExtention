package dz.oooo.rc;

import java.util.ArrayList;
import java.util.Iterator;

public class Clause {
	private ArrayList<Short> litteraux;
	
	public Clause(){
		this.litteraux=new ArrayList<Short>();
	}
	
	public Clause(short a){
		this();
		this.litteraux.add(a);
	}
	public Clause(short a,short b){
		this(a);
		this.litteraux.add(b);
	}
	public Clause(short a,short b,short c){
		this(a,b);
		this.litteraux.add(c);
	}
	public Clause(String clause){
		this();
		String[] litteraux=clause.split(",");
		for(int i=0;i<litteraux.length;i++){
			this.litteraux.add(Short.parseShort(litteraux[i]));
		}
	}
	
	public ArrayList<Short> getLitteraux(){
		return this.litteraux;
	}
	public void setLitteraux(ArrayList<Short> litteraux){
		this.litteraux=litteraux;
	}
	public void addLitteral(short l){
		this.litteraux.add(l);
	}
	
	public String toString(){
		String s="";
		Iterator<Short> litterauxIterator=this.litteraux.iterator();
		while(litterauxIterator.hasNext()){
			s+=litterauxIterator.next().toString()+" ";
		}
		return s;
	}
	
	public boolean equals(Clause c){
		if(c==null || c.getLitteraux().size()!=this.litteraux.size()){
			return false;
		}
		for(int i=0;i<this.litteraux.size();i++){
			if((short)(this.litteraux.get(i))!=(short)(c.getLitteraux().get(i))){
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Object o){
		Clause c=(Clause) o;
		return this.equals(c);
	}
	
	public Clause clone(){
		Clause c=new Clause();
		for(int i=0;i<this.litteraux.size();i++){
			c.addLitteral(this.litteraux.get(i));
		}
		return c;
	}
}
