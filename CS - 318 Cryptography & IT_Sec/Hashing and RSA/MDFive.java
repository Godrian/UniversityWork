import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class MDFive {
	/*
	 * Given a file path as a string, this method will return
	 * the MD5 value for the corresponding file. 
	 * @returns The MD5 value of the given file as a string.
	 */
	public String computeDigest(String filePath) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("MD5");  
		
		Path path = Paths.get(filePath);
	    byte[] data = Files.readAllBytes(path);
	    
        byte[] mdbytes = md.digest(data);
       
        //convert the byte to hex format
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
        	sb.append(String.format("%02x", mdbytes[i]));
        }
        
		return sb.toString() ;
	}
}

/*
* 291/252 = 1*252 + 39
252/39 = 6*39 + 36
39/36 = 1*36 + 3
36/3 = 12*3 + 0

GCD = 3



p=5
q=11
n=p*q -> 5*11=55
e=3
d=27

Encrypt:
m=4, e=3, n=55
c= 4^3 mod 55 = 9

Decrypt:
c=9, d=27, n=55
m= 9^27 mod 55 = 4*/