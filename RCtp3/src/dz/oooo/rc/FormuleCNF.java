package dz.oooo.rc;

import java.util.ArrayList;
import java.util.Iterator;

public class FormuleCNF {
	private ArrayList<Clause> clauses;
	
	public FormuleCNF(){
		this.clauses=new ArrayList<Clause>();
	}
	public FormuleCNF(short a){
		this();
		this.clauses.add(new Clause(a));
	}

	public ArrayList<Clause> getClauses() {
		return clauses;
	}
	public void setClauses(ArrayList<Clause> clauses) {
		this.clauses = clauses;
	}
	public void addClause(Clause c){
		this.clauses.add(c);
	}
	
	public FormuleCNF negation(){
		FormuleCNF n=new FormuleCNF();
		String s="";
		Iterator<Clause> clauses=this.clauses.iterator();
		while(clauses.hasNext()){
			Clause tmpClause=clauses.next();
			Iterator<Short> litteraux=tmpClause.getLitteraux().iterator();
			s+=String.valueOf((-1)*litteraux.next());
			while(litteraux.hasNext()){
				s+="OR"+(-1*litteraux.next());
			}
			s+="AND";
		}
		s=s.substring(0,s.length()-3);
		s=s.replaceAll("AND", "OU");
		s=s.replaceAll("OR", "AND");
		s=s.replaceAll("OU", "OR");
		String[] chainesClauses=s.split("AND");
		for(int i=0;i<chainesClauses.length;i++){
			String[] chainesLitteraux=chainesClauses[i].split("OR");
			Clause tmpClause=new Clause();
			for(int j=0;j<chainesLitteraux.length;j++){
				tmpClause.addLitteral(Short.parseShort(chainesLitteraux[j]));
			}
			n.addClause(tmpClause);
		}
		return n;
	}
	
	public String toString(){
		String s="";
		Iterator<Clause> clausesIterator=this.clauses.iterator();
		while(clausesIterator.hasNext()){
			s+=clausesIterator.next().toString()+"\n";
		}
		return s;
	}
	
	public boolean equals(FormuleCNF f){
		if(f==null || f.getClauses().size()!=this.clauses.size()){
			return false;
		}
		Iterator<Clause> clausesIterator=f.getClauses().iterator();
		while(clausesIterator.hasNext()){
			if(!this.clauses.contains(clausesIterator.next())){
				return false;
			}
		}
		return true;
	}
	
	public boolean equals(Object o){
		FormuleCNF f=(FormuleCNF) o;
		return this.equals(f);
	}
	
}
