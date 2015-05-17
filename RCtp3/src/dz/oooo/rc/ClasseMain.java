package dz.oooo.rc;

import java.util.ArrayList;

public class ClasseMain {

	public static void main(String[] args) {
		Theorie t=new Theorie("/mnt/Doc1/MEGAsync/m1s2/rc/tp3/structure de fichier de théorie.txt");
		//System.out.println(t.getMonde().getFormules().get(0));
		//System.out.println(t.getMonde().clone().toString());
		ArrayList<Monde> extensions=t.extension(t.getDefauts(), t.getMonde().clone(), t.getMonde().clone());
		System.out.println(extensions.get(0).toString());
	}

}
