package ch13pc08;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author Frank
 */
public class MainForm extends JFrame {
    //fields
    private final int width = 500;
    private final int height = 300;
    private final int generalRegistrationFee = 895;
    private final int studentRegistrationFee = 495;
    private final int dinnerFee = 30;
    private final int eCommerceFee = 295;
    private final int futureFee = 295;
    private final int advancedFee = 395;
    private final int networkFee = 395;
    
    //menu components
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitItem;
    
    //components for the main form
    private JPanel registrationPanel, openingPanel, preconferencePanel, calculationPanel;
    private JLabel lblTotal, lblBlank;
    private JTextField txtTotal;
    private JButton btnTotal;
    private JRadioButton optGeneral, optStudent;
    private ButtonGroup registrationGroup;
    private JCheckBox chkDinner, chkEcommerce, chkFuture, chkAdvanced, chkNetwork;
    
    public MainForm() {
        //set the Title
        this.setTitle("Conference Registration System");
        
        //set default close operations, minimum size, and resizability
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(width, height));
        this.setResizable(true);
        this.setLayout(new GridLayout(1, 4));
        
        //build components
        buildMenuBar();
        buildRegistrationPanel();
        buildOpeningPanel();
        buildPreconferencePanel();
        buildCalculationPanel();
        
        this.add(registrationPanel);
        this.add(openingPanel);
        this.add(preconferencePanel);
        this.add(calculationPanel);
        
        //pack and display the window
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void buildMenuBar() {
        //create the menubar
        menuBar = new JMenuBar();
        
        //create the menus
        //create menu items
        exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new exitListener());
        
        //create a JMenu object for the File Menu
        fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(exitItem);
                
        //add menus to the menu bar
        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
                
        //set the window's menu bar
        setJMenuBar(menuBar);
    }
    
    //methods
    private void buildRegistrationPanel() {
        registrationPanel = new JPanel(new GridLayout(2, 1));
        registrationPanel.setBorder(BorderFactory.createTitledBorder("Select from the following:"));
        
        optGeneral = new JRadioButton("General Admission");
        optGeneral.setMnemonic(KeyEvent.VK_G);
        optGeneral.setSelected(true);
        
        optStudent = new JRadioButton("Student Admission");
        optStudent.setMnemonic(KeyEvent.VK_S);
        
        registrationGroup = new ButtonGroup();
        registrationGroup.add(optGeneral);
        registrationGroup.add(optStudent);
        
        registrationPanel.add(optGeneral);
        registrationPanel.add(optStudent);
    }
    
    private void buildOpeningPanel() {
        openingPanel = new JPanel(new BorderLayout());
        openingPanel.setBorder(BorderFactory.createTitledBorder("Attend the Opening Dinner and Keynote Address?"));
        
        chkDinner = new JCheckBox("Optional Dinner");
        
        openingPanel.add(chkDinner);
    }
    
    private void buildPreconferencePanel() {
        preconferencePanel = new JPanel(new GridLayout(4, 1));
        preconferencePanel.setBorder(BorderFactory.createTitledBorder("Attend Preconference Workshopts?"));
        
        chkEcommerce = new JCheckBox("Introduction to E-commerce");
        chkFuture = new JCheckBox("The Future of the Web");
        chkAdvanced = new JCheckBox("Advanced Java Programming");
        chkNetwork = new JCheckBox("Network Security");
        
        preconferencePanel.add(chkEcommerce);
        preconferencePanel.add(chkFuture);
        preconferencePanel.add(chkAdvanced);
        preconferencePanel.add(chkNetwork);
    }
    
    private void buildCalculationPanel() {
        calculationPanel = new JPanel(new GridLayout(4, 2));
        
        //add components
        btnTotal = new JButton("Calculate Total");
        btnTotal.addActionListener(new totalListener());
        
        lblBlank = new JLabel();
        lblTotal = new JLabel("Total Price: ");
        
        txtTotal = new JTextField(15);
        txtTotal.setEditable(false);
        txtTotal.setText("$0.00");
        
        calculationPanel.add(btnTotal);
        calculationPanel.add(lblBlank);
        calculationPanel.add(lblBlank);
        calculationPanel.add(lblBlank);
        calculationPanel.add(lblBlank);
        calculationPanel.add(lblBlank);
        calculationPanel.add(lblTotal);
        calculationPanel.add(txtTotal);
    }
    
    
    //inner classes
    /**
     * private inner class that handles the event generated when the user
     * selects Exit from the File Menu
     */
    private class exitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    /**
     * private inner class that handles the event generated when the user
     * selects the Total Button
     */
    private class totalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int total = 0;
            
            if (optGeneral.isSelected())
                total += generalRegistrationFee;
            if (optStudent.isSelected())
                total += studentRegistrationFee;
            if (chkDinner.isSelected())
                total += dinnerFee;
            if (chkEcommerce.isSelected())
                total += eCommerceFee;
            if (chkFuture.isSelected())
                total += futureFee;
            if (chkAdvanced.isSelected())
                total += advancedFee;
            if (chkNetwork.isSelected())
                total += networkFee;
            
            txtTotal.setText("$" + total + ".00");
        }
    }
}