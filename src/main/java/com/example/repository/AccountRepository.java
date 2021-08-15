
package com.example.repository;

public interface AccountRepository {

	public boolean check(String account);

	public double balance(String account);
	
	public void update(String account_id, double balance);


	
}
