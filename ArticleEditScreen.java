import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArticleEditScreen extends Closet implements ActionListener{
  private Container screen;
  private JButton back, save;

  public ArticleEditScreen(){
    //make generic window
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // look into this for how to write to file

    screen = this.getContentPane();
    screen.setLayout(new FlowLayout());

    //create buttons
    back = new JButton("Back");
    save = new JButton("Save");

    back.addActionListener(this);
    save.addActionListener(this);

    screen.add(back);
    screen.add(save);
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
    if(s.equals("Save")){
      // add to arraylist
      // write to file
      ArticleDisplayScreen w = new ArticleDisplayScreen();
      w.setVisible(true);
      this.dispose();
    }
  }
}
