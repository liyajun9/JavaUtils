package utils.security.cipher;

public class Cipher{
	private static final String MODE_AES_CBC = "AES/CBC/PKCS5Padding";
	private static final String MODE_DES_CBC = "DES/CBC/PKCS5Padding";
	private static final String KEYMODE_AES = "AES"; 
	private static final String KEYMODE_DES = "DES"; 
	
	public static String AES64_CBC_Encrypt(byte[] bytes, String key, String iv){
		return BaseCipher.encrypt64(bytes, key, iv, MODE_AES_CBC, KEYMODE_AES, BaseCipher.KEY_TRANSFORM_NONE);
	}
	
	public static byte[] AES64_CBC_Decrypt(String data, String key, String iv){
		return BaseCipher.decrypt64(data, key, iv, MODE_AES_CBC, KEYMODE_AES, BaseCipher.KEY_TRANSFORM_NONE);
	}
	
	public static String DES64_CBC_EncryptWithKeyMD5(byte[] bytes, String key, String iv){
		return BaseCipher.encrypt64(bytes, key, iv, MODE_DES_CBC, KEYMODE_DES, BaseCipher.KEY_TRANSFORM_MD5);
	}
	
	public static byte[] DES64_CBC_DecryptWithKeyMD5(String data, String key, String iv){
		return BaseCipher.decrypt64(data, key, iv, MODE_DES_CBC, KEYMODE_DES, BaseCipher.KEY_TRANSFORM_MD5);
	}
	
	public static String DES64_CBC_Encrypt(byte[] bytes, String key, String iv){
		return BaseCipher.encrypt64(bytes, key, iv, MODE_DES_CBC, KEYMODE_DES, BaseCipher.KEY_TRANSFORM_NONE);
	}
	
	public static byte[] DES64_CBC_Decrypt(String data, String key, String iv){
		return BaseCipher.decrypt64(data, key, iv, MODE_DES_CBC, KEYMODE_DES, BaseCipher.KEY_TRANSFORM_NONE);
	}
	
	public static void main(String[] args) {
//		 String sData = "jkljgklfjglnnmcbxi45353";
//		 System.out.println(Cipher.AES64_CBC_Encrypt(sData.getBytes(), "1234567887654321", "abcdefghabcdefgh"));
//		 
//		 String sCipherText = "qskXGbpOXGC5GZ4quV83mW4cMMTaRshvFnd045Xi97E=";
//		 System.out.println(Cipher.AES64_CBC_Decrypt(sCipherText, "1234567887654321", "abcdefghabcdefgh"));
		 
		 String sData = "jkljgklfjglnnmcbxi45353";
		 System.out.println(Cipher.DES64_ECB_EncryptWithKeyMD5(sData.getBytes(), "12345678", "01234567"));
//		 
//		 String sCipherText = "pzF3o9OTAyth2TYsiWlY94ljfbLhFgpi";
//		 System.out.println(Cipher.DES64_CBC_DecryptWithKeyMD5(sCipherText, "12345678", "01234567"));
	}

}
