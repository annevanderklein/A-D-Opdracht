public class Binairo{

       private int[][] elements;
       private boolean solvable;
       
       //vul de hele binairo met '-1'
       public Binairo(int n){
         if(n > 0){
            elements = new int[n] [n];
                   for(int i = 0; i < n; i++){
                           for(int j = 0; j < n; j++){
                                   elements[i] [j] = -1;
                           }
                   }
            solvable = true;
         }
       }

       //vult een vakje met '0', '1'of '-1'
       public void set(int row, int col, int val){
          if(0 <= row && row < elements.length && 0 <= col && col < elements.length && (val == -1 || val == 0 || val == 1)){
            if(val == 0){
              elements[row][col] = 0;
            }
            else{
              if(val == 1){
                elements[row][col] = 1;
              }
              else{
                elements[row][col] = -1;
              }
            }
         }
       }

       //haal de waarde op van een vakje
       public int get(int row, int col){
         if(0 <= row && row < elements.length && 0 <= col && col < elements.length){
           return elements[row][col];
         }
         return 7;
       }

       //geef de waarde van het aantal rijen
       public int numRows(){
         return elements.length;
       }

       //geef een string-representatie van de binairo
       public String toString(){
         if(this.numRows() > 0){
           String res = "";
                for(int i = 0; i < this.numRows(); i++){
                  for(int j = 0; j < this.numRows(); j++){
                     res = res + elements[i] [j] + "   ";
                  }
                  res = res + "\n";
                }
                return res;
         }
         return "";
       }

      //oplossen binairo
      public Binairo solve(){
      Binairo kopie = this.copy();
      //rij
      int x = 0;
      //kolom
      int y = 0;
      while(x < kopie.numRows() && x >= 0){
        //check of er een oningevuld hokje is
        int a = 0;
        for(int i = 0; i< kopie.numRows(); i++){
          for(int j = 0; j<kopie.numRows(); j++){
            if(kopie.get(i,j) == -1){
              kopie.set(i,j,0);
              x = i;
              y = j;
              a = 1;
              break;
            }
          }
          if(a == 1){
            //oningevuld hokje gevonden
            break;
          }
        }
        if(a == 0){
          //alles is correct ingevuld
          x = kopie.numRows();
        }
        if(check(kopie) == false){
          //0 kan niet, zet naar 1
          kopie.set(x,y,1);
          if(check(kopie) == false){
            //1 kan ook niet, zet naar -1
            kopie.set(x,y,-1);
            //ga net zo ver terug tot een 0 in een correcte 1 veranderd kan worden en ga verder
            while(x >= 0 && (this.get(x,y) != -1 || kopie.get(x,y) == -1)){
              //ga 1 hokje terug
              if(y > 0){
                y--;
              }
              else{
                x--;
                y = kopie.numRows() - 1;
              }
              //check of waarde veranderd mag worden
              if(this.get(x,y) == -1){
                //als waarde 1 is, zet waarde naar -1 en ga verder terug
                if(kopie.get(x,y) == 1){
                  kopie.set(x,y,-1);
                }
                else{
                  //waarde is 0, probeer 1
                  kopie.set(x,y,1);
                  if(check(kopie) == false){
                    //1 kan niet, zet waarde naar -1 en ga verder terug
                    kopie.set(x,y,-1);
                  }
                }
              }
            }
          }
        }
      }
      if(x < 0){
        //binairo is niet oplosbaar
        solvable = false;
      }
      return kopie;
    }

  //maak kopie van binairo om de oorspronkelijke invoer te bewaren
  public Binairo copy(){
    Binairo kopie = new Binairo(this.numRows());
    for(int i = 0; i < kopie.numRows(); i++){
      for(int j = 0; j < kopie.numRows(); j++){
        kopie.set(i,j, this.get(i,j));
      }
    }
    return kopie;
  }

  //voer checkmethodes een voor een uit, tot de binairo niet meer voldoet aan een check of alle checks succesvol zijn doorlopen
  public boolean check(Binairo b){
    checkMethods c = new checkMethods();
    c.noMoreThanTwoRow(b);
    if(c.getCheck() == false){
      return c.getCheck();
    }
    c.noMoreThanTwoColumn(b);
    if(c.getCheck() == false){
      return c.getCheck();
    }
    c.numberOfRows(b);
    if(c.getCheck() == false){
      return c.getCheck();
    }
    c.numberOfColumns(b);
    if(c.getCheck() == false){
      return c.getCheck();
    }
    c.identicalRows(b);
    if(c.getCheck() == false){
      return c.getCheck();
    }
    c.identicalColumns(b);
    if(c.getCheck() == false){
      return c.getCheck();
    }
    return c.getCheck();
  }

  public boolean getSolvable(){
    return solvable;
  }
}