package StudentSwingQuestion;

public class Student {
	String name,usn,address,category;
	int age;
	float cgpa;
	
	public Student(String name, String usn, String address, String category, int age, float cgpa) {
		super();
		this.name = name;
		this.usn = usn;
		this.address = address;
		this.category = category;
		this.age = age;
		this.cgpa = cgpa;
	}

	public String toString() {
		return "Student [name=" + name + ", usn=" + usn + ", address=" + address + ", category=" + category + ", age="
				+ age + ", cgpa=" + cgpa + "]";
	}
}