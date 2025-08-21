package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 部署IDのコンソール入力をするクラス
 */
public class DeptIdReader {

	/**
	 * @return inputNumber コンソール入力された整数値を返す
	 * @throws IOException 不正な状態の場合にスローされる
	 * @throws IllegalArgumentException 不正な入力の場合にスローされる
	 */
	public Integer input() throws IOException, IllegalArgumentException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int id = Integer.parseInt(reader.readLine());
		return id;
	}

	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {
		return false;//1-3までの整数かどうかをチェック
	}

}
