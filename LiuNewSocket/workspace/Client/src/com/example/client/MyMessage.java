package com.example.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class MyMessage {
	private byte b;
	private String str;
	public byte[] Message2Byte() throws IOException{
		byte[] messagebyte;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();// �ֽ������  
        DataOutputStream dos = new DataOutputStream(baos);// ������������ڰ�װ�ֽ������  
        dos.write(b);
        dos.writeUTF(str);
        messagebyte=baos.toByteArray();// ��д�������ת�����ֽ����� 
        dos.close();  
        baos.close();  
        return messagebyte;
	}
	public static MyMessage byte2Message(byte[] messagebyte) throws IOException{
		MyMessage mymessage=new MyMessage();
		//byte []temp=null;
		ByteArrayInputStream bais = new ByteArrayInputStream(messagebyte);// �ֽ�������  
        DataInputStream dis = new DataInputStream(bais);// �������������ڰ�װ�ֽ�������
        mymessage.setb(dis.readByte());
        mymessage.setstr(dis.readUTF());
        /*dis.read(temp);
        message.setstr(temp.toString());*/
        return mymessage;
	}
	public void setb(byte b){
		this.b=b;
	}
	public void setstr(String str){
		this.str=str;
	}
	public byte getb(){
		return b;
	}
	public String getStr(){
		return str;
	}
}