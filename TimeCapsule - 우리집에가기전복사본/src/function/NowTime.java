package function;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class NowTime {
	
	public String getTime() {
		String time_url = "http://ko.thetimenow.com/south_korea";
		String date_url = "http://ko.todaysdate365.com/getdate.php?lang=ko";
		
		String result_time ="";
		String result_date ="";
		
		try {
			Document doc_time = Jsoup.connect(time_url).get();
			result_time = doc_time.select("span#main_time").text();


			Document doc_date = Jsoup.connect(date_url).get();
			String[] date = doc_date.select("li+li+li").text().split("/");
			result_date = date[0]+"-"+date[1]+"-"+date[2]; 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result_date+" "+result_time;
	}

}
