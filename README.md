# wordcount
##Flink 
1) start/stop cluster: 
  ./bin/start-cluster.sh
  ./bin/stop-cluster.sh
  
2) run default example:
  $ ./bin/flink run examples/streaming/WordCount.jar
  $ tail log/flink-*-taskexecutor-*.out
refer to https://ci.apache.org/projects/flink/flink-docs-release-1.12/try-flink/local_installation.html

3) prepare example:
  - create maven based project
  - write source code
  - package jar file
  - use ./bin/flink to invoke above jar file
  
## run cusutom example for dataset:
  - ./bin/flink run /tmp/wordcount-0.1.jar (consume default text)
  - ./bin/flink run /tmp/wordcount-0.1.jar --input /opt/flink-1.12.1/README.txt --output /opt/flink-1.12.1/result.txt
  
## run cusutom example for datastream:
  - open one terminal, start local nc: nc -lk 9999
  - open another terminal, invoke datastream example: ./bin/flink run /tmp/windowwordcount-0.1.jar
  - back to first terminal, input value and enter to new line, continue to input
  - open third terminal, check result under /opt/flink-1.12.1/log
### execution result:
input:
	root@hall-OptiPlex-9020:~# nc -lk 9999
	aa
	aa
	aa aa
	aa aa aa
	aa aa aaa aaa
	aa
	aa
	aa
	bb
	bb
	bb bb bb
	bb bb bb bbb
	abc abc abc abc ded

output under third terminal:
	cat flink-root-taskexecutor-2-hall-OptiPlex-9020.out
	WARNING: An illegal reflective access operation has occurred
	WARNING: Illegal reflective access by org.apache.flink.shaded.akka.org.jboss.netty.util.internal.ByteBufferUtil (file:/opt/flink-1.12.1/lib/flink-dist_2.12-1.12.1.jar) to method java.nio.DirectByteBuffer.cleaner()
	WARNING: Please consider reporting this to the maintainers of org.apache.flink.shaded.akka.org.jboss.netty.util.internal.ByteBufferUtil
	WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
	WARNING: All illegal access operations will be denied in a future release
	(aa,7)
	(aa,2)
	(aaa,2)
	(aa,3)
	(bb,5)
	(bb,3)
	(bbb,1)
	(abc,4)
	(ded,1)

output under second terminal:
	./bin/flink run /tmp/windowwordcount-0.1.jar
	WARNING: An illegal reflective access operation has occurred
	WARNING: Illegal reflective access by org.apache.flink.api.java.ClosureCleaner (file:/opt/flink-1.12.1/lib/flink-dist_2.12-1.12.1.jar) to field java.lang.String.value
	WARNING: Please consider reporting this to the maintainers of org.apache.flink.api.java.ClosureCleaner
	WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
	WARNING: All illegal access operations will be denied in a future release
	
View job status on GUI:
  - http://10.182.173.198:8081/#/job/running
  
  
### quit stream job:
under second terminal, click "Ctrl + C" to quit stream process then get below output:
	./bin/flink run /tmp/windowwordcount-0.1.jar
	WARNING: An illegal reflective access operation has occurred
	WARNING: Illegal reflective access by org.apache.flink.api.java.ClosureCleaner (file:/opt/flink-1.12.1/lib/flink-dist_2.12-1.12.1.jar) to field java.lang.String.value
	WARNING: Please consider reporting this to the maintainers of org.apache.flink.api.java.ClosureCleaner
	WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
	WARNING: All illegal access operations will be denied in a future release
	Job has been submitted with JobID 4b78a3668e35c432a9258f8d8ce3efc7
	Program execution finished
	Job with JobID 4b78a3668e35c432a9258f8d8ce3efc7 has finished.
	Job Runtime: 179893 ms

View job status on GUI:
  - http://10.182.173.198:8081/#/job/completed