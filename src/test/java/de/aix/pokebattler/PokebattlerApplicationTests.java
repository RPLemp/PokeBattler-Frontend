package de.aix.pokebattler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootTest(classes = PokebattlerApplicationTests.TestConfig.class)
class PokebattlerApplicationTests {

	@Configuration
	static class TestConfig {
	}

	@Test
	void contextLoads() {
	}

}
