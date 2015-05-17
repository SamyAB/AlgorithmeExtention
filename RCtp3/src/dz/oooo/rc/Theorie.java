package dz.oooo.rc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
	
	public Theorie(String nomFichier){
		this();
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(nomFichier)));
			String ligne=null;
			while((ligne=br.readLine())!=null){
				if(ligne.charAt(0)=='m'){
					String[] clauses=ligne.split(";");
					FormuleCNF f=new FormuleCNF();
					for(int i=1;i<clauses.length;i++){
						f.addClause(new Clause(clauses[i]));
					}
					this.monde.addFormule(f);
				}
				else if(ligne.charAt(0)=='d'){
					String[] parties=ligne.split(":");
					
					String[] prerquis=parties[1].split(";");
					FormuleCNF p=new FormuleCNF();
					for(int i=0;i<prerquis.length;i++){
						p.addClause(new Clause(prerquis[i]));
					}
					
					String[] parties2=parties[2].split("/");
					String[] justificatif=parties2[0].split(";");
					FormuleCNF j=new FormuleCNF();
					for(int i=0;i<justificatif.length;i++){
						j.addClause(new Clause(justificatif[i]));
					}
					
					String[] consequent=parties2[1].split(";");
					FormuleCNF c=new FormuleCNF();
					for(int i=0;i<consequent.length;i++){
						c.addClause(new Clause(consequent[i]));
					}
					
					Defaut d=new Defaut(p, j, c);
					this.defauts.add(d);
				}
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
