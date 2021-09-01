import java.sql.*;
public class movies {
	

	public static void main(String[] args) {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Using Oracle Database 11g 
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","system");
			//Setting up connection with the oracle database
			
			
			Statement st=con.createStatement();
			String s="CREATE TABLE MOVIE(MOVIE_ID NUMBER(4) PRIMARY KEY,MOVIE_NAME VARCHAR(20) NOT NULL, ACTOR_NAME VARCHAR(20) NOT NULL,ACTRESS_NAME VARCHAR(20),DIRCETOR_NAME VARCHAR(20) NOT NULL,RELEASE_DATE DATE NOT NULL)";
			
			//creating table
			
		    st.executeUpdate(s);
		    System.out.println("Table Created");
		     
		    
		    //Inserting values into table
		    
		    String s1="INSERT INTO MOVIE VALUES(01,'3 IDIOTS','AAMIR KHAN','KAREENA KAPOOR','RAJKUMAR HIRANI','25-DEC-2009')";
		    st.executeUpdate(s1);
		    
		    String s2="INSERT INTO MOVIE VALUES(02,'MOHABBATEIN','SHAH RUKH KHAN','AISHWARYA ROY','ADITYA CHOPRA','27-OCT-2000')";
		    st.executeUpdate(s2);
		    
		    String s3="INSERT INTO MOVIE VALUES(03,'DHOOM 3','AAMIR KHAN','KATRINA KAIF','VIJAY ACHARYA','20-DEC-2013')";
		    st.executeUpdate(s3);
		    
		    String s4="INSERT INTO MOVIE VALUES(04,'DDLJ','SHAH RUKH KHAN','KAJOL','ADITYA CHOPRA','20-OCT-1995')";
		    st.executeUpdate(s4);
		    
		    String s5="INSERT INTO MOVIE VALUES(05,'CHHICHHORE','SUSHANT SINGH','SHRADDHA KAPOOR','NITESH TIWARI','06-SEP-2019')";
		    st.executeUpdate(s5);
		    
		     
			//Query retrieving all data from table Movie		
			
			String sql="select * from Movie";
			String sql1="select * from movie where actor_name='AAMIR KHAN'";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6));
			ResultSet rs1=st.executeQuery(sql1);
			System.out.println();
			System.out.println();
			
			//Query for retrieving movies in which actor is AAMIR KHAN
			while(rs1.next())
				System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+"  "+rs1.getString(4)+"  "+rs1.getString(5)+"  "+rs1.getString(6));
				
			con.close();
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
