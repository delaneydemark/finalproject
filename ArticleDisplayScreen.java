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
  private JPanel labelPane, buttonsPane, containsText, categoryPane, sizePane, occasionPane, colorPane, brandPane, materialPane, pricePane, datePane;
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
    categoryPane = new JPanel(new FlowLayout());
    sizePane = new JPanel(new FlowLayout());
    occasionPane = new JPanel(new FlowLayout());
    colorPane = new JPanel(new FlowLayout());
    brandPane = new JPanel(new FlowLayout());
    materialPane = new JPanel(new FlowLayout());
    pricePane = new JPanel(new FlowLayout());
    datePane = new JPanel(new FlowLayout());
    containsText = new JPanel(new FlowLayout());
    labelPane = new JPanel();
    buttonsPane = new JPanel(new FlowLayout());
    labelPane.setLayout(new BoxLayout(labelPane,BoxLayout.PAGE_AXIS));

    //create buttons
    back = new JButton("Back");
    edit = new JButton("Edit");

    back.addActionListener(this);
    edit.addActionListener(this);

    buttonsPane.add(back);
    buttonsPane.add(edit);    
    back.setBackground(Color.WHITE);
    edit.setBackground(Color.WHITE);
    buttonsPane.setBackground(Color.BLACK);
    screen.add(buttonsPane, BorderLayout.PAGE_START);

    //upload image
    image = new JLabel();
    containsText.add(image);
    try{
	    photo = ArticleAddScreen.editImage(120,120,ImageIO.read(new File(art.getFileName())));
	    ImageIcon i = new ImageIcon(photo);
	    image.setIcon(i);
    }catch(Exception ex){
	    ex.printStackTrace();
    }
	
    //set up data displayed
    category = new JLabel("Category: "+ art.getCategory());
    categoryPane.add(category);
    labelPane.add(categoryPane);
    size = new JLabel("Size: "+ art.getSize());
    sizePane.add(size);
    labelPane.add(sizePane);
    occasion = new JLabel("Occasion: ");
    //set up occasion
    occasionPane.add(occasion);    
    JLabel[] oLabels = new JLabel[art.getOccasion().size()];
    for(int i = 0;i < art.getOccasion().size();i++){
      if(i < art.getOccasion().size() - 1){
        oLabels[i] = new JLabel(art.getOccasion().get(i) + ",");
      }
      else{
        oLabels[i] = new JLabel(art.getOccasion().get(i));
      }
      occasionPane.add(oLabels[i]);
      String current = art.getOccasion().get(i);
      oLabels[i].addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent me){
            HomeScreen w = new HomeScreen(current);
            w.setVisible(true);
            dispose();
          }
        });
    }
    labelPane.add(occasionPane);
    color = new JLabel("Color: ");
    colorPane.add(color);
    JLabel[] cLabels = new JLabel[art.getColor().size()];
    for(int i = 0;i < art.getColor().size();i++){
      if(i < art.getColor().size() - 1){
        cLabels[i] = new JLabel(art.getColor().get(i) + ",");
      }
      else{
        cLabels[i] = new JLabel(art.getColor().get(i));
      }
      colorPane.add(cLabels[i]);
      String current = art.getColor().get(i);
      cLabels[i].addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent me){
            HomeScreen w = new HomeScreen(current);
            w.setVisible(true);
            dispose();
          }
        });
    }
    labelPane.add(colorPane);
    brand = new JLabel("Brand: " + art.getBrand());
    brandPane.add(brand);
    labelPane.add(brandPane);
    material = new JLabel("Material: " + art.getMaterial());
    materialPane.add(material);
    labelPane.add(materialPane);
    price = new JLabel("Price: " + art.getPrice());
    pricePane.add(price);
    labelPane.add(pricePane);
    dates = new JLabel("Date: ");
    datePane.add(dates);
    JLabel[] dLabels = new JLabel[art.getDates().size()];
    for(int i = 0;i < art.getDates().size();i++){
      if(i < art.getDates().size() - 1){
        dLabels[i] = new JLabel(art.getDates().get(i) + ",");
      }
      else{
        dLabels[i] = new JLabel(art.getDates().get(i));
      }
      datePane.add(dLabels[i]);
      String current = art.getDates().get(i);
      dLabels[i].addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent me){
            HomeScreen w = new HomeScreen(current);
            w.setVisible(true);
            dispose();
          }
        });
      labelPane.add(datePane);
      containsText.add(labelPane);
      screen.add(containsText, BorderLayout.CENTER);
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

