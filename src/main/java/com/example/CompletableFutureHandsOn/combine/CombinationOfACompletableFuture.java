package com.example.CompletableFutureHandsOn.combine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.example.CompletableFutureHandsOn.dto.User;
import com.example.CompletableFutureHandsOn.service.UserService;

public class CombinationOfACompletableFuture {
	
	private final UserService userService = new UserService();
	
	/**
	 * @param userId
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * Combine two dependent futures using thenCompose()
	 * 
	 * 
	 * 
	 */
	public Double withThenCompose(long userId) throws InterruptedException, ExecutionException {
		return CompletableFuture.supplyAsync(() -> {
			return userService.getUserDetails(userId);
		}).thenCompose(user -> getCreditRating(user)).get();
	}

	CompletableFuture<Double> getCreditRating(User user) {
		return CompletableFuture.supplyAsync(() -> {
			return userService.getCreditRating(user);
		});
	}
	
	/**
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * 
	 * Combine two independent futures using thenCombine()
	 * thenCombine() is used when you want two Futures to run independently
	 * and do something after both are complete
	 * 
	 */
	public Double withThenCombine() throws InterruptedException, ExecutionException {
		CompletableFuture<Double> userDetails = CompletableFuture.supplyAsync(() -> {
			User u = userService.getUserDetails(1L);
			return u.getFirstName().length() + 0.00;
		});
		
		CompletableFuture<Double> creditRating = getCreditRating(null);
		
		return userDetails.thenCombine(creditRating, (i,j) -> {
			return i+j;
		}).get();
	}
	
	/**
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public Double withAllOf() throws InterruptedException, ExecutionException {
		CompletableFuture<Double> userDetails = CompletableFuture.supplyAsync(() -> {
			User u = userService.getUserDetails(1L);
			return u.getFirstName().length() + 0.00;
		});
		
		CompletableFuture<Double> creditRating = getCreditRating(null);
		
		List<CompletableFuture<Double>> cFutures = Arrays.asList(userDetails, creditRating);
		
		CompletableFuture.allOf(cFutures.toArray(new CompletableFuture[cFutures.size()]));
		
		return CompletableFuture
				.allOf(cFutures.toArray(new CompletableFuture[cFutures.size()]))
				.thenApplyAsync(v->{
					return cFutures.stream().map(future -> future.join()).collect(Collectors.toList());
				}).get().stream().collect(Collectors.summingDouble(Double::doubleValue));
	}
}
