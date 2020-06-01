package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.CustomerBean;


public class CustomerDAO {

	/**
	 * 顧客情報一覧表示メソッド
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CustomerBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<CustomerBean> customerList = new ArrayList<CustomerBean>();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_customer")) {

			// 結果の操作
			while (res.next()) {

				int customer_id = res.getInt("customer_id");
				String customer_name = res.getString("customer_name");
				String customer_name_kana = res.getString("customer_name_kana");
				String postal_code = res.getString("postal_code");
				String address = res.getString("address");
				String area_code = res.getString("area_code");
				String contact_person_name = res.getString("contact_person_name");
				String contact_person_name_kana = res.getString("contact_person_name_kana");
				String contact_person_tel = res.getString("contact_person_tel");
				String user_id = res.getString("user_id");




				CustomerBean ct = new CustomerBean();
				ct.setCm_id(customer_id);
				ct.setCm_name(customer_name);
				ct.setCm_name_kana(customer_name_kana);
				ct.setPt_code(postal_code);
				ct.setAddress(address);
				ct.setArea_code(area_code);
				ct.setCt_person_name(contact_person_name);
				ct.setCt_person_name_kana(contact_person_name_kana);
				ct.setCt_person_tel(contact_person_tel);
				ct.setUser_id(user_id);


				customerList.add(ct);
			}
		}
		return customerList;
	}

	public List<CustomerBean> login(String user_id, String password)
			throws SQLException, ClassNotFoundException {

		CustomerBean cb = new CustomerBean();

		List<CustomerBean> userList = new ArrayList<CustomerBean>();

		String sql = "SELECT * FROM m_user WHERE user_id = ? AND password = ?";
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// プレースホルダへの値の設定
			pstmt.setString(1, user_id);
			pstmt.setString(2, password);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			// 結果の操作
			while (res.next()) {
				cb.setUser_id(res.getString("user_id"));
				cb.setPassword(res.getString("password"));
				cb.setUser_name(res.getString("user_name"));

				userList.add(cb);
			}
		}
		return userList;
	}

	/**
	 * 顧客情報編集メソッド
	 * @param customer
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int update(CustomerBean customer) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE m_customer SET customer_name = ?, customer_name_kana = ?, postal_code = ?, address = ?, area_code = ?, contact_person_name = ?, contact_person_name_kana = ?,"
				+ "contact_person_tel = ?, user_id = ? WHERE customer_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String customer_name = customer.getCm_name();
			String customer_name_kana = customer.getCm_name_kana();
			String postal_code = customer.getPt_code();
			String address = customer.getAddress();
			String area_code = customer.getArea_code();
			String contact_person_name = customer.getCt_person_name();
			String contact_person_name_kana = customer.getCt_person_name_kana();
			String contact_person_tel = customer.getCt_person_tel();
			String user_id = customer.getUser_id();
			int customer_id = customer.getCm_id();


			// プレースホルダへの値の設定
			pstmt.setString(1, customer_name);
			pstmt.setString(2, customer_name_kana);
			pstmt.setString(3, postal_code);
			pstmt.setString(4, address);
			pstmt.setString(5, area_code);
			pstmt.setString(6, contact_person_name);
			pstmt.setString(7, contact_person_name_kana);
			pstmt.setString(8, contact_person_tel);
			pstmt.setString(9, user_id);
			pstmt.setInt(10, customer_id);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}

	/**
	 * 顧客情報登録メソッド
	 * @param customer
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int insert(CustomerBean customer) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "INSERT INTO m_customer(customer_name, customer_name_kana, postal_code, address, area_code, contact_person_name, contact_person_name_kana, contact_person_tel, user_id) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String customer_name = customer.getCm_name();
			String customer_name_kana = customer.getCm_name_kana();
			String postal_code = customer.getPt_code();
			String address = customer.getAddress();
			String area_code = customer.getArea_code();
			String contact_person_name = customer.getCt_person_name();
			String contact_person_name_kana = customer.getCt_person_name_kana();
			String contact_person_tel = customer.getCt_person_tel();
			String user_id = customer.getUser_id();


			// プレースホルダへの値の設定
			pstmt.setString(1, customer_name);
			pstmt.setString(2, customer_name_kana);
			pstmt.setString(3, postal_code);
			pstmt.setString(4, address);
			pstmt.setString(5, area_code);
			pstmt.setString(6, contact_person_name);
			pstmt.setString(7, contact_person_name_kana);
			pstmt.setString(8, contact_person_tel);
			pstmt.setString(9, user_id);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}

	public int delete(CustomerBean customer) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "DELETE FROM m_customer WHERE customer_id = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			int customer_id = customer.getCm_id();


			// プレースホルダへの値の設定
			pstmt.setInt(1, customer_id);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}

	/**
	 * 地区マスタの情報を取得
	 * @return areaList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CustomerBean> selectArea()
			throws SQLException, ClassNotFoundException {

		List<CustomerBean> areaList = new ArrayList<CustomerBean>();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_area")) {

			// 結果の操作
			while (res.next()) {

				String area_code = res.getString("area_code");
				String area_name = res.getString("area_name");

				CustomerBean ct = new CustomerBean();
				ct.setArea_code(area_code);
				ct.setArea_name(area_name);

				areaList.add(ct);
			}
		}
		return areaList;
	}

	/**
	 * ユーザマスタの情報を取得
	 * @return userList
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<CustomerBean> selectUser()
			throws SQLException, ClassNotFoundException {

		List<CustomerBean> userList = new ArrayList<CustomerBean>();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_user")) {

			// 結果の操作
			while (res.next()) {

				String user_id = res.getString("user_id");
				String user_name = res.getString("user_name");

				CustomerBean ct = new CustomerBean();

				ct.setUser_id(user_id);
				ct.setUser_name(user_name);


				userList.add(ct);
			}
		}
		return userList;
	}

}