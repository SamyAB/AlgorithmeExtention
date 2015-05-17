package dz.oooo.rc;

public class Defaut {
	private FormuleCNF prerquis;
	private FormuleCNF justificatif;
	private FormuleCNF consequent;
	private int id;
	
	public Defaut(FormuleCNF prerquis,FormuleCNF justificatif,FormuleCNF consequent,int id){
		this.prerquis=prerquis;
		this.justificatif=justificatif;
		this.consequent=consequent;
		this.id=id;
	}
	public Defaut(short prerequis,short justificatif,short consequent){
		this.prerquis=new FormuleCNF(prerequis);
		this.justificatif=new FormuleCNF(justificatif);
		this.consequent=new FormuleCNF(consequent);
	}

	public FormuleCNF getPrerquis() {
		return prerquis;
	}

	public void setPrerquis(FormuleCNF prerquis) {
		this.prerquis = prerquis;
	}

	public FormuleCNF getJustificatif() {
		return justificatif;
	}

	public void setJustificatif(FormuleCNF justificatif) {
		this.justificatif = justificatif;
	}

	public FormuleCNF getConsequent() {
		return consequent;
	}

	public void setConsequent(FormuleCNF consequent) {
		this.consequent = consequent;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id=id;
	}
}
