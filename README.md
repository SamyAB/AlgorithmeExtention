##Algorithme d'extention
Projet visant à créer une implémentation de l'algorithme de construction d'extention de la logique des défauts
Projet 3 - Représentation de conaissances et Raisonnement - master 1 SII -USTHB

#Langage
Java

#Remarque
Les formules utilisée sont des fomules écrite en forme normale conjonctive (FNC)

#Structure de fichier théorie en entrée
-lingne de monde, ajoute une formuleCNF au monde : m;clause1;clause2;....;clauseN
-ligne de défauts, ajoute un defaut à la liste des défaut : d:prérequis:justificatif/consequent
	--prérequis sous la forme clause1;clause2;...;clauseN
	--justificatif sous la forme clause1;clause2;...;clauseN
	--consequent sous la forme clause1;clause2;...;clauseN
