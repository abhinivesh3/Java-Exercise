// Get an input from the user through Command line arguments, and print the encrypted or decrypted text depending on the input
// The input from the user should read as -> Crypto testing key encrypt for encrypting and Crypto /wZf6nsWgQA key decrypt for decrypting(where ascy35;> is the encrypted string). Encrypting and decrypting must be done using the key user gives. Error must be thrown for insufficient input. Use inbuilt or your own encryption logic.
// TIP: Use Cipher to encrypt/decrypt data if you are using inbuilt classes.


// inputs
// input encrypt : java EncryptingAndDecrypting Crypto key encrypt "Hello, world!"
// input decrypt : java EncryptingAndDecrypting Crypto key decrypt "/Tz0QhI+5x4YQmEE7BVSmw=="
// input invalid : java EncryptingAndDecrypting Crypto key decrypt "/Tz0QhI+5x4YQmEE7BVSmw=="

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class EncryptingAndDecrypting {

    private static String encryptAES(String string,SecretKey key,byte[] iv){
        try{
            //Cipher cipher=Cipher.getInstance("AES/ECB/PKCS5Padding");
            Cipher cipher=Cipher.getInstance("AES/ECB/NoPadding");
            GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
            cipher.init(Cipher.ENCRYPT_MODE, key,parameterSpec);

            byte[] inputBytes = string.getBytes(StandardCharsets.UTF_8);
            byte[] encrytedBytes = cipher.doFinal(inputBytes);

            ByteBuffer byteBuffer = ByteBuffer.allocate(iv.length + encrytedBytes.length);
            byteBuffer.put(iv);
            byteBuffer.put(encrytedBytes);
            byte[] combined = byteBuffer.array();

            return Base64.getEncoder().encodeToString(combined);
        } 
        catch(Exception e){
            System.out.println("Error while encrypting : "+e);
        }
        return null;
    }

    private static String decryptAES(String encryptedText, SecretKey key,byte[] iv){

        try{
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            GCMParameterSpec parameterSpec = new GCMParameterSpec(128, iv);
            cipher.init(Cipher.DECRYPT_MODE,key,parameterSpec);

            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            return new String(decryptedBytes , StandardCharsets.UTF_8);
        }
        catch(Exception e){
            System.out.println("Error while decrypting : "+e);
        }
        return null;
    }

    private static SecretKey generateAESKey(){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); 
            return keyGen.generateKey();
        }
        catch(NoSuchAlgorithmException  e){
            System.out.println("Error while generateAESKey : "+e);
        }
        return null;
    }
    
    private static byte[] generateIV(){
        byte[] iv=new byte[12];
        SecureRandom secureRandom=new SecureRandom();
        secureRandom.nextBytes(iv);
        return iv;
    }

    public static void main(String[] args) throws Exception{
        if(args.length<4){
            System.out.println("Insufficient input. Please provide: Crypto testing key encrypt <key> for encrypting or Crypto //wZf6nsWgQA key decrypt <encryptedText> for decrypting");
            System.exit(1);
        }
        String command = args[0];
        String keyStr = args[1];
        String operation = args[2];
        String string = args[3];
        
        if (!command.equals("Crypto") || !operation.equals("key")) {
            System.out.println("Invalid input format.");
            return;
        }

        SecretKey key = generateAESKey();
        byte[] iv = generateIV();

        if (operation.equals("encrypt")) {
            String encryptedText = encryptAES(string, key, iv);
            System.out.println("Encrypted text: " + encryptedText);
        } else if (operation.equals("decrypt")) {
            String decryptedText = decryptAES(string, key, iv);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Invalid operation. Use 'encrypt' or 'decrypt'.");
        }
    }

}
