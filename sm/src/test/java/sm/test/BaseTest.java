/**
 * 
 */
package sm.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author pan
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring/spring-main.xml")

public class BaseTest {
	
	@Test
	public void test(){
		
		System.out.println("**********************");
	}
	
	
	public static void main(String[] args) throws IOException {
//		readFile("D:/456.autotrans");
		// TODO Auto-generated method stub
				
		String txtPath = "D:/456.autotrans";
		int lineNo = 7;
		System.out.println(readTxtLine(txtPath,lineNo));
				
	}
	
	public static String readFile(String fileName)
	{   
		String fileContent = "";   
	    try 
	    {     
	    	File f = new File(fileName);    
	    	if(f.isFile()&&f.exists())
	    	{     
	    		InputStreamReader read = new InputStreamReader(new FileInputStream(f),"gbk");     
	    		BufferedReader reader=new BufferedReader(read);     
	    		String line;     
	    		while ((line = reader.readLine()) != null) 
	    		{      
	    			fileContent += line;     
	    			System.out.println(line);
	    		}       
	    		read.close();    
	    	}   
	    } catch (Exception e) 
	    {       
	    	e.printStackTrace();   
	    }   
	    return fileContent; 
	} 
	
	public static String readTxtLine(String txtPath, int lineNo) {

		String line = "";
		String encoding="GBK";
		try {
			File txtFile = new File(txtPath);
			InputStream in = new FileInputStream(txtFile);
			InputStreamReader read = new InputStreamReader(in,encoding);
			BufferedReader reader = new BufferedReader(read);
			int i = 0;
			while (i < lineNo) {
				line = reader.readLine();
				i++;
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return line;
	}
	
}
