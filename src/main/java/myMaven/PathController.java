package myMaven;
import java.io.*;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper; //JSON Parser
/*
	PathController;
		Controller for the PathFinder
	Adds the directory and FileDepth parameters for the /PathFinder url
 */
@RestController
public class PathController {
    
    List<Attributes> listAttri = null;	
    private String result = null;
	private static ObjectMapper JSON_Parser = new ObjectMapper();

    @RequestMapping("/PathFinder")
    public ResponseEntity PathFinder(@RequestParam(value="directory", defaultValue=".") String strPath, @RequestParam(value = "FileDepth", defaultValue = "5") Integer intFileDepth ) throws IOException {
        PathFinder pathFinder = new PathFinder();
		
		listAttri = pathFinder.findPath(strPath, intFileDepth);
		result = JSON_Parser.writeValueAsString(listAttri);
		
		return ResponseEntity.ok(result);
    }
}