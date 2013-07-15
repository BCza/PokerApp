package com.example.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MyMessage {
	private byte b;
	private String str;
	private String strps;
	private String type;
	private boolean valid;
	//Change up here for the type of message I'm looking for when receiving
	
	
	public byte[] Message2Byte() throws IOException{
		byte[] messagebyte;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// �ֽ������  
        DataOutputStream dos = new DataOutputStream(baos);// ������������ڰ�װ�ֽ������  
        
        dos.write(b);
        dos.writeUTF(str);
        dos.writeUTF(strps);
        dos.writeUTF(type);
        messagebyte=baos.toByteArray();// ��д�������ת�����ֽ����� 
        dos.close();  
        baos.close();  
        
        return messagebyte;
	}
	
	
	public static MyMessage byte2Message(byte[] messagebyte) throws IOException{
		
		MyMessage mymessage=new MyMessage();
		ByteArrayInputStream bais = new ByteArrayInputStream(messagebyte);// �ֽ�������  
        DataInputStream dis = new DataInputStream(bais);// �������������ڰ�װ�ֽ�������
        
        mymessage.setb(dis.readByte());
        mymessage.setstr(dis.readUTF());
        mymessage.setstrps(dis.readUTF());
        mymessage.setType(dis.readUTF());
        
        return mymessage;
	}
	
	public void setb(byte b){
		this.b=b;
	}
	
	public void setstr(String str){
		this.str=str;
	}
	
	public void setstrps(String strps){
		this.strps=strps;
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
	
	public String getStr(){
		return str;
	}
	
	public String getStrps(){
		return strps;
	}
	
	public String getType(){
		return type;
	}
	
	public Boolean getValid(){
		return valid;
	}
	
}