package testing.tests.regex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import testing.regex.UrlRegex;

class UrlTest {

    @Test
    void testCaptureMatch() {
        // Arrange
        String pattern = "(https?|s?ftp|ftps?|ssh):\\/\\/((?:[a-z0-9_\\-]+\\.)+[a-z]{2,})((?:\\/[a-z0-9_\\-]+)+\\/?)";
        String flags = "i";
        UrlRegex ur = new UrlRegex(pattern, flags);
        String proto = "http";
        String domain = "gitlab.dawan.fr";
        String path = "/branches/main";
        // Act
        List<String> groups = ur.captureMatch(proto + "://" + domain + path);
        // Assert:               EXPECTED                          CALCULATED
        assertArrayEquals(new String[] {proto, domain, path}, groups.toArray());
    }

}
