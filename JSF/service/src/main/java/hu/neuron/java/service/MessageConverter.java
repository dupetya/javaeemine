package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.MessageVO;
import hu.schonherz.java.entities.Message;

public class MessageConverter {

	private static Mapper mapper = new DozerBeanMapper();

	public static MessageVO toVo(Message Message) {
		if (Message == null) {
			return null;
		}
		return mapper.map(Message, MessageVO.class);
	}

	public static Message toEntity(MessageVO Message) {
		if (Message == null) {
			return null;
		}
		return mapper.map(Message, Message.class);
	}

	public static List<MessageVO> toVo(List<Message> Messages) {
		List<MessageVO> res = new ArrayList<>();

		for (Message Message : Messages) {
			res.add(toVo(Message));
		}

		return res;
	}

	public static List<Message> toEntity(List<MessageVO> Messages) {
		List<Message> res = new ArrayList<>();

		for (MessageVO Message : Messages) {
			res.add(toEntity(Message));
		}

		return res;
	}

}
