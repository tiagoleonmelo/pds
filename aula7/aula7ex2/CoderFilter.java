package aula7ex2;

import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CoderFilter extends Decorator{
	
	Scanner sc;

	public CoderFilter(Reader tr) {
		super(tr);
		sc = new Scanner(tr.next());
	}
	
	@Override
	public boolean hasNext() {
		return sc.hasNext() || tr.hasNext();
	}


	@Override
	public String next() {
		if(!sc.hasNext()) 
			sc = new Scanner(tr.next());	// passar para o prox paragrafo
		
		String strData = sc.next(); 
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strData.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(strData.getBytes());
			strData=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return strData;
	}
	
}
