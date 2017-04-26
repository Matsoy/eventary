import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame{

  private JFrame frame;
  private JPanel panel;

  public Screen(){
    this.panel = new JPanel();
    //Définit un titre pour notre fenêtre
    this.setTitle("Eventary");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    this.setSize(1440,810);

    this.setBackground(new Color(240,240,240));
    //Nous demandons maintenant à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton bouton = new EventaryButton("Hello World");
    JButton bouton2 = new EventaryButton("Hello World");
    bouton.addMouseListener(new ListenerPrintHello());
    panel.add(bouton, BorderLayout.CENTER);
    panel.add(bouton2, BorderLayout.CENTER);
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
