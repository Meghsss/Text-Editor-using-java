import java.awt.Font;

public class FunctionFormat {
    GUI gui;
    Font arial,comicsansms,timesnewroman;
    String selectedfont;

    public FunctionFormat(GUI gui){
        this.gui=gui;
    }
    public void wordwrap(){
        gui.wordwrapOn = !gui.wordwrapOn; // Toggle the flag

    if (gui.wordwrapOn) {
        gui.textArea.setLineWrap(true);
        gui.textArea.setWrapStyleWord(true);
        gui.iWrap.setText("Word Wrap: On");
    } else {
        gui.textArea.setLineWrap(false);
        gui.textArea.setWrapStyleWord(false);
        gui.iWrap.setText("Word Wrap: Off");
    }
    }
    public void createFont(int fontsize){
        arial= new Font("Arial",Font.PLAIN,fontsize);
        comicsansms= new Font("Comic Sans Ms",Font.PLAIN,fontsize);
        timesnewroman= new Font("Times New Roman",Font.PLAIN,fontsize);

        setFont(selectedfont);
    }
    public void setFont(String font){
        selectedfont=font;
        switch(selectedfont){
            case "Arial":
             gui.textArea.setFont(arial);
             break;
            case "Comic Sans MS":
             gui.textArea.setFont(comicsansms);
             break;
            case "Times New Roman":
             gui.textArea.setFont(timesnewroman);
             break;
        }
    }
}
