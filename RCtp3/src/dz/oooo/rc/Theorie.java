package dz.oooo.rc;

import java.util.ArrayList;

public class Theorie {
	private Monde monde;
	private ArrayList<Defaut> defauts;
	
	public Theorie(){
		this.monde=new Monde();
		this.defauts=new ArrayList<Defaut>();
	}
	public Theorie(Monde monde,Defaut defaut){
		this.monde=monde;
		this.defauts=new ArrayList<Defaut>();
		this.defauts.add(defaut);
	}

	public Monde getMonde(){
		return monde;
	}

	public void setMonde(Monde monde) {
		this.monde = monde;
	}

	public ArrayList<Defaut> getDefauts() {
		return defauts;
	}

	public void setDefauts(ArrayList<Defaut> defauts) {
		this.defauts = defauts;
	}
	
	
}
