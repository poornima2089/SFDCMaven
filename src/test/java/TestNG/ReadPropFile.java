package TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {
	static Properties props;

	public static void loadPropertyFile() throws IOException {
		props = new Properties();
		File Config = new File("C:\\Users\\poorn\\eclipse-workspace1\\SalesForceProject\\PathsAndUrl.properties");

		
			FileInputStream Fis = new FileInputStream(Config);
			
			props.load(Fis);
		
	}

	public static String getObject(String data) throws IOException {
		loadPropertyFile();
		String Data = props.getProperty("data");
		return Data;
	}

	/*public String getApplicationURL() {
		String baseurl = props.getProperty("ReusableMethod_BaseURL");
		return baseurl;
	}

	public String getReportPath() {
		String reportPath = props.getProperty("Annotations_ReportPath");
		return  reportPath;
	}

	public String getXlPath() {
		String xlPath = props.getProperty("Annotations_XlPath");
		return xlPath ;
	
}*/


}
