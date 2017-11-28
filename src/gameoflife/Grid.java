package gameoflife;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class Grid {
	
   private static final int TIMER_DELAY = 100; //Speed of iterations
   private boolean stopnow = false;
   
   private GridPane gridPane = new GridPane();
   private GameOfLife gol = new GameOfLife();
   public int tickCount = 0;
   private Pattern patterns;
   
   //Initialing form elements
   private JButton startBtn = new JButton("Start");
   private JButton stopBtn = new JButton("Stop");
   private String[] golPatterns= new String[] {"Select Pattern","Block", "Beehive", 
											   "Loaf","Boat","Tub","Blinker","Toad",
											   "Beacon","Pentadecathlon","Glider","LWSS"};
   private JComboBox<String> patternsList = new JComboBox<>(golPatterns);
   private JLabel genCountLabel ;
   

   public Grid() {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }
            JFrame frame = new JFrame("Game of Life"); //title of the frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());
            Container pane = frame.getContentPane();
            
            pane.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
            
            genCountLabel = new JLabel("Generation");
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
            patterns = new Pattern((int)(gridPane.MAX_X/2), (int)(gridPane.MAX_Y/2));
            ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
                @Override
                public void actionPerformed(ActionEvent e) {

                	String selectedPattern = (String) patternsList.getSelectedItem();//get the selected item
                	tickCount = 0;
                	genCountLabel.setText("Generation: "+tickCount);
                	gridPane.setSeed(new ArrayList<Cell>());
                    switch (selectedPattern) {//check for a matching pattern and call there respective functions from Class Pattern
                        case "Block":
                        	gridPane.setSeed(patterns.getBlock());
                            break;
                        case "Beehive":
                        	gridPane.setSeed(patterns.getBeehive());
                            break;
                        case "Loaf":
                        	gridPane.setSeed(patterns.getLoaf());
                            break;
                        case "Boat":
                        	gridPane.setSeed(patterns.getBoat());
                            break;
                        case "Tub":
                        	gridPane.setSeed(patterns.getTub());
                            break;
                        case "Blinker":
                        	gridPane.setSeed(patterns.getBlinker());
                            break;
                        case "Toad":
                        	gridPane.setSeed(patterns.getToad());
                            break;
                        case "Beacon":
                        	gridPane.setSeed(patterns.getBeacon());
                            break;
                        case "Pentadecathlon":
                        	gridPane.setSeed(patterns.getPentadecathlon());
                            break;
                        case "Glider":
                        	gridPane.setSeed(patterns.getGlider());
                            break;
                        case "LWSS":
                        	gridPane.setSeed(patterns.getLWSS());
                            break;
                    }//end switch Pattern
                }
            }; //end ActionListener

            patternsList.addActionListener(cbActionListener);
            
//Adding and setting postions of the different elements in the Frame
            pane.add(gridPane, BorderLayout.NORTH);
            pane.add(genCountLabel, BorderLayout.SOUTH);
            pane.add(startBtn, BorderLayout.WEST);
            pane.add(stopBtn, BorderLayout.EAST);
            pane.add(patternsList, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
         }
      });
   }

   public void startGameOfLife() {
	   Thread worker = new Thread() {
		   public void run() {
		    
			   //check if stop button isn't pressed, if not then continue the iterations
			   while (!stopnow) {
				   if (!stopnow) {
					   ArrayList<Cell> ng = gol.evolve(gridPane.getSeed());
					   gridPane.setSeed(ng);
					   tickCount++;
					   genCountLabel.setText("Generation: "+tickCount); //Update Counter 
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
   }

   public static void main(String[] args) {
      new Grid();
      
   }
}

class GridPane extends JPanel {
	
	//Set frame and grid drawing parameters
	   public static final int MAX_X = 40;
	   public static final int MAX_Y = MAX_X;
	   Cell seed[][] = new Cell[MAX_X][MAX_Y];
	   private static final int CELL_WIDTH = 20;
	   private static final int PREF_W = CELL_WIDTH * MAX_X;
	   private static final int PREF_H = CELL_WIDTH * MAX_Y;
	   private static final Color FILL_COLOR = Color.black;
	   private Color defaultBackground;
	
	
	/*
	** function GridPane() takes the size of rows and columns defined above and draws
	** the grid taking in count the dimensions of the cells, with the default background. 
	** It also makes the border of the cell's with a black colour.
	*/
	
	   public GridPane() {
		   for (int i=0;i<MAX_X; i++) {
			for (int j=0;j<MAX_Y;j++) {
				seed[i][j] = new Cell(i,j,false);
			}end for j
		   }//end for i
	
	   	defaultBackground = getBackground();
	
	        MatteBorder border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
	   	this.setBorder(border);
	   		
		   addMouseListener(new MouseAdapter() {
	           @Override
	           public void mouseClicked(MouseEvent e) {
	        	   int x1 = (int)(e.getX()/CELL_WIDTH);
	        	   int y1 = (int)(e.getY()/CELL_WIDTH);
	        	   if(seed[x1][y1].isAlive) {
	        		   seed[x1][y1].isAlive = false;
	        	   }
	        	   else {
	        		   seed[x1][y1].isAlive = true;
	        	   }
	        	   System.out.println("["+x1+","+y1+"]");
	               repaint();
	           }
	       });
	   }
	
	/*
	** function paintComponent changes the colour according to the state of the cell.
	** It checks if cell is alive, then change colour to Black otherwise let it be
	** the Default Colour.
	*/
	   
	   @Override
	   protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      for (int y = 0; y < MAX_Y; y++) {
	         for (int x = 0; x < MAX_X; x++) {  
	            if(seed[x][y].isAlive) {
	                g.setColor(FILL_COLOR);
	                g.fillRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
	            }
	            else{
	                g.setColor(defaultBackground);
	                g.fillRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
	            }//end if..
	          g.setColor(Color.GRAY);
	          g.drawRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
	         }//end for x
	      }//end for y
	   }//end func..
	
	
	/*
	** function setSeed gets the new list of new generation.
	** It moves the cell according to change in the state of the Cells.
	** Moreover it also flipover the cells if the pattern grows outside 
	** the Set frame size.
	*/
	   
	   public void setSeed(ArrayList<Cell> newSeed) {
	
		   for (int y=0;y<MAX_Y;y++) {
			for (int x=0;x<MAX_X;x++) {
				seed[x][y] = new Cell(x,y,false);		   
			}//end for x
		   }//end for y
		   
		   for (int k=0; k<newSeed.size();k++) {
			   int x1 = Math.abs(newSeed.get(k).x) % MAX_X;
			   int y1 = Math.abs(newSeed.get(k).y) % MAX_Y;
			   
			   seed[x1][y1] = newSeed.get(k);
		   }//end for k
		   repaint(); //repaint's the grid with new generation
		   updateUI();
	   }//end func..
	   
	   public ArrayList<Cell> getSeed(){
		   ArrayList<Cell> temp = new ArrayList<Cell>();
		   for (int i=0;i<MAX_X; i++) {
			   for (int j=0; j<MAX_Y; j++) {
				   if(seed[i][j].isAlive) {
					   temp.add(seed[i][j]);
				   }
			   }
		   }
		   return temp;
	   }
	
	   @Override
	   public Dimension getPreferredSize() {
	      return new Dimension(PREF_W, PREF_H);
	   }

}
