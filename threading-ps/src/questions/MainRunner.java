package questions;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


class Question implements Callable<String>{
 private String question; 
 private String opt1, opt2, opt3, opt4; 
 private String correctOpt; 
 
 public void setData(String q,String o1,String o2,String o3,String o4,String c){
	 question = q;
	 opt1 = o1;
	 opt2 = o2;
	 opt3 = o3;
	 opt4 = o4;
	 correctOpt = c;
 }
 public void printQs() {
	 System.out.println(question+"\n a."+opt1+"\n b."+opt2+"\n c."+opt3+"\n d."+opt4);
 }
 public String call() throws Exception {
	 printQs();
	BufferedReader br = new BufferedReader(
	        new InputStreamReader(System.in));
		    String input;
		    do {
		      try {
		        // wait until we have data to complete a readLine()
		        while (!br.ready()) {
		          Thread.sleep(200);
		        }
		        input = br.readLine();
		      } catch (InterruptedException e) {
		        return null;
		      }
		    } while ("".equals(input));
	if(input.contentEquals(correctOpt))	    	
		    return "CORRECT";
	 else 
		 return "INCORRECT";
 }
}



public class MainRunner {

    public static void quizInput(ExecutorService executor,Question q) {
    	Future<String> future = executor.submit(q);
    	try {
    	   String result = future.get(10, TimeUnit.SECONDS);
    	   System.out.println(result);
    	} catch (TimeoutException ex) {
    	   System.out.println("TIMEOUT");
    	   future.cancel(true);
    	} catch (InterruptedException e) {
    	   // handle the interrupts
    	} catch (ExecutionException e) {
    	   // handle other exceptions
    	} finally {
    	   // may or may not desire this
    	}
    }
    public static void main(String args[]){
    	ScheduledExecutorService executor = Executors.newScheduledThreadPool(2); 
    	Question questions[] = new Question[10];
    	for(int i=0;i<10;i++) {
    		questions[i] = new Question();
    	}
    	questions[0].setData("Who is president of india", "Donald Trump", 
    			"Ramnath Kovind", "Narendra Modi", "None","b");
    	questions[1].setData("Who is prime minister of india", "Donald Trump", 
    			"Ramnath Kovind", "Narendra Modi", "None","c");
    	questions[2].setData("Who is president of USA", "Donald Trump", 
    			"Ramnath Kovind", "Narendra Modi", "None","a");
    	questions[3].setData("How many rings are on the Olympic flag?", "6", 
    			"4", "5", "None","c");
    	questions[4].setData(" In darts, what's the most points you can score with a single throw?", "100", 
    			"80", "40", "60","d");
    	questions[5].setData("How many holes are on a standard bowling ball?", "2", 
    			"3", "1", "4","b");
    	questions[6].setData(" What are the main colors on the flag of Spain?", "Black and Blue", 
    			"Red and Yellow", "Yellow and Black", "None","b");
    	questions[7].setData(" What is the longest that an elephant has ever lived? (That we know of)", "86", 
    			"62", "77", "48","a");
    	questions[8].setData("Who is president of india", "Donald Trump", 
    			"Ramnath Kovind", "Narendra Modi", "None","b");
    	questions[9].setData("Who is president of india", "Donald Trump", 
    			"Ramnath Kovind", "Narendra Modi", "None","b");
    
    	for(int i=0;i<10;i++) {
    		quizInput(executor,questions[i]);
    	}
    	executor.shutdown();
 	   
    }

}
