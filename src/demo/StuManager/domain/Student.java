	package demo.StuManager.domain;

public class Student {

	private int sid ;
	private String name ;
	private String gender ;
	private String address; 
	private String tel; 
	private int age;
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", gender=" + gender + ", address=" + address + ", tel=" + tel
				+ ", age=" + age + "]";
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(int sid, String name, String gender, String address, String tel, int age) {
		super();
		this.sid = sid;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
		this.age = age;
	}
	public Student() {
		super();
	}
	
	
}
