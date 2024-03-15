package arbre;

public class Main {
    public static void main(String[] args) {
        ArbreBinaire arbre = ArbreBinaire.getArbreVide();

        arbre.inserer(1);
        arbre.inserer(2);
        arbre.inserer(3);
        arbre.inserer(4);
        arbre.inserer(5);
        arbre.inserer(6);
        arbre.inserer(7);

        System.out.println("Affichage de l'arbre binaire :");
        arbre.afficher();

        boolean trouve = arbre.rechercher(4);
        System.out.println("La valeur 4 est dans l'arbre : " + trouve);

        int taille = arbre.taille();
        System.out.println("Taille de l'arbre : " + taille);
    }
}
