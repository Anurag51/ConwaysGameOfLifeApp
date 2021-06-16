
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPaintDemo2 {


    public void main() {
      /* Runnable r= new Runnable() {
            public void run() {
                createAndShowGUI();
            }

        };
        SwingUtilities.invokeLater(r);*/

        createAndShowGUI();
    }

    private  void createAndShowGUI() {

        JFrame f = new JFrame("Conway's Game Of Life");
        f.setType(Window.Type.POPUP);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridCalculator gc = new GridCalculator(400);
        gc.playWithGrid();
        MyPanel pa=new MyPanel(gc.getGrid());
      //  pa.add(new MyButton());
        f.add(pa);
        f.pack();
        f.setVisible(true);
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i=0;
        while(i < 10000){
            gc.applyConwaysRuleToGrid();
            gc.moveGridToNextGeneration();
            pa.setGrid(gc.getGrid());
            pa.repaint();
            try {
                Thread.sleep(83l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}

class MyPanel extends JPanel {
    public void setGrid(byte[][] grid) {
        this.grid = grid;
    }

    byte grid[][];
    int bright=0;
    int dark=-765;
    boolean flip;
    int flipColors;

    int r,g,b;
    public MyPanel(byte[][] grid) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        //setBackground(new Color(10,2,10));
        setBackground(new Color(2,2,2));
        this.grid=grid;
       /* JButton b=new JButton();
        b.addActionListener(new
                             ActionListener() {
                                           public void actionPerformed (ActionEvent e){
                                        this..setText("Welcome to Javatpoint.");
                                           }
                                       });*/
    }

    public Dimension getPreferredSize() {
        return new Dimension(1500,600);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        // Draw Text

        for(int i =0 ; i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1) {
                    flipColors=  (flipColors+1)%255;
                    flipColors++;
                   /* if(flipColors) {
                        g.setColor(Color.yellow);
                    }else {
                        g.setColor(Color.ORANGE);
                    }*/
                   // graphics.setColor(new Color((flipColors*j)%219,(flipColors*i)%1,(flipColors*i)%1,255)); //Red
                   // graphics.setColor(new Color((flipColors*j)%221,(flipColors*i)%221,(flipColors*i)%1,255)); //Green
                   // graphics.setColor(new Color((flipColors*j)%1,(flipColors*i)%1,(flipColors*i)%251,255)); //Blue
                    //graphics.setColor(new Color((flipColors*j)%255,(flipColors*i)%255,(flipColors*i)%255,255)); //White
                    //graphics.setColor(new Color(245,245,245,205)); //WHITE
                  //if(j<251)
                /*  if(j%7==0 || i%7==0)
                  {
                      graphics.setColor(new Color(100, 100, 238, 250));
                  }else {
                      graphics.setColor(new Color(238, 0, 0, 250));
                  }*/
/*
                    if((j> grid.length/2-40 && j< grid.length/2+40)
                        ||(i> grid.length/2-40 && i< grid.length/2+40))
                    {
                        graphics.setColor(new Color(255, 0, 0, 250));
                    }else {
                        graphics.setColor(new Color(238, 238, 238, 250));
                    }*/

                    paintTriColor(i,j,graphics,grid.length);
                    graphics.fillOval(j*2, i*2, 2, 2);
                    if(flipColors%5000==0) increment();
                    //setBackground(new Color(bright));
                    //g.fill3DRect(i*2, j*2, 2, 2, true);
                }
            }
        }
        //g.draw3DRect(20,100,20,20,true);

    }

    private void increment() {
        if(bright==76500000){
            flip=true;
        }
        if(bright==0){
            flip=false;
        }
        if(flip){
            bright--;
        }else{
            bright++;
        }
    }

    private void paintTriColor(int i, int j , Graphics graphics,int size) {

        if (i < size - size * 0.66) {
            graphics.setColor(new Color(255, 100, 0, 250));
        } else if (i < size - size * 0.33) {
            graphics.setColor(Color.WHITE);
            if(j>size - size * 0.66 && j< size - size * 0.3  ) {
                graphics.setColor(new Color(0, 0, 255, 255));
            }
        } else {
            graphics.setColor(new Color(0, 100, 0, 255));
        }
    }
}