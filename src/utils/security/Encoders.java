package utils.security;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public final class Encoders {
	public static final Encoder encoder = Base64.getEncoder();
	public static final Decoder decoder = Base64.getDecoder();
	
	public static String base64Encode(byte[] bytes){
		return encoder.encodeToString(bytes);
	}
	
	public static byte[] base64Decode(String str){
		return decoder.decode(str);
	}
}
