package myMaven;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PathFinderTest {
    PathFinder pathFinder = new PathFinder();
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testDirectoryTraverserThrowsFileNotFoundExceptionWithInvalidPathName() throws IOException {
        // assert Statements
        exception.expect(FileNotFoundException.class);
        pathFinder.findPath("BrokenPath", 5);
    }

    @Test
    public void testDirectoryTraverserThrowsIllegalArgumentExceptionWithInvalidDepth() throws IOException {
        // assert Statements
        exception.expect(IllegalArgumentException.class);
        pathFinder.findPath(".", -1);
    }
}
