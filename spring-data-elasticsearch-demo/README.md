## Java Spring Elasticsearch Demo

Make sure you have the spring-data-elaticsearch dependency, lombok is an optional, although it helps.

Run the docker 

      docker pull elasticsearch:6.8.3 ( Be consistent with spring-data-elastic version) 
      docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" <imageid>
 

You coud run unit test together with your  browser, and Postman
