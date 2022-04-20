package com.example.CompletableFutureHandsOn.transform;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TransformationOfACompletableFututre {
	
	/**
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * You can use thenApply() method to process and transform the result of a CompletableFuture when it arrives. 
	 * It takes a Function<T,R> as an argument.
	 * Function<T,R> is a simple functional interface representing a function that
	 * accepts an argument of type T and produces a result of type R
	 * 
	 */
	public String withThenApply(String name) throws InterruptedException, ExecutionException {
		return CompletableFuture.supplyAsync(() ->{
			return name;
		})
		.thenApply((n)->{
			return "Hello "+ n;
		}).get();
	}
	
	/**
	 * @param name
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * CompletableFuture.thenAccept() takes a Consumer<T> and returns CompletableFuture<Void>.
	 * It has access to the result of the CompletableFuture on which it is attached
	 * 
	 */
	public void withThenAccept(String name) throws InterruptedException, ExecutionException {
		CompletableFuture.supplyAsync(() ->{
			return name;
		})
		.thenAccept((n)->{
			System.out.println("In thenAccept--> Hello "+n);
		}).get();
	}
	
	/**
	 * @param name
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * While thenAccept() has access to the result of the CompletableFuture on which it is attached,
	 * thenRun() doesn’t even have access to the Future’s result. 
	 * It takes a Runnable and returns CompletableFuture<Void>
	 * 
	 */
	public void withThenRun(String name) throws InterruptedException, ExecutionException {
		CompletableFuture.supplyAsync(() ->{
			return name;
		})
		.thenRun(()->{
			System.out.println("In thenRun--> Hello ");
		}).get();
	}
	
	/**
	 * @param name
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * To have more control over the thread that executes the callback task, you can use async callbacks. 
	 * If you use thenApplyAsync() callback, 
	 * then it will be executed in a different thread obtained from ForkJoinPool.commonPool()
	 * 
	 */
	public String withThenApplyAsync(String name) throws InterruptedException, ExecutionException {
		return CompletableFuture.supplyAsync(() ->{
			return name;
		})
		.thenApplyAsync((n)->{
			return "Hello "+ n;
		}).get();
	}
}
