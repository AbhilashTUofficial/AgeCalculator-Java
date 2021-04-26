package com.age_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main extends JFrame implements ActionListener {
    JPanel window=new JPanel();
    JLabel startDate=new JLabel();
    JLabel startDateCheck=new JLabel();
    JLabel endDate=new JLabel();
    JLabel endDateCheck=new JLabel();
    JTextArea result=new JTextArea();
    String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
    JComboBox startMonth=new JComboBox(months);
    JComboBox endMonth=new JComboBox(months);
    JTextField startDay=new JTextField();
    JTextField endDay=new JTextField();
    JTextField startYear=new JTextField();
    JTextField endYear=new JTextField();
    JButton startCheckBtn=new JButton();
    JButton endCheckBtn=new JButton();
    JButton calculate=new JButton();
    Font font1=new Font("Arial",Font.BOLD,14);
    boolean readyToCalculate=false;
    SimpleDateFormat dateOfBirth = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat ageAt = new SimpleDateFormat("yyyy-MM-dd");

    Main(){
        setBounds(100,100,400,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new CardLayout());
        add(window());
        setVisible(true);
    }
    public JPanel window(){
        window.setBackground(Color.darkGray);
        window.setLayout(null);
        window.setBackground(Color.darkGray);

        startDate.setText("DATE OF BIRTH : ");
        startDate.setFont(font1);
        startDate.setForeground(Color.lightGray);
        startDate.setBounds(38,40,150,34);
        startDateCheck.setText("PENDING....");
        startDateCheck.setFont(font1);
        startDateCheck.setForeground(Color.lightGray);
        startDateCheck.setBounds(160,40,100,34);

        startMonth.setForeground(Color.darkGray);
        startMonth.setBounds(38,74,100,34);
        startDay.setForeground(Color.darkGray);
        startDay.setBounds(140,74,40,34);
        startDay.setHorizontalAlignment(JTextField.CENTER);
        startYear.setForeground(Color.darkGray);
        startYear.setBounds(182,74,80,34);
        startYear.setHorizontalAlignment(JTextField.CENTER);
        startCheckBtn.setText("Check");
        startCheckBtn.setBounds(264,74,80,34);
        startCheckBtn.setFocusable(false);
        startCheckBtn.addActionListener(this);

        endDate.setText("AGE AT THE DATE OF :");
        endDate.setFont(font1);
        endDate.setForeground(Color.lightGray);
        endDate.setBounds(38,110,160,34);
        endDateCheck.setText("PENDING....");
        endDateCheck.setFont(font1);
        endDateCheck.setForeground(Color.lightGray);
        endDateCheck.setBounds(200,110,100,34);

        endMonth.setForeground(Color.darkGray);
        endMonth.setBounds(38,144,100,34);
        endDay.setForeground(Color.darkGray);
        endDay.setBounds(140,144,40,34);
        endDay.setHorizontalAlignment(JTextField.CENTER);
        endYear.setForeground(Color.darkGray);
        endYear.setBounds(182,144,80,34);
        endYear.setHorizontalAlignment(JTextField.CENTER);
        endCheckBtn.setText("Check");
        endCheckBtn.setBounds(264,144,80,34);
        endCheckBtn.setFocusable(false);
        endCheckBtn.addActionListener(this);

        calculate.setText("Calculate");
        calculate.setBounds(38,190,306,32);
        calculate.setFocusable(false);
        calculate.addActionListener(this);

        result.setBounds(38,234,306,200);
        result.setForeground(Color.DARK_GRAY);
        result.setFont(font1);

        window.add(startDate);
        window.add(startDateCheck);
        window.add(startMonth);
        window.add(startDay);
        window.add(startYear);
        window.add(startCheckBtn);
        window.add(endDate);
        window.add(endDateCheck);
        window.add(endMonth);
        window.add(endDay);
        window.add(endYear);
        window.add(endCheckBtn);
        window.add(calculate);
        window.add(result);
        return window;
    }

    public void checkDate(SimpleDateFormat date){

    }
    public void calculate(){

    }
    public static void main(String[] args) {
	new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(readyToCalculate && e.getSource()==calculate){
            calculate();
        }
        if(e.getSource()==startCheckBtn){
        }
        if(e.getSource()==endCheckBtn){
            //checkDate();
        }
    }
}
