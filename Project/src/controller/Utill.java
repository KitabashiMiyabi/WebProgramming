package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utill {

	/**
	 * 文字列を日付に変更
	 * @param date
	 * @return
	 */
	public static Date convertDate(String date) {

		Date formatDate = null;

		// 変換対象の日付文字列
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		// Date型変換
		try {
			formatDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatDate;
	}

	/**
	 * 日付を文字列に変更
	 * @param date
	 * @return
	 */
	public static String convertStr(Date date) {
		 String str = new SimpleDateFormat("yyyy-MM-dd").format(date);
		 return str;
	}
}
