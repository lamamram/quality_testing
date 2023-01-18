package testing.tests.regex;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import testing.regex.SLowDependency;
import testing.regex.UrlRegex;

class UrlTest {
    
    // fixtures
    private UrlRegex ur;
    String pattern = "(https?|s?ftp|ftps?|ssh):\\/\\/((?:[a-z0-9_\\-]+\\.)+[a-z]{2,})((?:\\/[a-z0-9_\\-]+)+\\/?)?";
    String flags = "i";
    private final SLowDependency sd = mock(SLowDependency.class);

    @BeforeEach
    void instantiateRegex() {
        ur = new UrlRegex(pattern, flags);
    }

    @Test
    @DisplayName("Tester la capture des groupe")
    @Tag("Unit")
    void testCaptureMatch() {
        // Arrange
        //String pattern = "(https?|s?ftp|ftps?|ssh):\\/\\/((?:[a-z0-9_\\-]+\\.)+[a-z]{2,})((?:\\/[a-z0-9_\\-]+)+\\/?)";
        //String flags = "i";
        //UrlRegex ur = new UrlRegex(pattern, flags);
        String proto = "http";
        String domain = "gitlab.dawan.fr";
        String path = "/branches/main";
        // Act
        try {
            // redefinition de la méthode lente
            // qui renvoie la réponse immédiatement
            when(sd.slowMethod()).thenReturn("param");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        List<String> groups = ur.captureMatch(proto + "://" + domain + path);
        // Assert: EXPECTED CALCULATED
        assertArrayEquals(new String[] { proto, domain, path }, groups.toArray());
    }

    @Test
    @DisplayName("Tester le remplacement de regex")
    @Tag("Unit")
    @Tag("Regex")
    void testReplaceMatch() {
        // Arrange
        String target = "sites: http://google.com et ftp://ftp.oracle.com/data";
        String repl = "*****";
        String expected = "sites: ***** et *****";
        // Act
        String replaced = ur.replace(target, repl);
        // Assert
        assertEquals(expected, replaced);
    }
}
