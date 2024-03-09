import java.io.*;
import java.util.Random;

public class ChatBot{
	public static void Chat(String systemLangIs, String learnLang) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();
		
		boolean chatBotRunning = true;
		boolean askName = true;
		int generated;
		
		String text = "";
		String words[];
		String name = "";
		
		
		
		if(learnLang.equals("en")) {
			System.out.println(GoogleTranslator.translate("en", systemLangIs, "Welcome User!! Enter EXIT CHAT to Quit System"));
			System.out.println("");
			System.out.println("AIren: Hi, I am AIren. What's your name?");
			while(chatBotRunning) {
				while(askName) {
					System.out.print("You: ");
					text = r.readLine();
					text = text.toLowerCase();
					
					if(text.contains("my name is") || text.contains("i am") || text.contains("i'm")){
						words = text.split(" ");
						for(int i = 0; i < words.length; i++) {
							if(words[i].equals("is")){
								name = words[i+1];
								break;
							}else if(words[i].equals("am")) {
								name = words[i+1];
								break;
							}else if(words[i].equals("i'm")) {
								name = words[i+1];
								break;
							}
						}
					}else {
						generated = rand.nextInt(3);
						if(generated == 0) System.out.println("AIren: What is it?");
						else if(generated == 1) System.out.println("AIren: I don't understand");
						else if(generated == 2) System.out.println("AIren: What?");
					}
					String firstL = name.substring(0, 1).toUpperCase();
					String remainL = name.substring(1);
					name = firstL + remainL; 
					if(name != "") {
						System.out.println("AIren: Nice to meet you " + name);
						askName = false;
					}
				}
				
				System.out.print("You: ");
				text = r.readLine();
				text = text.toLowerCase();
				
				if((text.contains("old") && text.contains("how")) || (text.contains("age") && (text.contains("your")))) {
					System.out.println("AIren: I have no idea how old I am, but I was created in March 19, 2022, 4:55PM :)");
					System.out.println("AIren: How about you?");
					System.out.print("You: ");
					text = r.readLine();
					
					System.out.println("AIren: What are your hobbies?");
					System.out.print("You: ");
					text = r.readLine();
					
					System.out.println("AIren: How was your day?");
				}
				
				else if(text.contains("fine") || text.contains("good") || text.contains("well")) {
					System.out.println("AIren: Are you sure?");
					System.out.print("You: ");
					text = r.readLine();
					text = text.toLowerCase();
					if(text.contains("yes")) {
						System.out.println("AIren: Cool, you know where I am if you need me");
						System.out.print("You: ");
						text = r.readLine();
					}else if(text.contains("no")) {
						System.out.println("AIren: Can you tell me what's the problem?");
						System.out.print("You: ");
						text = r.readLine();
						System.out.println("AIren: All will be alright in time :D. If it's not alright, it's not the time");
						System.out.println("AIren: Cheer up! I'm here for you");
						System.out.print("You: ");
						text = r.readLine();
					}
					chatBotRunning = false;
				}
				else if(text.contains("depressed") || text.contains("sad") || text.contains("anxious") || text.contains("stressed")) {
					generated = rand.nextInt(3);
					if(generated == 0) System.out.println("AIren: It's okay to not feel your best. You're doing a good job!");
					else if(generated == 1) System.out.println("AIren: When you feel like giving up, look back at how far you've come");
					else if(generated == 2) System.out.println("AIren: Life is not a race, it's your happiness that matters :D");
					System.out.print("You: ");
					text = r.readLine();
					chatBotRunning = false;
				}
				else if(text.contains("great") || text.contains("very")) {
					generated = rand.nextInt(3);
					if(generated == 0) System.out.println("AIren: You make the world a brighter, more beautiful place");
					else if(generated == 1) System.out.println("AIren: Keep up the good work!");
					else if(generated == 2) System.out.println("AIren: You should be proud of yourself!");
					System.out.print("You: ");
					text = r.readLine();
					chatBotRunning = false;
				}
				else if(text.contains("my name is") || text.contains("i am") || text.contains("i'm")){
					continue;
				}
				else {
					generated = rand.nextInt(3);
					if(generated == 0) System.out.println("AIren: What is it?");
					else if(generated == 1) System.out.println("AIren: I don't understand");
					else if(generated == 2) System.out.println("AIren: What?");
				}
				
				if(text.equals("exit chat")) {
					chatBotRunning = false;
				}	
			}
			System.out.println("AIren: Oops, it looks like I have a scheduled maintenance right now. I'll get back to you later");
		}
		else {
			if(systemLangIs.equals("en")) {
				System.out.println("Welcome User!! Enter EXIT CHAT to Quit System");
			}
			else {
				System.out.println(GoogleTranslator.translate("en", systemLangIs, "Welcome User!! Enter EXIT CHAT to Quit System"));
			}
			System.out.println("");
			System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Hi, I am AIren. What's your name?"));
			while(chatBotRunning) {
				
				while(askName) {
					System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
					text = r.readLine();
					text = GoogleTranslator.translate(learnLang, "en", text).toLowerCase();
					
					if(text.contains("my name is") || text.contains("i am") || text.contains("i'm") || text.contains("name")){
						words = text.split(" ");
						for(int i = 0; i < words.length; i++) {
							if(words[i].equals("is")){
								name = words[i+1];
								break;
							}else if(words[i].equals("am")) {
								name = words[i+1];
								break;
							}else if(words[i].equals("i'm")) {
								name = words[i+1];
								break;
							}
						}
					}else {
						generated = rand.nextInt(3);
						if(generated == 0) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: What is it?"));
						else if(generated == 1) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: I don't understand"));
						else if(generated == 2) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: What?"));
					}
					String firstL = name.substring(0, 1).toUpperCase();
					String remainL = name.substring(1);
					name = firstL + remainL; 
					if(name != "") {
						System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Nice to meet you " + name));
						askName = false;
					}
				}
				
				System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
				text = r.readLine();
				text = GoogleTranslator.translate(learnLang, "en", text).toLowerCase();
				
				if((text.contains("old") && text.contains("how")) || (text.contains("age") && (text.contains("your")))) {
					System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: I have no idea how old I am, but I was created in March 19, 2022, 4:55PM :)"));
					System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: How about you?"));
					System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
					text = r.readLine();
					
					System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: What are your hobbies?"));
					System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
					text = r.readLine();
					
					System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: How was your day?"));
				}
				
				else if(text.contains("fine") || text.contains("good") || text.contains("well")) {
					System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Are you sure?"));
					System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
					text = r.readLine();
					text = GoogleTranslator.translate(learnLang, "en", text).toLowerCase();
					if(text.contains("yes")) {
						System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Cool, you know where I am if you need me"));
						System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
						text = r.readLine();
					}else if(text.contains("no")) {
						System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Can you tell me what's the problem?"));
						System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
						text = r.readLine();
						System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: All will be alright in time :D. If it's not alright, it's not the time"));
						System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Cheer up! I'm here for you"));
						System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
						text = r.readLine();
					}
					chatBotRunning = false;
				}
				else if(text.contains("depressed") || text.contains("sad") || text.contains("anxious") || text.contains("stressed")) {
					generated = rand.nextInt(3);
					if(generated == 0) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: It's okay to no feel your best. You're doing a good job!"));
					else if(generated == 1) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: When you feel like giving up, look back at how far you've come"));
					else if(generated == 2) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Life is not a race, it's your happiness that matters :D"));
					System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
					text = r.readLine();
					chatBotRunning = false;
				}
				else if(text.contains("great") || text.contains("very")) {
					generated = rand.nextInt(3);
					if(generated == 0) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: You make the world a brighter, more beautiful place"));
					else if(generated == 1) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Keep up the good work!"));
					else if(generated == 2) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: You should be proud of yourself!"));
					System.out.print(GoogleTranslator.translate("en", learnLang, "You: "));
					text = r.readLine();
					chatBotRunning = false;
				}
				else if(text.contains("my name is") || text.contains("i am") || text.contains("i'm")){
					continue;
				}
				else {
					generated = rand.nextInt(3);
					if(generated == 0) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: What is it?"));
					else if(generated == 1) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: I don't understand"));
					else if(generated == 2) System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: What?"));
				}
				
				
				if(text.equals("exit chat")) {
					chatBotRunning = false;
				}	
			}
			System.out.println(GoogleTranslator.translate("en", learnLang, "AIren: Oops, it looks like I have a scheduled maintenance right now. I'll get back to you later"));
			for(int i = 0; i < 50; i++) {
				System.out.println("\n");
			}
		}
		
	}
}