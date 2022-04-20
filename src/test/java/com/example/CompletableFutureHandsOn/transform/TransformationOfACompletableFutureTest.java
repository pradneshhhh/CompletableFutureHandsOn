package com.example.CompletableFutureHandsOn.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransformationOfACompletableFutureTest {
	
	private TransformationOfACompletableFututre TransformationOfACompletableFuture = new TransformationOfACompletableFututre();
	
	@Test
	public void withThenApplyTest() throws InterruptedException, ExecutionException {
		var result = TransformationOfACompletableFuture.withThenApply("Paddy");
		assertEquals("Hello Paddy", result);
	}
	
	@Test
	public void withThenAcceptTest() throws InterruptedException, ExecutionException {
		TransformationOfACompletableFuture.withThenAccept("Paddy");
	}
	
	@Test
	public void withThenRunTest() throws InterruptedException, ExecutionException {
		TransformationOfACompletableFuture.withThenRun("Paddy");
	}
	
	@Test
	public void withThenApplyAsyncTest() throws InterruptedException, ExecutionException {
		var result = TransformationOfACompletableFuture.withThenApplyAsync("Paddy");
		assertEquals("Hello Paddy", result);
	}
}
