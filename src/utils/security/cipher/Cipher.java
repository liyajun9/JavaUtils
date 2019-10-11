package utils.security.cipher;

import java.io.UnsupportedEncodingException;

public class Cipher{
	private static final String MODE_AES_CBC = "AES/CBC/PKCS5Padding";
	private static final String MODE_DES_CBC = "DES/CBC/PKCS5Padding";
	private static final String KEYMODE_AES = "AES"; 
	private static final String KEYMODE_DES = "DES"; 
	
	public static String AES64_CBC_Encrypt(String data, String key, String iv){
		try{
			return BaseCipher.encrypt64(data.getBytes("utf-8"), key, iv, MODE_AES_CBC, KEYMODE_AES, BaseCipher.KEY_TRANSFORM_NONE);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String AES64_CBC_Decrypt(String data, String key, String iv){
		try{
			return new String(BaseCipher.decrypt64(data, key, iv, MODE_AES_CBC, KEYMODE_AES, BaseCipher.KEY_TRANSFORM_NONE), "utf-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String DES64_CBC_EncryptWithKeyMD5(String data, String key, String iv){
		try{
			return BaseCipher.encrypt64(data.getBytes("utf-8"), key, iv, MODE_DES_CBC, KEYMODE_DES, BaseCipher.KEY_TRANSFORM_MD5);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String DES64_CBC_DecryptWithKeyMD5(String data, String key, String iv){
		try{
			return new String(BaseCipher.decrypt64(data, key, iv, MODE_DES_CBC, KEYMODE_DES, BaseCipher.KEY_TRANSFORM_MD5), "utf-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String DES64_CBC_Encrypt(String data, String key, String iv){
		try{
			return BaseCipher.encrypt64(data.getBytes("utf-8"), key, iv, MODE_DES_CBC, KEYMODE_DES, BaseCipher.KEY_TRANSFORM_NONE);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String DES64_CBC_Decrypt(String data, String key, String iv){
		try{
			return new String(BaseCipher.decrypt64(data, key, iv, MODE_DES_CBC, KEYMODE_DES, BaseCipher.KEY_TRANSFORM_NONE), "utf-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		 String sData = "jkljgklfjglnnmcbxi45353";
		 System.out.println(Cipher.AES64_CBC_Encrypt(sData, "1234567887654321", "abcdefghabcdefgh"));
//		 
//		 String sCipherText = "qskXGbpOXGC5GZ4quV83mW4cMMTaRshvFnd045Xi97E=";
//		 System.out.println(Cipher.AES64_CBC_Decrypt(sCipherText, "1234567887654321", "abcdefghabcdefgh"));
		 
//		 String sData = "jkljgklfjglnnmcbxi45353";
//		 System.out.println(Cipher.DES64_CBC_EncryptWithKeyMD5(sData, "12345678", "01234567"));
//		 
//		 String sCipherText = "pzF3o9OTAyth2TYsiWlY94ljfbLhFgpi";
//		 System.out.println(Cipher.DES64_CBC_DecryptWithKeyMD5(sCipherText, "12345678", "01234567"));
	}

}
