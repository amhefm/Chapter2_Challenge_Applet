package appletchallenge;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {

    private String name;
    private int x;
    private Thread thread;
    private boolean running;

    @Override
    public void init() {
        setSize(400, 200);
        setBackground(Color.BLACK);
        name = "EMRAN";   // <-- your name
        x = 0;
    }

    @Override
    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void stop() {
        running = false;
        thread = null;
    }

    @Override
    public void run() {
        while (running) {
            x += 10;

            if (x > getWidth()) {
                x = 0;
            }

            repaint();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // ignored
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString(name, x, 100);
    }
}
