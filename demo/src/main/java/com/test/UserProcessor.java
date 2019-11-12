package com.test;



import org.springframework.batch.item.ItemProcessor;

public class UserProcessor implements ItemProcessor<User, User> {

	private String threadName;

	@Override
	public User process(User item) throws Exception {

		System.out.println(threadName + " processing : " 
			+ item.getId() + " : " + item.getUsername());

		return item;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

}
