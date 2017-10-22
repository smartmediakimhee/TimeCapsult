package function;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MyWeather {

	public String getWeather() {
		MyLocation ml = new MyLocation();
		
		String location = ml.getLocation().split(" ")[0];
		System.out.println(location);
		String url = "http://www.kma.go.kr/weather/observation/currentweather.jsp"; 
		String weather = "";
		try {
			Document doc = Jsoup.connect(url).get();
			
			String[] info = doc.select("tbody>tr").text().split(" ");
			for (int i = 0; i < info.length; i++) {
				if(info[i].equals(location)) {
					weather = info[i+1];
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return weather;

	}

}
