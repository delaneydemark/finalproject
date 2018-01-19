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

public class HomeScreen extends Closet implements ActionListener{
  private Container screen;
  private JPanel buttonsPane, mainPane;
  private JButton suggestOutfits, add, filterButton, clear;
  private JTextField filterBox;

  public HomeScreen(){
    System.out.println("HOME");
    //make generic window
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // look into this for how to write to file

    screen = this.getContentPane();
    buttonsPane = new JPanel(new FlowLayout());
    mainPane = new JPanel();
    mainPane.setLayout(new BoxLayout(mainPane,BoxLayout.PAGE_AXIS));

    //create buttons
    suggestOutfits = new JButton("Suggest Outfits");
    add = new JButton("Add");
    filterButton = new JButton("Filter");
    filterBox = new JTextField(15);
    clear = new JButton("Clear Closet");
    suggestOutfits.setBackground(Color.WHITE);
    add.setBackground(Color.WHITE);
    filterButton.setBackground(Color.WHITE);
    clear.setBackground(Color.WHITE);
	

    suggestOutfits.addActionListener(this);
    add.addActionListener(this);
    filterButton.addActionListener(this);
    filterBox.addActionListener(this);
    clear.addActionListener(this);

    buttonsPane.add(suggestOutfits);
    buttonsPane.add(add);
    buttonsPane.add(filterBox);
    buttonsPane.add(filterButton);
    buttonsPane.add(clear);

    buttonsPane.setBackground(Color.BLACK);

    screen.add(mainPane,BorderLayout.CENTER);
    screen.add(buttonsPane, BorderLayout.PAGE_START);

    JScrollPane scroll = new JScrollPane(mainPane);
    add(scroll);

    //loop through length of closet and display photos

    //CREATE AN ARRAY LIST OF JLABELS. AND LOOP THROUGH JLABELS.
    BufferedImage[]  photos = new BufferedImage[len()];
    JLabel[] images = new JLabel[len()];
    ArrayList<JLabel> categories = new ArrayList<JLabel>();
    ArrayList<JPanel> mainPanes = new ArrayList<JPanel>();
    ArrayList<JPanel> subPanes = new ArrayList<JPanel>();
    String current = "";
    for(int i = 0;i < len();i++){
	    //print the photo of corresponding article
	    Article art = get(i);
	    if(!current.equals(art.getCategory())){
        if(categories.size() != 0){
          mainPane.add(subPanes.get(categories.size() - 1));
        }
        current = art.getCategory();
        mainPanes.add(new JPanel());
        subPanes.add(new JPanel());
        categories.add(new JLabel());
        int last = categories.size() - 1;
        JLabel curren = categories.get(last);
        JPanel now = mainPanes.get(last);
        curren = new JLabel(current);
        now = new JPanel();
        now.setLayout(new BoxLayout(now, BoxLayout.PAGE_AXIS));
        now.add(curren);
        JPanel noww = subPanes.get(last);
        noww = new JPanel(new FlowLayout());
        mainPane.add(now);
	    }
	    images[i] = new JLabel();
      subPanes.get(categories.size() - 1).add(images[i]);
	    try{
        photos[i] = ArticleAddScreen.editImage(120,120,ImageIO.read(new File(art.getFileName())));
        ImageIcon j = new ImageIcon(photos[i]);
        images[i].setIcon(j);
	    }catch(Exception ex){
        ex.printStackTrace();
	    }
	    images[i].addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent me){
            ArticleDisplayScreen w = new ArticleDisplayScreen(art);
            w.setVisible(true);
            dispose();
          }
        });
      if(i == len() - 1){
        mainPane.add(subPanes.get(categories.size() - 1));
      }
    }

  }

  public HomeScreen(String filter){
    System.out.println(filter);
		//make generic window
		this.setSize(600,400);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // look into this for how to write to file

    screen = this.getContentPane();
    buttonsPane = new JPanel(new FlowLayout());
    mainPane = new JPanel();
    mainPane.setLayout(new BoxLayout(mainPane,BoxLayout.PAGE_AXIS));
    JPanel photoss = new JPanel(new FlowLayout());


    //create buttons
    suggestOutfits = new JButton("Suggest Outfits");
    add = new JButton("Add");
    filterButton = new JButton("Filter");
    filterBox = new JTextField(15);
    clear = new JButton("Clear Closet");
    suggestOutfits.setBackground(Color.WHITE);
    add.setBackground(Color.WHITE);
    filterButton.setBackground(Color.WHITE);
    clear.setBackground(Color.WHITE);

    suggestOutfits.addActionListener(this);
    add.addActionListener(this);
    filterButton.addActionListener(this);
    filterBox.addActionListener(this);
    clear.addActionListener(this);

    buttonsPane.add(suggestOutfits);
    buttonsPane.add(add);
    buttonsPane.add(filterBox);
    buttonsPane.add(filterButton);
    buttonsPane.add(clear);
    buttonsPane.setBackground(Color.BLACK);
    JLabel filterr = new JLabel("Filtering for: "+ filter);
    JPanel filterrr = new JPanel();
    filterrr.add(filterr);
    mainPane.add(filterrr);
    mainPane.add(photoss);
    screen.add(buttonsPane, BorderLayout.PAGE_START);
    screen.add(mainPane, BorderLayout.CENTER);
   
    //loop through length of closet and display photos

		//CREATE AN ARRAY LIST OF JLABELS. AND LOOP THROUGH JLABELS.
		BufferedImage[]  photos = new BufferedImage[len()];
		JLabel[] images = new JLabel[len()];
		for(int i = 0;i < len();i++){
      //print the photo of corresponding article
      Article art = get(i);
      if (art.getCategory().equals(filter) || art.getSize().equals(filter) || art.getOccasion().contains(filter)
	    		|| art.getColor().contains(filter) || art.getBrand().equals(filter) || art.getMaterial().equals(filter)
	    		|| art.getPrice().equals(filter) || art.getDates().contains(filter)){
        images[i] = new JLabel();
        photoss.add(images[i]);
        try{
					photos[i] = ArticleAddScreen.editImage(120,120,ImageIO.read(new File(art.getFileName())));
					ImageIcon j = new ImageIcon(photos[i]);
					images[i].setIcon(j);
        }catch(Exception ex){
					ex.printStackTrace();
        }
        images[i].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
              ArticleDisplayScreen w = new ArticleDisplayScreen(art);
              w.setVisible(true);
              dispose();
            }
          });
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
    if(s.equals("Filter") && !filterBox.getText().equals("")){
      HomeScreen w = new HomeScreen(filterBox.getText());
      w.setVisible(true);
      this.dispose();
    }
    if(s.equals("Filter") && filterBox.getText().equals("")){
      HomeScreen w = new HomeScreen();
      w.setVisible(true);
      this.dispose();
    }
    if(s.equals("Clear Closet")){
      clear();
      HomeScreen w = new HomeScreen();
      w.setVisible(true);
      this.dispose();
    }
  }
  
}
