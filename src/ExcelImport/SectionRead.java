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

public class SectionRead {
	
	public static void main(String[] args) throws Exception 
	{
		//
		// An excel file name. You can create a file name with a full
		// path information.
		//
		String filename = "C:/Users/john/Downloads/section.xls";
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
		
		ArrayList<SectionInto> feeList=new ArrayList<>();
		
//		int counter=193;
		for (int i = 1; i < sheetData.size(); i++) {
			List list = (List) sheetData.get(i);
			
			SectionInto info=new SectionInto();
			
			
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
						info.setId(temp);
					}
					if(j==1)
					{
					info.setName(temp);
					}
					
					if(j==2)
					{
					info.setStatus(temp);;
					}
					if(j==3)
					{
					info.setClassId(temp);
					}
					if(j==4)
					{
					info.setSchid(temp);
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
		
		insertData(conn,feeList);
		
		}
	
	public static void insertData(Connection conn, ArrayList<SectionInto> feeList)
	{
		try
		{
		//Timestamp date=new Timestamp(info.getPostdate().getTime());
			Statement st=conn.createStatement();
			for(SectionInto ss:feeList)
			{
				
				String query="insert into section(id, name, status, classid, schid)values('"+ss.getId()+"','"+ss.getName()+"','"+ss.getStatus()+"','"+ss.getClassId()+"','"+ss.getSchid()+"')";
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
