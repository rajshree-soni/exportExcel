package ExcelImport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CoreJava
{
	public static void main(String[] args)throws Exception
	{
		Connection conn=DataBaseConnection.getDefaultConnection();
		 new CoreJava().obtainDetail(conn);
		 conn.close();
	}
	public void obtainDetail(Connection conn)
	{
		
		ArrayList<StudentInfo>studentList=new ArrayList<>();
		studentList=getStudentDetail(conn);
		Statement st=null;
		for(StudentInfo ss:studentList)
		{
			try
			{
				st=conn.createStatement();
				String query="update student_fee_table set section_id='"+ss.getSectionid()+"' where studentid='"+ss.getAddNumber()+"' and session='"+ss.getSession()+"' and schid='"+ss.getSchid()+"'" ;
				st.executeUpdate(query);	
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally{
				if(st!=null)
				{
					try {
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	public ArrayList<StudentInfo>getStudentDetail(Connection conn) 
	{
		int count=1;
		ArrayList<StudentInfo> sList=new ArrayList<StudentInfo>();
		Statement st=null;
		ResultSet rr=null;
		try
		{
			st=conn.createStatement();
			String query="select * from student_fee_table inner join registration1 on student_fee_table.studentid=registration1.addNumber where  registration1.schid=student_fee_table.schid"; 
			rr=st.executeQuery(query);
			while(rr.next())
			{
				StudentInfo list=new StudentInfo();
				list.setSno(count++);
				list.setAddNumber(rr.getString("student_fee_table.studentid"));
				list.setSchid(rr.getString("student_fee_table.schid"));
				list.setSession(rr.getString("student_fee_table.session"));
				if(rr.getString("registration1.session").equalsIgnoreCase(rr.getString("student_fee_table.session")))
				{
					list.setSectionid(rr.getString("registration1.classid"));
				}
				else
				{
					list.setSectionid(checkPromotionForSession(rr.getString("student_fee_table.session"),list.getAddNumber(),list.getSchid()));
				}
				
				sList.add(list);
			}	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
			if(st!=null)
			{
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(rr!=null)
			{
				try {
					rr.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return sList;
	}
	public String checkPromotionForSession(String session, String addnUmber, String schid) 
	{
		Statement st=null;
		ResultSet rr=null;
		//classFrom,classTo,studentId,postDate,session,schid
		try(Connection conn=DataBaseConnection.getDefaultConnection();)
		{
			st=conn.createStatement();
			String query="select classTo from promotion where session='"+session+"' and schid='"+schid+"' and studentId='"+addnUmber+"'";
			rr=st.executeQuery(query);
			if(rr.next())
			{
				return rr.getString("classTo");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			if(st!=null)
			{
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(rr!=null)
			{
				try {
					rr.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

}
