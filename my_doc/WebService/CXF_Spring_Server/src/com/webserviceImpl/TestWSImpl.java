package com.webserviceImpl;

import javax.jws.WebService;

import com.webservice.TestWS;

 /**
  * ʵ��webservice�ӿ�
  * @author Xin
  *
  */
@WebService(endpointInterface="com.webservice.TestWS", serviceName="TestWSImpl")
public class TestWSImpl implements TestWS{

	@Override
	public void hello() {
		System.out.println("hello world!");
	}
	
}
