package testing.tests.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



class SeleniumFirefoxTest {
	
	private WebDriver driver;
	
	//@Test
	@Tag("E2E")
	void test() {
		this.driver = new FirefoxDriver();
        this.driver.get("https://dawan.fr");
        assertThat(this.driver.getTitle()).contains("Dawan");
		this.driver.close();
	}

}
