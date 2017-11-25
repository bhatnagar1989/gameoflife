package gameoflife;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class GridWithStartAndStopButtons {
   private static final int TIMER_DELAY = 200;
//   private int current_x;
//   private int current_y;
   private TestPane testPane = new TestPane();
   private Random random = new Random();
   private JButton startBtn = new JButton("Start");
   private JButton stopBtn = new JButton("Stop");
   private JPanel jpanel = new JPanel();
   private GameOfLife gol = new GameOfLife();
   private boolean stopnow = false;

   public GridWithStartAndStopButtons() {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            Container pane = frame.getContentPane();
            
            pane.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
            // !! frame.add(new TestPane());
            pane.add(testPane, BorderLayout.PAGE_START);
            
            JLabel jlabel = new JLabel("  ");
            startBtn.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		stopnow = false;
            		startGameOfLife();
            	}
            });
            stopBtn.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent e) {
            		stopnow = true;
            	}
            });
            
//            pane.add(jlabel, BorderLayout.CENTER);
            pane.add(startBtn, BorderLayout.LINE_START);
            pane.add(stopBtn, BorderLayout.LINE_END);
            //frame.add(jpanel); // !!
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
         }
      });
//      new Timer(TIMER_DELAY, new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent evt) {
//            current_x = random.nextInt(TestPane.MAX_X);
//            current_y = random.nextInt(TestPane.MAX_Y);
//            testPane.setGridX(current_x);
//            testPane.setGridY(current_y);
//            testPane.repaint();
//         }
//      }).start();
   }

   public void startGameOfLife() {
	   Thread worker = new Thread() {
		   public void run() {
		    
			   while (!stopnow) {
				   if (!stopnow) {
					   ArrayList<Cell> ng = gol.start(testPane.getSeed());
//					   for (int j=0;j<ng.size();j++) {
//						   System.out.println("newGen["+ng.get(j).x+","+ng.get(j).y+"]="+ng.get(j).isAlive);
//					   }
					   testPane.setSeed(ng);
					   try        
					   {
					       Thread.sleep(TIMER_DELAY);
					   } 
					   catch(InterruptedException ex) 
					   {
					       Thread.currentThread().interrupt();
					   }
				   }
			   }
		   }
		  };
		  
		  worker.start();
//	   for (int i=0;i<5;i++) {
//		   if (!stopnow) {
//			   ArrayList<Cell> ng = gol.start(testPane.getSeed());
//			   for (int j=0;j<ng.size();j++) {
//				   System.out.println("newGen["+ng.get(j).x+","+ng.get(j).y+"]="+ng.get(j).isAlive);
//			   }
//			   testPane.setSeed(ng);
//			   try        
//			   {
//			       Thread.sleep(500);
//			   } 
//			   catch(InterruptedException ex) 
//			   {
//			       Thread.currentThread().interrupt();
//			   }
////			   testPane.setSeed(ng);
//		   }
//	   }
   }
   
   
   public void updateGrid(ArrayList<Cell> ng) {
	   
   }
   
//   public void getCurrentValues(int x, int y) {
//      this.current_x = x;
//      this.current_y = y;
//   }

   public static void main(String[] args) {
      new GridWithStartAndStopButtons();
      
   }
}

class TestPane extends JPanel {
	
   public static final int MAX_X = 40;
   public static final int MAX_Y = MAX_X;
	Cell myseed[][] = new Cell[MAX_X][MAX_Y];
   private static final int CELL_WIDTH = 20;
   private static final int PREF_W = CELL_WIDTH * MAX_X;
   private static final int PREF_H = CELL_WIDTH * MAX_Y;
   private static final Color FILL_COLOR = Color.black;
   //private static final Color GRID_COLOR = Color.black;
   private int gridX = -1;
   private int gridY = -1;
   private Color defaultBackground;
   boolean state = false;

   public TestPane() {
	   for (int i=0;i<MAX_X; i++) {
		   for (int j=0;j<MAX_Y;j++) {
			   myseed[i][j] = new Cell(i,j,false);
		   }
		  
	   }

   		defaultBackground = getBackground();

        MatteBorder border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
   		this.setBorder(border);
   		
	   addMouseListener(new MouseAdapter() {
           @Override
           public void mouseEntered(MouseEvent e) {
//               
//               setBackground(Color.BLACK);
           }

           @Override
           public void mouseExited(MouseEvent e) {
//               setBackground(defaultBackground);
           }
           
           @Override
           public void mouseClicked(MouseEvent e) {
//        	   System.out.println(e.getX() + ","+e.getY());
        	   int x1 = (int)(e.getX()/CELL_WIDTH);
        	   int y1 = (int)(e.getY()/CELL_WIDTH);
        	   if(myseed[x1][y1].isAlive) {
        		   myseed[x1][y1].isAlive = false;
        	   }
        	   else {
        		   myseed[x1][y1].isAlive = true;
        	   }
//        	   setGridX(x1);
//               setGridY(y1);
               repaint();
           }
           
           
       });
   }
   
   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (int y = 0; y < MAX_Y; y++) {
         for (int x = 0; x < MAX_X; x++) {
//            
            if(myseed[x][y].isAlive) {
                g.setColor(FILL_COLOR);
                g.fillRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
            }
            else{
                g.setColor(defaultBackground);
                g.fillRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
            }
          g.setColor(Color.GRAY);
          g.drawRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
         }
      }
   }
   
   public void setSeed(ArrayList<Cell> newSeed) {

	   for (int y=0;y<MAX_Y;y++) {
		   for (int x=0;x<MAX_X;x++) {
			   myseed[x][y] = new Cell(x,y,false);		   }
	   }
	   for (int k=0; k<newSeed.size();k++) {
		   if(newSeed.get(k).x< MAX_X && newSeed.get(k).x>=0 && newSeed.get(k).y< MAX_Y && newSeed.get(k).y>=0) {
			   myseed[newSeed.get(k).x][newSeed.get(k).y] = newSeed.get(k);
		   }
	   }
//	   System.out.println("Setting new seed");
	   repaint();
	   updateUI();
   }
   
   public ArrayList<Cell> getSeed(){
	   ArrayList<Cell> seed = new ArrayList<Cell>();
	   for (int i=0;i<MAX_X; i++) {
		   for (int j=0; j<MAX_Y; j++) {
			   if(myseed[i][j].isAlive) {
				   seed.add(myseed[i][j]);
			   }
		   }
	   }
//	   for (int i=0; i<seed.size();i++) {
//
//    	   System.out.println("\nin get seed "+seed.get(i).x + "," + seed.get(i).y);
//	   }
	   return seed;
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public int getGridX() {
      return gridX;
   }

   public void setGridX(int gridX) {
      this.gridX = gridX;
   }

   public int getGridY() {
      return gridY;
   }

   public void setGridY(int gridY) {
      this.gridY = gridY;
   }
}