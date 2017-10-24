package myMaven;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

// The Iterate class defines how the PathFinder iterates over the file structure 

class Iterate implements FileVisitor<Path>{
    
    private long globalCount;
    private List<Attributes> attrList = new ArrayList<Attributes>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
	//after iterating over a file add its attributes to the list and increment the globalCount
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {        
        globalCount++;
        attrList.add(getFileAttributesFromPath(file));

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
	// Returns globalCount total files iterated
    public long getFilesCount() {        
        return globalCount;
    }
	// Returns attributes list
    public List<Attributes> getFileAttributesList() {        
        return attrList;
    }
	// Attributes object for each file in the file path
    private static Attributes getFileAttributesFromPath(Path file) {        
        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

            return new Attributes(
                    file.toString(),                    
                    attr.lastModifiedTime().toString(),                    
                    attr.isDirectory(),
                    attr.size());
        } catch (IOException e) {
            System.out.print("Error in Iterate");
            throw new RuntimeException();
        }
    }



}


