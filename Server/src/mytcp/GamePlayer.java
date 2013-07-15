package mytcp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class GamePlayer {
	private byte b;
	private String username;
	private String password;
	private String type; 
	int chips;
	int minBet;
	private boolean valid;
	private boolean ready;
	
	public byte[] Message2Byte() throws IOException{
		
		byte[] messagebyte;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// �ֽ������  
        DataOutputStream dos = new DataOutputStream(baos);// ������������ڰ�װ�ֽ������  
        
        dos.write(b);
        dos.writeUTF(username);
        dos.writeUTF(password);
        dos.writeUTF(type);
        messagebyte=baos.toByteArray();// ��д�������ת�����ֽ����� 
        
        dos.close();  
        baos.close();  
        
        return messagebyte;
	}
	
	public static GamePlayer byte2Message(byte[] messagebyte) throws IOException{
		GamePlayer mymessage=new GamePlayer();
		ByteArrayInputStream bais = new ByteArrayInputStream(messagebyte);// �ֽ�������  
        DataInputStream dis = new DataInputStream(bais);// �������������ڰ�װ�ֽ�������
        
        mymessage.setb(dis.readByte());
        mymessage.setUsername(dis.readUTF());
        mymessage.setPassword(dis.readUTF());
        mymessage.setType(dis.readUTF());
        
        return mymessage;
	}
	
	public void setb(byte b){
		this.b=b;
	}
	
	public void setUsername(String username){
		this.username=username;
	}
	
	public void setPassword(String strps){
		this.password=strps;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	public void setValid(boolean valid){
		this.valid=valid;
	}
	
	public byte getb(){
		return b;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getType(){
		return type;
	}
	
	public Boolean getValid(){
		return valid;
	}
}
