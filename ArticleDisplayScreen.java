import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;

public class ArticleDisplayScreen extends Closet implements ActionListener{
  private Container screen;
  private JButton back, edit;
  private BufferedImage photo;
  private JLabel image, category,size,occasion,color,brand,material,price,dates;
  private Article art;

  public ArticleDisplayScreen(Article arti){
    art = arti;
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
	
    //set up data displayed
    category = new JLabel("Category: "+ art.getCategory());
    screen.add(category);
    size = new JLabel("Size: "+ art.getSize());
    screen.add(size);
    occasion = new JLabel("Occasion: ");
    //set up occasion
    screen.add(occasion);    
    JLabel[] oLabels = new JLabel[art.getOccasion().size()];
    for(int i = 0;i < art.getOccasion().size();i++){
      if(i < art.getOccasion().size() - 1){
        oLabels[i] = new JLabel(art.getOccasion().get(i) + ",");
      }
      else{
        oLabels[i] = new JLabel(art.getOccasion().get(i));
      }
      screen.add(oLabels[i]);
      String current = art.getOccasion().get(i);
      oLabels[i].addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent me){
            HomeScreen w = new HomeScreen(current);
            w.setVisible(true);
            dispose();
          }
        });
    }
    color = new JLabel("Color: ");
    screen.add(color);
    JLabel[] cLabels = new JLabel[art.getColor().size()];
    for(int i = 0;i < art.getColor().size();i++){
      if(i < art.getColor().size() - 1){
        cLabels[i] = new JLabel(art.getColor().get(i) + ",");
      }
      else{
        cLabels[i] = new JLabel(art.getColor().get(i));
      }
      screen.add(cLabels[i]);
      String current = art.getColor().get(i);
      cLabels[i].addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent me){
            HomeScreen w = new HomeScreen(current);
            w.setVisible(true);
            dispose();
          }
        });
    }
    brand = new JLabel("Brand: " + art.getBrand());
    screen.add(brand);
    material = new JLabel("Material: " + art.getMaterial());
    screen.add(material);
    price = new JLabel("Price: " + art.getPrice());
    screen.add(price);
    dates = new JLabel("Date: ");
    screen.add(dates);
    JLabel[] dLabels = new JLabel[art.getDates().size()];
    for(int i = 0;i < art.getDates().size();i++){
      if(i < art.getDates().size() - 1){
        dLabels[i] = new JLabel(art.getDates().get(i) + ",");
      }
      else{
        dLabels[i] = new JLabel(art.getDates().get(i));
      }
      screen.add(dLabels[i]);
      String current = art.getDates().get(i);
      dLabels[i].addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent me){
            HomeScreen w = new HomeScreen(current);
            w.setVisible(true);
            dispose();
          }
        });
    }

    category.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent me){
          HomeScreen w = new HomeScreen(art.getCategory());
          w.setVisible(true);
          dispose();
        }
	    });
    size.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent me){
          HomeScreen w = new HomeScreen(art.getSize());
          w.setVisible(true);
          dispose();
        }
	    });
    /*occasion.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
      HomeScreen w = new HomeScreen(art.getCategory());
      w.setVisible(true);
      dispose();
      }
	    });
      color.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
      HomeScreen w = new HomeScreen(art.getCategory());
      w.setVisible(true);
      dispose();
      }
      });*/
    brand.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent me){
          HomeScreen w = new HomeScreen(art.getBrand());
          w.setVisible(true);
          dispose();
        }
	    });
    material.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent me){
          HomeScreen w = new HomeScreen(art.getMaterial());
          w.setVisible(true);
          dispose();
        }
	    });
    price.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent me){
          HomeScreen w = new HomeScreen(art.getPrice());
          w.setVisible(true);
          dispose();
        }
	    });
    /*dates.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent me){
      HomeScreen w = new HomeScreen(art.getCategory());
      w.setVisible(true);
      dispose();
      }
      });*/
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
	    ArticleEditScreen w = new ArticleEditScreen(art);
	    w.setVisible(true);
	    this.dispose();
    }
  }
}

