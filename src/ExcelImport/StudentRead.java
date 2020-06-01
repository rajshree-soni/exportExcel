package ExcelImport;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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

public class StudentRead {

	public static void main(String[] args) throws Exception 
	{
		
		// An excel file name. You can create a file name with a full
		// path information.
		//C:\Users\john\Downloads
		String filename = "C:/Users/India/Desktop/blmprimary.xls";
		
		
		// Create an ArrayList to store the data read from excel sheet.
	
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

			//
			// When we have a sheet object in hand we can iterator on
			// each sheet's rows and on each row's cells. We store the
			// data read on an ArrayList so that we can printed the
			// content of the excel to the console.
			//
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
		//
		// Iterates the data and print it out to the console.
		//
		
		Connection conn=DataBaseConnection.getDefaultConnection();
		StudentRead read=new StudentRead();
		
		ArrayList<StudentExcel> feeList=new ArrayList<>();
		
//		int counter=193;
		for (int i = 1; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			
			StudentExcel info=new StudentExcel();
			
			
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
					info.setAdmissionNO(temp);
				}
				if(j==1)
				{
					info.setSrNo(temp);
				}
				if(j==2)
				{
					info.setStudentName(temp);
					
				}
				if(j==3)
				{
					info.setFatherName(temp);
				}
				if(j==4)
				{
					info.setMotherName(temp);
					
				}
				if(j==5)
				{
					info.setStrDob(temp);
				}

				if(j==6)
				{
					info.setStrAdd(temp);
				}
				if(j==7)
				{
					info.setPermanentAddr(temp);
				}
				if(j==8)
				{
					if(temp.length()==10)
					{
					info.setMobNo(temp);	
					}
					else
					{
					info.setMobNo("0");
					}
				}
				
				if(j==9)
				{
				    info.setStuclass(temp);
				}
				if(j==10)
				{
					info.setStatusType(temp);	
				}
				if(j==11)
				{
					info.setConcession(temp);
				}
				if(j==12)
				{
					info.setRollNo(temp);	
				}
				if(j==13)
				{
					info.setGender(temp);
				}
				/*if(j==11)
				{
					
				}*/
					/*if(j==1)
					{
					info.setAdmissionNO(temp);
					}
					
					if(j==2)
					{
					info.setStrAdd(temp);;
					}
					if(j==3)
					{
					info.setStudentName(temp);
					}
					if(j==4)
					{
					info.setStrDob(temp);
					}
					if(j==5)
					{
					info.setStuclass(temp);
						
					}
					if(j==6)
					{
						
					info.setSession(temp);
						
					}
					if(j==7)
					{
						info.setRollNo(temp);	
					}
					if(j==8)
					{
						
						info.setStatusType(temp);
						
					}
					if(j==9)
					{
						
						info.setAadharNo(temp);
						
					}
					if(j==10)
					{
							
						if(temp.length()==10)
							{
							info.setMobNo(temp);	
							}
						else
						{
							info.setMobNo("0");
						}
					}
					if(j==11)
					{
					info.setCurrentAdr(temp);
					}
					if(j==12)
					{
						info.setPermanentAddr(temp);
					}
					if(j==13)
					{
						info.setGender(temp);
					}
					if(j==14)
					{
						info.setNationality(temp);
					}
					if(j==15)
					{
						
					info.setReligion(temp);
						
					}
					
					if(j==16)
					{
						
						info.setCategory(temp);
					}
					if(j==17)
					{
						info.setCaste(temp);
					}
					if(j==18)
					{
						info.setBplStatus(temp);
					}
					if(j==19)
					{
						
					info.setPincode(temp);
					}
					
					if(j==20)
					{
					info.setSingleParent(temp);;
					}
					if(j==21)
					{
					info.setSingleChild(temp);
					}
					if(j==22)
					{
					info.setCountry(temp);
					}
					if(j==23)
					{
					info.setFatherName(temp);
					}
					if(j==24)
					{
					info.setMotherName(temp);
					}
					if(j==25)
					{
						info.setFatherEmail(temp);	
					}
					if(j==26)
					{
						info.setFatherUuid(temp);
					}
					if(j==27)
					{
						info.setMotherEmail(temp);
					}
					if(j==28)
					{
						info.setMotherUuid(temp);	
					}
					
					if(j==29)
					{
						if(temp.length()==10)
						{
							info.setMotherNo(temp);
						}
						else
						{
							info.setMotherNo("0");
						}
					}
					if(j==30)
					{
						info.setResidenceNm(temp);
					}
					if(j==31)
					{
						info.setLiveWithParents(temp);
					}
					if(j==32)
					{
						info.setLastSchool(temp);
					}
					if(j==33)
					{
						
					info.setPassesClass(temp);
						
					}
					if(j==34)
					{
						info.setMedium(temp);
					}
					if(j==35)
					{
						info.setResult(temp);
					}
					if(j==36)
					{
						info.setBoard(temp);
					}
					if(j==37)
					{
					info.setPrcntage(temp);
					}
					if(j==38)
					{
					info.setReasontoLeave(temp);
					}
					if(j==39)
					{
					info.setTCDate(temp);
					}
					if(j==40)
					{
					info.setHeight(temp);
						
					}
					if(j==41)
					{
						
					info.setWeight(temp);
						
					}
					if(j==42)
					{
						info.setEyes(temp);	
					}
					if(j==43)
					{
						info.setBloodGroup(temp);
						
					}
					if(j==44)
					{
						
						info.setGuardianName1(temp);
						
					}
					if(j==45)
					{
						info.setRelation1(temp);	
					}
					
					if(j==46)
					{
					info.setOccupation1(temp);
					}
					
					if(j==47)
					{
						
						info.setNumber1(temp);
					}
					if(j==48)
					{
						info.setAddress1(temp);
					}
					if(j==49)
					{
						info.setGuardianName2(temp);
					}
					if(j==50)
					{
						info.setRelation2(temp);						
					}
					
					if(j==51)
					{
						info.setOccupation2(temp);			
					}
					if(j==52)
					{
						info.setNumber2(temp);
					}
					if(j==53)
					{
						info.setAddress1(temp);
					}
					if(j==54)
					{
						info.setFaQualification(temp);
					}
					if(j==55)
					{
					info.setFasOccupation(temp);
					}
					
					if(j==56)
					{
					info.setFaofficeContact(temp);
					}
					if(j==57)
					{
					info.setFaofficeAddr(temp);
					}
					if(j==58)
					{
					info.setFaIsSchoolEmploy(temp);
					}
					if(j==59)
					{
					info.setMaQualification(temp);
					}
					if(j==60)
					{
					info.setMasOccupation(temp);
					}
					if(j==61)
					{
						info.setMaofficeContact(temp);	
					}
					if(j==62)
					{
						info.setMaofficeAddr(temp);
					}
					if(j==63)
					{
						info.setMaIsSchoolEmploy(temp);
					}
					if(j==64)
					{
						info.setRoute(temp);	
					}
					
					if(j==65)
					{
					info.setRouteFee(temp);
					}
					if(j==66)
					{
						info.setDiscountFee(temp);
					}
					if(j==67)
					{
						info.setTotalFee(temp);
					}
					if(j==68)
					{
						info.setConcession(temp);
					}
					if(j==69)
					{
						
					info.setHostler(temp);
						
					}
					if(j==70)
					{
						info.setHouse(temp);
					}
					if(j==71)
					{
						info.setSibling1(temp);
					}
					if(j==72)
					{
						info.setSibClass1(temp);
					}
					if(j==73)
					{
						info.setSibling2(temp);
					}
					if(j==74)
					{
						info.setSibClass2(temp);
					}
					if(j==75)
					{
						info.setBplNo(temp);
					}
					if(j==76)
					{
						info.setStatusStu(temp);
					}*/
					/*if(j==77)
					{
						info.setAdmitClass(temp);
					}*/
					
					
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
		
		//System.out.println(classid);
			//update(conn,feeList);
		insertNow(conn,feeList);
		//insertData(conn, feeList);
		
		}
	
