package CommonUtilities;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.testng.Reporter;
import CredentialStore.CredentialStores;


public class SendMailSSLWithAttachment {
	String DecrptData, Pwd, ConfigName, ConfigValue, Address;
	public static String FileName = "ApplyOnline.xlsx";
	String fileLocation = CredentialStores.InputFileLocation;
	String InputFilePath = fileLocation + FileName;
	
	public void ExcelParameterSetting(String ReportRows[]) {
		ConfigName = ReportRows[0];
		ConfigValue = ReportRows[1];
	}
	

	public void SendMailTest() throws Exception {
			Thread.sleep(3000);
			try {
				String SheetName = ExcelFunctions.getSheetName(fileLocation + FileName, 4);
				if ((SheetName.equalsIgnoreCase("InputConfig"))) {
					ExcelFunctions.setPath(InputFilePath,SheetName);
					String ExcelData[] = ExcelFunctions.readBlankCell(InputFilePath,SheetName);
					String ReportRows[] = ExcelData[1].split("--");
					ExcelParameterSetting(ReportRows);
					if(!(ConfigName.equalsIgnoreCase("NA")&&ConfigValue.equalsIgnoreCase("NA"))){ 
						  Address = ConfigValue;
					  	  }
				}
			} catch (Exception e) {
				Reporter.log("Error occured for recipients address");
				Thread.sleep(2000);	
			}
	
		// Create object of Property file
		Properties props = new Properties();
		
		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp.uow.edu.au");

		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "25");

		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "25");

		Session session = Session.getDefaultInstance(props, new Authenticator() {
					public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("qa-testing@uow.edu.au", "");
					}
				});

		try {
 
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			message.setFrom(new InternetAddress("qa-testing@uow.edu.au"));

			// Set the recipient address
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Address));
			//Get current date
			long millis=System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			  
			
            // Add the subject link_--  
			message.setSubject("ApplyOnline-Automation Execution Report-" + date);

			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();

			// Set the body of email
			messageBodyPart1.setText("Hi, \n\nThis is the automated email generated from automated test execution. "
					+ "Please review the results attached with this email. \n\n"
					+ "Regards, \n"
					+ "QA Team");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//			MimeBodyPart messageBodyPart3 = new MimeBodyPart();

			// Mention the file which you want to send
			String filename1 = CredentialStores.ReportFile1;
//			String filename2 = CredentialStores.ReportFile2;
			
			// Create data source and pass the filename
			DataSource source1 = new FileDataSource(filename1);
//			DataSource source2 = new FileDataSource(filename2);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source1));
//			messageBodyPart3.setDataHandler(new DataHandler(source2));

			// set the file
			messageBodyPart2.setFileName("TestRunStatus.xlsx");
//			messageBodyPart3.setFileName("ExtentReport.html");

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
//			multipart.addBodyPart(messageBodyPart3);

			// add body part 2
			multipart.addBodyPart(messageBodyPart2);
			
			// add body part 3
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
