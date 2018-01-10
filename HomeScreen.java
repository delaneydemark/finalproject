import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HomeScreen extends Closet implements ActionListener{
  private Container screen;
  private JButton suggestOutfits, add, filter;
    private JLabel image;
    private BufferedImage photo;

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
    //loop through lenght of closet and display photos

      //CREATE AN ARRAY LIST OF JLABELS. AND LOOP THROUGH JLABELS.
      photo = new BufferedImage();
      image = new JLabel();
      ArrayList<JLabel> images = new ArrayList<JLabel>();
      for(int i = 0;i < clothes.len();i++){
	  //print the photo of corresponding article
	  Article art = clothes.get(i);
	  JLabel  = new JLabel();
	screen.add();
	try{
	    photo = ArticleAddScreen.editImage(120,120,ImageIO.read(new File(art.getFileName())));
	    ImageIcon i = new ImageIcon(photo);
	    image.setIcon(i);
	}catch(Exception ex){
	    ex.printStackTrace();
      }
  	}
  }


  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    //check if they clicked Add...go to ArticleAddScreen and close current window
    if(s.equals("Add")){
      ArticleAddScreen w = new ArticleAddScreen();
      w.setVisible(true);
      this.dispose();
    }
    //check if they clicked SuggestOutfitScreen...open new window and close current
    if(s.equals("Suggest Outfits")){
      SuggestOutfitsScreen w = new SuggestOutfitsScreen();
      w.setVisible(true);
      this.dispose();
    }
    //check if they clicked filter...filter screen
  }
}
