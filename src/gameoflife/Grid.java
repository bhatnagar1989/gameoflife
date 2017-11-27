package gameoflife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Grid {

//    public static void main(String[] args) {
//        new Grid();
//    }

    public int rows = 16;
    public int cols = 16;
    JFrame frame;
    
    public Grid() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                frame = new JFrame("Game of Life");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                
                GridPane gp = new GridPane();
                
                
                frame.add(new GridPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
//                gp.addSeed(Pattern.StillLifes.getBlock());
            }
        });
    }
    
    
    
    public int getGridCenterX() {return (rows/2) - (rows/2)%1;}
    public int getGridCenterY() {return (cols/2) - (cols/2)%1;}

    public class GridPane extends JPanel {

    	ArrayList<CellPane> cp = new ArrayList<CellPane>();
    	
        public GridPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row <rows; row++) {
                for (int col = 0; col < cols; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane(row,col);
//                    JLabel jl = new JLabel(Integer.toString(col*row));
                    Border border = null;

                    border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    cellPane.setBorder(border);
//                    cellPane.setBackground(Color.BLUE);
                    cp.add(cellPane);
                    if (row==7 && col==7) {
                    	cellPane.setBackground(Color.BLUE);
                    	add(cellPane, gbc);
                    }
                    else {
                    	add(cellPane, gbc);
                    }
                    
                    Component[] components = this.getComponents();
//                    for ( int i=0; i<components.length; i++) {
//                    	CellPane c1 = (CellPane)components[i];
//                    	System.out.println(c1.row+","+c1.col+" = "+c1.state);
//                    }
                }
            }
        }
        
        public void addSeed(ArrayList<Cell> cells) {
        	for (int i=0; i< cp.size(); i++) {
        		CellPane cellPane = cp.get(i);
                cellPane.setBackground(Color.GRAY);
        	}
        	Component[] components = this.getComponents();
        	for (int i=0; i< cells.size(); i++) {
        		for (int j=0;j<components.length; j++) {
        			if(components[j] instanceof CellPane) {
        				CellPane mycp = (CellPane)components[j];
        				if (mycp.row==cells.get(i).x && mycp.col==cells.get(i).y) {
        					mycp.setBackground(Color.BLACK);
        					CellPane cellPane = new CellPane(cells.get(i).x,cells.get(i).y);
                            Border border = null;
                            border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                            cellPane.setBorder(border);
                            GridBagConstraints gbc = new GridBagConstraints();
                            gbc.gridx = cells.get(i).x;
                            gbc.gridy = cells.get(i).y;
                            cellPane.setBackground(Color.BLACK);
            				
            				components[j] = (Component)cellPane;
        				}
        			}
        		}
//        		int pos = cells.get(i).x * rows + cells.get(i).y;
//        		System.out.println(cells.get(i).x + "   " + cells.get(i).y + "pos =" + pos);
////        		CellPane c1 = (CellPane)components[pos];
////        		c1.setBackground(Color.BLACK);
////        		System.out.println(c1.row + "  " + c1.col);
//        		
////        		this.getComponents()[pos].revalidate();
//        		System.out.println(((CellPane)this.getComponents()[pos]).getBackground());
//        		System.out.println(pos);
//        		System.out.println(((CellPane)this.getComponents()[pos]).row + "," + ((CellPane)this.getComponents()[pos]).col);
////        		((CellPane)this.getComponents()[pos]).changeColor();
////        		cp.get(pos).setBackground(Color.BLACK);
////        		this.revalidate();
////        		this.repaint();
//        		remove(pos);
//        		((CellPane)this.getComponents()[pos]).changeColor();
        		CellPane cellPane = new CellPane(cells.get(i).x,cells.get(i).y);
                Border border = null;
                border = new MatteBorder(1, 1, 1, 1, Color.BLACK);
                cellPane.setBorder(border);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = cells.get(i).x;
                gbc.gridy = cells.get(i).y;
                cellPane.setBackground(Color.BLACK);
//
//                this.getComponents()[pos] = (Component) cellPane;
                this.revalidate();
                repaint();
//        		add(cellPane, gbc);
//        		this.revalidate();
//        		repaint();
                
//        		System.out.println(((CellPane)this.getComponents()[pos]).col);
//        		System.out.println(((CellPane)this.getComponents()[pos]).state);
//        		this.component
//        		System.out.println(Color.BLACK);
//        		c1.setBackground(Color.BLACK);
        	}
        }
    }

    public class CellPane extends JPanel {

        private Color defaultBackground;
        boolean state = false;
        public int row,col;

        public CellPane(int row, int col) {
        	this.row = row;
        	this.col = col;
        	defaultBackground = getBackground();
        	
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
//                    
//                    setBackground(Color.BLACK);
                }

                @Override
                public void mouseExited(MouseEvent e) {
//                    setBackground(defaultBackground);
                }
                
                @Override
                public void mouseClicked(MouseEvent e) {
                	if (state) {
                        setBackground(defaultBackground);
                        state = false;
                	}
                	else {
                		state = true;
                		setBackground(Color.BLACK);
                	}
                    int x=row;
                    int y=col;
                    System.out.println(x+","+y);//these co-ords are relative to the component
                }
                
                
            });
        }
        
        public void changeColor() {
        	if (state) {
                setBackground(defaultBackground);
                state = false;
        	}
        	else {
        		state = true;
        		setBackground(Color.BLACK);
        	}
        }

//        @Override
//        protected void paintComponent(Graphics g) {
//           super.paintComponent(g);
//           for (int y = 0; y < rows; y++) {
//              for (int x = 0; x < cols; x++) {
//                 if (x == row && y == col) {
//                	 if (state) {
////                         setBackground(defaultBackground);
//                         g.setColor(Color.BLACK);
//                         g.fillRect(0, 0, 50, 50);
//                         state = false;
//                 	}
//                 	else {
//                 		state = true;
////                 		setBackground(Color.BLACK);
//                        g.setColor(defaultBackground);
//                        g.fillRect(0, 0, 50, 50);
//                 	}
////                    g.setColor(Color.BLACK);
////                    g.fillRect(0, 0, 50, 50);
//                 }
//                 g.setColor(defaultBackground);
////                 g.drawRect(x * CELL_WIDTH, y * CELL_WIDTH, CELL_WIDTH, CELL_WIDTH);
//              }
//           }
//        }
        
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}