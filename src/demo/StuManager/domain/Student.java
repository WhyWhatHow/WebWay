package demo.StuManager.domain;

import java.util.Date;

public class Student {

	private int sid;
	private String sname;
	private String gender;
	private String address;
	private String tel;
	private String hobby;
	private String info;
	private Date birthday;
	private int  age ;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", address=" + address + ", tel="
				+ tel + ", hobby=" + hobby + ", info=" + info + ", birthday=" + birthday + ", age=" + age + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String sname, String gender, String address, String tel, String hobby, String info,
			Date date, int age) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
		this.hobby = hobby;
		this.info = info;
		this.birthday = date;
		this.age = age;
	}
	

}
