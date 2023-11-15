package com.elangovan16.interviewpanel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class InterviewPanel extends TimerTask{
	static Queue<String> candidates=new LinkedList <String>();
	public static void main(String[] args) {
		
		InterviewPanel interview = new InterviewPanel();
		interview.start();	
		}
	private void start() {
		Scanner sc=new Scanner(System.in);
		int choice;
		startInteview();
		do {
			details();
			choice=sc.nextInt();
			sc.nextLine();
			if(choice==1) {
				System.out.println("Enter Canditate Name : ");
				String name=sc.nextLine();
				InterviewPanel.candidates.add(name);
				
			}
			else if(choice==2) {
				printCandidates();
			}
			else if(choice==0){
				System.out.println("InterviewPanel Application was closeing...");
			}
			else {
				System.out.println("Invalid choice. Please Enter Valid Choice.");
			}
		}
		while(choice!=0);
		System.out.println("Thankyou for Using InterviewPanel Application.");
		sc.close();
	}
	private void details() {
		System.out.println("1. Enter Candidate Details");
		System.out.println("2. Candidate waiting RoomList");
		System.out.println("0. Exit...");
		System.out.println("Enter your Choice : ");
	}
	private void printCandidates() {
		int index=1;
		if(candidates.isEmpty()) {
			System.out.println("\nCandidate waiting Room was Empty.\n");
		}
		else {
		System.out.println("\nWaiting Room Candidate List");
		for(String candidate:InterviewPanel.candidates) {
			System.out.println(index++ + ". "+candidate);
		}
		System.out.println();
		}
	}
	private void startInteview() {	
		Timer time=new Timer();
		time.schedule(this,10000,10000);
	}
	@Override
	public void run() {
		if(!candidates.isEmpty()) {
			System.out.println("Interview Completed for ---> "+candidates.poll());
		}
	}
}
