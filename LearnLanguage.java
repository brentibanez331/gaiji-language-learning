import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public class LearnLanguage {
	
	
	
    public static void main(String[] args) throws IOException {
    	
    	String subsystems[] = {"Translator", "Chat with AI", "Flashcards"};
    	String en_options[] = {"Change Language", "Quit System"};
    	String options[] = {"Change Language", "Quit System"};
    	
    	ImageIcon mainIcon = new ImageIcon("gaiji.jpg");
    	
    	String systemLang = "";
    	String systemLangIs = "";
    	boolean modifyLanguage = true;
    	boolean systRunning = true;
    	
    	JOptionPane.showMessageDialog(null, "Welcome to Gaiji!", null, JOptionPane.PLAIN_MESSAGE, mainIcon);
    	
    	//Start loop
    	while(systRunning) {
    		AskSystemLang:
    	    	while(modifyLanguage) {
    	    		String languages[] = {"English", "Arabic", "Chinese", "Dutch", "French", "German", "Greek",
    	        	    	"Indonesian", "Italian", "Japanese", "Russian", "Spanish", "Tagalog", "Thai", "Vietnamese"};
    	    		for(int i = 0; i < 2; i++) {
    	    			options[i] = en_options[i];
    	    		}
    	    		
    	    		systemLang = UserSystemLanguage(languages, mainIcon);
    	    		if(systemLang == null) break AskSystemLang;
    	        	systemLangIs = LanguageChoice(systemLang);
    	        	
    	        	//remove chosen language for system to 
    	        	List<String> langList = new ArrayList<String>(Arrays.asList(languages));
    	        	
    	        	for(int i = 0; i < 16; i++) {
    	        		if(languages[i].equals(systemLang)) {
    	        			langList.remove(i);
    	        			languages = langList.toArray(languages);
    	        			break;
    	        		}
    	        	}
    	        	
    	        	String userLearnLang = UserLearnLanguage(languages, systemLangIs, mainIcon);
    	        	if(userLearnLang == null) break AskSystemLang;
    	        	
    	        	String systChoice = SystemChoice(systemLangIs, subsystems, mainIcon);
    	        	if(systChoice == null) break AskSystemLang;
    	        	
    	    		String learnLang = LanguageChoice(userLearnLang);
    	    		if(systChoice.equals(subsystems[0])) Translator.TranslateText(systemLangIs, learnLang);
    	    		else if(systChoice.equals(subsystems[1])) ChatBot.Chat(systemLangIs, learnLang);
    	    		else if(systChoice.equals(subsystems[2])) FlashCard.ShowCard(systemLangIs, learnLang);
    	    	}
    		
    			JPanel panel = new JPanel();
    			if(systemLang == null || systemLangIs.equals("en")) {
        			panel.add(new JLabel("What to do?"));
    			}else {
    				panel.add(new JLabel(GoogleTranslator.translate("en", systemLangIs, "What to do?")));
    				for(int i = 0; i < 2; i++) {
    					options[i] = GoogleTranslator.translate("en", systemLangIs, options[i]);
    				}
    			}
    			
    	    	int choice = JOptionPane.showOptionDialog(null, panel, "Learn a Language", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    	    	if(choice == 1 || choice == -1) {
    	    		System.exit(0);
    	    	}
    	}
    	
    }
    
    //Change the system language
    static String UserSystemLanguage(String languages[], ImageIcon mainIcon) throws IOException{
    	String userSystLang = (String) (JOptionPane.showInputDialog(null, "Choose your preferred language: ", null, JOptionPane.QUESTION_MESSAGE, mainIcon, languages, languages[0]));
    	
    	return userSystLang;
    }
    
    static String UserLearnLanguage(String languages[], String systemLangIs, ImageIcon mainIcon) throws IOException{
    	String lang = "";
    	
    	if(systemLangIs.equals("en")) {
    		lang = (String) (JOptionPane.showInputDialog(null, "Which language do you want to learn?", null, JOptionPane.QUESTION_MESSAGE, mainIcon, languages, languages[0]));
    	}
    	else {
    		lang = (String) (JOptionPane.showInputDialog(null, GoogleTranslator.translate("en", systemLangIs, "Which language do you want to learn?"), null, JOptionPane.QUESTION_MESSAGE, mainIcon, languages, languages[0]));
    	}
    	return lang;
    }
    
    //Return a Language ISO code
    static String LanguageChoice(String systemLang) throws IOException {
    	String sl = "";
    	
    	if(systemLang.equals("English")) sl = "en";
    	if(systemLang.equals("Arabic")) sl = "ar";
    	if(systemLang.equals("Chinese")) sl = "zh";
    	if(systemLang.equals("Dutch")) sl = "nl";
    	if(systemLang.equals("French")) sl = "fr";
    	if(systemLang.equals("German")) sl = "de";
    	if(systemLang.equals("Greek")) sl = "el";
    	if(systemLang.equals("Indonesian")) sl = "id";
    	if(systemLang.equals("Italian")) sl = "it";
    	if(systemLang.equals("Japanese")) sl = "ja";
    	if(systemLang.equals("Korean")) sl = "ko";
    	if(systemLang.equals("Russian")) sl = "ru";
    	if(systemLang.equals("Spanish")) sl = "es";
    	if(systemLang.equals("Tagalog")) sl = "tl";
    	if(systemLang.equals("Thai")) sl = "th";
    	if(systemLang.equals("Vietnamese")) sl = "vi";
    	
    	return sl;
    }
    
    static String SystemChoice(String systLang, String subsystems[], ImageIcon mainIcon) throws IOException {
    	
    	String subsyst = "";
    	
    	if(systLang.equals("en")) {
    		subsyst = (String) (JOptionPane.showInputDialog(null, "Please choose a subsystem: ", null, JOptionPane.QUESTION_MESSAGE, mainIcon, subsystems, subsystems[0]));
    	}
    	else {
    		for(int i = 0; i < 3; i++) {
        		subsystems[i] = GoogleTranslator.translate("en", systLang, subsystems[i]);
        	}
        	subsyst = (String) (JOptionPane.showInputDialog(null, GoogleTranslator.translate("en", systLang, "Please choose a subsystem: "), null, JOptionPane.QUESTION_MESSAGE, mainIcon, subsystems, subsystems[0]));
    	}
    	
    	return subsyst;
    }
}