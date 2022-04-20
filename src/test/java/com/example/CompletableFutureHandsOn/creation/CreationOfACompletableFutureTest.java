package com.example.CompletableFutureHandsOn.creation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreationOfACompletableFutureTest {
	
	private CreationOfACompletableFuture creationOfACompletableFuture = new CreationOfACompletableFuture();
	
	@Test
	public void withRunAsyncTest() throws InterruptedException, ExecutionException {
		creationOfACompletableFuture.withRunAsync();
	}
	
	@Test
	public void withSupplyAsyncTest() throws InterruptedException, ExecutionException {
		var result = creationOfACompletableFuture.withSupplyAsync();
		assertEquals("Hello World", result);
	}
}
