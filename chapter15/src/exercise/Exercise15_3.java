package exercise;

import java.io.*;

public class Exercise15_3 {
    static int totalFiles = 0; // 총 파일 개수를 저장하는 변수
    static int totalDirs = 0; // 총 디렉토리 개수를 저장하는 변수
    static int totalSize = 0; // 총 파일 크기를 저장하는 변수

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("USAGE: java DirectoryInfoTest DIRECTORY");
            System.exit(0);
        }

        File dir = new File(args[0]); // 입력으로 받은 디렉토리 이름으로 File 객체 생성

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory: " + args[0]);
            System.exit(0);
        }

        countFiles(dir); // 디렉토리 탐색 및 파일 정보 계산 수행

        System.out.println();
        System.out.println("Total " + totalFiles + " files");
        System.out.println("Total " + totalDirs + " directories");
        System.out.println("Total size: " + totalSize + " bytes");
    }

    public static void countFiles(File dir) {
        File[] files = dir.listFiles(); // 디렉토리의 파일과 디렉토리 목록을 얻어온다.

        if (files == null) {
            return; // 디렉토리에 접근 권한이 없을 경우 null이 반환될 수 있으므로 처리합니다.
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                // 현재 파일이 디렉토리인 경우
                totalDirs++; // 총 디렉토리 개수를 증가시킨다.
                countFiles(files[i]); // 재귀적으로 해당 디렉토리의 파일과 디렉토리를 탐색한다.
            } else {
                // 현재 파일이 일반 파일인 경우
                totalFiles++; // 총 파일 개수를 증가시킨다.
                totalSize += files[i].length(); // 파일 크기를 총 파일 크기에 더한다.
            }
        }
    }
}
