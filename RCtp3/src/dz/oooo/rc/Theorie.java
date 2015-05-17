package dz.oooo.rc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

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
					
					Defaut d=new Defaut(p, j, c,this.defauts.size());
					this.defauts.add(d);
				}
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
	
	public ArrayList<Monde> extension(ArrayList<Defaut> defauts,Monde e,Monde sigma){
		ArrayList<Monde> extensions=new ArrayList<Monde>();
		ArrayList<Defaut> nonTeste=new ArrayList<Defaut>();
		nonTeste.addAll(defauts);
		Iterator<Defaut> defautIterator=defauts.iterator();
		while(defautIterator.hasNext()){
			Defaut tmpDefaut=defautIterator.next();
			nonTeste.remove(tmpDefaut);
			if(sigma.getFormules().contains(tmpDefaut.getPrerquis())){
				System.out.println("Le prérquis du défaut "+tmpDefaut.getId()+" appartient à SigmaDelta(E), le défaut est donc utilisable");
				FormuleCNF negationDeJustificatif = tmpDefaut.getJustificatif().negation();
				if(e.getFormules().contains(negationDeJustificatif)){
					System.out.println("La négation du justificatif du défaut "+tmpDefaut.getId()+" appartient à E, le défaut n'est donc pas applicable");
				}
				else if(e.getFormules().contains(tmpDefaut.getJustificatif())){
					System.out.println("La négation du justificatif du défaut "+tmpDefaut.getId()+" n'appartient pas à E, le défaut est donc applicable");
					System.out.println("Le conséquent du défaut est ajouté à SigmaDelta(E)");
					sigma.addFormule(tmpDefaut.getConsequent());
					e.addFormule(tmpDefaut.getConsequent());
				}
				else{
					System.out.println("Nous ne savons pas si la négation du justificatif du défaut "+tmpDefaut.getId()+" appartient ou non à E");
					System.out.println("2 cas:");
					System.out.println("1er cas : la négation du justificatif du défaut appartient à E, le défaut et donc non applicable");
					Monde e1=e.clone();
					e1.addFormule(negationDeJustificatif);
					extensions.addAll(extension(nonTeste,e1,sigma.clone()));
					System.out.println("2eme cas : la négation du justificatif du défaut n'appartient pas à E, le défaut est donc applicable");
					sigma.addFormule(tmpDefaut.getConsequent());
					e.addFormule(tmpDefaut.getConsequent());
				}
			}
			else{
				System.out.println("Le prérquis du défaut "+tmpDefaut.getId()+" n'appartient pas à SigmaDelta(E), le défaut n'est pas utilisable");
				System.out.println("le prérquis :"+tmpDefaut.getPrerquis());
				System.out.println(sigma.getFormules().get(0).toString());
			}
		}
		if(e.coherent()&&e.equals(sigma)){
			System.out.println("E:"+e+" est une extention");
			extensions.add(e);
		}
		
		return extensions;
	}
	
	
}
