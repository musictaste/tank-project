package com.mashibing.tank.net;

import java.util.List;
import java.util.UUID;

import com.mashibing.tank.Dir;
import com.mashibing.tank.Group;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MsgDecoder extends ByteToMessageDecoder{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		//数据类型(int)+数据长度(int)
		if(in.readableBytes() < 8) return;

		//很重要，记录读数据的位置
		in.markReaderIndex();
		
		MsgType msgType = MsgType.values()[in.readInt()];
		int length = in.readInt();

		//如果消息的长度小于消息体的长度，则等待消息传送过来
		if(in.readableBytes()< length) {
			//重置读指针，如果数据类型和数据长度已经度过了，重置后，就不需要再读数据类型和数据长度了
			in.resetReaderIndex();
			return;
		} 
		
		byte[] bytes = new byte[length];
		in.readBytes(bytes);
		
		Msg msg = null;
		
		//第一种方法：switch；第二种：reflection反射
		msg = (Msg)Class.forName("com.mashibing.tank.net." + msgType.toString() + "Msg").getDeclaredConstructor().newInstance();
		/*switch(msgType) {
		case TankJoin:
			msg = new TankJoinMsg();
			break;
		case TankStartMoving:
			msg = new TankStartMovingMsg();
			break;
		case TankStop:
			msg = new TankStopMsg();
			break;
		case Tank
		default:
			break;
		}*/
		
		msg.parse(bytes);
		out.add(msg);
		
	}

}
