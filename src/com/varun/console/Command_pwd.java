package com.varun.console;

import java.util.List;

public class Command_pwd extends Command{
	private List<String> args;
	Command_pwd( List<String> ls) {
		super("pwd");
		args=ls;
	}

	@Override
	Directory execute(Directory root,Directory currDir) {
		// TODO Auto-generated method stub
		if(args.size()!=0)
		{
			System.out.println("ERR: SYNTAX WRONG");
			return currDir;
		}
		Directory tmp=currDir;
		StringBuilder st=new StringBuilder("");
		while(tmp!=null)
		{
			if(tmp!=root)
			{
			st.insert(0, tmp.getName());
			}
			st.insert(0, '/');
			tmp=tmp.getParent();
		}
		
		System.out.println("PATH: "+st);
		return currDir;
	}

}
