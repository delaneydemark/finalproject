import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ArticleDisplayScreen extends Closet implements ActionListener{
  private Container screen;
  private JButton back, edit;

  public ArticleDisplayScreen(){
    //make generic window
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // look into this for how to write to file

    screen = this.getContentPane();
    screen.setLayout(new FlowLayout());

    //create buttons
    back = new JButton("Back");
    edit = new JButton("Edit");

    back.addActionListener(this);
    edit.addActionListener(this);

    screen.add(back);
    screen.add(edit);
  }

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    //check if they clicked back...go to HomeScreen and close current window
    if(s.equals("Back")){
      HomeScreen w = new HomeScreen();
      w.setVisible(true);
      this.dispose();
    }
    //check if they clicked edit...go to ArticleEditScreen close current window
    if(s.equals("Edit")){
      ArticleEditScreen w = new ArticleEditScreen();
      w.setVisible(true);
      this.dispose();
    }
  }
}
