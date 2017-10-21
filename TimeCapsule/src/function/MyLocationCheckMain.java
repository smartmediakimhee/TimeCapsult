package function;
public class MyLocationCheckMain {

	public static void main(String[] args) {
		MyLocation ml = new MyLocation();
		String location = ml.getLocation();
		//접속한 지역의 시정보 반환하는 메소드 : 광주 남구 송하동
		
		String city = location.split(" ")[0];
		//주소 중에 "시" 정보만 반환 : 광주
		
		MyWeather mw = new MyWeather();
		System.out.println(mw.getWeather());
		//"시" 정보 전달하면 해당 시의 날씨를 String 타입으로 반환 : 구름조금
		
		NowTime nt = new NowTime();
		System.out.println(nt.getTime());
		//"현재" 시각을 인터넷을 통해 받아오기 
		
	}

}
