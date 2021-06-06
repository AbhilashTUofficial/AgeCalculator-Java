package com.age_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

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
    SimpleDateFormat dateOfBirth = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat ageAt = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat thisDay=new SimpleDateFormat("d");
    SimpleDateFormat thisMonth=new SimpleDateFormat("M");
    SimpleDateFormat thisYear=new SimpleDateFormat("y");


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
        endMonth.setSelectedIndex(Integer.parseInt(thisMonth.format(Calendar.getInstance().getTime()))-1);
        endDay.setForeground(Color.darkGray);
        endDay.setBounds(140,144,40,34);
        endDay.setHorizontalAlignment(JTextField.CENTER);
        endDay.setText(thisDay.format(Calendar.getInstance().getTime()));
        endYear.setForeground(Color.darkGray);
        endYear.setBounds(182,144,80,34);
        endYear.setHorizontalAlignment(JTextField.CENTER);
        endYear.setText(thisYear.format(Calendar.getInstance().getTime()));
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

    public void checkDate(int y,int m,int d,JLabel label){

        int daysInJan=31;
        int daysInFeb=28;
        if(y%4==0){
            daysInFeb=29;
        }
        int daysInMar=31;
        int daysInApr=30;
        int daysInMay=31;
        int daysInJun=30;
        int daysInJul=31;
        int daysInAug=31;
        int daysInSep=30;
        int daysInOct=31;
        int daysInNov=30;
        int daysInDec=31;

        int[] daysInMonth={daysInJan,daysInFeb,daysInMar,daysInApr,daysInMay,daysInJun,daysInJul,daysInAug,daysInSep,daysInOct,daysInNov,daysInDec};
        if(d>daysInMonth[m]){
            label.setForeground(Color.red);
            label.setText("ERROR");
        }else{
            label.setForeground(Color.green);
            label.setText("READY");
        }
        if(y<1000){
            label.setForeground(Color.red);
            label.setText("ERROR");
        }else{
            label.setForeground(Color.green);
            label.setText("READY");
        }

    }
    public void calculate(int d,int D,int m,int M,int y,int Y){
        if(startDateCheck.getText().equals("READY") && endDateCheck.getText().equals("READY")){
            int years=Math.abs(Y-y-1);
            int months=Math.abs(M-m);
            int days=Math.abs(D-d);
            int totalMonths=years*12+months;
            int leapDays= (int) Math.floor(totalMonths/48);
            int totalDays=daysInMonth(months)+days+years*365+leapDays;
            int totalHours=totalDays*24;
            long totalMinutes=totalHours* 60L;
            long totalSeconds=totalMinutes* 60L;
            result.setText(String.valueOf(
                    years+" years "+months+" months "+days+" Days\n"
                    +"or "+totalMonths+" months "+" and "+days+" days\n"
                    +"or "+totalDays+" days\n"
                    +"or "+totalHours+" hours\n"
                    +"or "+totalMinutes+" minutes\n"
                    +"or "+totalSeconds+" seconds\n"
            ));
        }
    }
    public int daysInMonth(int months){
        int[] daysInMonth={31,28,31,30,31,30,31,31,30,31,30,31};
        int days=0;
        for(int i=0;i<months;i++){
            days+=daysInMonth[i];
        }
        return days;
    }
    public static void main(String[] args) {
	new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==calculate){
            int y= Integer.parseInt(startYear.getText());
            int m=startMonth.getSelectedIndex();
            int d= Integer.parseInt(startDay.getText());

            int Y= Integer.parseInt(endYear.getText());
            int M=endMonth.getSelectedIndex();
            int D= Integer.parseInt(endDay.getText());
           calculate(d,D,m,M,y,Y);
        }
        if(e.getSource()==startCheckBtn){
            try{
                int y= Integer.parseInt(startYear.getText());
                int m=startMonth.getSelectedIndex();
                int d= Integer.parseInt(startDay.getText());
                checkDate(y,m,d,startDateCheck);
            }catch (Exception x){

            }

        }
        if(e.getSource()==endCheckBtn){
            try{
                int y= Integer.parseInt(endYear.getText());
                int m=endMonth.getSelectedIndex();
                int d= Integer.parseInt(endDay.getText());
                checkDate(y,m,d,endDateCheck);
            }catch (Exception x){

            }
        }
    }
}
