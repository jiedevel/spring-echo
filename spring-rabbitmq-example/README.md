## Java Spring RabbitMQ Demo

Make sure you have the AQMP dependency, lombok is an optional, although it helps.

Run the docker 

      docker pull rabbitmq:management
      docker run -d -p 5672:5672 -p 15672:15672 --name <ifyouwantaname> <imageid>
 

1. You coud run unit test to send and receive message with pre-defined exchanges, queues, bindings.  
2. Run the server, which is listening on the rabbitmq server; you then could run the unit test to send messages.
3. Use AqmpAdmin to manage the exchanges, queues, bindings.