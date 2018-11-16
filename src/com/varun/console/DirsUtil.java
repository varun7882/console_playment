package com.varun.console;

public class DirsUtil {
	 static Directory getToPath(String input,Directory root,Directory currDir)
	 {
		 Directory ret=null;
		 Directory temp;
		 int i=0;
		 //for absolute paths
		 if(input.charAt(0)=='/')
		 {
			// System.out.println("root h");
			 i=1;
			 temp=root;
		 }
		 else
		 {
			 temp=currDir;
		 }
		 String[] ins=input.split("/");
		 while(i<ins.length && (temp.childDirectories.containsKey(ins[i]) || ins[i].equals("..")))
		 {
			 if(ins[i].equals(".."))
			 {
				 temp=temp.getParent();
			 }
			 else
			 {
				 temp=temp.childDirectories.get(ins[i]);
			 }
			i++;
		 }
		 if(i==ins.length-1)
		 {
			 ret=temp;
		 }
		 return ret;
	 }
	 static String getLastDirectory(String input)
	 {
		 String[] ins=input.split("/");
		 return ins[ins.length-1];
	 }
	 static Directory changeToPath(String input,Directory root,Directory currDir) {
		 Directory ret=null;
		 Directory temp;
		 int i=0;
		 //for absolute paths
		 if(input.charAt(0)=='/')
		 {
			 temp=root;
			 i=1;
		 }
		 else
		 {
			 temp=currDir;
		 }
		 String[] ins=input.split("/");
		 while(i<ins.length && (temp.childDirectories.containsKey(ins[i]) || ins[i].equals("..")))
		 {
			 if(ins[i].equals(".."))
			 {
				 temp=temp.getParent();
			 }
			 else
			 {
				 temp=temp.childDirectories.get(ins[i]);
			 }
			i++;
		 }
		 if(i==ins.length)
		 {
			 ret=temp;
		 }
		 return ret; 
	 }
}
