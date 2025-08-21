package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.DeptIdReader;
import jp.co.sss.crud.io.EmployeeNameReader;

/**
 * 社員管理システム実行用クラス
 */
public class MainSystem01NonValid {

	/**
	 * メイン処理01
	 * 
	 * <p>メニュー表示から社員削除機能までを実装し、このクラスで呼び出す。
	 * 
	 * <p>BufferedReaderを用いてコンソールから必要な項目を入力する。
	 * 入力結果に基づいてEmployeeDAOからメソッドを呼び出し、処理を行う。
	 * 参照系機能のメソッドを呼び出す場合は戻り値のエンティティリストを受け取り、
	 * mainメソッド内でデータ表示を行う。
	 * 
	 * {@code 
	 * 	List<Hoge> list = xxxDAO.find();
	 * 		for(Hoge hoge : list){
	 * 			System.out.println(hoge);
	 * 		}
	 * }
	 * 
	 * 例外処理はExceptionをキャッチする
	 * 	"システムエラーが発生しました"と出力し、スタックトレースを出力する。
	 * 	その後、ループを抜けてシステムを終了する。
	 *
	 */
	public static void main(String[] args) {
		//コンソール入力準備
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//エンティティ
		Employee employee = new Employee();
		Department department = new Department();

		//データベースアクセス
		EmployeeDAO employeeDAO = new EmployeeDAO();

		int menuNo = 0;
		try {
			do {
				// メニューの表示
				System.out.println("=== 社員管理システム ===");
				System.out.println("1. 全件表示");
				System.out.println("2. 社員名検索");
				System.out.println("3. 部署ID検索");
				System.out.println("4. 登録");
				System.out.println("5. 更新");
				System.out.println("6. 削除");
				System.out.println("7. 終了");
				System.out.print("メニュー番号を入力してください:");

				// メニュー番号の入力
				String menuNoStr = br.readLine();
				menuNo = Integer.parseInt(menuNoStr);
				
				// 機能の呼出
				switch (menuNo) {
				case 1:
					System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
					//TODO 以下に実装する
					List<Employee> employees = employeeDAO.findAll();
					for (Employee emp:employees) {
						System.out.println(emp);
					}
					break;

				case 2:
					System.out.print("社員名を入力してください:");
					//TODO 以下に実装する
					EmployeeNameReader empname=new EmployeeNameReader();
					String str;
					str=empname.input();
					List<Employee>es = employeeDAO.findByEmployeeName(str);
					if(es.isEmpty()) {
						System.out.println("該当する社員は存在しません。");
					} else {
						System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
						for (Employee emp:es) {
							System.out.println(emp);
						}
					}
					
					break;

				case 3:
					System.out.print("部署ID(1：営業部、2：経理部、3：総務部)を入力してください: ");
					//TODO 以下に実装する
					DeptIdReader eIR = new DeptIdReader();
					int id = eIR.input();
					List<Employee> list = employeeDAO.findByDeptId(id);
					if(list.isEmpty()) {
						System.out.println("該当する社員は存在しません。");
					} else {
						System.out.println("社員ID\t社員名\t性別\t生年月日\t部署名");
						for (Employee emp:list) {
							System.out.println(emp);
						}
					}
					

					break;

				case 4:
					//TODO 以下に実装する
					employeeDAO.insert(employee);

					break;

				case 5:
					//TODO 以下に実装する

					employeeDAO.update(employee);

					break;

				case 6:
					//TODO 以下に実装する

					System.out.print("削除する社員の社員IDを入力してください:");
					
					int eId=Integer.parseInt(br.readLine());
					employeeDAO.delete(eId);

					break;

				}
			} while (menuNo != 7);
		} catch (Exception e) {
			//TODO 以下に実装する
		}
		System.out.println("システムを終了します。");
	}

}
