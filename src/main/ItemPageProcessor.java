package main;



import org.apache.log4j.BasicConfigurator;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author code4crafter@gmail.com <br>
 * @since 0.3.2
 */
public class ItemPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    
    private ResultItems resultItems;
    
    public ResultItems getResultItems(){
    	return resultItems;
    }

    public void process(Page page) {
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-]+/[\\w\\-])").all());
        //page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/[\\w\\-])").all());
        //page.putField("author", page.getUrl().regex("https://github\\.com/(\\w+)/.*").toString());
       
    	page.putField("title", page.getHtml().xpath("//h1[@id='title']/span[@id='productTitle']/text()").toString());
        if (page.getResultItems().get("title")==null){
            //skip this page
            page.setSkip(true);
        }
        
        page.putField("style", page.getHtml().xpath("//div[@id='variation_style_name']/div[@class='a-row']/span[@class='selection']/text()"));
        page.putField("size", page.getHtml().xpath("//div[@id='variation_size_name']/div[@class='a-row']/span[@class='selection']/text()"));
        page.putField("color", page.getHtml().xpath("//div[@id='variation_color_name']/div[@class='a-row']/span[@class='selection']/text()"));
        
        page.putField("price", page.getHtml().xpath("//span[@id='priceblock_ourprice']/text()"));
        
        resultItems = page.getResultItems();
        System.out.println(page.getResultItems().toString());
    }

    public Site getSite() {
        return site;
    }

    
}