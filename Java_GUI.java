package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.*;
import java.util.ArrayList;


public class Java_GUI extends BackendMethods implements ActionListener { 

    private static JFrame frame;
    private static JPanel pannel;
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JTextField userText;
    private static JPasswordField passwordField;
    private static JButton button;
    private static JButton registerButton;
    private static JLabel success;
    public static String[] userAndPass = new String[2];

    public Java_GUI(){
        frame = new JFrame();
        pannel = new JPanel(); 
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(pannel);

        pannel.setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        pannel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        pannel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        pannel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        pannel.add(passwordField);

        button = new JButton("Login");
        button.setBounds(100, 80, 80, 25);
        button.addActionListener(this);
        pannel.add(button);

        registerButton = new JButton("Sign up");
        registerButton.setBounds(180, 80, 80, 25);
        registerButton.addActionListener(this);
        pannel.add(registerButton);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        pannel.add(success);
        success.setText("");

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            userAndPass[0] = actionPerformedUser(e);
            userAndPass[1] = actionPerformedPassword(e);
            BackendMethods appMethods = new BackendMethods();
        if(appMethods.tryToLogin(userAndPass[0], userAndPass[1], appMethods.getUrl(), appMethods.getAdmin(), appMethods.getPasskey()) == true){
            success.setText("You entered your account!");
        }
        else if(userAndPass[0].equals("") || userAndPass[1].equals("")){
            success.setText("Username and password fields are obligatory");
        }
        else{
            success.setText("Username or password are incorrect");
        }
        }
        if(e.getSource() == registerButton){
            Java_Register_Gui javaRegGui = new Java_Register_Gui();
        }
    }
    
    public String actionPerformedUser(ActionEvent e){
        String[] userTextArray = userText.getText().split("");
        if(userTextArray[userTextArray.length - 1].equals(" ")){
            String userTextFinal = userText.getText().substring(0, userText.getText().length() - 1);
            return userTextFinal;
        }
        return userText.getText();
    }
    public String actionPerformedPassword(ActionEvent e){
        return passwordField.getText();
    }

    
}
