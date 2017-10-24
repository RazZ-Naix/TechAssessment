package myMaven;
/*
Object for the file attributes of the iterated file.
*/
public class Attributes {
    private final String path;    
    private final String lastModified;    
    private final Boolean isDirectory;
    private final long size;

    public Attributes(String path, String lastModified, Boolean isDirectory, long size) {
        this.path = path;        
        this.lastModified = lastModified;        
        this.isDirectory = isDirectory;
        this.size = size;
    }

    public String getPath() {
        return path;
    }    

    public String getLastModified() {
        return lastModified;
    }  

    public Boolean getDirectory() {
        return isDirectory;
    }

    public long getSize() {
        return size;
    }
}
