package function;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MyLocation {
	private String[] location = new String[3];
	public String getLocation() {
		 try {
			Document doc = Jsoup.connect("http://mylocation.co.kr/").get();
			
			location = doc.select("span#txtAddr").text().split(" ");
								
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return location[0]+" "+location[1]+" "+location[2];
	}

}
