import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;

public class Screen extends JFrame{

  private JFrame frame;
  private JPanel panel;

  public Screen(){
    this.panel = new JPanel();
    //Définit un titre pour notre fenêtre
    this.setTitle("Eventary");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    this.setSize(1440,810);
    //Nous demandons maintenant à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton bouton = new JButton("Hello World");
    bouton.addMouseListener(new ListenerPrintHello());
    panel.add(bouton, BorderLayout.CENTER);
    this.setContentPane(panel);


    //Et enfin, la rendre visible
    this.setVisible(true);
  }
}
class Main {

  public static void main(String[] args){

    Screen screen = new Screen();
  }
}
