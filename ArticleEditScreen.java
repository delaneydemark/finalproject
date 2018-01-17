import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.lang.String;

public class ArticleEditScreen extends Closet implements ActionListener{
    private Container screen;
    private JButton back, save,delete;
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
	delete = new JButton("Delete");

	back.addActionListener(this);
	save.addActionListener(this);
	delete.addActionListener(this);

	screen.add(back);
	screen.add(save);
	screen.add(delete);


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
  categoryText.setText(art.getCategory());
	sizeText.setText(art.getSize());
	occasionText.setText(String.join(", ", art.getOccasion()));
	colorText.setText(String.join(", ", art.getColor()));
	brandText.setText(art.getBrand());
	materialText.setText(art.getMaterial());
	priceText.setText(art.getPrice());
	dateText.setText(String.join(", ", art.getDates()));
    }

  public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    //check if they clicked back...go to HomeScreen and close current window
    if(s.equals("Back")){
      HomeScreen w = new HomeScreen();
      w.setVisible(true);
      this.dispose();
    }
    //checks if they pressed delete
    if(s.equals("Delete")){
      //remove article from arraylist clothes
      remove(art);
      //writeToCSV
      writeToCSV("articles.csv");
      //go to homescreen
      HomeScreen w = new HomeScreen();
      w.setVisible(true);
      this.dispose();
    }
    //check if they clicked save...go to ArticleDisplayScreen close current window
    if(s.equals("Save")){
    //remove old article
    System.out.println(remove(art));
	// edit article in arraylist
	art.setCategory(categoryText.getText());
	art.setSize(sizeText.getText());
      art.setOccasion(occasionText.getText());
      art.setColor(colorText.getText());
      art.setBrand(brandText.getText());
      art.setMaterial(materialText.getText());
      art.setPrice(priceText.getText());
      art.setDates(dateText.getText());
      art.setFileName(art.getFileName());
      add(art);
      // write to file
      writeToCSV("articles.csv");
      //swap screen
      ArticleDisplayScreen w = new ArticleDisplayScreen(art);
      w.setVisible(true);
      this.dispose();
    }
  }
}
