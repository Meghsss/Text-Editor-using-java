import java.awt.Color;

public class functionColor {
    GUI gui;
    public functionColor(GUI gui){
        this.gui=gui;
    }
    public void changeColor(String color){
        switch(color){
            case "Red":
             gui.window.getContentPane().setBackground(Color.RED);
             gui.textArea.setBackground(Color.RED);
             gui.textArea.setForeground(Color.BLACK);
             break;
            case "Black":
             gui.window.getContentPane().setBackground(Color.BLACK);
             gui.textArea.setBackground(Color.BLACK);
             gui.textArea.setForeground(Color.WHITE);
             break;
            case "Blue":
             gui.window.getContentPane().setBackground(Color.BLUE);
             gui.textArea.setBackground(Color.BLUE);
             gui.textArea.setForeground(Color.WHITE);
             break;
            case "White":
             gui.window.getContentPane().setBackground(Color.white);
             gui.textArea.setBackground(Color.white);
             gui.textArea.setForeground(Color.black);
             break;
             
        }
    }
}
