import java.util.ArrayList;

public class Closet extends JFrame{
  public static void main(String[] args){
    ArticleAddScreen w = new ArticleAddScreen();
    w.setVisible(true);
  }
  
  private ArrayList<Article> clothes = new ArrayList<Article>();
  
  public Closet(){
  	
  }
  
  public void add(Article art){
  	clothes.add(art);
  }
  
  
}
