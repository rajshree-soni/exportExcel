package ExcelImport;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ClassRead {
	
	public static void main(String[] args) throws Exception 
	{
		//
		// An excel file name. You can create a file name with a full
		// path information.
		//
		String filename = "C:/Users/john/Downloads/class.xls";
		//
		// Create an ArrayList to store the data read from excel sheet.
		//
		List sheetData = new ArrayList();

		FileInputStream fis = null;
		try {
			//
			// Create a FileInputStream that will be use to read the
			// excel file.
			//
			fis = new FileInputStream(filename);

			//
			// Create an excel workbook from the file system.
			//
			HSSFWorkbook workbook = new HSSFWorkbook(fis);
			//
			// Get the first sheet on the workbook.
			//
			HSSFSheet sheet = workbook.getSheetAt(0);

			
			// When we have a sheet object in hand we can iterator on
			// each sheet's rows and on each row's cells. We store the
			// data read on an ArrayList so that we can printed the
			// content of the excel to the console.
			
			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				Iterator cells = row.cellIterator();

				List data = new ArrayList();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();
					data.add(cell);
				}

				sheetData.add(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
				}
		}

		showExelData(sheetData);
	}

	private static void showExelData(List sheetData) {
		
		// Iterates the data and print it out to the console.
		
		
		Connection conn=DataBaseConnection.getDefaultConnection();
		StudentRead read=new StudentRead();
		
		ArrayList<StudentInfo> feeList=new ArrayList<>();
		
//		int counter=193;
		for (int i = 1; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			
			StudentInfo info=new StudentInfo();
			
			
			/*String dob="";
			String addDate="";*/
			for (int j = 0; j <list.size(); j++) {
				String temp="";
				Cell cell = (Cell) list.get(j);
				if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
					
					DataFormatter fmt = new DataFormatter();

					// Once per cell
					String valueAsSeenInExcel = fmt.formatCellValue(cell);
					temp=valueAsSeenInExcel;
				
				} else if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					
					temp=String.valueOf(cell.getRichStringCellValue());

				} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
					
					temp=String.valueOf(Cell.CELL_TYPE_BOOLEAN);
				}
					
					if(j==0)
					{
						info.setClassName(temp);
					}
					if(j==1)
					{
					info.setDesc(temp);
					}
					
					if(j==2)
					{
					info.setFeeId(temp);;
					}
					if(j==3)
					{
					info.setStatus(temp);
					}
					if(j==4)
					{
					info.setSession(temp);
					}
					if(j==5)
					{
					info.setGroupId(temp);
						
					}
					if(j==6)
					{
						
					info.setMonth(temp);
						
					}
					if(j==7)
					{
						info.setFeeAmt(temp);	
					}
					if(j==8)
					{
						
						info.setOldFee(temp);
						
					}
					if(j==9)
					{
						
						info.setSchId(temp);
						
					}
					if(j==10)
					{
						
						info.setConId(temp);
						
					}
					
					
					
						//info.setRecipietNo(String.valueOf(counter));
			}
            
         //  info.setStrAdd(addDate); 
          // System.out.println(addDate);
			feeList.add(info);
			
		}
		
		System.out.println(feeList.size());	
	/*	
		for(StudentExcel ss:feeList)
		{
			System.out.println(ss.getPincode());//System.out.println(ss.getAdmissionNO()+"           "+ss.getStrAdd()+"       " +ss.getStudentName()+"                      "+ss.getStrDob()+"      "+ss.getStuclass()+"     "+ss.getSession()+"     "+ss.getRollNo()+"    "+ss.getStatusType()+"       "+ss.getAadharNo()+"     "+ss.mobNo+"          "+ss.getCurrentAdr()+"    "+ss.getPermanentAddr()+ "     "+ss.getPincode());
		
		}*/
		for(StudentInfo ss:feeList){
		System.out.println(ss.getStatus());}
			//update(conn,feeList);
		insertData(conn,feeList);
		
		}
	
	public static void insertData(Connection conn, ArrayList<StudentInfo> feeList)
	{
		try
		{
		//Timestamp date=new Timestamp(info.getPostdate().getTime());
			Statement st=conn.createStatement();
			for(StudentInfo ss:feeList)
			{
				
				String query="insert into class(name, description, fee_id, status, session, groupid, month, fee_amount, old_fee_amount, schid, connsessioncategory)values('"+ss.getClassName()+"','null','"+ss.getFeeId()+"','"+ss.getStatus()+"','"+ss.getSession()+"','"+ss.getGroupId()+"','"+ss.getMonth()+"','"+ss.getFeeAmt()+"','"+ss.getOldFee()+"','"+ss.getSchId()+"','"+ss.getConId()+"') ";
				int i=st.executeUpdate(query);
				System.out.println(query);
				if(i==1)
				{
					System.out.println("good");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	/*public static void update(Connection conn, ArrayList<StudentExcel>feeList ) 
	{
		
		try
		{
		//Timestamp date=new Timestamp(info.getPostdate().getTime());
			Statement st=conn.createStatement();
			for(StudentExcel ss:feeList)
			{
				
				String query="update registration1 set classid='"+ss.getStuclass()+"',postdate='"+ss.getStrAdd()+"',fname='"+ss.getStudentName()+"', fathersname='"+ss.getFatherName()+"', mname='"+ss.getMotherName()+"',transportroute='"+ss.getRoute()+"', gender='"+ss.getGender()+"', nationality='"+ss.getNationality()+"', religion='"+ss.getReligion()+"', currentAddress='"+ss.getCurrentAdr()+"', permAddress='"+ss.getPermanentAddr()+"', pincode='"+ss.getPincode()+"', country='"+ss.getCountry()+"', session='"+ss.getSession()+"', status='"+ss.getStatus()+"', categoryid='"+ss.getCategory()+"', residencePhone='"+ss.getResidenceNm()+"', fathersOccupation='"+ss.getFasOccupation()+"', mothersPhone='"+ss.getMotherNo()+"', fathersPhone='"+ss.getMobNo()+"', dob='"+ss.getStrDob()+"',bpl='"+ss.getBplStatus()+"',concession='"+ss.getConcession()+"',caste='"+ss.getCaste()+"', "
						+ "singleChild='"+ss.getSingleChild()+"', bloodGroup='"+ss.getBloodGroup()+"', aadharNo='"+ss.getAadharNo()+"', SingleParent='"+ss.getSingleParent()+"', livingWith='"+ss.getLiveWithParents()+"', fatherEmail='"+ss.getFatherEmail()+"', motherEmail='"+ss.getMotherEmail()+"',student_status='"+ss.getStatus()+"',sendMessageMobileNo='"+ss.getMobNo()+"', admitClass='"+ss.getStuclass()+"',relation='"+ss.getRelation1()+"', occupation='"+ss.getOccupation1()+"', mobile='"+ss.getNumber1()+"', lastSchoolName='"+ss.getLastSchool()+"', passedClass='"+ss.getPassesClass()+"', medium1='"+ss.getMedium()+"', board='"+ss.getBoard()+"', sname1='"+ss.getSibling1()+"', sclassid1='"+ss.getSibClass1()+"', sname2='"+ss.getSibling2()+"', sclassid2='"+ss.getSibClass2()+"', address='"+ss.getAddress1()+"', gname2='"+ss.getRelation2()+"',relation2='"+ss.getRelation2()+"', occupation2='"+ss.getOccupation2()+"', phone2='"+ss.getNumber2()+"', address2='"+ss.getAddress2()+"', pResult='"+ss.getResult()+"', p_percent='"+ss.getPrcntage()+"', pReason='"+ss.getReasontoLeave()+"', height='"+ss.getHeight()+"', weight='"+ss.getWeight()+"', eyes='"+ss.getEyes()+"', fatherQualification='"+ss.getFaQualification()+"',fatheroccupation='"+ss.getFasOccupation()+"', fatherofficecontactno='"+ss.getFaofficeContact()+"', fatherOfficeAdd='"+ss.getFaofficeAddr()+"',fatherSchoolEmp='"+ss.getFaIsSchoolEmploy()+"', motherQualification='"+ss.getMaQualification()+"', motherOccupation='"+ss.getMasOccupation()+"', motherofficecontacno='"+ss.getMaofficeContact()+"', motherOfficeAdd='"+ss.getMaofficeAddr()+"',motherSchoolEmp='"+ss.getMaIsSchoolEmploy()+"', tcdt='"+ss.getTCDate()+"', hostel='"+ss.getHouse()+"', housename='"+ss.getHouse()+"', g1name='"+ss.getGuardianName1()+"', rollno='"+ss.getRollNo()+"', discounttransportFee='"+ss.getDiscountFee()+"',bplCardNo='"+ss.getBplNo()+"' where addNumber='"+ss.getAdmissionNO()+"'";

				int i=st.executeUpdate(query);
				System.out.println(query);
				if(i==1)
				{
					System.out.println("good");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	

	}
*/
	private static int getClass(String stuclass) 
	{
		int x=0;
		Connection conn=DataBaseConnection.getDefaultConnection();	
		try {
			Statement st=conn.createStatement();
			String query="select * from classtable where className='"+stuclass+"'";
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				return rs.getInt("idclasstable");
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
			return 0;
		
	}

	public static void insertFeeSerialNo(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9)
	{
		Connection conn=DataBaseConnection.getDefaultConnection();
		try
		{
			Statement st=conn.createStatement();
			String query="insert into franchise_list(name, address, emailid, state, cpersonno, city, pinno, district_head, itgkcode, cpersonname)"
					+ "values('"+string2+"','"+string9+"','"+string4+"','22','"+string6+"','"+string7+"','"+string8+"', '3','"+string+"','"+string5+"')";
			int i=st.executeUpdate(query);
			if(i==1)
			{
				String type="franchise";
				addUserId(string,type,string2,string6);
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	private static void insertFeeSerialNo(String first) 
	{
		Connection conn=DataBaseConnection.getDefaultConnection();
		try
		{
			Statement st=conn.createStatement();
			String query="insert into diagnosis(dg) values('"+first+"')";
			int i=st.executeUpdate(query);
			if(i==1)
			{
				String type="franchise";
				//addUserId(string,type,string2,string7);
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public static void addUserId(String itgkCode, String type, String name, String cPersonNo) 
	{
		try(Connection conn=DataBaseConnection.getDefaultConnection())
		{
			Statement st=conn.createStatement();
			String query="insert into login(userid, type,password,name, status, mobile_no) values('"+itgkCode+"','"+type+"','password','"+name+"', 'ACTIVE','"+cPersonNo+"')";
			st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	/*public static void insertNow(Connection conn, ArrayList<StudentExcel> feeList)
	{
		try
		{
		//Timestamp date=new Timestamp(info.getPostdate().getTime());
			Statement st=conn.createStatement();
			for(StudentExcel ss:feeList)
			{
				
				String query="insert into registration1(student_status,classid,addNumber,postdate,fname, fathersname, mname,transportroute, gender, nationality, religion, currentAddress, permAddress, pincode, country, session,categoryid, residencePhone, fathersOccupation, mothersPhone, fathersPhone, dob,bpl,concession,caste, singleChild, bloodGroup, aadharNo, SingleParent, livingWith, fatherEmail, motherEmail,sendMessageMobileNo, admitClass,relation, occupation, mobile, lastSchoolName, passedClass, medium1, board, sname1, sclassid1, sname2, sclassid2, address, gname2,relation2, occupation2, phone2, address2, pResult, p_percent, pReason, height, weight, eyes, fatherQualification, fatheroccupation, fatherofficecontactno, fatherOfficeAdd,fatherSchoolEmp, motherQualification, motherOccupation, motherofficecontacno, motherOfficeAdd,motherSchoolEmp, tcdt, hostel, housename, g1name, rollno, discounttransportFee,bplCardNo,status,schid) values"
						+ "('"+ss.getStatusType()+"','"+ss.getStuclass()+"','"+ss.getAdmissionNO()+"','"+ss.getStrAdd()+"','"+ss.getStudentName()+"','"+ss.getFatherName()+"','"+ss.getMotherName()+"','"+ss.getRoute()+"','"+ss.getGender()+"','"+ss.getNationality()+"','"+ss.getReligion()+"','"+ss.getCurrentAdr()+"','"+ss.getPermanentAddr()+"','"+ss.getPincode()+"','"+ss.getCountry()+"','"+ss.getSession()+"','"+ss.getCategory()+"','"+ss.getResidenceNm()+"','"+ss.getFasOccupation()+"','"+ss.getMotherNo()+"','"+ss.getMobNo()+"','"+ss.getStrDob()+"','"+ss.getBplStatus()+"','"+ss.getConcession()+"','"+ss.getCaste()+"','"+ss.getSingleChild()+"','"+ss.getBloodGroup()+"','"+ss.getAadharNo()+"','"+ss.getSingleParent()+"','"+ss.getLiveWithParents()+"','"+ss.getFatherEmail()+"','"+ss.getMotherEmail()+"','"+ss.getMobNo()+"','"+ss.getStuclass()+"','"+ss.getRelation1()+"','"+ss.getOccupation1()+"','"+ss.getNumber1()+"','"+ss.getLastSchool()+"','"+ss.getPassesClass()+"','"+ss.getMedium()+"','"+ss.getBoard()+"','"+ss.getSibling1()+"','"+ss.getSibClass1()+"','"+ss.getSibling2()+"','"+ss.getSibClass2()+"',"
										+ "'"+ss.getAddress1()+"','"+ss.getGuardianName2()+"','"+ss.getRelation2()+"','"+ss.getOccupation2()+"','"+ss.getNumber2()+"','"+ss.getAddress2()+"','"+ss.getResult()+"','"+ss.getPrcntage()+"','"+ss.getReasontoLeave()+"','"+ss.getHeight()+"','"+ss.getWeight()+"','"+ss.getEyes()+"','"+ss.getFaQualification()+"','"+ss.getFasOccupation()+"','"+ss.getFaofficeContact()+"','"+ss.getFaofficeAddr()+"','"+ss.getFaIsSchoolEmploy()+"','"+ss.getMaQualification()+"','"+ss.getMasOccupation()+"','"+ss.getMaofficeContact()+"','"+ss.getMaofficeAddr()+"','"+ss.getMaIsSchoolEmploy()+"','"+ss.getTCDate()+"','"+ss.getHostler()+"','"+ss.getHouse()+"','"+ss.getGuardianName1()+"','"+ss.getRollNo()+"','"+ss.getDiscountFee()+"','"+ss.getBplNo()+"','"+ss.getStatusStu()+"','1')" ;
				int i=st.executeUpdate(query);
				System.out.println(query);
				if(i==1)
				{
					System.out.println("good");
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}*/
	
	public static Date dateFromString(String dateInString)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		Date date=null;
		try {
	 
			 date = formatter.parse(dateInString);
	 
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return date;
	}

	public static Date dateFromString2(String dateInString)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		Date date=null;
		try {
	 
			 date = formatter.parse(dateInString);
	 
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return date;
	}


}
