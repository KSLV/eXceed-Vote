import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public abstract class VerificationProcess {

	private InputStream uis,pis;
	private InputStreamReader uin,pin;
	private BufferedReader ubr,pbr;
	private String tmpUsername;
	private String tmpPassword;
	private String userListDir;
	private String passListDir;

	public VerificationProcess(String userListDir , String passListDir) throws IOException
	{
		this.userListDir = userListDir;
		this.passListDir = passListDir;
	}
	
	public int verifyLogin(String username , String password) throws IOException
	{
		uis = new FileInputStream(userListDir);
		uin = new InputStreamReader(uis);
		ubr = new BufferedReader(uin);
		pis = new FileInputStream(passListDir);
		pin = new InputStreamReader(pis);
		pbr = new BufferedReader(pin);
		int idCounter = 1;
		tmpUsername = ubr.readLine();
		tmpPassword = pbr.readLine();
		while(tmpUsername != null)
		{
			if(tmpUsername.equals(username) && tmpPassword.equals(password)) 
			{
				uis.close();
				uin.close();
				ubr.close();
				pis.close();
				pin.close();
				pbr.close();
				return idCounter;
			}
			idCounter++;
			tmpUsername = ubr.readLine();
			tmpPassword = pbr.readLine();
		}
		uis.close();
		uin.close();
		ubr.close();
		pis.close();
		pin.close();
		pbr.close();
		return 0;
	}
	
}
