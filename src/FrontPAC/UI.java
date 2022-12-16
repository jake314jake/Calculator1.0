package FrontPAC;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

import DBManager.DBConxCalculator;

import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UI {

	private JFrame frame;
	private static JTextField Screen;
    private boolean State=true;
    private String Val="";
   
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
static void  setScreen(String ID) {
	UI.Screen.setText(UI.Screen.getText()+ID);
	}
static String  getScreen() {
	return UI.Screen.getText();
	}
static void erzScreen() {
	String ScreenVal=UI.Screen.getText();
	if(!ScreenVal.equals("")) {
		ScreenVal=ScreenVal.substring(0, ScreenVal.length()-1);
		UI.Screen.setText(ScreenVal);
	}
}

	/**
	 * Create the application.
	 */
	public UI() {
		
		initialize();
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(70, 70, 400, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Jake 1.0");
		JPanel KeyBoardPAN = new JPanel();
		KeyBoardPAN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		KeyBoardPAN.setBounds(10, 123, 364, 377);
		frame.getContentPane().add(KeyBoardPAN);
		KeyBoardPAN.setLayout(null);
		
		Btn BTN1 = new Btn("1");
		BTN1.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN1.setBounds(10, 235, 68, 58);
		KeyBoardPAN.add(BTN1);
		
		Btn BTN2 = new Btn("2");
		BTN2.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN2.setBounds(88, 235, 68, 58);
		KeyBoardPAN.add(BTN2);
		
		Btn BTN3 = new Btn("3");
		BTN3.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN3.setBounds(169, 235, 68, 58);
		KeyBoardPAN.add(BTN3);
		
		Btn BTN4 = new Btn("4");
		BTN4.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN4.setBounds(10, 166, 68, 58);
		KeyBoardPAN.add(BTN4);
		
		Btn BTN5 = new Btn("5");
		BTN5.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN5.setBounds(88, 166, 68, 58);
		KeyBoardPAN.add(BTN5);
		
		Btn BTN6 = new Btn("6");
		BTN6.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN6.setBounds(169, 166, 68, 58);
		KeyBoardPAN.add(BTN6);
		
		Btn BTN7 = new Btn("7");
		BTN7.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN7.setBounds(10, 97, 68, 58);
		KeyBoardPAN.add(BTN7);
		
		Btn BTN8 = new Btn("8");
		BTN8.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN8.setBounds(88, 97, 68, 58);
		KeyBoardPAN.add(BTN8);
		
		Btn BTN9 = new Btn("9");
		BTN9.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN9.setBounds(169, 97, 68, 58);
		KeyBoardPAN.add(BTN9);
		
		Btn BTNpoint = new Btn(".");
		BTNpoint.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNpoint.setBounds(88, 304, 68, 58);
		KeyBoardPAN.add(BTNpoint);
		
		Btn BTN0 = new Btn("0");
		BTN0.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTN0.setBounds(10, 304, 68, 58);
		KeyBoardPAN.add(BTN0);
		
		JButton BTNeql = new JButton("=");
		
		
		BTNeql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!getScreen().equals("")) {
				String expression=UI.getScreen();
				Double Value=InfixEvaluation.evaluate(expression) ;
				UI.Screen.setText("");
				UI.setScreen(Value.toString());
			
				}
			}
		});
		BTNeql.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNeql.setBounds(166, 304, 71, 58);
		BTNeql.setBackground(Color.orange);
		KeyBoardPAN.add(BTNeql);
		
		Btn BTNplus = new Btn("+");
		BTNplus.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNplus.setBounds(257, 304, 97, 58);
		KeyBoardPAN.add(BTNplus);
		
		Btn BTNmins = new Btn("-");
		BTNmins.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNmins.setBounds(257, 235, 97, 58);
		KeyBoardPAN.add(BTNmins);
		
		Btn BTNmul = new Btn("*");
		BTNmul.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNmul.setBounds(257, 166, 97, 58);
		KeyBoardPAN.add(BTNmul);
		
		Btn BTNdiv = new Btn("/");
		BTNdiv.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNdiv.setBounds(257, 100, 97, 58);
		KeyBoardPAN.add(BTNdiv);
		
		Btn BTNclose = new Btn(")");
		BTNclose.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNclose.setBounds(169, 31, 68, 58);
		KeyBoardPAN.add(BTNclose);
		
		Btn BTNopen = new Btn("(");
		BTNopen.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNopen.setBounds(88, 31, 68, 58);
		KeyBoardPAN.add(BTNopen);
		
		JButton BTNerz = new JButton("<-");
		BTNerz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				erzScreen();
			}
		});
		BTNerz.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNerz.setBounds(10, 60, 68, 29);
		BTNerz.setBackground(Color.green);
		KeyBoardPAN.add(BTNerz);
		
		JButton BTNonoff = new JButton("ON/OFF");
		BTNonoff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(State) {//TURN OFF
					Val=UI.Screen.getText();
					UI.Screen.setText("");
				}else {// TURN ONN
					UI.Screen.setText(Val);
				}
				State =! State;
			}
		});
		BTNonoff.setFont(new Font("Tahoma", Font.BOLD, 7));
		BTNonoff.setBounds(10, 11, 68, 49);
		BTNonoff.setBackground(Color.RED);
		KeyBoardPAN.add(BTNonoff);
		
		Btn BTNpow = new Btn("^");
		BTNpow.setText("^");
		BTNpow.setFont(new Font("Tahoma", Font.BOLD, 16));
		BTNpow.setBounds(257, 31, 97, 58);
		KeyBoardPAN.add(BTNpow);
		
		JPanel ScreenPAN = new JPanel();
		ScreenPAN.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ScreenPAN.setBounds(10, 30, 364, 82);
		frame.getContentPane().add(ScreenPAN);
		ScreenPAN.setLayout(null);
		
		Screen = new JTextField();
		Screen.setFont(new Font("Tahoma", Font.BOLD, 20));
		Screen.setText("");
		Screen.setHorizontalAlignment(SwingConstants.RIGHT);
		Screen.setBounds(10, 11, 344, 60);
		ScreenPAN.add(Screen);
		Screen.setColumns(10);
		
	}
}
