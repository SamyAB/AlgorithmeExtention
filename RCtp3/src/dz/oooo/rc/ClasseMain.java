package dz.oooo.rc;

public class ClasseMain {

	public static void main(String[] args) {
		Theorie t=new Theorie("/mnt/Doc1/MEGAsync/m1s2/rc/tp3/structure de fichier de théorie.txt");
		System.out.println(t.getDefauts().get(0).getJustificatif().negation());
	}

}
