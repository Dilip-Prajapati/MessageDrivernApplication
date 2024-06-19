Class Description:

MessageQueue class:
  MessageQueue class is create LinkedBlockingQueue.
  Create send and receive method.
  
Logger class:
  Create AtomicInteger variable for successMessage count and errorMessage cout.

Producer Class:
  Produces messages and puts them into the queue.
  
Consumer Class:
    Consumes messages from the queue.
    Logs successful messages and errors encountered.

Main Class:
    Sets up the producer and consumer, starts their threads using ExecutorService.
	
Unit Tests:
    Tests both successful and error scenarios.
    Uses a blocking queue to simulate the message queue.
    Verifies the counts of successful messages and errors.
	
	
Step to Run the Code:

Set Up Your Development Environment:
     Ensure you have Java Development Kit (JDK) installed.
	   Set up an Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or use a text editor and terminal.

Import Project:
    Import Project From Github Link in IntelliJ IDEA, Eclipse.

Run Main Class:
    In your IDE, locate the Main.java file.
    Right-click on Main.java and select "Run".
	
Run the Unit Tests:
    In your IDE, locate the MessageDrivenApplicationTest.java file.
	  Right-click on MessageDrivenApplicationTest.java and select "Run as JUnit Test".
