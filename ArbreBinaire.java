package arbre;
public class ArbreBinaire {
    private Integer clef;
    private ArbreBinaire gauche, droite;
    private static final ArbreBinaire arbreVide = new ArbreBinaire();

    private ArbreBinaire() {
        this.clef = null;
        this.gauche = null;
        this.droite = null;
    }

    public static ArbreBinaire getArbreVide() {
        return arbreVide;
    }

    public boolean estVide() {
        return this.clef == null && this.gauche == null && this.droite == null;
    }

    public void inserer(Integer nouvelleClef) {
        if (this.estVide()) {
            this.clef = nouvelleClef;
            this.gauche = new ArbreBinaire();
            this.droite = new ArbreBinaire();
        } else {
            if (nouvelleClef < this.clef) {
                if (this.gauche.estVide()) {
                    this.gauche.clef = nouvelleClef;
                    this.gauche.gauche = new ArbreBinaire();
                    this.gauche.droite = new ArbreBinaire();
                } else {
                    this.gauche.inserer(nouvelleClef);
                }
            } else if (nouvelleClef > this.clef) {
                if (this.droite.estVide()) {
                    this.droite.clef = nouvelleClef;
                    this.droite.gauche = new ArbreBinaire();
                    this.droite.droite = new ArbreBinaire();
                } else {
                    this.droite.inserer(nouvelleClef);
                }
            }
        }
    }

    public void afficher() {
        if (!this.estVide()) {
            if (this.gauche != null) this.gauche.afficher();
            System.out.println(this.clef);
            if (this.droite != null) this.droite.afficher();
        }
    }

    public int taille() {
        if (this.estVide()) {
            return 0;
        } else {
            int tailleGauche = this.gauche != null ? this.gauche.taille() : 0;
            int tailleDroite = this.droite != null ? this.droite.taille() : 0;
            return 1 + tailleGauche + tailleDroite;
        }
    }

    public boolean rechercher(Integer clef) {
        if (this.estVide()) {
            return false;
        } else if (this.clef.equals(clef)) {
            return true;
        } else {
            return (this.gauche != null && this.gauche.rechercher(clef)) ||
                   (this.droite != null && this.droite.rechercher(clef));
        }
    }
}
