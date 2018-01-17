import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class SuggestOutfitsScreen extends Closet implements ActionListener{
  private Container screen;
  private JButton back, create;
  private JLabel category;
  private JTextField categories;
  private boolean created;

  public SuggestOutfitsScreen(){
    //make generic window
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // look into this for how to write to file
    created = false;
    screen = this.getContentPane();
    screen.setLayout(new FlowLayout());

    //create buttons and textfields
    back = new JButton("Back");
    category = new JLabel("Categories: ");
    categories = new JTextField(10);
    create = new JButton("Create");

    back.addActionListener(this);
    create.addActionListener(this);

    screen.add(back);
    screen.add(category);
    screen.add(categories);
    screen.add(create);
  }

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    //check if they clicked back...go to HomeScreen and close current window
    if(s.equals("Back")){
      HomeScreen w = new HomeScreen();
      w.setVisible(true);
      this.dispose();
    }
    if(s.equals("Create")){
      uploadImages(categories.getText());
      }
         
    
  }

  public void uploadImages(String categoriess){
    String cats[] = categoriess.split(", ");
      BufferedImage[]  photos = new BufferedImage[cats.length];
      JLabel[] images = new JLabel[cats.length];
      for(int i = 0;i < cats.length;i++){
        //print the photo of corresponding article
        // CALL DELANEYS FUNCTION
        int n = randArticle(cats[i]);
          images[i] = new JLabel();
          screen.add(images[i]);
          try{
            photos[i] = ArticleAddScreen.editImage(120,120,ImageIO.read(new File(get(n).getFileName())));
            ImageIcon j = new ImageIcon(photos[i]);
            images[i].setIcon(j);
          }catch(Exception ex){
            ex.printStackTrace();
          }
          images[i].addMouseListener(new MouseAdapter(){
              public void mouseClicked(MouseEvent me){
                ArticleDisplayScreen w = new ArticleDisplayScreen(get(n));
                w.setVisible(true);
                dispose();
              }
            });
        }
  }
  
  
}
