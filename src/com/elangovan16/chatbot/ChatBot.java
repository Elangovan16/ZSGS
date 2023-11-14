package com.elangovan16.chatbot;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class ChatBot {
	Stack<String> backStack = new Stack<String>();

	public static void main(String[] args) throws Exception {
		ChatBot chatBot = new ChatBot();
		chatBot.start();
	}

	public void start() throws Exception {
		int index;
		introduction();
		backStack.add("Press");
		displayChat(parse("Press"));
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter your Option :");
			index = scan.nextInt();
			if (index == 0) {
				backStack.pop();
				if (backStack.isEmpty()) {
					break;
				}
			} else if (index == -1) {
				break;
			} else {
				backStack.push(backStack.peek() + "_" + (index - 1));
			}
			String path = backStack.peek();
			try {
				displayChat(parse(path));
				System.out.println("PREV 0");
				System.out.println("Exit -1");
			} catch (Exception e) {
				System.out.println("Please Select Correct Number! ");
			}
		} while (index != -1);
		System.out.println("-----Thank you for using Vodafone care-----");
	}

	private void displayChat(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = (JSONObject) jsonArray.get(i);
			System.out.println(object.get(Integer.toString(i)));
		}
	}

	private JSONArray parse(String path) throws Exception {
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(new FileReader("src/com/elangovan16/chatbot/data.json"));
		return (JSONArray) obj.get(path);
	}

	public void introduction() {
		System.out.println();
		System.out.println("---Send Instructions---");
		System.out.println("MSI-SND: 9876543210");
		System.out.println("Main Balance: Rs 0.22");
		System.out.println("UL Validity: 13-01-2024");
		System.out.println("Select Language : ");
		System.out.println();
	}
}
