package genericUtilities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.Format;


/**
 * This class consist of generic methods releted to Java
 * @author Admin
 */

public class JavaUtility {
	/**
	 * This method will capture the current System date and return to caller
	 * Used to name Screenshots and reports
	 * @author Admin
	 * @return
	 */
	public String getSystemDateInFormate() 
	{
		Date d=new Date();
		SimpleDateFormat f= new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = f.format(d);
		return date;
		
		
	}

}
