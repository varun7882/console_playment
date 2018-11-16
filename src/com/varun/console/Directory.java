package com.varun.console;
import java.util.*;
public class Directory {
	private String name;
	private Directory parent;
	Map<String,Directory> childDirectories;
	Directory(String name,Directory parent)
	{
		this.name=name;
		this.parent=parent;
		childDirectories=new HashMap<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Directory getParent() {
		return parent;
	}
	public void setParent(Directory parent) {
		this.parent = parent;
	}
	
}
