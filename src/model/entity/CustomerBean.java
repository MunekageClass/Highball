package model.entity;

import java.io.Serializable;

public class CustomerBean implements Serializable {

	/**
	 * 顧客ID
	 */
	private int customer_id;

	/**
	 * 顧客名称
	 */
	private String customer_name;

	/**
	 * 顧客名称かな
	 */
	private String customer_name_kana;

	/**
	 * 郵便番号
	 */
	private String postal_code;

	/**
	 * 所在地
	 */
	private String address;

	/**
	 * 地区コード
	 */
	private String area_code;

	/**
	 * 地区名
	 */
	private String area_name;

	/**
	 * 担当者名
	 */
	private String contact_person_name;

	/**
	 * 担当者名かな
	 */
	private String contact_person_name_kana;

	/**
	 * 担当者電話番号
	 */
	private String contact_person_tel;

	/**
	 * ユーザID
	 */
	private String user_id;

	/**
	 * 更新日時
	 */
	private String updatetime;

	/**
	 * パスワード
	 */
	private String password;

	/**
	 * ユーザ名
	 */
	private String user_name;

	public CustomerBean() {

	}


	public int getCm_id() {
		return customer_id;
	}

	public void setCm_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCm_name() {
		return customer_name;
	}

	public void setCm_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCm_name_kana() {
		return customer_name_kana;
	}

	public void setCm_name_kana(String customer_name_kana) {
		this.customer_name_kana = customer_name_kana;
	}

	public String getPt_code() {
		return postal_code;
	}

	public void setPt_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getCt_person_name() {
		return contact_person_name;
	}

	public void setCt_person_name(String contact_person_name) {
		this.contact_person_name = contact_person_name;
	}

	public String getCt_person_name_kana() {
		return contact_person_name_kana;
	}

	public void setCt_person_name_kana(String contact_person_name_kana) {
		this.contact_person_name_kana = contact_person_name_kana;
	}

	public String getCt_person_tel() {
		return contact_person_tel;
	}

	public  void setCt_person_tel(String contact_person_tel) {
		this.contact_person_tel = contact_person_tel;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getPassword() {
		return password;
	}

	public void  setPassword(String password) {
		this.password = password;
	}

	public  String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}