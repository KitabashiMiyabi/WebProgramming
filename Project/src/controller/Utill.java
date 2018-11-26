package controller;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

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

	public static String password(String password) {
		//ハッシュを生成したい元の文字列
		String source = password;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;

		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		//標準出力
		System.out.println(result);
		return result;


	}

}
