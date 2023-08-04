package exercise;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Exercise15_6 {
    static String[] argArr; // 입력한 매개변수를 담기위한 문자열배열
    static File curDir; // 현재 디렉토리

    static {
        try {
            curDir = new File(System.getProperty("user.dir"));
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print(curDir.getCanonicalPath() + ">>"); // 현재 디렉토리 경로 출력

            String input = s.nextLine();
            input = input.trim(); // 입력받은 값에서 불필요한 앞뒤 공백을 제거한다.
            argArr = input.split(" +"); // 입력받은 명령어와 매개변수를 분리하여 배열로 저장

            if (argArr.length == 0) {
                continue; // 입력된 명령어가 없으면 다시 입력 받는다.
            }

            String command = argArr[0].toLowerCase(); // 명령어를 소문자로 바꾼다.

            if (command.equals("q")) {
                // "q" 또는 "Q"를 입력하면 프로그램을 종료한다.
                System.exit(0);
            } else if (command.equals("cd")) {
                // "cd" 명령어를 입력하면 현재 디렉토리를 변경하는 메서드를 호출한다.
                cd();
            } else {
                // 그 외의 명령어는 임시적으로 간단하게 출력한다.
                for (int i = 0; i < argArr.length; i++) {
                    System.out.println(argArr[i]);
                }
            }
        } // while(true)
    } // main

    public static void cd() {
        if (argArr.length == 1) {
            // "cd" 명령어만 입력된 경우 현재 디렉토리를 출력한다.
            System.out.println(curDir);
            return;
        } else if (argArr.length > 2) {
            // "cd" 명령어 다음에 인자가 2개 이상인 경우 사용 방법을 출력한다.
            System.out.println("USAGE : cd directory");
            return;
        }

        String subDir = argArr[1];

        if ("..".equals(subDir)) {
            // "cd .."인 경우 현재 디렉토리의 부모 디렉토리로 이동한다.
            File newDir = curDir.getParentFile();

            if (newDir == null) {
                System.out.println("Invalid directory.");
            } else {
                curDir = newDir;
            }
        } else if (".".equals(subDir)) {
            // "cd ."인 경우 현재 디렉토리를 그대로 유지하고 경로를 출력한다.
            System.out.println(curDir);
        } else {
            // 그 외의 경우 입력된 디렉토리(subDir)가 현재 디렉토리의 하위 디렉토리인지 확인한다.
            File newDir = new File(curDir, subDir);

            if (newDir.exists() && newDir.isDirectory()) {
                // 디렉토리가 존재하고 디렉토리인 경우 현재 디렉토리를 변경한다.
                curDir = newDir;
            } else {
                System.out.println("Invalid directory.");
            }
        }
    } // cd()
}

