package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputWindow{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9209189870448938629L;
	private JTextField[] inputs;
	private String[] values;
	private Object[] message;
	private int length=0;
	public InputWindow(String[] ss) {
		length=ss.length-1;
		inputs=new JTextField[length];
		message=new Object[2*length];
		for(int i=0;i<length;++i){
			inputs[i]=new JTextField();
			
			message[2*i]=ss[i+1];
			message[2*i+1]=inputs[i];
		}		
	}
	public String[] showForm(){
		int i=JOptionPane.showConfirmDialog(null, message,"Input",JOptionPane.OK_CANCEL_OPTION);
		if(i==JOptionPane.OK_OPTION){
			values=new String[inputs.length+1];
			values[0]="0";
			for(int j=1;j<values.length;j++){
				values[j]=inputs[j-1].getText();
			}
			return values;
		}else return null;
	}
	

}
