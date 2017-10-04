package Business.Utils;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import userinterface.Mainframe;

public class InactivityListener extends JFrame implements
        AWTEventListener {

    private long[] events = {
        AWTEvent.FOCUS_EVENT_MASK,
        AWTEvent.INPUT_METHOD_EVENT_MASK,
        AWTEvent.ITEM_EVENT_MASK,
        AWTEvent.KEY_EVENT_MASK,
        AWTEvent.MOUSE_EVENT_MASK,
        AWTEvent.MOUSE_MOTION_EVENT_MASK,
        AWTEvent.MOUSE_WHEEL_EVENT_MASK,
        AWTEvent.PAINT_EVENT_MASK,
        AWTEvent.TEXT_EVENT_MASK
    };

    private Toolkit kit;

    private int count = 0;
    private volatile boolean running = true;
    JPanel upc;

    public InactivityListener(JPanel userprocessContainer) {

        this.upc = userprocessContainer;
        kit = Toolkit.getDefaultToolkit();

    }

    public void eventDispatched(AWTEvent awte) {
        count = 0;
    }

    public void start() {

        for (int i = 0; i < events.length; i++) {
            kit.addAWTEventListener(this, events[i]);
        }
        JPanel blankJP = new JPanel();
        new Thread(new Runnable() {
            public void run() {
                while (running) {
                    if (count++ == 1000) {
                        Component[] componentArray = upc.getComponents();
                        Component component = componentArray[componentArray.length - 1];

                        if (!(component == blankJP)) {
                            JOptionPane.showMessageDialog(null, "Please LogOut and Login again!! Your Session has been expired!!");
                            upc.removeAll();
                            upc.add("blank", blankJP);
                            CardLayout crdLyt = (CardLayout) upc.getLayout();
                            crdLyt.next(upc);
                        }

                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ie) {
                        System.err.println(ie.getMessage());
                    }
                }
            }
        }).start();

    }

}
