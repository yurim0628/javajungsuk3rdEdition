package example;

import java.io.*;
import java.util.ArrayList;

// 사용자 정보를 저장하는 클래스
class UserInfo implements Serializable {
	private String username; // 사용자 이름
	private String password; // 비밀번호
	private int age; // 나이

	// 생성자
	public UserInfo(String username, String password, int age) {
		this.username = username;
		this.password = password;
		this.age = age;
	}

	// Getter, Setter 메서드 (생략)

	// toString 메서드 (생략)
}

public class SerialEx1 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			ObjectOutputStream out = new ObjectOutputStream(bos);

			UserInfo u1 = new UserInfo("JavaMan", "1234", 30);
			UserInfo u2 = new UserInfo("JavaWoman", "4321", 26);

			ArrayList<UserInfo> list = new ArrayList<>();
			list.add(u1);
			list.add(u2);

			// 객체를 직렬화하여 파일에 저장
			out.writeObject(u1); // UserInfo 객체 u1을 직렬화하여 저장
			out.writeObject(u2); // UserInfo 객체 u2를 직렬화하여 저장
			out.writeObject(list); // ArrayList<UserInfo> 객체를 직렬화하여 저장

			out.close();
			System.out.println("객체를 파일에 저장하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // main
} // class
