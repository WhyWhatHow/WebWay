package demo.StuManager.domain;

import java.sql.Date;

public class Student {

	private int sid;
	private String name;
	private String gender;
	private String address;
	private String tel;
	private String hobby;
	private String info;
	private Date birthday;

	public Student(int sid, String name, String gender, String address, String tel, String hobby, String info,
			Date birthday, int age) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
		this.hobby = hobby;
		this.info = info;
		this.birthday = birthday;
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	private int age;

	public Student() {
		super();
	}


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", gender=" + gender + ", address=" + address + ", tel=" + tel
				+ ", hobby=" + hobby + ", info=" + info + ", age=" + age + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
