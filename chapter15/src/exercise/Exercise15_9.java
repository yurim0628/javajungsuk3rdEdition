package exercise;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Exercise15_9 extends Frame {
    String fileName;
    TextArea content;
    MenuBar mb;
    Menu mFile;
    MenuItem miNew, miOpen, miSaveAs, miExit;

    Exercise15_9(String title) {
        super(title);

        content = new TextArea();
        add(content);

        // 메뉴바와 메뉴들을 생성
        mb = new MenuBar();
        mFile = new Menu("파일");
        miNew = new MenuItem("새로 만들기");
        miOpen = new MenuItem("열기");
        miSaveAs = new MenuItem("다른 이름으로 저장");
        miExit = new MenuItem("종료");

        // 메뉴 아이템들을 메뉴에 추가
        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSaveAs);
        mFile.addSeparator(); // 메뉴 분리선(separator)을 넣는다.
        mFile.add(miExit);

        // 메뉴를 메뉴바에 추가
        mb.add(mFile);

        // 메뉴바를 프레임에 설정
        setMenuBar(mb);

        // 메뉴 아이템에 이벤트 핸들러 등록
        MyHandler handler = new MyHandler();
        miNew.addActionListener(handler);
        miOpen.addActionListener(handler);
        miSaveAs.addActionListener(handler);
        miExit.addActionListener(handler);

        setSize(300, 200);
        setVisible(true);
    }

    // 선택된 파일의 내용을 읽어서 TextArea에 보여주는 메서드
    void fileOpen(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        StringWriter sw = null;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            sw = new StringWriter();

            String line = "";

            // 파일을 라인 단위로 읽어 StringWriter에 추가한다.
            while ((line = br.readLine()) != null) {
                sw.write(line);
                sw.write('\n'); // 개행문자를 출력한다.
            }

            // TextArea에 StringWriter의 내용을 표시한다.
            content.setText(sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {}
        }
    }

    // TextArea의 내용을 지정된 파일에 저장하는 메서드
    void saveAs(String fileName) {
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            // BufferedWriter와 FileWriter를 생성한다.
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);

            // TextArea에 있는 내용을 가져와서 BufferedWriter에 출력한다.
            bw.write(content.getText());
        } catch (IOException ie) {
            ie.printStackTrace();
        } finally {
            try {
                // BufferedWriter를 닫는다.
                if (bw != null)
                    bw.close();
            } catch (IOException e) {}
        }
    }

    public static void main(String args[]) {
        Exercise15_9 mainWin = new Exercise15_9("텍스트 에디터");
    }

    // 메뉴를 클릭했을 때 메뉴별 처리코드
    class MyHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("새로 만들기")) {
                // "새로 만들기"를 선택한 경우, TextArea를 비운다.
                content.setText("");
            } else if (command.equals("열기")) {
                // "열기"를 선택한 경우, FileDialog를 열어 파일을 선택하고 해당 파일의 내용을 표시한다.
                FileDialog fileOpen = new FileDialog(Exercise15_9.this, "파일 열기");
                fileOpen.setVisible(true);
                fileName = fileOpen.getDirectory() + fileOpen.getFile();

                // 선택된 파일의 내용을 TextArea에 보여준다.
                fileOpen(fileName);
            } else if (command.equals("다른 이름으로 저장")) {
                // "다른 이름으로 저장"을 선택한 경우, FileDialog를 열어 파일을 선택하고 TextArea의 내용을 해당 파일에 저장한다.
                FileDialog fileSave = new FileDialog(Exercise15_9.this, "파일 저장", FileDialog.SAVE);
                fileSave.setVisible(true);
                fileName = fileSave.getDirectory() + fileSave.getFile();

                // 현재 TextArea의 내용을 선택된 파일에 저장한다.
                saveAs(fileName);
            } else if (command.equals("종료")) {
                // "종료"를 선택한 경우, 프로그램을 종료시킨다.
                System.exit(0);
            }
        }
    } // class MyHandler
} // Exercise15_9 클래스의 끝

