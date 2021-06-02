public abstract class Piece
{
  private int couleur;	// 0 pour noir, 1 pour blanc
  private int ligne;	// position x
  private int colonne;	// position y

    // Constructeur avec paramètres
  public Piece(){
  }

  public Piece(int x, int y, int couleur)
  {
    this.ligne = x;
    this.colonne = y;
    this.couleur = couleur;
  }

    public boolean deplacer(Echiquier e,Case arrive){
    Case depart = e.getCase(this.x, this.y);
    System.out.println(depart.getPosX() + " et : " + depart.getPosY());
    System.out.println(arrive.getPosX() + " et : " + arrive.getPosY());
    System.out.println(depart.getPiece().verifDeplacement(e,arrive));
    if(depart.getPiece().verifDeplacement(e,arrive)) {
          System.out.println("entre du if 1");
          e.setCase(arrive, depart.getPiece());
          System.out.println(e.getCase(arrive.getPosX(),arrive.getPosY()));
          depart.setPiece(null);
          System.out.println(e.getCase(depart.getPosX(),depart.getPosX()));
          return true;
      }
    return false;
  }

   public boolean memeCouleur(Case depart, Case arrive) {
    if(!(arrive.estVide()) )
      if(arrive.getPiece().getCouleur()==depart.getPiece().getCouleur())
        return true;
    return false;
  }


  public boolean coupPossible(Echiquier e, Case arrive)
  {
    return true;
  }


    /* GETTERS */
    public int getPosLigne()
    {
      return this.ligne;
    }

  public int getPosColonne()
    {
      return this.colonne;
    }

    public int getCouleur()
    {
      return this.couleur;
    }

    public String getPropriete() {
      return "";
    }

  /*___________________FIN DES GETTERS	*/

    /* SETTERS */
  public void setPosLigneEtColonne(int x, int y) {
    this.setPosLigne(x);
    this.setPosColonne(y);
  }
    public void setPosLigne(int x)
    {
      this.ligne = x;
    }

    public void setPosColonne(int y)
    {
      this.colonne = y;
    }

    public void setCouleur(int c)
    {
      this.couleur = c;
    }
  /*FIN DES SETTERS	*/

    /*// Deplacer piece a redefinir dans les objects tour, cavalier etc...
     public void deplacerPiece(Echiquier e, Case arrive)
     {
       System.out.println("test 1");
       if (this.verifDeplacement(e,arrive))
       {
          int x = this.getPosLigne();
          int y = this.getPosColonne();
          int i = arrive.getPosLigne();
          int j = arrive.getPosColonne();
          System.out.println("Ligne " + x + " Colonne " + y);
          System.out.println("i " + i + " j " + j);
          e.setCase(e.getCase(i,j),e.getCase(x,y).getPiece());
          System.out.println(e.getCase(i,j));
          e.setCase(e.getCase(x,y),null);
          System.out.println(e.getCase(x,y));
       }
     }*/


  /* Methode toString */
    public String toString()
    {
      String s ="";
      if(this.couleur == 0)
        s = "noir";
      else
        s = "blanc";

        return "Piece [" + this.ligne+";"  + this.colonne+ "]" + "couleur : " + s;
    }
}
