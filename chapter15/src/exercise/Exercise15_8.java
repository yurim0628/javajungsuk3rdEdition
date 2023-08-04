package exercise;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Exercise15_8 extends Frame {
    // GUI 컴포넌트들
    Button first = new Button("<<");
    Button prev = new Button("<");
    Button next = new Button(">");
    Button last = new Button(">>");
    Panel buttons = new Panel();
    TextArea ta = new TextArea();
    ArrayList<String> wordList = new ArrayList<>();
    final String WORD_FILE = "word_data.txt";
    final String CR_LF = System.getProperty("line.separator"); // 개행문자

    int pos = 0;

    WordStudy(String title) {
        super(title);
        buttons.add(first);
        buttons.add(prev);
        buttons.add(next);
        buttons.add(last);
        add("South", buttons);
        add("Center", ta);

        EventHandler handler = new EventHandler();
        addWindowListener(handler);
        first.addActionListener(handler);
        prev.addActionListener(handler);
        next.addActionListener(handler);
        last.addActionListener(handler);

        loadFile(WORD_FILE); // 단어 데이터 파일을 읽어와서 wordList에 저장

        setBackground(Color.BLACK);
        setSize(300, 200);
        setLocation(200, 200);
        setResizable(true);
        setVisible(true);

        showFirst(); // 프로그램 실행 시 첫 번째 단어를 화면에 표시
    }

    // 첫 번째 단어를 화면에 표시하는 메서드
    void showFirst() {
        pos = 0;
        display(pos);
    }

    // 이전 단어를 화면에 표시하는 메서드
    void showPrevious() {
        pos = (pos > 0) ? --pos : 0;
        display(pos);
    }

    // 다음 단어를 화면에 표시하는 메서드
    void showNext() {
        int size = wordList.size();
        pos = (pos < size - 1) ? ++pos : size - 1;
        display(pos);
    }

    // 마지막 단어를 화면에 표시하는 메서드
    void showLast() {
        pos = wordList.size() - 1;
        display(pos);
    }

    // 단어를 화면에 표시하는 메서드
    void display(int position) {
        String tmp = wordList.get(position);
        StringBuffer sb = new StringBuffer(tmp.length());
        StringTokenizer st = new StringTokenizer(tmp, "|");

        // '|'를 구분자로 잘라서 개행문자를 붙여서 StringBuffer에 추가
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken()).append(CR_LF);
        }

        // StringBuffer의 내용을 TextArea에 표시
        ta.setText(sb.toString());
    }

    // 파일을 읽어서 단어 목록을 ArrayList에 저장하는 메서드
    void loadFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";

            // 파일의 내용을 라인 단위로 읽어서 wordList에 저장
            while ((line = br.readLine()) != null) {
                wordList.add(line);
            }

            br.close();
        } catch (IOException e) {
            // 파일을 읽을 수 없을 때의 예외 처리
            System.out.println("데이터 파일을 읽을 수 없습니다.");
            System.exit(1);
        }
    }

    public static void main(String args[]) {
        WordStudy mainWin = new WordStudy("Word Study");
    }

    // 이벤트 핸들러 클래스
    class EventHandler extends WindowAdapter implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            // 버튼 클릭 이벤트 처리
            Button b = (Button) ae.getSource();

            if (b == first) {
                showFirst();
            } else if (b == prev) {
                showPrevious();
            } else if (b == next) {
                showNext();
            } else if (b == last) {
                showLast();
            }
        }

        public void windowClosing(WindowEvent e) {
            // 윈도우 창 닫기 이벤트 처리
            System.exit(0);
        }
    } // class EventHandler
}

