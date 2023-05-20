package GenericLibraries;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * This class contains reusable methods to perform java relatable operations 
 * @author Mallikarjun
 *
 */

public class JavaUtility {
	/**
	 * This method returns random numbers within specified limits
	 * @param limit 
	 * @return
	 */
	
	public int generateRandomNumber(int limit) {
		Random random =new Random();
		return random.nextInt(limit);
	}
	
	/**
	 * this method is used to return the current time
	 */

	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_mm_sss");
		return sdf.format(date);
	}
}
