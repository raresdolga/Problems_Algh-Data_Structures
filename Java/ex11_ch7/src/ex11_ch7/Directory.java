package ex11_ch7;

import java.util.HashMap;

public class Directory extends Common {

	private HashMap<String,Common> files;
	
	public Directory(String name, int size, String parent){
		super(name, size, parent);
		files = new HashMap<>();
	}
	
	@Override
	public void addFile(Common f){
		if(files.get(f) != null){
			if(f instanceof Directory == this instanceof Directory){
				System.out.println("File with the same type and  the same name unsupported");
			}
			else {
				//make the difference between files and directory with the same name
				files.put(f.getName() + " ", f);
			}
		}
		else
			files.put(f.getName(), f);
	}
	
	@Override 
	public void removeFile(Common f){
		//removing the parent will remove the other inner Common files as well
		files.remove(f);
		
	}
}
