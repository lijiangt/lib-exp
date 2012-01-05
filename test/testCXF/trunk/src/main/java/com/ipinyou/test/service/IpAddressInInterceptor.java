package com.ipinyou.test.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

public class IpAddressInInterceptor extends AbstractPhaseInterceptor<Message> {

	public IpAddressInInterceptor() {
		super(Phase.RECEIVE);
	}

	public void handleMessage(Message message) throws Fault {
		HttpServletRequest request = (HttpServletRequest) message
				.get(AbstractHTTPDestination.HTTP_REQUEST);
		String ip = request.getRemoteAddr(); // 取客户端IP地址
		if (!"127.0.0.1".equals(ip)) {//127.0.0.1
			throw new Fault(new IllegalAccessException("IP address " + ip
					+ " is denied"));
		}
	}

}
