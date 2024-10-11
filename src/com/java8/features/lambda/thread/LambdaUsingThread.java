package com.java8.features.lambda.thread;

public class LambdaUsingThread{

	public static void main(String[] args) {
		
		LambdaUsingThreadImpl laImpl = new LambdaUsingThreadImpl();
		laImpl.run();
		
		Runnable runnable = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("LambdaUsingThreadImpl : " + i);
			}
		};

		runnable.run();
	}


}
