package com.solaluna.wiki;

import com.solaluna.wiki.service.PageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WikiApplicationTests {

	@Autowired
    PageService service;
	@Test
	void delete() {
		service.removeById(4);
	}

}
