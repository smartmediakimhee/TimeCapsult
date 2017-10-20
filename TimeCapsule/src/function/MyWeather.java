package function;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MyWeather {

	public String getWeather(String loc) {
		
		String url = "http://www.kma.go.kr/weather/observation/currentweather.jsp"; 
		String weather = "";
		try {
			Document doc = Jsoup.connect(url).get();
			
			String[] info = doc.select("tbody>tr").text().split(" ");
			
			for (int i = 0; i < info.length; i++) {
				if(info[i].equals(loc)) {
					weather = info[i+1];
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return weather;

	}

}
