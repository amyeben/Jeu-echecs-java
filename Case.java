public class Case
{
    private int x; // position x
    private int y; // position y
    private Piece p; // case peut etre compose de piece

  public Case(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public Case(int x, int y, Piece p)
      {
          this.x = x;
          this.y = y;
        this.p = p;  // sinon par exemple je fais des if(p instanceof cavalier)
      }


  public Case(Piece p)
  {
    this.p = p;
  }

  /*Permet de savoir si la Case contient une piece ou non
   * Utile pour la fonction etatCase() dans la classe echiqier
   */

  public boolean estVide() {
    if(this.p!=null)
      return false;
    return true;
  }
   
  /*
   * Case sur la meme colonne | utile pour methode CaseDevant()
   */
    public boolean memeColonne(Case arrive)
  {
    if(this.getPosY() == arrive.getPosY())
      return true;
    return false;
        
  }
     /*
     * Case sur la meme ligne | utile pour methode CaseDevant(),verifReine
     */
    public boolean memeLigne(Case arrive)
    {
      if(this.getPosX()== arrive.getPosX())
        return true;
      return false;
          
    }
    /*
     * J'utilise dans verifDeplacement de Pion
     */
    public boolean manger(Case arrive) {
    if(this.getPiece().getCouleur() != arrive.getPiece().getCouleur())
    {
      if(this.getPiece().getCouleur()==0)//noir
        if(arrive.getPosX()==this.getPosX()+1)
        {
          if(arrive.getPosY()==this.getPosY()-1)
            return true;
          else if (arrive.getPosY()==this.getPosY()+1)
            return true;
        }
      else 
      
        if(arrive.getPosX()==this.getPosX()-1)
        {
          if(arrive.getPosY()==this.getPosY()-1)
            return true;
          else if (arrive.getPosY()==this.getPosY()+1)
            return true;
        }
    }
      
    return false;
  }
    
    /*
     * Verifier si c'est bien la case de devant | utile pour les deplacements
     * True = ARRIVE est devant THIS
     */
    public boolean caseDevant(Case arrive) {
      if(this.getPiece().getCouleur() == 0)//noir
        if(this.memeColonne(arrive) && this.getPosX()+1 == arrive.getPosX())
          return true;
      else if (this.getPiece().getCouleur() == 1)
        if(this.memeColonne(arrive) && this.getPosX()-1 == arrive.getPosX())
          return true;
      
      return false;
    }


    /* ACCESSEUR*/

    public String getForme()
    {
      return this.p.getForme();
    }
    public Piece getPiece()
      {
    return this.p;
      }

    public int getPosX()
    {
      return this.x;
  }

  public int getPosY()
  {
      return this.y;
    }


    public void setPosX(int x)
    {
          this.x = x;
    }

    public void setPosY(int y)
    {
        this.y = y;
    }

    public void setPiece(Piece piece)
    {
      this.p = piece; // met la piece dans la case
    }
    /*FIN ACCESSEUR*/

  public String toString()
  {
    return "Case["+this.x + ","+this.y+ "]"+ this.p;
  }


    /*  ---------------------------------------- VERIFIE SI LA SAISIE DE LA CASE EST VALIDE -------------------
    public boolean saisieValide()
    {
      char[] tabChar = {"A","B","C","D","E","F","G","H"};
      boolean t = false;
      if(this.positionCase.lenght != 2) // faut pas que ca fasse A12 d'ou taille de la position different de 2
        return t;
      else
      {
        for(int i = 0; i < tabChar.lenght; i++)
        {
          if( this.positionCase[0] >= 1 && this.positionCase[0] <= 8 && this.positionCase[1] == tabChar[i])
            p = true; //  met true si la position est bien valide
        }
      }
    return p;
    }
      --------------------------------------------------------------------------------------------------------- */

}
