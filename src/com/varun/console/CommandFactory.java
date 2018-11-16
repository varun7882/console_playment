package com.varun.console;

import java.util.*;

public class CommandFactory {
	static Command  getCommandInstance(String input,Map<String,Boolean> commandsAvailable)
	{
		String[] ins=input.split(" ");
		ArrayList<String> ls;
		Command com=null;
		switch(ins[0])
		{
			case "pwd":
				 ls=new ArrayList<>();
					for(int i=1;i<ins.length;i++)
					{
						ls.add(ins[i]);
					}
				com=new Command_pwd(ls);
				break;
			case "ls":
				 ls=new ArrayList<>();
					for(int i=1;i<ins.length;i++)
					{
						ls.add(ins[i]);
					}
				com=new Command_ls(ls);
				break;
			case "mkdir":
				 ls=new ArrayList<>();
				for(int i=1;i<ins.length;i++)
				{
					ls.add(ins[i]);
				}
				com=new Command_mkdir(ls);
				break;
			case "rm":
				ls=new ArrayList<>();
				for(int i=1;i<ins.length;i++)
				{
					ls.add(ins[i]);
				}
				com=new Command_rm(ls);
				break;
			case "cd":
				ls=new ArrayList<>();
				for(int i=1;i<ins.length;i++)
				{
					ls.add(ins[i]);
				}
				com=new Command_cd(ls);
				break;
			case "session":
				if(ins[1].equals("clear"))
				{
					com=new Command_session_clear();
				}
				break;
			default:
				break;
		}
		return com;
	}
}
