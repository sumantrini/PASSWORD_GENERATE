//package PASSWORD_GENERATE;

import java.util.Scanner;

public class Main {
	public static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		
		Generator g=new Generator(sc);
		g.options();
	}

}