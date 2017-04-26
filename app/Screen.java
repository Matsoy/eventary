import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame{

  private JFrame frame;
  private JPanel panel;

  public Screen(){
    //Définit un titre pour notre fenêtre
    this.setTitle("Eventary");
    //Définit sa taille : 400 pixels de large et 100 pixels de haut
    this.setSize(1440,810);
    //Nous demandons maintenant à notre objet de se positionner au centre
    this.setLocationRelativeTo(null);
    //Termine le processus lorsqu'on clique sur la croix rouge
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());


    /*
    this.setBackground(new Color(240,240,240));
    JButton bouton = new EventaryButton("Hello World");
    JButton bouton2 = new EventaryButton("Hello World");
    bouton.addMouseListener(new ListenerPrintHello());
    panel.add(bouton);
    panel.add(bouton2);
    */
    JPanel panelGreen = new JPanel();
    panelGreen.setBackground(new Color(191,169,120));
    panelGreen.setPreferredSize(new Dimension(360, 810));
    
    this.panel = new JPanel();
    panel.setBackground(Color.WHITE);
    
    this.getContentPane().add(panel,BorderLayout.CENTER);
    //this.setContentPane(panelGreen);
    this.getContentPane().add(panelGreen,BorderLayout.WEST);
    //panelGreen.pack(true);
    //Et enfin, la rendre visible
    this.setVisible(true);
  }
}
class Main {

  public static void main(String[] args){

    Screen screen = new Screen();
  }
}
