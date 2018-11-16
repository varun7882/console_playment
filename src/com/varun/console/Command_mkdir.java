package com.varun.console;
import java.util.*;
public class Command_mkdir extends Command{

	private List<String> directoriesToCreate;
	Command_mkdir(List<String> ls) {
		super("mkdir");
		directoriesToCreate=ls;
	}

	@Override
	Directory execute(Directory root,Directory currDir) {
		if(directoriesToCreate.size()==0)
		{
			System.out.println("ERR: SYNTAX WRONG");
			return currDir;
		}
		for(int i=0;i<directoriesToCreate.size();i++)
		{
			String path=directoriesToCreate.get(i);
			Directory workDir=DirsUtil.getToPath(path, root,currDir);
			if(workDir==null)
			{
				System.out.println("ERR: "+path+" DOESN'T EXISTS");
				continue;
			}
			String directoryToCreate=DirsUtil.getLastDirectory(path);
			if(workDir.childDirectories.containsKey(directoryToCreate))
			{
				System.out.println("ERR: DIRECTORY ALREADY EXISTS");
			}
			else
			{
				workDir.childDirectories.put(directoryToCreate, new Directory(directoryToCreate, workDir));
			}
		}
		return currDir;
	}

	public List<String> getDirectoriesToCreate() {
		return directoriesToCreate;
	}

	public void setDirectoriesToCreate(List<String> directoriesToCreate) {
		this.directoriesToCreate = directoriesToCreate;
	}

}
