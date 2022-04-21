package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

interface BankaccRepository {
	public double getBalance(long accountid);
	public double updateBalance(long accountid,double newBalance);
	

}
public class BankaccRepositoryimpl implements BankaccRepository{
	@Autowired
	static JdbcTemplate jdbctemplate;
	public void setJdbcTemplate(JdbcTemplate jdbctemplate) {
		BankaccRepositoryimpl.jdbctemplate=jdbctemplate;
		
	}
	@Override
	public double getBalance(long accountid) {
		String SQL_SELECT="select * from bankaccount where accountid="+accountid;
		List<Bankaccount> acc=jdbctemplate.query(SQL_SELECT,new BeanPropertyRowMapper<Bankaccount>(Bankaccount.class));
		return acc.get(0).getAccountbalance();
		
	}
	@Override
	public double updateBalance(long accountid,double newBalance) {
		String SQL_UPDATE="update bankaccount set accountbalance=(?) where accountid =(?)";
		return jdbctemplate.update(SQL_UPDATE,newBalance,accountid);
	}
	
}
