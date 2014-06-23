public class checkMethods{
  
  private boolean check;
  
  //constructor
  public checkMethods(){
    check = true;
  }
  
  //controleer of er nergens meer dan twee nullen of enen naast elkaar staan
  public void noMoreThanTwoRow(Binairo b){
    for(int i = 0; i < b.numRows(); i++){
      for(int j = 0; j < b.numRows() - 2;j++){
        if((b.get(i,j) == 0 && b.get(i,j+1) == 0 && b.get(i,j+2) == 0) || (b.get(i,j) == 1 && b.get(i,j+1) == 1 && b.get(i,j+2) == 1)){
          check = false;
        }
      }
    }
  }

  //controleer of er nergens meer dan twee nullen of enen onder elkaar staan
  public void noMoreThanTwoColumn(Binairo b){
    for(int i = 0; i < b.numRows() - 2; i++){
      for(int j = 0; j < b.numRows();j++){
        if((b.get(i,j) == 0 && b.get(i+1,j) == 0 && b.get(i+2,j) == 0) || (b.get(i,j) == 1 && b.get(i+1,j) == 1 && b.get(i+2,j) == 1)){
          check = false;
        }
      }
    }
  }

  //controleer of het aantal nullen en enen in een rij niet meer dan de helft is van de lengte van een rij
  public void numberOfRows(Binairo b){
    //houd aantal nullen bij in rij
    int k = 0;
    //houd aantal enen bij in rij
    int l = 0;
    for(int i = 0; i < b.numRows();i++){
      for(int j = 0; j < b.numRows();j++){
        if(b.get(i,j) == 0){
          k++;
        }
        if(b.get(i,j) == 1){
          l++;
        }
      }
      if(k > (b.numRows()/2)){
        check = false;
      }
      if(l > (b.numRows()/2)){
        check = false;
      }
      k = 0;
      l = 0;
    }
  }

  //controleer of het aantal nullen en enen in een kolom niet meer dan de helft is van de lengte van een kolom
  public void numberOfColumns(Binairo b){
    //houd aantal nullen bij in kolom
    int k = 0;
    //houd aantal enen bij in kolom
    int l = 0;
    for(int i = 0; i < b.numRows();i++){
      for(int j = 0; j < b.numRows();j++){
        if(b.get(j,i) == 0){
          k++;
        }
        if(b.get(j,i) == 1){
          l++;
        }
      }
      if(k > b.numRows()/2){
        check = false;
      }
      if(l > b.numRows()/2){
        check = false;
      }
      k = 0;
      l = 0;
    }
  }

  //
  public void identicalRows(Binairo b){
    int m = 0;
    int a = 0;
    int k = b.numRows();     //ga uit van compleet gevulde binairo, tenzij straks -1 gevonden wordt
    //vind de laatste compleet gevulde rij
    for(int i = 0; i < b.numRows(); i++){
      for(int j =0; j < b.numRows(); j++){
        if(b.get(i,j) == -1){
          k = i;
          a = 1;
          break;
        }
      }
      if(a == 1){
        break;
      }
    }
    //check alle gevulde rijen met elkaar
    if(k > 1){
      for(int i = 0; i < k ; i++){                 //vaste rij
        for(int j = 1; j < k - i ; j++){           //bewegende rij
          for(int l = 0; l < b.numRows(); l++){   //vergelijk alle vakjes van vaste en bewegende rij
            if(b.get(i,l) == b.get(i+j,l)){
              m++;
            }
          }
          if(m == b.numRows()){
            check = false;
            break;
          }
          m = 0;
        }
        if(check == false){
          break;
        }
      }
    }
  }

  public void identicalColumns(Binairo b){
    int m = 0;
    int a = 0;
    int k = b.numRows();  //ga uit van compleet gevulde binairo, tenzij straks -1 gevonden wordt
    //vind de laatste compleet gevulde kolom
    for(int i = 0; i < b.numRows(); i++){
      for(int j = 0; j < b.numRows(); j++){
        if(b.get(j,i) == -1){
          k = i;
          a = 1;
          break;
        }
      }
      if(a == 1){
        break;
      }
    }
    if(k > 1){
      for(int i = 0; i < k; i++){                 //vaste kolom
        for(int j = 1; j < k - i; j++){           //bewegende kolom
          for(int l = 0; l < b.numRows(); l++){   //vergelijk alle vakjes van vaste en bewegende kolom
            if(b.get(l,i) == b.get(l,i+j)){
              m++;
            }
          }
          if(m == b.numRows()){
            check = false;
            break;
          }
          m = 0;
        }
        if(check == false){
          break;
        }
      }
    }
  }
  
  public boolean getCheck(){
    return check;
  }


}