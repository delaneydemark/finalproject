import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.util.List;
import java.util.ArrayList;

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
	size = new JLabel("Size: "+ art.getSize());
	occasion = new JLabel("Occasion: " + String.join(",",art.getOccasion()));
  color = new JLabel("Color: " + String.join(",",art.getColor()));
	brand = new JLabel("Brand: " + art.getBrand());
	material = new JLabel("Material: " + art.getMaterial());
	price = new JLabel("Price: " + art.getPrice());
  dates = new JLabel("Date: " + String.join(",",art.getDates()));

	
	screen.add(category);
	screen.add(size);
	screen.add(occasion);
	screen.add(color);
	screen.add(brand);
	screen.add(material);
	screen.add(price);
	screen.add(dates);
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

