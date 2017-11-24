package gameoflife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class Grid {

    public static void main(String[] args) {
        new Grid();
    }

    public Grid() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Game of Life");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new GridPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class GridPane extends JPanel {

    	ArrayList<CellPane> cp = new ArrayList<CellPane>();
    	
        public GridPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < 16; row++) {
                for (int col = 0; col < 16; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane(row,col);
                    Border border = null;
//                    if (row < 4) {
//                        if (col < 4) {
//                            border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
//                        } else {
//                            border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
//                        }
//                    } else {
//                        if (col < 4) {
//                            border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
//                        } else {
//                            border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
//                        }
//                    }
                    border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                    Component[] components = this.getComponents();
//                    for ( int i=0; i<components.length; i++) {
//                    	CellPane c1 = (CellPane)components[i];
//                    	System.out.println(c1.row+","+c1.col+" = "+c1.state);
//                    }
                }
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

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}