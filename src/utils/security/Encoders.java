package utils.security;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public final class Encoders {
	public static final Encoder encoder = Base64.getEncoder();
	public static final Decoder decoder = Base64.getDecoder();
	
	public static String base64Encode(byte[] bytes){
		return encoder.encodeToString(bytes);
	}
	
	public static String base64Encode(String str){
		try {
			return encoder.encodeToString(str.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] base64Decode(String str){
		return decoder.decode(str);
	}
	
	public static String base64DecodeToString(String str){
		try{
			return new String(decoder.decode(str), "utf-8");
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return null;
	}
}
