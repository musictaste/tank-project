package com.mashibing.tank.net;

public abstract class Msg {
	
	public abstract void handle();
	//���룺��������תByte
	public abstract byte[] toBytes();
	//���룺Byteת��������
	public abstract void parse(byte[] bytes);
	public abstract MsgType getMsgType();
	
}
