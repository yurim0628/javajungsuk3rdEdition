package exercise;

import java.awt.*;
import java.awt.event.*;

/* Exercise 7-28. 아래의 EventHandler를 익명클래스(anonymous class)로 변경하시오. */
class Exercise7_28 {
    public static void main(String[] args) {
        Frame f = new Frame();
//		f.addWindowListener(new EventHandler());
        f.addWindowListener(new WindowAdapter() {
                                public void windowClosing(WindowEvent e) {
                                    e.getWindow().setVisible(false);
                                    e.getWindow().dispose();
                                    System.exit(0);
                                }
                            }	// 익명클래스 끝
        );
    }
}

class EventHandler extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        e.getWindow().setVisible(false);
        e.getWindow().dispose();
        System.exit(0);
    }
}
