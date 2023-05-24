package com.solaluna.wiki;

import com.solaluna.wiki.pojo.page.Chara;
import com.solaluna.wiki.pojo.page.Page;
import com.solaluna.wiki.service.PageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WikiApplicationTests {
	@Autowired
	PageService service;

	@Test
	void add() {
//		Map<String,String> history = new HashMap<>();
//		history.put("123","123");
		Chara chara = new Chara("1","1","1");
		Page page = new Page();
		page.setMainchara(chara);
//		page.setHistory(history);
		System.out.println(page);
		service.save(page);
	}

	@Test
	void get()
	{
		Page page = service.getById(1);
		System.out.println(page);
	}
}
