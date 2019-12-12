package numberbasechanger;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class NumberBaseChanger extends JFrame {
	
	
    NumberBaseChanger () {
    	
		JFrame new_window = new JFrame ();
		new_window.setSize(600, 600);
		new_window.setLocation(300, 100);
		
		new_window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		new_window.setTitle("BIN-HEX CONVERTER");
		
		
		JButton botao_confirma = new JButton ("Convert"); 
		
		
		
		JLabel question1 = new JLabel ("Enter the number:");
	    question1.setBounds(20,100,200,50);
	    question1.setFont(new Font ("arial", Font.PLAIN, 20));
	    
	    
	    JTextField number = new JTextField();
	    number.setBounds(200,110,350,30);
	    number.setFont(new Font ("arial",Font.PLAIN, 20));
	   
	   
	
		JRadioButton bin = new JRadioButton ("BIN to HEX");
		bin.setBounds(100,200,100,50);
		JRadioButton hex = new JRadioButton ("HEX to BIN");
		hex.setBounds (100,250,100,50);
		
		
		bin.addItemListener(new ItemListener() {
			 
			public void itemStateChanged (ItemEvent e) {
				
			     int state = e.getStateChange();
			
			     if (state == ItemEvent.SELECTED) {
				
				hex.setSelected(false);
			     }
			}


		});   
		
		hex.addItemListener (new ItemListener() {
			
			public void itemStateChanged (ItemEvent e) {
				
			     int state = e.getStateChange();
			
			     if (state == ItemEvent.SELECTED) {
				
				bin.setSelected(false);
			     }
			}


		});   
			
		botao_confirma.setBounds(300, 400, 100, 50);
		botao_confirma.addActionListener(new ActionListener ()
				
				{
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String msg = number.getText();
				String final_number = null;
				
				if (hex.isSelected()) {
					
				     final_number = hexToBin (msg);
					
				}
				
				if (bin.isSelected()) {
					
					final_number = BinToHex (msg);
					
					
				}
			    
			    JLabel result = new JLabel(final_number);
			    result.setFont(new Font("arial", Font.PLAIN, 20));
			  
			    JDialog res = new JDialog();
			    res.add(result);
			    res.setLocationRelativeTo(null);
			    res.setSize(300, 200);
			    res.setVisible(true);
				
			}
			
		});
		
	    new_window.add(question1);new_window.add(botao_confirma);new_window.add(number);
	    new_window.add(bin);new_window.add(hex);
	
		
		new_window.setLayout(null);
		
		new_window.setVisible(true);
	}
  
    private String hexToBin(String hex){
        String bin = "";
        String binFragment = "";
        int iHex;
        hex = hex.trim();
        hex = hex.replaceFirst("0x", "");

        for(int i = 0; i < hex.length(); i++){
            iHex = Integer.parseInt(""+hex.charAt(i),16);
            binFragment = Integer.toBinaryString(iHex);

            while(binFragment.length() < 4){
                binFragment = "0" + binFragment;
            }
            bin += binFragment;
        }
        return bin;
    }
    
    private String BinToHex (String bin) {
    	
    	final String[] hexValues = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    	 String hexadecimal = "";
    	    int sum = 0;
    	    int exp = 0;
    	    for (int i=0; i<bin.length(); i++){
    	        exp = 3 - i%4;
    	        if((i%4)==3){
    	            sum = sum + Integer.parseInt(bin.charAt(i)+"")*(int)(Math.pow(2,exp));
    	            hexadecimal = hexadecimal + hexValues[sum];
    	            sum = 0;
    	        }
    	        else
    	        {
    	            sum = sum + Integer.parseInt(bin.charAt(i)+"")*(int)(Math.pow(2,exp));
    	        }
    	    }
    	    return hexadecimal;
    }
    
    
    public static void main (String [] args) {
    	
    	NumberBaseChanger my_window = new NumberBaseChanger ();
    	my_window.setVisible(true);
        my_window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	
	
}
