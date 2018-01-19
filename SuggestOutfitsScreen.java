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
  private JPanel buttonsPane, main, textPane, photoPane;
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
    buttonsPane = new JPanel(new FlowLayout());
    textPane = new JPanel(new FlowLayout());
    main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
    
    //create buttons and textfields
    back = new JButton("Back");
    category = new JLabel("Categories: ");
    categories = new JTextField(10);
    create = new JButton("Create");

    back.addActionListener(this);
    create.addActionListener(this);

    buttonsPane.add(back);
    buttonsPane.setBackground(Color.BLACK);
    back.setBackground(Color.WHITE);
    create.setBackground(Color.WHITE);
    screen.add(buttonsPane, BorderLayout.PAGE_START);
    textPane.add(category);
    textPane.add(categories);
    textPane.add(create);
    main.add(textPane);
    screen.add(main, BorderLayout.CENTER);
  }

  public SuggestOutfitsScreen(String categoriess){
    //make generic window
    this.setSize(600,400);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); // look into this for how to write to file
    created = false;
    screen = this.getContentPane();
    buttonsPane = new JPanel(new FlowLayout());
    buttonsPane.setBackground(Color.BLACK);
    textPane = new JPanel(new FlowLayout());
    photoPane = new JPanel(new FlowLayout());
    main = new JPanel();
    main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));

    //create buttons and textfields
    back = new JButton("Back");
    category = new JLabel("Categories: ");
    categories = new JTextField(10);
    create = new JButton("Create");

    back.addActionListener(this);
    create.addActionListener(this);  
    back.setBackground(Color.WHITE);
    create.setBackground(Color.WHITE);

    buttonsPane.add(back);
    
    screen.add(buttonsPane, BorderLayout.PAGE_START);
    textPane.add(category);
    textPane.add(categories);
    textPane.add(create);
    main.add(textPane);
    main.add(photoPane);
    screen.add(main, BorderLayout.CENTER);
    categories.setText(categoriess);
    uploadImages(categoriess);
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
      SuggestOutfitsScreen w = new SuggestOutfitsScreen(categories.getText());
      w.setVisible(true);
      dispose();
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
        if(n==-1){
        	JLabel broken = new JLabel(cats[i] + " is not a stored category");
        	screen.add(broken);
        }else{
          images[i] = new JLabel();
          photoPane.add(images[i]);
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
  
  
}
