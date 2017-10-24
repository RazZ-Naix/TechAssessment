package myMaven;
import java.util.*;
import java.io.*;
import java.nio.file.*;
/*
	Inputs:
		String strPath: Defines the starting directory
		int range: Defines how far into the file structure the PathFinder will iterate
	Returns:
		List of attributes
	
	PathFinder:
		Finds paths and attributes
 */
public class PathFinder {

    private List<Attributes> result = null;

    public List<Attributes> findPath(String strPath, int range) throws IOException {

        Path path = Paths.get(strPath);
        try{
            if (Files.exists(path)) {
                System.out.print(path);
                Iterate iterater = new Iterate();//declare iterater
                Files.walkFileTree(path, EnumSet.noneOf(FileVisitOption.class), range, iterater);//iterateration
                result = iterater.getFileAttributesList();                

                if (!Integer.class.isInstance(range))//simple error checking
                {
                    System.out.print("FileDepth must be an integer");
                    throw new IllegalArgumentException();
                }
                else if (!(range >= 0)){
                    System.out.print("FileDepth must be positive");
                    throw new IllegalArgumentException();
                }

            }
            else {
                throw new FileNotFoundException();
            }
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        catch (IOException e) {
            throw new IOException();

        }

        return result;
    }
}