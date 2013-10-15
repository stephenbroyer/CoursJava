package Flickr;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class LoadImageApp extends Component {
    BufferedImage img;
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    public LoadImageApp(String server, String id, String secret) {
        try {
            URL url = new URL("http://static.flickr.com/"+server+"/"+id+"_"+secret+".jpg");
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100,100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }
    public static void main(String[] args) {
        JFrame f = new JFrame("Load Image Sample");
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //f.add(new LoadImageApp());
        //f.pack();
        //f.setVisible(true);
    }
}