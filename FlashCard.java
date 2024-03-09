import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class FlashCard {

	public static void ShowCard(String sl, String ll) throws IOException {
		boolean flashCardRunning = true;
		String images[] = {"Hello.jpg", "Goodmorning.jpg", "Goodnight.jpg", "University.jpg", "Vegetables.jpg", "Meat.jpg", "Job.jpg", "BoughtBook.jpg", 
							"Agree.jpg", "Student.jpg", "Time.jpg", "ThisYear.jpg", "Place.jpg", "Now.jpg", "Think.jpg", "Order.jpg", "Travel.jpg", 
							"Doctor.jpg", "Country.jpg", "WhatThink.jpg"};
		String en_sent[] = {"Hello", "Goodmorning", "Goodnight", "University", "Vegetables", "Meat", "Job", "I bought one book", "I think so too", "Student", "Time", 
				"This year", "Place", "Now", "Think", "I'll have this please", "I want to travel to Italy this year", "He became a doctor", "Country", "What do you think?"};
		String sl_sent[] = {"Hello", "Goodmorning", "Goodnight", "University", "Vegetables", "Meat", "Job", "I bought one book", "I think so too", "Student", "Time", 
				"This year", "Place", "Now", "Think", "I'll have this please", "I want to travel to Italy this year", "He became a doctor", "Country", "What do you think?"};
		String ll_sent[] = {"Hello", "Goodmorning", "Goodnight", "University", "Vegetables", "Meat", "Job", "I bought one book", "I think so too", "Student", "Time", 
				"This year", "Place", "Now", "Think", "I'll have this please", "I want to travel to Italy this year", "He became a doctor", "Country", "What do you think?"};
		String options[] = {"Show Answer", "Next", "Quit"};
		String options2[] = {"Show Original", "Next", "Quit"}; 
		
		for(int i = 0; i < en_sent.length; i++) {
			
			if(sl != "en") {
				sl_sent[i] = GoogleTranslator.translate("en", sl, en_sent[i]);
			}else {
				sl_sent[i] = en_sent[i];
			}
			if(ll != "en") {
				ll_sent[i] = GoogleTranslator.translate("en", ll, en_sent[i]);
			}else {
				ll_sent[i] = en_sent[i];
			}
			
		}
		
		int upperbound = 20;
		StartFlashcard:
		while(flashCardRunning) {
			if(upperbound == 0) {
				JOptionPane.showMessageDialog(null, "More Flashcards Coming Soon!...");
				break StartFlashcard;
			}
			
			Random rand = new Random();
			int n = rand.nextInt(upperbound);
			List<String> ll_sentList = new ArrayList<String>(Arrays.asList(ll_sent));
			List<String> sl_sentList = new ArrayList<String>(Arrays.asList(sl_sent));
			List<String> imgList = new ArrayList<String>(Arrays.asList(images));
			
			ImageIcon img = new ImageIcon(images[n]);
			
			int op = -1;
			int op2 = -1;
			int count = 1;
			
			op = JOptionPane.showOptionDialog(null, ll_sent[n], "Flashcards", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, img, options, options[0]);
			while(true) {
				if(count == 1){
					if(op == 0) {
						count = 2;
						op2 = JOptionPane.showOptionDialog(null, sl_sent[n], "Flashcards", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, img, options2, options2[0]);
					}else if(op == 1){
						break;
					}else {
						break StartFlashcard;
					}
				}
				if(count == 2) {
					if(op2 == 0) {
						count = 1;
						op = JOptionPane.showOptionDialog(null, ll_sent[n], "Flashcards", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, img, options, options[0]);
					}else if(op2 == 1){
						break;
					}else {
						break StartFlashcard;
					}
				}
			}
			ll_sentList.remove(n);
			sl_sentList.remove(n);
			imgList.remove(n);
			ll_sent = ll_sentList.toArray(ll_sent);
			sl_sent = sl_sentList.toArray(sl_sent);
			images = imgList.toArray(images);
			
			upperbound--;
		}
	}

}
