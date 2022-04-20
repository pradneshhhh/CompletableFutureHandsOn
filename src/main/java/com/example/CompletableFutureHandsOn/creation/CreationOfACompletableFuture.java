package com.example.CompletableFutureHandsOn.creation;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CreationOfACompletableFuture {
	
	
	/**
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * If you want to run some background task asynchronously 
	 * and don’t want to return anything from the task, 
	 * then you can use CompletableFuture.runAsync() method. 
	 * It takes a Runnable object 
	 * and returns CompletableFuture<Void>
	 * 
	 */
	public void withRunAsync() throws InterruptedException, ExecutionException {
		
		// Run a task specified by a Runnable Object asynchronously.
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			System.out.println("Task is running inside of CompletableFuture with runAsync()");
		});
		
		// Block and wait for the future to complete
		future.get();
	}
	
	/**
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * CompletableFuture.supplyAsync() takes a Supplier<T>
	 * and returns CompletableFuture<T> 
	 * where T is the type of 
	 * the value obtained by calling the given supplier 
	 * 
	 */
	public String withSupplyAsync() throws InterruptedException, ExecutionException{
		
		// Run a task specified by a Supplier object asynchronously
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Task is running inside of CompletableFuture with supplyAsync()");
			return "Hello World";
		});
		
		// Block and wait for the future to complete
		return future.get();
	}
}
