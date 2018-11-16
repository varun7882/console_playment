package com.varun.console;

import java.util.List;
import java.util.Set;

public class Command_ls extends Command{
	private List<String> args;
	Command_ls(List<String> ls) {
		super("ls");
		args=ls;
	}

	@Override
	Directory execute(Directory root,Directory currDir) {
		if(args.size()!=0)
		{
			System.out.println("ERR: SYNTAX WRONG");
			return currDir;
		}
		System.out.print("DIRS: ");
		Set<String> keyset=currDir.childDirectories.keySet();
		for(String k: keyset)
		{
			System.out.print(k+" ");
		}
		System.out.println();
		return currDir;
	}



}
