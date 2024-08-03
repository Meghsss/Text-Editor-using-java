import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GUI implements ActionListener{
    JFrame window;

    //TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordwrapOn= false;
    // TOP MENU BAR
    JMenuBar menuBar;
    JMenu Filemenu,editmenu,formatmenu,colormenu;
    //FILE MENU
    JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
    // EDIT MENU
    JMenuItem iUndo,iRedo;
    // FORMAT MENU
    JMenuItem iWrap,ifontArial,ifontCSMS,ifontTNR,ifontsize8,ifontsize12,ifontsize16,ifontsize20,ifontsize24,ifontsize28;
    JMenu menufont,menufontSize;
    // COLOR MENU
    JMenuItem icolor1,icolor2,icolor3,icolor4;


    FunctionFile file= new FunctionFile(this);
    FunctionFormat format=new FunctionFormat(this);
    functionColor color=new functionColor(this);
    functionedit edit=new functionedit(this);

    UndoManager um=new UndoManager();
    public static void main(String[] args) {
        new GUI();
    }
    public GUI(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();

        format.selectedfont="Arial";
        format.createFont(16);
        format.wordwrap();
        color.changeColor("White");

        window.setVisible(true);
    }
    public void createWindow(){
        window=new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea(){
        textArea=new JTextArea();
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent e ){
                um.addEdit(e.getEdit());
            }
        });
        scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    public void createMenuBar(){
        menuBar=new JMenuBar();
        window.setJMenuBar(menuBar);

        Filemenu=new JMenu("File");
        menuBar.add(Filemenu);

        editmenu=new JMenu("Edit");
        menuBar.add(editmenu);

        formatmenu=new JMenu("Format");
        menuBar.add(formatmenu);
        
        colormenu=new JMenu("Color");
        menuBar.add(colormenu);
    }
    public void createFileMenu(){
        iNew=new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        Filemenu.add(iNew);

        iOpen=new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        Filemenu.add(iOpen);

        iSave=new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        Filemenu.add(iSave);

        iSaveAs=new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        Filemenu.add(iSaveAs);

        iExit=new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        Filemenu.add(iExit);
    }
    public void createEditMenu(){
        iUndo=new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        editmenu.add(iUndo);

        iRedo=new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        editmenu.add(iRedo);
    }
    public void createFormatMenu(){
        iWrap=new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        formatmenu.add(iWrap);

        menufont=new JMenu("Font");
        formatmenu.add(menufont);

        ifontArial=new JMenuItem("Arial");
        ifontArial.addActionListener(this);
        ifontArial.setActionCommand("Arial");
        menufont.add(ifontArial);

        ifontCSMS=new JMenuItem("Comic Sans MS");
        ifontCSMS.addActionListener(this);
        ifontCSMS.setActionCommand("Comic Sans MS");
        menufont.add(ifontCSMS);

        ifontTNR=new JMenuItem("Times New Roman");
        ifontTNR.addActionListener(this);
        ifontTNR.setActionCommand("Times New Roman");
        menufont.add(ifontTNR);


        menufontSize=new JMenu("Font Size");
        formatmenu.add(menufontSize);

        ifontsize8 =new JMenuItem("8");
        ifontsize8.addActionListener(this);
        ifontsize8.setActionCommand("size8");
        menufontSize.add(ifontsize8);

        ifontsize12 =new JMenuItem("12");
        ifontsize12.addActionListener(this);
        ifontsize12.setActionCommand("size12");
        menufontSize.add(ifontsize12);

        ifontsize16=new JMenuItem("16");
        ifontsize16.addActionListener(this);
        ifontsize16.setActionCommand("size16");
        menufontSize.add(ifontsize16);

        ifontsize20=new JMenuItem("20");
        ifontsize20.addActionListener(this);
        ifontsize20.setActionCommand("size20");
        menufontSize.add(ifontsize20);

        ifontsize24=new JMenuItem("24");
        ifontsize24.addActionListener(this);
        ifontsize24.setActionCommand("size24");
        menufontSize.add(ifontsize24);

        ifontsize28 =new JMenuItem("28");
        ifontsize28.addActionListener(this);
        ifontsize28.setActionCommand("size28");
        menufontSize.add(ifontsize28);

    }
    public void createColorMenu(){
        icolor1=new JMenuItem("Red");
        icolor1.addActionListener(this);
        icolor1.setActionCommand("Red");
        colormenu.add(icolor1);

        icolor2=new JMenuItem("Blue");
        icolor2.addActionListener(this);
        icolor2.setActionCommand("Blue");
        colormenu.add(icolor2);

        icolor3=new JMenuItem("Black");
        icolor3.addActionListener(this);
        icolor3.setActionCommand("Black");
        colormenu.add(icolor3);

        icolor4=new JMenuItem("White");
        icolor4.addActionListener(this);
        icolor4.setActionCommand("White");
        colormenu.add(icolor4);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        switch(command){
            case "New": file.newFile();
            break;
            case "Open": file.openFile();
            break;
            case "Save": file.saveFile();
            break;
            case "SaveAs": file.filesaveAS();
            break;
            case "Exit": file.fileExit();
            break;
            case "Undo": edit.undo();
            break;
            case "Redo": edit.redo();
            break;
            case "Word Wrap": format.wordwrap();
            break;
            case "Arial": format.setFont(command);
            break;
            case "Comic Sans MS": format.setFont(command);
            break;
            case "Times New Roman": format.setFont(command);
            break;
            case "size8": format.createFont(8);
            break;
            case "size12": format.createFont(12);
            break;
            case "size16": format.createFont(16);
            break;
            case "size20": format.createFont(20);
            break;
            case "size24": format.createFont(24);
            break;
            case "size28": format.createFont(28);
            break;
            case "Red": color.changeColor(command);
            break;
            case "Blue": color.changeColor(command);
            break;
            case "Black": color.changeColor(command);
            break;
            case "White": color.changeColor(command);
            break;
        }
    }
}