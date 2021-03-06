package ex11_ch7;

public abstract class Common {
	private String name;
	private int size;
	private String parent;
	private Scale s;
	private String path;
	
	public Common(String name, int size, String parent){
		this.name = name;
		this.size = size;
		this.parent = parent;
		s = Scale.KB;
		increaseScale(size);
		if(parent == null)
			this.path =  this.name;
		else
			this.path = parent + "/" + this.name;
	}
	
	public String getPath(){
		return path;
	}
	
	public int getSize(){
		return size;
	}
	
	public String getName(){
		return name;
	}
	
	public void increaseScale(int val){
		size += val;
		int q = size/1024;
		if(q == 0)
			s = Scale.KB;
		else
		if(q == 1)
			s = Scale.MB;
		else
		if(q == 2)
			s = Scale.GB;
		else
			s = Scale.TB;
	}
	
	//hook method
	public void addFile(Common f) {
		throw new UnsupportedOperationException();
	}
	
	public void removeFile(Common f) {
		throw new UnsupportedOperationException();
	}
}
