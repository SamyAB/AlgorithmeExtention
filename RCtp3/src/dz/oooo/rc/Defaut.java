package dz.oooo.rc;

public class Defaut {
	private FormuleCNF prerquis;
	private FormuleCNF justificatif;
	private FormuleCNF consequent;
	
	public Defaut(FormuleCNF prerquis,FormuleCNF justificatif,FormuleCNF consequent){
		this.prerquis=prerquis;
		this.justificatif=justificatif;
		this.consequent=consequent;
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
		
}
