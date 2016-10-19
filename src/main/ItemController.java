package main;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;

@Controller

public class ItemController{
	@RequestMapping(value="/getItemInfo")
	@ResponseBody
	public  String getItemInfo(@RequestParam("ASIN") String ASIN){
		//String ASIN = request.getParameter("ASIN");
		System.out.println("ok");
		String url = "https://www.amazon.com/dp/"+ASIN;
		System.out.println(ASIN);
		System.out.println(url);
		
		
		ItemPageProcessor proc = new ItemPageProcessor();
		BasicConfigurator.configure();
        Spider.create(proc)
        .addUrl(url)
        .thread(1)
        .run();
		
        System.out.println(proc.getResultItems().toString());
        
        return "";
        
//		ResultItems r = proc.getResultItems();
//		Book item = new Book();
//		item.setName(ASIN);
//		item.setPrice(799.38);
//		
//		return new ObjectMapper().writeValueAsString(item);
	}

	public static void main(String[] args)
	{
		ItemPageProcessor proc = new ItemPageProcessor();
		BasicConfigurator.configure();
        Spider.create(proc)
        .addUrl("https://www.amazon.com/dp/B00UGBMRQ8")
        .thread(1)
        .run();
		
        System.out.println(proc.getResultItems().toString());
	}
}
