import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HomeScreen extends Closet implements ActionListener{
  private Container screen;
  private JButton suggestOutfits, add, filter;

  public HomeScreen(){
    //make generic window
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // look into this for how to write to file

    screen = this.getContentPane();
    screen.setLayout(new FlowLayout());

    //create buttons
    suggestOutfits = new JButton("Suggest Outfits");
    add = new JButton("Add");
    filter = new JButton("Filter");

    suggestOutfits.addActionListener(this);
    add.addActionListener(this);
    filter.addActionListener(this);

    screen.add(suggestOutfits);
    screen.add(add);
    screen.add(filter);

  }

  public HomeScreen(String filter){
    //do something
  }


  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    //check if they clicked Add...go to ArticleAddScreen and close current window
    if(s.equals("Add")){
      System.out.println("add");
      ArticleAddScreen w = new ArticleAddScreen();
      w.setVisible(true);
    }
  }
}
