package howard.edu.lsp.finals.problem;
import org.junit.Test;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static org.junit.Assert.*;

public class SongsDatabaseTest {
    @Test
    public void testSongsDatabase() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rap", "Savage");
        db.addSong("Rap", "Gin and Juice");
        db.addSong("Jazz", "Always There");
        db.addSong("Pop", "Rock My World");
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));
        assertFalse(rapSongs.contains("Always There"));
        assertEquals("Rap", db.getGenreOfSong("Savage"));
        assertEquals("Jazz", db.getGenreOfSong("Always There"));
        assertNull(db.getGenreOfSong("Rock My World"));
        System.out.println(db.getGenreOfSong("Gin and Juice")); // prints "Rap"
        System.out.println(db.getGenreOfSong("Rock My World")); // should print "pop"
        System.out.println(db.getGenreOfSong("Savage")); // should print "pop"
    }
    
    @Test
    public void testAddMultipleSongsToSameGenre() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Hip Hop", "Lose Yourself");
        db.addSong("Hip Hop", "Crush on You");
        db.addSong("Hip Hop", "Who Run It");

        Set<String> hipHopSongs = db.getSongs("Hip Hop");
        assertTrue(hipHopSongs.contains("Lose Yourself"));
        assertTrue(hipHopSongs.contains("Crush on You"));
        assertTrue(hipHopSongs.contains("Who Run It"));
        assertEquals(3, hipHopSongs.size()); // should add all these three songs to the hiphop genre
    }
    
    @Test
    public void testGetGenreOfNonExistingSong() {
        SongsDatabase db = new SongsDatabase();
        assertNull(db.getGenreOfSong("I Hate You"));
    }
    @Test
    public void testAddSameSongToMultipleGenres() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Pop", "Bad Guy");
        db.addSong("Hip Hop", "Bad Guy");
        assertEquals("Pop", db.getGenreOfSong("Bad Guy"));
        Set<String> expectedSongs = new HashSet<>();
        expectedSongs.add("Bad Guy");
        assertEquals(expectedSongs, db.getSongs("Pop"));
        assertEquals(expectedSongs, db.getSongs("Hip Hop"));
    }

// final
    
}