# amazonDashboard

This is a simple dashboard for monnitoring the prices of a set of goods sold on amazon. 

The user can upload a CSV file which contains a set of goods information including the ASIN (can be taken as good's ID). Then the user can swicth to a dashboard page to view the details of those goods specially the price in a table.

So far, if the user want to see the realtime price, he need to refresh the page.

## data flow
1. user upload the CSV file.
2. parse the CSV file, store those information in MySQL database.
3. retrieve the records to get the goods' ASIN number.
4. download those corresponding pages on Amazon for each good.
5. parse those pages and extract the information we need and store it into MySQL database.
6. retrieve the desired information from database and show them on dashboard page by page.

## To do list

1. set a certain time to crawl the newest products' details automatically and refresh the page.
2. set proxy server so that the crawler works. 
