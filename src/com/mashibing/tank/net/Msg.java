package com.mashibing.tank.net;

public abstract class Msg {
	
	public abstract void handle();
	//编码：数据类型转Byte
	public abstract byte[] toBytes();
	//解码：Byte转数据类型
	public abstract void parse(byte[] bytes);
	public abstract MsgType getMsgType();
	
}
