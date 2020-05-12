package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votesCount = new HashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		sc.close();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				int vote = Integer.parseInt(fields[1]);
				if (votesCount.containsKey(name)) {
					vote += votesCount.get(name);
				}
				votesCount.put(name, vote);
				line = br.readLine();
			}
			for (String key : votesCount.keySet()) {
				System.out.println(key + ": " + votesCount.get(key));
			}
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
