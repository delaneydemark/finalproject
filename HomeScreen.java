import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HomeScreen extends Closet implements ActionListener{
  private Container screen;

  public HomeScreen(){
    //make generic window
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // look into this for how to write to file
  }

  public HomeScreen(String filter){
    //do something
  }


  public void actionPerformed(ActionEvent e){

  }
}
