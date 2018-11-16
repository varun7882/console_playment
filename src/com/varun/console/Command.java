package com.varun.console;

public abstract class Command {
	private String name;
	Command(String name)
	{
		this.setName(name);
	}
	abstract Directory execute(Directory root,Directory currDir);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
