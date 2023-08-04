package exercise;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

class Exercise15_7 extends Frame {
    String nickname = "";
    TextArea ta = new TextArea();
    Panel p = new Panel();
    TextField tf = new TextField(30);
    Button bSave = new Button("저장");

    Exercise15_7(String nickname) {
        super("채팅");
        this.nickname = nickname;
        setBounds(200, 100, 300, 200);

        p.setLayout(new FlowLayout());
        p.add(tf);
        p.add(bSave);

        add(ta, "Center");
        add(p, "South");

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0); // 창을 닫으면 프로그램을 종료
            }
        });
    }

    EventHandler handler = new EventHandler();
    ta.addFocusListener(handler);
    tf.addFocusListener(handler);
    tf.addActionListener(handler);

    ta.setText("#" + nickname + "님 즐거운 채팅되세요.");
    ta.setEditable(false);
    setResizable(false);
    setVisible(true);
    tf.requestFocus();
}

bSave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
        FileDialog fileSave = new FileDialog(Exercise15_7.this, "파일 저장", FileDialog.SAVE);
        fileSave.setVisible(true);
        String fileName = fileSave.getDirectory() + fileSave.getFile();
        saveAs(fileName); // 파일 저장 기능 실행
        }
        });

        void saveAs(String fileName) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
        fw = new FileWriter(fileName);
        bw = new BufferedWriter(fw);

        // TextArea의 내용을 파일에 저장한다.
        bw.write(ta.getText());
        } catch (IOException ie) {
        ie.printStackTrace();
        } finally {
        try {
        if (bw != null)
        bw.close();
        } catch (IOException e) {}
        }
        }

public static void main(String[] args) {
        if (args.length != 1) {
        System.out.println("USAGE: java Exercise15_7 NICKNAME");
        System.exit(0);
        }

        new Exercise15_7(args[0]);
        }

class EventHandler extends FocusAdapter implements ActionListener {
    public void actionPerformed(ActionEvent ae) {
        String msg = tf.getText();
        if ("".equals(msg))
            return;

        ta.append("\r\n" + nickname + "> " + msg); // 메시지를 TextArea에 추가
        tf.setText(""); // 입력 필드 초기화
    }

    public void focusGained(FocusEvent e) {
        tf.requestFocus(); // 입력 필드에 포커스 설정
    }
}
