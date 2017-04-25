package com.publish;
import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;

import com.interceptor.MyInterceptor;
import com.webservice.TestWS;
import com.webserviceImpl.TestWSImpl;

/**
 * ����webservice�ӿ�,�����󼴿ɷ��ʵ�http://192.168.1.12/xin?wsdl���wsdl�ļ�Ŀ¼
 * @author Xin
 *
 */
public class WSPublish {

	public static void main(String[] args) {
		
		TestWS tws = new TestWSImpl();
		
		EndpointImpl ep = (EndpointImpl)Endpoint.publish("http://192.168.1.12/xin", tws);
		
		//���������˵�webservice��Դ���In������
		//ep.getInInterceptors().add(new LoggingInInterceptor());
		ep.getInInterceptors().add(new MyInterceptor());
		
		System.out.println("�ɹ�!!!");
	}

}
