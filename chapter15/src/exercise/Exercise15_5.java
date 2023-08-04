package exercise;

import java.io.*;
class Exercise15_5 {
    public static void main(String[] args) {
        // 커맨드 라인에서 원본 HTML 파일 이름과 제거된 태그가 저장될 파일 이름을 인자로 받는다.
        if (args.length != 2) {
            System.out.println("USAGE: java Exercise15_5 TARGET_FILE SOURCE_FILE");
            System.exit(0);
        }
        String inputFile = args[1]; // 입력으로 받은 원본 HTML 파일 이름
        String outputFile = args[0]; // 입력으로 받은 제거된 태그가 저장될 파일 이름

        try (BufferedReader input = new BufferedReader(new FileReader(inputFile));
             HtmlTagFilterWriter output = new HtmlTagFilterWriter(new FileWriter(outputFile))) {

            int c;
            while ((c = input.read()) != -1) {
                output.write(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class HtmlTagFilterWriter extends FilterWriter {
    StringWriter tmp = new StringWriter(); // 태그 안에 있는 문자열을 임시로 저장할 StringWriter
    boolean inTag = false; // 현재 태그 안에 있는지 여부를 나타내는 플래그

    HtmlTagFilterWriter(Writer out) {
        super(out);
    }

    public void write(int c) throws IOException {
        // 현재 문자가 '<'이면, 태그가 시작되었음을 표시하기 위해 inTag 값을 true로 설정한다.
        if (c == '<') {
            inTag = true;
        }
        // 현재 문자가 '>'이고, 이전에 '<'가 나왔다면, 태그가 끝났음을 표시하기 위해 inTag 값을 false로 설정한다.
        else if (c == '>' && inTag) {
            inTag = false;
            tmp = new StringWriter(); // StringWriter 초기화 (이전에 저장한 태그 내용을 버린다)
            return; // 빈 StringWriter를 반환하고 더 이상 처리하지 않는다.
        }

        if (inTag) {
            // 태그 내에 있는 문자는 StringWriter에 저장한다.
            tmp.write(c);
        } else {
            // 태그 밖에 있는 문자는 기반 스트림을 통해 출력한다.
            out.write(c);
        }
    }

    public void close() throws IOException {
        // StringWriter에 저장된 태그를 기반 스트림을 통해 출력한다.
        out.write(tmp.toString());
        super.close(); // 기반 스트림을 닫는다.
    }
}

