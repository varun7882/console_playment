package com.varun.console;
import java.util.*;
public class LinuxConsole {
	private static Scanner s;
	public static void main(String args[])
	{
		Map<String,Boolean> commandsAvailable=new HashMap<String, Boolean>();
		commandsAvailable.put("cd",true);
		commandsAvailable.put("mkdir",true);
		commandsAvailable.put("rm",true);
		commandsAvailable.put("pwd",true);
		commandsAvailable.put("ls",true);
		commandsAvailable.put("session clear",true);
		Directory currentDir=new Directory("/", null);
		Directory root=currentDir;
		startApplication(commandsAvailable, root, currentDir);
	}
	public static void startApplication(Map<String,Boolean> commandsAvailable,Directory root,Directory currentDir)
	{
		s = new Scanner(System.in);
		while(true)
		{
			System.out.print("$>");
			String input=s.nextLine();
			Command com= CommandFactory.getCommandInstance(input,commandsAvailable);
			if(com==null)
			{
				System.out.println("ERR: CANNOT RECOGNIZE INPUT");
				continue;
			}
			else if(com.getName()=="session clear")
			{
				root=currentDir=new Directory("/", null);
				System.out.println("SUCC: CLEARED: RESET TO ROOT");
				continue;
			}
			currentDir=com.execute(root, currentDir);
		}
	}
}
