package corejavaexamples;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import com.org.examples.multithreading.SynchronizedMethods;

public class SynchronizedMethodsTest {
	
	@Test
	public void givenMultiThread_whenNonSyncMethod() throws InterruptedException {
	    ExecutorService service = Executors.newFixedThreadPool(3);
	    SynchronizedMethods summation = new SynchronizedMethods();

	    IntStream.range(0, 1000)
	      .forEach(count -> service.submit(summation::calculate));
	    service.awaitTermination(1000, TimeUnit.MILLISECONDS);

	    assertEquals(1000, summation.getSum());
	}
	
	@Test
	public void givenMultiThread_whenMethodSync() throws InterruptedException {
	    ExecutorService service = Executors.newFixedThreadPool(3);
	    SynchronizedMethods method = new SynchronizedMethods();

	    IntStream.range(0, 1000)
	      .forEach(count -> service.submit(method::synchronisedCalculate));
	    service.awaitTermination(1000, TimeUnit.MILLISECONDS);

	    assertEquals(1000, method.getSum());
	}
	
	@Test
	public void givenMultiThread_whenStaticSyncMethod() throws InterruptedException {
	    ExecutorService service = Executors.newCachedThreadPool();

	    IntStream.range(0, 1000)
	      .forEach(count -> 
	        service.submit(SynchronizedMethods::syncStaticCalculate));
	    service.awaitTermination(100, TimeUnit.MILLISECONDS);

	    assertEquals(1000, SynchronizedMethods.staticSum);
	}
	
	@Test
	public void givenMultiThread_whenBlockSync() throws InterruptedException {
	    ExecutorService service = Executors.newFixedThreadPool(3);
	    SynchronizedMethods synchronizedBlocks = new SynchronizedMethods();

	    IntStream.range(0, 1000)
	      .forEach(count -> 
	        service.submit(synchronizedBlocks::performSynchronizedTask));
	    service.awaitTermination(100, TimeUnit.MILLISECONDS);

	    assertEquals(1000, synchronizedBlocks.getCount());
	}
	
	@Test
	public void givenMultiThread_whenStaticSyncBlock() throws InterruptedException {
	    ExecutorService service = Executors.newCachedThreadPool();

	    IntStream.range(0, 1000)
	      .forEach(count -> 
	        service.submit(SynchronizedMethods::performStaticSyncTask));
	    service.awaitTermination(100, TimeUnit.MILLISECONDS);

	    assertEquals(1000, SynchronizedMethods.staticCount);
	}

}
