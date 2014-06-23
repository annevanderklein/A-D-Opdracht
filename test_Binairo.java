public class test_Binairo{

  public static Binairo makeBinairo(int[][] test){
    Binairo b = new Binairo(test.length);
    for(int i = 0; i < b.numRows(); i++){
      for(int j = 0; j < b.numRows(); j++){
        b.set(i,j,test[i][j]);
      }
    }
    return b;
  }
  
  public static void main(String[] args){
    //test Checkmethod noMoreThanTwoRow
    int[][] test1 = new int [][] {{-1,-1,0,0,0,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b1 = makeBinairo(test1);
    System.out.println(b1.toString());
    checkMethods c1 = new checkMethods();
    c1.noMoreThanTwoRow(b1);
    if(c1.getCheck() == false){
      System.out.println("Checkmethod noMoreThanTwoRow gives false ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod noMoreThanTwoRow gives true ==> Test Failed");
      System.out.println();
    }
    int[][] test2 = new int [][] {{-1,-1,-1,-1,-1,-1},
                                  {-1,1,1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b2 = makeBinairo(test2);
    System.out.println(b2.toString());
    checkMethods c2 = new checkMethods();
    c2.noMoreThanTwoRow(b2);
    if(c2.getCheck() == true){
      System.out.println("Checkmethod noMoreThanTwoRow gives true ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod noMoreThanTwoRow gives false ==> Test Failed");
      System.out.println();
    }

    //Test Checkmethod noMoreThanTwoColumn
    System.out.println();
    int[][] test3 = new int [][] {{-1,-1,-1,-1,-1,-1},
                                  {-1,0,-1,-1,-1,-1},
                                  {-1,0,-1,-1,-1,-1},
                                  {-1,0,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b3 = makeBinairo(test3);
    System.out.println(b3.toString());
    checkMethods c3 = new checkMethods();
    c3.noMoreThanTwoColumn(b3);
    if(c3.getCheck() == false){
      System.out.println("Checkmethod noMoreThanTwoColumn gives false ==> Test Passed");  
      System.out.println();
    }
    else{
      System.out.println("Checkmethod noMoreThanTwoColumn gives true ==> Test Failed");
      System.out.println();
    }
    int[][] test4 = new int [][] {{-1,-1,-1,-1,-1,-1},
                                  {-1,1,-1,-1,-1,-1},
                                  {-1,1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b4 = makeBinairo(test4);
    System.out.println(b4.toString());
    checkMethods c4 = new checkMethods();
    c4.noMoreThanTwoColumn(b4);
    if(c4.getCheck() == true){
      System.out.println("Checkmethod noMoreThanTwoColumn gives true ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod noMoreThanTwoColumn gives false ==> Test Failed");
      System.out.println();
    }
    
    //Test Checkmethod numberOfRows
    System.out.println();
    int[][] test5 = new int [][] {{-1,0,0,0,0,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b5 = makeBinairo(test5);
    System.out.println(b5.toString());
    checkMethods c5 = new checkMethods();
    c5.numberOfRows(b5);
    if(c5.getCheck() == false){
      System.out.println("Checkmethod numberOfRows gives false ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod numberOfRows gives true ==> Test Failed");
      System.out.println();
    }
    int[][] test6 = new int [][] {{-1,-1,-1,-1,-1,-1},
                                  {-1,1,1,1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b6 = makeBinairo(test6);
    System.out.println(b6.toString());
    checkMethods c6 = new checkMethods();
    c6.numberOfRows(b6);
    if(c6.getCheck() == true){
      System.out.println("Checkmethod numberOfRows gives true ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod numberOfRows gives false ==> Test Failed");
      System.out.println();
    }
    
    //Test Checkmethod numberOfColumns
    System.out.println();
    int[][] test7 = new int [][] {{-1,-1,-1,-1,-1,-1},
                                  {-1,0,-1,-1,-1,-1},
                                  {-1,0,-1,-1,-1,-1},
                                  {-1,0,-1,-1,-1,-1},
                                  {-1,0,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b7 = makeBinairo(test7);
    System.out.println(b7.toString());
    checkMethods c7 = new checkMethods();
    c7.numberOfColumns(b7);
    if(c7.getCheck() == false){
      System.out.println("Checkmethod numberOfColumns gives false ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod numberOfColumns gives true ==> Test Failed");
      System.out.println();
    }
    int[][] test8 = new int [][] {{-1,-1,-1,-1,-1,-1},
                                  {-1,1,-1,-1,-1,-1},
                                  {-1,1,-1,-1,-1,-1},
                                  {-1,1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b8 = makeBinairo(test8);
    System.out.println(b8.toString());
    checkMethods c8 = new checkMethods();
    c8.numberOfColumns(b8);
    if(c8.getCheck() == true){
      System.out.println("Checkmethod numberOfColumns gives true ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod numberOfColumns gives false ==> Test Failed");
      System.out.println();
    }
    
    //test Checkmethod identicalRows
    System.out.println();
    int[][] test9 = new int [][] {{1,1,0,0,1,-1},
                                  {1,1,0,0,1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b9 = makeBinairo(test9);
    System.out.println(b9.toString());
    checkMethods c9 = new checkMethods();
    c9.identicalRows(b9);
    if(c9.getCheck() == true){
      System.out.println("Checkmethod identicalRows gives true ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod identicalRows gives false ==> Test Failed");
      System.out.println();
    }
    int[][] test10 = new int [][] {{1,1,0,0,1,0},
                                  {1,1,0,1,0,0},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b10 = makeBinairo(test10);
    System.out.println(b10.toString());
    checkMethods c10 = new checkMethods();
    c10.identicalRows(b10);
    if(c10.getCheck() == true){
      System.out.println("Checkmethod identicalRows gives true ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod identicalRows gives false ==> Test Failed");
      System.out.println();
    }
    int[][] test11 = new int [][] {{1,1,0,0,1,0},
                                  {1,0,1,0,1,0},
                                  {1,1,0,0,1,0},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b11 = makeBinairo(test11);
    System.out.println(b11.toString());
    checkMethods c11 = new checkMethods();
    c11.identicalRows(b11);
    if(c11.getCheck() == false){
      System.out.println("Checkmethod identicalRows gives false ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod identicalRows gives true ==> Test Failed");
      System.out.println();
    }
    
     //test Checkmethod identicalColumns
    System.out.println();
    int[][] test12 = new int [][] {{1,1,-1,-1,-1,-1},
                                  {1,1,-1,-1,-1,-1},
                                  {0,0,-1,-1,-1,-1},
                                  {1,1,-1,-1,-1,-1},
                                  {0,0,-1,-1,-1,-1},
                                  {-1,-1,-1,-1,-1,-1}};
    Binairo b12 = makeBinairo(test12);
    System.out.println(b12.toString());
    checkMethods c12 = new checkMethods();
    c12.identicalColumns(b12);
    if(c12.getCheck() == true){
      System.out.println("Checkmethod identicalColumns gives true ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod identicalColumns gives false ==> Test Failed");
      System.out.println();
    }
    int[][] test13 = new int [][] {{1,1,-1,-1,-1,-1},
                                  {1,0,-1,-1,-1,-1},
                                  {0,1,-1,-1,-1,-1},
                                  {0,0,-1,-1,-1,-1},
                                  {1,1,-1,-1,-1,-1},
                                  {0,0,-1,-1,-1,-1}};
    Binairo b13 = makeBinairo(test13);
    System.out.println(b13.toString());
    checkMethods c13 = new checkMethods();
    c13.identicalColumns(b13);
    if(c13.getCheck() == true){
      System.out.println("Checkmethod identicalColumns gives true ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod identicalColumns gives false ==> Test Failed");
      System.out.println();
    }
    int[][] test14 = new int [][] {{0,1,1,-1,-1,-1},
                                  {1,0,0,-1,-1,-1},
                                  {0,1,1,-1,-1,-1},
                                  {0,1,1,-1,-1,-1},
                                  {1,0,0,-1,-1,-1},
                                  {1,0,0,-1,-1,-1}};
    Binairo b14 = makeBinairo(test14);
    System.out.println(b14.toString());
    checkMethods c14 = new checkMethods();
    c14.identicalColumns(b14);
    if(c14.getCheck() == false){
      System.out.println("Checkmethod identicalColumns gives false ==> Test Passed");
      System.out.println();
    }
    else{
      System.out.println("Checkmethod identicalColumns gives true ==> Test Failed");
      System.out.println();
    }


  }


}