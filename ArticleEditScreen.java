import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.*;

public class ArticleEditScreen extends Closet implements ActionListener{
  private Container screen;
  private JButton back, save;
  private Article art;
  private BufferedImage photo;
    private JTextField categoryText, sizeText, occasionText, colorText, brandText, materialText, priceText, dateText;
  private JLabel image, categoryLabel, sizeLabel, occasionLabel, colorLabel, brandLabel, materialLabel, priceLabel, dateLabel;

  public ArticleEditScreen(Article arti){
      art = arti;
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


    //upload image
    image = new JLabel();
    screen.add(image);
    try{
      photo = ArticleAddScreen.editImage(120,120,ImageIO.read(new File(art.getFileName())));
      ImageIcon i = new ImageIcon(photo);
      image.setIcon(i);
    }catch(Exception ex){
      ex.printStackTrace();
    }

    //set up textfields for data
    categoryLabel = new JLabel("Category: ");
    categoryText = new JTextField(15);
    sizeLabel = new JLabel("Size: ");
    sizeText = new JTextField(15);
    occasionLabel = new JLabel("Occasion: ");
    occasionText = new JTextField(15);
    colorLabel = new JLabel("Color: ");
    colorText = new JTextField(15);
    brandLabel = new JLabel("Brand: ");
    brandText = new JTextField(15);
    materialLabel = new JLabel("Material: ");
    materialText = new JTextField(15);
    priceLabel = new JLabel("Price: ");
    priceText = new JTextField(15);
    dateLabel = new JLabel("Date: ");
    dateText = new JTextField(15);

    screen.add(categoryLabel);
    screen.add(categoryText);
    screen.add(sizeLabel);
    screen.add(sizeText);
    screen.add(occasionLabel);
    screen.add(occasionText);
    screen.add(colorLabel);
    screen.add(colorText);
    screen.add(brandLabel);
    screen.add(brandText);
    screen.add(materialLabel);
    screen.add(materialText);
    screen.add(priceLabel);
    screen.add(priceText);
    screen.add(dateLabel);
    screen.add(dateText);

    //set textfields to include current data

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
      ArticleDisplayScreen w = new ArticleDisplayScreen(art);
      w.setVisible(true);
      this.dispose();
    }
  }
}
