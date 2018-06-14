package com.treesaSunny.registration;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/*
 * Includes methods to make updates to the database using the JDBCTemplate
 */

@Repository
public class SpringRootConfigRespository{

	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * saves the user to the database
	 */
	public int saveUserDetails(UserDetails user) {
	    return jdbcTemplate.update("insert into UserDetails ( firstname, lastname, emailid) " + "values( ?, ?, ?)",
	        new Object[] {
	        		 user.getFirstname(), user.getLastName(),user.getEmailID()
	        });
	}
	
	/*
	 * Retrieves all users with the particular email ID
	 * /basically checking if the emaiID already exists in the database
	 */
	public UserDetails RetrieveAllUsersWithEmailID(String emailID)
	{
		
		UserDetails h=new UserDetails();
		//jdbcTemplate queries for userDetails object specific to the emailID
		List<UserDetails> usrs  = jdbcTemplate.query("select * from UserDetails where emailid= '"+emailID+"'",
				new BeanPropertyRowMapper(UserDetails.class));
		if(usrs.isEmpty())
		{
			UserDetails user=new UserDetails();
			user.setEmailID("default@gmail.com");
			user.setFirstname("defaultName");
			user.setLastName("defaultlName");
			return user;
		}
		
		else
		{
		return  jdbcTemplate.queryForObject("select * from UserDetails where emailid=?", new Object[] {
				emailID
	        },
	        new BeanPropertyRowMapper < UserDetails > (UserDetails.class));
		
		}
	}
	
		
	public List<UserDetails> RetrieveAllUsers()
	{
		List<UserDetails> usrs  = jdbcTemplate.query("select * from UserDetails",new BeanPropertyRowMapper(UserDetails.class));
		ArrayList<List<String>> usersAsList=new ArrayList<List<String>> ();
		String currentfirstNAme=usrs.get(1).getFirstname();
		return usrs;
	}

		
	}

