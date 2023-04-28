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
        Set<String> rapSongs = db.getSongs("Rap");
        assertTrue(rapSongs.contains("Savage"));
        assertTrue(rapSongs.contains("Gin and Juice"));
        assertFalse(rapSongs.contains("Always There"));
        assertEquals("Rap", db.getGenreOfSong("Savage"));
        assertEquals("Jazz", db.getGenreOfSong("Always There"));
        assertNull(db.getGenreOfSong("Hotel California"));
        System.out.println(db.getGenreOfSong("Gin and Juice")); // prints "Rap"
        System.out.println(db.getGenreOfSong("Hotel California")); // prints "Jazz"
    }
    
}