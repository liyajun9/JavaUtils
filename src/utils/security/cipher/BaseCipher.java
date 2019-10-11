package utils.security.cipher;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import utils.security.Encoders;

public class BaseCipher {
	protected static final int KEY_TRANSFORM_NONE = 0;
	protected static final int KEY_TRANSFORM_MD5 = 1;
	
	protected static String encrypt64(byte[] data, String key, String iv, String mode, String keyMode, int keyTransform){
		return Encoders.base64Encode(encrypt(data, key, iv, mode, keyMode, Cipher.ENCRYPT_MODE, keyTransform));
	}
	
	protected static byte[] decrypt64(String data, String key, String iv, String mode, String keyMode, int keyTransform){
		return encrypt(Encoders.base64Decode(data), key, iv, mode, keyMode, Cipher.DECRYPT_MODE, keyTransform);
	}
	
	protected static byte[] encrypt(byte[] data, String key, String iv, String mode, String keyMode, int encryptMode, int keyTransform){
		try{
			Cipher cipher = null;
			if(keyTransform == KEY_TRANSFORM_MD5)
				cipher = getCipherwithKeyMD5(key, iv, mode, keyMode, encryptMode);
			else if(keyTransform == KEY_TRANSFORM_NONE)
				cipher = getCipher(key, iv, mode, keyMode, encryptMode);
			else
				cipher = getCipher(key, iv, mode, keyMode, encryptMode);
			if(cipher != null)
				return cipher.doFinal(data);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected static Cipher getCipherwithKeyMD5(String key, String iv, String mode, String keyMode, int encryptMode){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(key.getBytes("utf-8"));
			
			DESKeySpec dsk = new DESKeySpec(md.digest());
			
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(keyMode);
			SecretKey sKey = keyFactory.generateSecret(dsk);
			
			IvParameterSpec ivSpec = new IvParameterSpec(generateSpec(iv));
			AlgorithmParameterSpec paramSpec = ivSpec;
			
			Cipher cipher = Cipher.getInstance(mode);
			cipher.init(encryptMode, sKey, paramSpec);
			return cipher;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected static Cipher getCipher(String key, String iv, String mode, String keyMode, int encryptMode){
		try{
			SecretKeySpec keySpec = new SecretKeySpec(generateSpec(key), keyMode);
			IvParameterSpec ivSpec = new IvParameterSpec(generateSpec(iv));
			Cipher cipher = Cipher.getInstance(mode);
			cipher.init(encryptMode, keySpec, ivSpec);
			return cipher;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	protected static byte[] generateSpec(String key){
		try{
			return key.getBytes("utf-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
