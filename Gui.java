import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//deze klasse maakt een scherm waarin je binairo's van verschillende grote kan invullen en laten oplossen
public class Gui extends JFrame implements ActionListener{
  private JTextField[][] binairo;
  private JPanel paneel;
  private JButton solve;
  private JButton zesbijzes;
  private JButton achtbijacht;
  private JButton tienbijtien;
  private JButton veertienbijveertien;
  private JLabel foutmelding;
  private Container c = getContentPane();
  private Font font = new Font("Verdana",Font.PLAIN ,20);

  //settings voor de lay-out van de Gui
  public Gui(){
    setTitle("Binairo");
    setBounds(50,100,400,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    c.setBackground(Color.yellow);
    c.setLayout(null);
    paneel = new JPanel();
    solve = new JButton("Solve");
    zesbijzes = new JButton("6x6");
    achtbijacht = new JButton("8x8");
    tienbijtien = new JButton("10x10");
    veertienbijveertien = new JButton("14x14");
    foutmelding = new JLabel("");
    paneel.setLayout(new GridLayout(6,6));
      binairo = new JTextField[6][6];
      for(int i = 0; i < 6; i++){
        for(int j = 0; j < 6; j++){
          binairo[i][j] = new JTextField();
          binairo[i][j].setHorizontalAlignment(JTextField.CENTER);
          binairo[i][j].setFont(font);
          paneel.add(binairo[i][j]);
        }
      }
      paneel.setBounds(150,25,40*6,40*6);
    solve.setBounds(25,25,100,35);
    zesbijzes.setBounds(25,80,100,35);
    achtbijacht.setBounds(25,145,100,35);
    tienbijtien.setBounds(25,210,100,35);
    veertienbijveertien.setBounds(25,275,100,35);
    foutmelding.setBounds(150,50+(40*6),300,30);
    foutmelding.setFont(font);
    c.add(paneel);
    c.add(solve);
    c.add(zesbijzes);
    c.add(achtbijacht);
    c.add(tienbijtien);
    c.add(veertienbijveertien);
    setVisible(true);
    solve.addActionListener(this);
    zesbijzes.addActionListener(this);
    achtbijacht.addActionListener(this);
    tienbijtien.addActionListener(this);
    veertienbijveertien.addActionListener(this);
  }

  //zet de invoer in een Binairo-object
  public Binairo input(){
    Binairo b = new Binairo(binairo.length);
    for(int i = 0; i < b.numRows(); i++){
      for(int j = 0; j < b.numRows(); j++){
        String text = binairo[i][j].getText();
        //als er een 0 of 1 wordt getypt, converteer dit dan naar een 0 of 1 in de lege binairo
        if(text.equals("0")||text.equals("1")){
          int cijfer = Integer.parseInt(text);
          b.set(i,j,cijfer);
        }
        //als er een andere waarde dan een 0 of 1 wordt ingevoerd, return een 1x1 binairo.
        else{
          if(text.length() > 0){
            return new Binairo(1);
          }
        }
      }
    }
    return b;
  }

  //toon Binairo-object op scherm
  public void output(Binairo b){
    for(int i = 0; i < b.numRows(); i++){
      for(int j = 0; j < b.numRows(); j++){
        int cijfer = b.get(i,j);
        if(cijfer == 0){
          binairo[i][j].setText("0");
        }
        else{
          if(cijfer == 1){
            binairo[i][j].setText("1");
          }
          else{
            binairo[i][j].setText("");
          }
        }
      }
    }
  }
  
  //maak een grid van goede grootte voor de binairo
  public void makePanel(int n){
    paneel.removeAll();
    c.remove(paneel);
    paneel.setLayout(new GridLayout(n,n));
      binairo = new JTextField[n][n];
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          binairo[i][j] = new JTextField();
          binairo[i][j].setHorizontalAlignment(JTextField.CENTER);
          binairo[i][j].setFont(font);
          paneel.add(binairo[i][j]);
        }
      }
      paneel.setBounds(150,25,40*n,40*n);
      c.add(paneel);
      foutmelding.setBounds(150,50+(40*n),300,30);
  }

  public void actionPerformed(ActionEvent e){
    c.remove(foutmelding);
    Object source = e.getSource();
    if(source == solve){
      foutmelding.setText("");
      Binairo b = input();
      //indien er een waarde anders dan een 0 of 1 is ingevoerd, return een error message
      if(b.numRows() == 1){
        foutmelding.setText("Incorrect input, please adjust");
        c.add(foutmelding);
      }
      //indien de ingevulde binairo onoplosbaar is, return een error message
      else{
        Binairo nieuw = b.solve();
        if(b.getSolvable() == false){
          foutmelding.setText("This binairo is unsolvable");
          c.add(foutmelding);
        }
        else{
          output(nieuw);
        }
      }
    }
    if(source == zesbijzes){
      makePanel(6);
    }
    if(source == achtbijacht){
      makePanel(8);
    }
    if(source == tienbijtien){
      makePanel(10);
    }
    if(source == veertienbijveertien){
      makePanel(14);
    }
  }
}
