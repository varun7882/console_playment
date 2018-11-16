package com.varun.console;

import java.util.List;

public class Command_cd extends Command {
	private List<String> directoriesToMove;
	Command_cd(List<String> ls) {
		super("cd");
		directoriesToMove=ls;
	}

	@Override
	Directory execute(Directory root,Directory currDir) {
		if(directoriesToMove.size()==0 || directoriesToMove.size()>1)
		{
			System.out.println("ERR: SYNTAX WRONG");
			return currDir;
		}
		Directory workDir=DirsUtil.changeToPath(directoriesToMove.get(0), root,currDir);
		if(workDir==null)
		{
			System.out.println("ERR: INVALID PATH");
		}
		return workDir;
	}

}
