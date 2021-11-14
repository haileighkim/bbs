 package mmms.member.controller;

import java.util.Scanner;

import mmms.member.action.Action;

public class Membercontroller {
	public void processRequest(Action action, Scanner sc) {
		try {
			action.execute(sc);
		} catch (Exception e) {
		
		}
	}
	
}
