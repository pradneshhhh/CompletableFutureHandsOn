package com.example.CompletableFutureHandsOn.combination;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CompletableFutureHandsOn.combine.CombinationOfACompletableFuture;

@SpringBootTest
public class CombinationOfACompletableFutureTest {
	
	private CombinationOfACompletableFuture combinationOfACompletableFuture = new CombinationOfACompletableFuture();
	
	@Test
	public void withThenComposeTest() throws InterruptedException, ExecutionException {
		var result = combinationOfACompletableFuture.withThenCompose(1L);
		assertEquals(result, 456.90);
	}
	
	@Test
	public void withThenCombineTest() throws InterruptedException, ExecutionException {
		var result = combinationOfACompletableFuture.withThenCombine();
		assertEquals(result, 2.00);
	}
	
	@Test
	public void withAllOfTest() throws InterruptedException, ExecutionException {
		var result = combinationOfACompletableFuture.withAllOf();
		assertEquals(result, 2.00);
	}
}
