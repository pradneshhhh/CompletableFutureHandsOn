package com.example.CompletableFutureHandsOn.exception;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHandelingOfACompletableFuture {
	
	/**
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * The exceptionally() callback gives you a chance to recover from errors generated from the original Future. 
	 * You can log the exception here and return a default value.
	 * 
	 */
	public String withExceptionally() throws InterruptedException, ExecutionException {
		int age = -1;
		CompletableFuture<String> ageFuture = CompletableFuture.supplyAsync(() -> {
			if(age < 0) {
				throw new IllegalArgumentException("Age cannot be negative!");
			} if(age >= 18) {
				return "Adult";
			} if(age < 18) {
				return "Minor";
			}
			return "Unknown!";
		}).exceptionally(ex -> {
			System.out.println("Exception occurred--> "+ex.getMessage());
			return "Unknown!!";
		});
		
		return ageFuture.get();
	}
	
	/**
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * The API also provides a more generic method - handle() to recover from exceptions. 
	 * It is called whether or not an exception occurs.
	 * 
	 */
	public String withHandle() throws InterruptedException, ExecutionException {
		int age = -1;
		CompletableFuture<String> ageFuture = CompletableFuture.supplyAsync(() -> {
			if (age < 0) {
				throw new IllegalArgumentException("Age cannot be negative!");
			}
			if (age >= 18) {
				return "Adult";
			}
			if (age < 18) {
				return "Minor";
			}
			return "Unknown!";
		}).handle((res, ex) -> {
			if (ex != null) {
				System.out.println("Exception occurred--> " + ex.getMessage());
				return "Unknown!!";
			}
			return res;
		});

		return ageFuture.get();
	}
}
