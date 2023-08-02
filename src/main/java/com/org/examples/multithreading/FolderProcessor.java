package com.org.examples.multithreading;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {
	
	private final String path;
	
	private final String extension;
	
	

	public FolderProcessor(String path, String extension) {
		super();
		this.path = path;
		this.extension = extension;
	}
	
	



	@Override
	protected List<String> compute() {
		
		List<String> list = new ArrayList<String>();
		
		 List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
		 
		 File file = new File(path);
		 
		 File[] files = file.listFiles();
		 
		 if(files != null) {
			 
			 for(int i=0;i<files.length;i++) {
				 
				 if(files[i].isDirectory()) {
                     FolderProcessor task = new FolderProcessor(files[i].getAbsolutePath(),extension);
					 
					 task.fork();
					 tasks.add(task);
				 } else {
					 if(files[i].getName().endsWith(extension))
						 list.add(files[i].getAbsolutePath());
				 }
			 }
		 }
		 
		 if (tasks.size() > 50) {
		      System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(),
		          tasks.size());
		    }
		 
		 for (FolderProcessor item : tasks) {
		      list.addAll(item.join());
		    }
		 
		 
		
		return list;
	}

}
