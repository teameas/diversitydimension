import scrapy

class WebSpider(scrapy.Spider):
    name = 'webspider'
    
    query = ['Vista Industrial Packaging, LLC', 'Alumawall, Inc.', 'Lavelle & Finn LLP']

    data={}
    for i in query:
        for j in search(i, tld="co.in", num=1, stop=1, pause=2):
            print(j)
            data['dunsName'] = i
            data['url'] = j
            
    start_url = "['" + data['url'] +"']"

    def parse(self, response):
        #Extracting the content using css selectors
        
        title = title.css('::text').get()
        i = response.xpath('//*[@class="the-content"] > p[text()="wife"]').extract()

        if i is not None:
            isWomen = '1-Y'
        else:
            isWomen = '0-N'
            
        d = response.xpath('//*[@class="the-content"] > p[text()="Asian" or text()="Black" or text()="African" ]').extract()
        
        if d is not None:
            isDiversedOwned = '1-Y'
        else:
            isDiversedOwned = '0-N'
       
        #Give the extracted content row wise
        for item in zip(titles,isWomen,isMinority):
            #create a dictionary to store the scraped info
            scraped_info = {
                'title' : item[0],
                'isWomen' : item[1],
                'isMinority' : item[2],
            }

            #yield or give the scraped info to scrapy
            yield scraped_info