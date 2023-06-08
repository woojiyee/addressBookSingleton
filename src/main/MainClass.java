package main;

import java.util.Scanner;

import dao.AddressDao;
import file.FileProc;

public class MainClass {

	public static void main(String[] args) {
		
		// 메뉴 //

		Scanner sc = new Scanner(System.in);
		
		AddressDao dao = new AddressDao();
		FileProc fp = new FileProc("addressbook");
		
		// file read 호출
		fp.read();
		
		// 메뉴 입력
		while(true) { // 대부분 무한루프 돌려 놓음, 몇번 입력받을지 모르니까
			boolean end = false;
			
			System.out.println("---address book menu------------");
			System.out.println("1.주소 추가"); // 전번 입력시 -말고 다른 걸로 써야 파일에서 데이터 불러와서 넣을 때 원하는 데로 들어감...
			System.out.println("2.주소 삭제");
			System.out.println("3.주소 검색");
			System.out.println("4.주소 수정");
			System.out.println("5.모두 출력");
			System.out.println("6.파일에 저장");
			System.out.println("7.종료");
			
			System.out.print("메뉴 입력 :");
			int menuNumber = sc.nextInt();
			
			switch(menuNumber) 
			{
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allDataPrint();
					break;
				case 6:
					fp.write();
					break;
				case 7:
					end = true;
					break;
			}
			
			if(end == true) break;
		}
	}

}
