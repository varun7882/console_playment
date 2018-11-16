package com.varun.console;

import java.util.List;

public class Command_rm extends Command{
	private List<String> directoriesToDelete;
	Command_rm(List<String> ls) {
		super("rm");
		directoriesToDelete=ls;
		// TODO Auto-generated constructor stub
	}

	@Override
	Directory execute(Directory root,Directory currDir) {
		if(directoriesToDelete.size()==0)
		{
			System.out.println("ERR: SYNTAX WRONG");
			return currDir;
		}
		for(int i=0;i<directoriesToDelete.size();i++)
		{
			String path=directoriesToDelete.get(i);
			Directory workDir=DirsUtil.getToPath(path, root,currDir);
			if(workDir==null)
			{
				System.out.println("ERR: "+path+" DOESN'T EXISTS");
				continue;
			}
			String directoryToDelete=DirsUtil.getLastDirectory(path);
			if(workDir.childDirectories.containsKey(directoryToDelete))
			{
				workDir.childDirectories.remove(directoryToDelete);
			}
			else
			{
				System.out.println("ERR: DIRECTORY DOESN'T EXISTS");
			}
		}
		return currDir;
	}

}
