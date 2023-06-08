package dto;

// DTO(Data Transfer Object) == VO(Value Object) : 값을 담아서 배포하는 오브젝트
public class AddressDto {

	// 서류철에서 한개의 데이터
	
	// column ( 항목 )
	private String name;
	private int age;
	private String phone;
	private String address;
	private String memo;
	
	// template ( 형태 ) // 지금 이 파일이 Dto의 기본 템플릿
	public AddressDto() {
		// TODO Auto-generated constructor stub
	}

	public AddressDto(String name, int age, String phone, String address, String memo) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.memo = memo;
	}

	public String getName() { // 검색 시, 이름으로만 검색할 경우 쓰임
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Override
	public String toString() {
		return "AddressDto [name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + ", memo="
				+ memo + "]";
	}
	
	public String print() {
		return  name + "-" + age + "-" + phone + "-" + address + "-"+ memo ;
	}
	
}
