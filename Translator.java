import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.GridLayout;
import java.io.*;

public class Translator {
	public static void TranslateText(String sl, String learnLang) throws IOException{
		boolean trnslatorRunning = true;
		String options[] = {"Translate", "Exit"};
		String options2[] = {"Retry", "Exit"};
		
		while(trnslatorRunning){
			JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
			JLabel label = new JLabel();
			if(sl.equals("en")){
				label = new JLabel("Enter text");
			}else {
				label = new JLabel(GoogleTranslator.translate("en", sl, "Enter text"));
				for(int i = 0; i < options.length; i++) {
					options[i] = GoogleTranslator.translate("en", sl, options[i]);
				}
			}
				
			JTextField text = new JTextField(15);
			panel.add(label);
			panel.add(text);
			
			int op = JOptionPane.showOptionDialog(null, panel, "Translator", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				
			String input = text.getText();
				
			int op2 = 0;
				
			if(op == 0) {
				String translated = GoogleTranslator.translate(sl, learnLang, input);
					
				panel = new JPanel(new GridLayout(0, 1, 5, 5));
				label = new JLabel("<html><u>Translated Text</u></html>");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(label);
				label = new JLabel("<html><b>" + translated + "</b></html>");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				panel.add(label);
					
				op2 = JOptionPane.showOptionDialog(null, panel, "Translator", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
			}else {
				trnslatorRunning = false;
			}
				
			if(op2 == 1) {
				trnslatorRunning = false;
			}
		}
	}
}
