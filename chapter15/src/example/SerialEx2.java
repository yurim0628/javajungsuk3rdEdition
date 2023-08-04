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

public class SerialEx2 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);

			ObjectInputStream in = new ObjectInputStream(bis);

			// 객체를 역직렬화하여 읽어오기
			UserInfo u1 = (UserInfo) in.readObject(); // 파일로부터 읽어온 UserInfo 객체 u1
			UserInfo u2 = (UserInfo) in.readObject(); // 파일로부터 읽어온 UserInfo 객체 u2
			ArrayList list = (ArrayList) in.readObject(); // 파일로부터 읽어온 ArrayList<UserInfo>

			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
} // class