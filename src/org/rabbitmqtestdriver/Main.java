package org.rabbitmqtestdriver;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        java.awt.EventQueue.invokeLater(() -> {
            MainFrame mf = new MainFrame();
            centreWindow(mf);
            mf.setVisible(true);
        });
    }

    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
}
