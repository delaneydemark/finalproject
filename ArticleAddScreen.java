import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArticleAddScreen extends Closet implements ActionListener{
  private Container screen;
    private JPanel labelPane, buttonsPane, textPane, containsText, categoryPane, sizePane, occasionPane, colorPane, brandPane, materialPane, pricePane, datePane;
  private JButton back, save, uploadImage;
  private JTextField categoryText, sizeText, occasionText, colorText, brandText, materialText, priceText, dateText;
  private JLabel image, categoryLabel, sizeLabel, occasionLabel, colorLabel, brandLabel, materialLabel, priceLabel, dateLabel;

  private String filename;
  private boolean uploaded;
  private BufferedImage photo;

  public ArticleAddScreen(){
    filename = "";
    uploaded = false;
    photo = null;
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
    textPane= new JPanel();
    textPane.setLayout(new BoxLayout(textPane,BoxLayout.PAGE_AXIS));
    //screen.setLayout(new FlowLayout());
    //set up back and save buttons
    back = new JButton("Back");
    save = new JButton("Save");

    back.addActionListener(this);
    save.addActionListener(this);

    buttonsPane.add(back, BorderLayout.PAGE_START);
    buttonsPane.add(save, BorderLayout.PAGE_START);


    //set up upload button to retrieve files
    uploadImage = new JButton("Upload...");
    uploadImage.addActionListener(this);


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

    categoryPane.add(categoryLabel);
    categoryPane.add(categoryText);
    sizePane.add(sizeLabel);
    sizePane.add(sizeText);
    occasionPane.add(occasionLabel);
    occasionPane.add(occasionText);
    colorPane.add(colorLabel);
    colorPane.add(colorText);
    brandPane.add(brandLabel);
    brandPane.add(brandText);
    materialPane.add(materialLabel);
    materialPane.add(materialText);
    pricePane.add(priceLabel);
    pricePane.add(priceText);
    datePane.add(dateLabel);
    datePane.add(dateText);

    labelPane.add(categoryPane);  
    labelPane.add(sizePane);
    labelPane.add(occasionPane);
    labelPane.add(colorPane);
    labelPane.add(brandPane);
    labelPane.add(materialPane);
    labelPane.add(pricePane);
    labelPane.add(datePane);
    
    containsText.add(uploadImage);
    containsText.add(labelPane);
    screen.add(buttonsPane, BorderLayout.PAGE_START);
    screen.add(containsText, BorderLayout.CENTER);
  }


  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();

    //check if they clicked back...return to homescreen
    if(s.equals("Back")){
      System.out.println("Go Back");
      //GO BACK TO HOME SCREEN
      HomeScreen w = new HomeScreen();
      w.setVisible(true);
      this.dispose();
    }
    //check if they clicked save...create new article with provided info
    if(s.equals("Save") && uploaded){
      System.out.println("Save");
      //create new article using given data
      Article art = new Article(categoryText.getText(),sizeText.getText(),occasionText.getText(),colorText.getText(),brandText.getText(),materialText.getText(),priceText.getText(),dateText.getText(),filename);
      //print article
      System.out.println(art);
      //call addArticle using new article
      add(art);
      // write to csv file
      writeToCSV("articles.csv");
      //go to ArticleDisplayScreen
      ArticleDisplayScreen w = new ArticleDisplayScreen(art);
      w.setVisible(true);
      this.dispose();
    }
    //check if they clicked upload...save the image file
    if(s.equals("Upload...") && !uploaded){
      //allow user to select file
      JFileChooser chooser = new JFileChooser();
      chooser.showOpenDialog(null);
      File f = chooser.getSelectedFile();
      filename = f.getAbsolutePath();
      image = new JLabel();
      containsText.add(image);
      uploaded = true;
      try{
        photo = editImage(120,120,ImageIO.read(new File(filename)));
        ImageIcon i = new ImageIcon(photo);
        image.setIcon(i);
      }catch(Exception ex){
        ex.printStackTrace();
      }

      //display file
      System.out.println("upload");
    }

  }

  public static BufferedImage editImage(int w, int h, BufferedImage img) throws Exception {
    BufferedImage i = new BufferedImage(w,h,BufferedImage.TRANSLUCENT);
    Graphics2D g = (Graphics2D) i.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    g.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
    g.drawImage(img,0,0,w,h,null);
    g.dispose();
    return i;
  }

  

}
