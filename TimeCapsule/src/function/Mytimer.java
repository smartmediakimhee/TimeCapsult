package function;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mytimer {
	
	private DateFormat dateToStringFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
	private SimpleDateFormat stringToDateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

	// String exstr = "2017-10-19 12:27:10";
	private double time;

	
	public boolean isOpen(Date nowDate, Date setDate) {
		time = (nowDate.getTime() - setDate.getTime()) / 60000.0;
		if (time > 0) {
			return true;
		} else {
			return false;
		}
	}

	// �����ð� ���ڿ��� ����
	public String howOpen(Date nowDate, Date setDate) {
		time = (setDate.getTime() - nowDate.getTime()) / 1000;
		String str = "";

		if (time > 0) {
			if (time <= 60) {
				str = time + " ��";
			} else if (time / 60 <= 60) {
				str = (int) time / 60 + "��" + (int) time % 60 + "��";
			} else if (time / 3600 <= 24) {
				str = (int) time / 3600 + "�ð�" + (int) time % 3600 / 60 + "��";
			} else {
				str = (int) time / (3600 * 24) + "��" + (int) time % (3600 * 24) / 3600 + "�ð�";
			}
		} else {
			str = "OPEN!";
		}
		return str;
	}

	public String dateToString(Date getDate) {
		String str = dateToStringFormat.format(getDate);
		return str;
	}

	public Date stringToDate(String getStr) throws ParseException {
		Date date = stringToDateFormat.parse(getStr);
		return date;
	}
}
