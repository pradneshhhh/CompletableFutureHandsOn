package com.example.CompletableFutureHandsOn.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExceptionHandelingOfACompletableFutureTest {
	
	private ExceptionHandelingOfACompletableFuture exceptionHandelingOfACompletableFuture = new ExceptionHandelingOfACompletableFuture();
	
	@Test
	public void withExceptionallyTest() throws InterruptedException, ExecutionException {
		String msg = exceptionHandelingOfACompletableFuture.withExceptionally();
		assertEquals(msg, "Unknown!!");
	}
	
	@Test
	public void withHandleTest() throws InterruptedException, ExecutionException {
		String msg = exceptionHandelingOfACompletableFuture.withHandle();
		assertEquals(msg, "Unknown!!");
	}
}
