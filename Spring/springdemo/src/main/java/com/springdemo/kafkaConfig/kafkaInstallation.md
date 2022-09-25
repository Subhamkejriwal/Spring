Apache Kafka can be downloaded from its official site : 
    
    https://kafka.apache.org/downloads


Extract the file and move the extracted folder to the directory where you wish to keep the files.

Copy the path of the Kafka folder. Now go to config inside kafka folder and open zookeeper.properties file. Copy the path against the field dataDir and add /zookeeper-data to the path.
          
          for eg. - dataDir=E:/kafka_2.13-3.2.3/zookeeper

Now in the same folder config open server.properties and scroll down to log.dirs and paste the path. To the path add /kafka-logs
          
          for eg. - log.dirs=E:/kafka_2.13-3.2.3/kafka-logs
          
This completes the configuration of zookeeper and kafka server. Now open command prompt and change the directory to the kafka folder.      First start zookeeper using the command given below:
     
     .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
     
Now open another command prompt and change the directory to the kafka folder. Run kafka server using the command:

     .\bin\windows\kafka-server-start.bat .\config\server.properties
     
create Topic on cmd kafka :-
    
     .\bin\windows\kafka-topics.bat --create --topic (topicName) --bootstrap-server localhost:9092
     
For starting Kafka producer(for sending or producing message) :-

        kafka-console-producer.bat --broker-list localhost:9092 --topic test
     
For starting kafka Consumer(for receiving message) :-

        kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic (topic name)
        
