package br.com.desafio2.ilab.group5.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {

	public static String encrypt(String original) throws Exception {

		String strMyKey = "ch@v3cr1pt0gr@f@d@+32b1t$d3s@f10";

		Key createKey = new SecretKeySpec(strMyKey.getBytes(), "AES");

		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.ENCRYPT_MODE, createKey);

		cipher.update(original.getBytes());

		String originalCripto = new String(cipher.doFinal(), "UTF-8");

		byte[] passwordEncrypt = originalCripto.getBytes();

		StringBuilder cryptoHex = new StringBuilder();

		for (byte b : passwordEncrypt) {
			cryptoHex.append(Integer.toHexString(b));
		}

		return cryptoHex.toString();
	}
}
