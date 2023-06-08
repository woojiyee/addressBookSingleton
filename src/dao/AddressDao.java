package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.standard.Sides;

import dto.AddressDto;
import singleton.Singleton;

// DAO(Data Access Object) 
public class AddressDao {

	// 데이터를 다루는 클래스, 데이터를 편집하는 클래스, 데이터에 접근하는 클래스
	
	// composition : 클래스 안에서 다른 클래스를 생성해서 씀..(상속은 아님)
	Scanner sc = new Scanner(System.in);

	
	
	public AddressDao() {
	}
	
	
	public void insert() {
		System.out.println("데이터를 추가합니다.");
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		// 주소엔 띄어쓰기가 존재 -> Scanner는 띄어쓰기에서 끊어짐? 인식안 됨 -> BufferedReader 이용해야함
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 파일 말고도 문장 입출력 시 사용
		System.out.print("주소 : ");
		String address = "";
		try {
			address = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("메모 : ");
		String memo = "";
		try {
			memo = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Singleton s = Singleton.getInstance();
		s.addressList.add(new AddressDto(name, age,phone,address,memo));
	}
	
	//TODO: delete // todo를 주석으로 작성하명 우측 스크롤에 책갈피마냥 뜸 -> 스크롤서 투두표시 호버하면 해당 투두 주석 확인 가능
	public void delete() { // 숫자 ->0, 문자열 -? ""  / 걍 null로 바꿔줘도 되긴 함
						   // select를 갖고 있어야 할거임
		
		System.out.println("데이터를 삭제합니다.");
				
		System.out.print("삭제할 이름 : ");
		String name = sc.next();
		
		Singleton s = Singleton.getInstance();
		for(int i = 0; i < s.addressList.size(); i++) {
			if(s.addressList.get(i).getName().equals(name)) { // 리스트 요소 삭제를 remove를 하면 해당 요소가 삭제되고 뒤에 있던 요소들이 땡겨지니까 빈 요소가 안 생김
															// + 리스트.size()만큼 돌리니 존재하는 요소만큼 for문이 돌아감
															// -> addressList.get(i) != null을 확인 안 해도 됨
				s.addressList.remove(i);
				break; // 동명이인 다 안지우고 처음 데이터만 삭제
			}
		}
		
	}
	
	public void select() { // 이름으로 검색
//		int searchIndex[] = new int[COUNT];
//		int count = 0;
		
		System.out.println("데이터를 검색합니다.");
		
		System.out.print("검색할 이름 : ");
		String name = sc.next();
		
		Singleton s = Singleton.getInstance();
		for(int i = 0; i < s.addressList.size(); i++) {
			if(s.addressList.get(i) != null && s.addressList.get(i).getName().equals(name)) {
//				searchIndex[count] = i;
//				count++;
				System.out.println(s.addressList.get(i).toString());
			}
		}
		
		
	}

	public void update() { //select를 갖고 있어야 할거임
		
		System.out.println("데이터를 수정합니다.");
		
		System.out.print("수정할 데이터의 이름 : ");
		String name = sc.next();
		
		int index = 0;
		
		Singleton s = Singleton.getInstance();
		for(int i = 0; i < s.addressList.size(); i++) {
			if(s.addressList.get(i) != null && s.addressList.get(i).getName().equals(name)) {
				index = i; // 이래 하면 해당 이름이 addressList에 없었을 때 삭제가 안 된 안내멘트를 못 날림
				break;
			}
		}
		
		while(true) {
			System.out.println("수정 가능한 메뉴");
			System.out.println("1.나이");
			System.out.println("2.전화번호");
			System.out.println("3.주소");
			System.out.println("4.메모");
			
			System.out.print("수정할 정보 번호 입력 :");
			int menu = sc.nextInt();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			switch(menu) 
			{
				case 1: // 나이
					System.out.print("나이 : ");
					s.addressList.get(index).setAge(sc.nextInt());
					break;
				case 2: // 전화번호
					System.out.print("전화번호 : ");
					s.addressList.get(index).setPhone(sc.next());
					break;
				case 3: // 주소
					System.out.print("주소 : ");
					try {
						s.addressList.get(index).setAddress(br.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 4: // 메모
					System.out.print("메모 : ");
					try {
						s.addressList.get(index).setMemo(br.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
			}
			
			System.out.print("수정을 계속 하시겠습니까? (y/n)");
			String ing = sc.next();
			
			if(ing.equals("n"))break;
		}
	}
	
	// 확인용 (원래 dao 기본 템플릿 메소드는 아님..?)
	public void allDataPrint() {
		
		Singleton s = Singleton.getInstance();
		if(s.addressList.isEmpty()) { // addressList.size() == 0
			System.out.println("데이터가 없습니다.");
			return;
		}
		for (int i = 0; i < s.addressList.size(); i++) {
				System.out.println(s.addressList.get(i).toString());
		}
		
	}

}
