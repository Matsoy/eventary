package view;
import javax.swing.*;
import java.awt.*;
public class EventaryButton extends JButton{
  EventaryButton(String str){
    super(str);
    this.setBackground(new Color(225,225,225));
    this.setForeground(Color.BLACK);
    this.setFocusPainted(false);
    this.setFont(new Font("Arial", Font.BOLD, 12));
    //this.setBorderPainted(false);
      //Enleve les bordures des boutons
    //this.setRolloverEnabled(false);
      //Enleve l'effet hoover
  }
}
