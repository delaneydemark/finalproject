import java.util.ArrayList;

public class Article{
    private String category;
    private String size;
    private ArrayList<String> color;
    private double price;
    private ArrayList<String> occassion;
    private ArrayList<String> dates;
    private String brand;
    private String material;
    private String fileName;

    public Article(String f, String s, String c, String p, String o, String d,
		   String b, String m){
	filename = f;
	size = s;
	category = c;
	price = Double.parseDouble(p);
	brand = b;
	material = m;
	
    }
}