	public static void insertData(Connection conn, ArrayList<StudentExcel> feeList)
	{
		try
		{
			Statement st=conn.createStatement();
			for(StudentExcel ss:feeList)
			{
				String query="insert into district_table(name, state_name) values('"+ss.getDistrict()+"','"+ss.getState()+"')" ;
				int i=st.executeUpdate(query);
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
			String query="insert into tehsil_table(name, district_name)"
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
	
	
	public static void insertNow(Connection conn, ArrayList<StudentExcel> feeList)
	{
		try
		{
			Statement st=conn.createStatement();
			for(StudentExcel ss:feeList)
			{
				Date d1=null;
				try {
					 d1=new SimpleDateFormat("yyyy/MM/dd").parse(ss.getStrDob());
								
				} catch (Exception e) {
				   d1=new Date();
				}
				
				Timestamp date1=new Timestamp(d1.getTime());
				
				Date d2=null;
				try {
					if(ss.getStrAdd()==null||ss.getStrAdd().equals(""))
					{
						d2=new Date();
					}
					else
					{
						d2=new SimpleDateFormat("yyyy/MM/dd").parse(ss.getStrAdd());
							
					}
					 			
				} catch (Exception e) {
				   d2=new Date();
				}
				
				Timestamp date2=new Timestamp(d2.getTime());
				//Timestamp date2=new Timestamp(new Date().getTime());
				date2.setHours(0);
				date2.setMinutes(0);
				date2.setSeconds(0);
				date2.setNanos(0);
				String query="insert into blmdata(sr_no,postdate,fname,classid,session,fathersPhone, dob,concession,admitClass, schid,student_status,addNumber,fathersname,mname,currentAddress, permAddress,gender,rollno) values"
						+ "('"+ss.getSrNo()+"','"+date2+"','"+ss.getStudentName()+"','"+ss.getStuclass()+"','2018-2019','"+ss.getMobNo()+"','"+date1+"','"+ss.getConcession()+"','"+ss.getStuclass()+"','252','"+ss.getStatusType()+"','"+ss.getAdmissionNO()+"','"+ss.getFatherName()+"','"+ss.getMotherName()+"','"+ss.getPermanentAddr()+"','"+ss.getPermanentAddr()+"','"+ss.getGender()+"','"+ss.getRollNo()+"')" ;
				//System.out.println(ss.getAdmissionNO()+","+ss.getStudentName()+","+ss.getMotherName()+","+ss.getStuclass());
				/*String query="insert into registration1(addNumber,fathersname,postdate,fname,mname, classid, currentAddress, permAddress,session,fathersPhone, dob,concession,admitClass, schid) values"
						+ "('"+ss.getAdmissionNO()+"','"+ss.getFatherName()+"','"+date2+"','"+ss.getStudentName()+"','"+ss.getMotherName()+"','"+ss.getStuclass()+"','"+ss.getCurrentAdr()+"','"+ss.getCurrentAdr()+"','2017-2018','"+ss.getMobNo()+"','"+date1+"','13','"+ss.getStuclass()+"','5')" ;
				*/int i=st.executeUpdate(query);
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
	/*public static void insertNow(Connection conn, ArrayList<StudentExcel> feeList)
	{
		try
		{
		//Timestamp date=new Timestamp(info.getPostdate().getTime());
			Statement st=conn.createStatement();
			for(StudentExcel ss:feeList)
			{
				Date d1=null;
				try {
					 d1=new SimpleDateFormat("MM/dd/yyyy").parse(ss.getStrAdd());
								
				} catch (Exception e) {
				   d1=new Date();
				}
				Date d2=null;
				try {
					 d2=new SimpleDateFormat("MM/dd/yyyy").parse(ss.getStrDob());
								
				} catch (Exception e) {
				   d2=new Date();
				}
				Timestamp date1=new Timestamp(d1.getTime());
				Timestamp date2=new Timestamp(d2.getTime());
				
				String query="insert into registration1(student_status,classid,addNumber,postdate,fname, fathersname, mname,transportroute, gender, nationality, religion, currentAddress, permAddress, pincode, country, session,categoryid, residencePhone, fathersOccupation, mothersPhone, fathersPhone, dob,bpl,concession,caste, singleChild, bloodGroup, aadharNo, SingleParent, livingWith, fatherEmail, motherEmail,sendMessageMobileNo, admitClass,relation, occupation, mobile, lastSchoolName, passedClass, medium1, board, sname1, sclassid1, sname2, sclassid2, address, gname2,relation2, occupation2, phone2, address2, pResult, p_percent, pReason, height, weight, eyes, fatherQualification, fatheroccupation, fatherofficecontactno, fatherOfficeAdd,fatherSchoolEmp, motherQualification, motherOccupation, motherofficecontacno, motherOfficeAdd,motherSchoolEmp, tcdt, hostel, housename, g1name, rollno, discounttransportFee,bplCardNo,status,schid) values"
						+ "('"+ss.getStatusType()+"','"+ss.getStuclass()+"','"+ss.getAdmissionNO()+"','"+date1+"','"+ss.getStudentName()+"','"+ss.getFatherName()+"','"+ss.getMotherName()+"','"+ss.getRoute()+"','"+ss.getGender()+"','"+ss.getNationality()+"','"+ss.getReligion()+"','"+ss.getCurrentAdr()+"','"+ss.getPermanentAddr()+"','"+ss.getPincode()+"','"+ss.getCountry()+"','"+ss.getSession()+"','"+ss.getCategory()+"','"+ss.getResidenceNm()+"','"+ss.getFasOccupation()+"','"+ss.getMotherNo()+"','"+ss.getMobNo()+"','"+date2+"','"+ss.getBplStatus()+"','"+ss.getConcession()+"','"+ss.getCaste()+"','"+ss.getSingleChild()+"','"+ss.getBloodGroup()+"','"+ss.getAadharNo()+"','"+ss.getSingleParent()+"','"+ss.getLiveWithParents()+"','"+ss.getFatherEmail()+"','"+ss.getMotherEmail()+"','"+ss.getMobNo()+"','"+ss.getStuclass()+"','"+ss.getRelation1()+"','"+ss.getOccupation1()+"','"+ss.getNumber1()+"','"+ss.getLastSchool()+"','"+ss.getPassesClass()+"','"+ss.getMedium()+"','"+ss.getBoard()+"','"+ss.getSibling1()+"','"+ss.getSibClass1()+"','"+ss.getSibling2()+"','"+ss.getSibClass2()+"',"
										+ "'"+ss.getAddress1()+"','"+ss.getGuardianName2()+"','"+ss.getRelation2()+"','"+ss.getOccupation2()+"','"+ss.getNumber2()+"','"+ss.getAddress2()+"','"+ss.getResult()+"','"+ss.getPrcntage()+"','"+ss.getReasontoLeave()+"','"+ss.getHeight()+"','"+ss.getWeight()+"','"+ss.getEyes()+"','"+ss.getFaQualification()+"','"+ss.getFasOccupation()+"','"+ss.getFaofficeContact()+"','"+ss.getFaofficeAddr()+"','"+ss.getFaIsSchoolEmploy()+"','"+ss.getMaQualification()+"','"+ss.getMasOccupation()+"','"+ss.getMaofficeContact()+"','"+ss.getMaofficeAddr()+"','"+ss.getMaIsSchoolEmploy()+"','"+ss.getTCDate()+"','"+ss.getHostler()+"','"+ss.getHouse()+"','"+ss.getGuardianName1()+"','"+ss.getRollNo()+"','"+ss.getDiscountFee()+"','"+ss.getBplNo()+"','"+ss.getStatusStu()+"','10')" ;
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