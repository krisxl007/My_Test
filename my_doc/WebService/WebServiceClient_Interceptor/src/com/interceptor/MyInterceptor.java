package com.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class MyInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	private String username;
	private String password;
	
	public MyInterceptor(String username, String password) {
		super(Phase.PREPARE_SEND); //�ÿͻ�����������׼������ǰ����
		this.username = username;
		this.password = password;	
	}

	/**
	 * ʵ��һ��Ϊ�ͻ�������webservice���ͷ�ļ���������
	 */
	@Override
	public void handleMessage(SoapMessage smg) throws Fault {
		
		/*�õ�ͷ�ļ���Ϣ*/
		List<Header> headers = smg.getHeaders();
		
		/*����ͷ�ļ���Ϣ*/
		Document doc = DOMUtils.createDocument(); //����Document����
		Element firstHeader = doc.createElement("firstHeader"); //����һ����"firstHeader"���Ƶ�Element
		Element usernameElement = doc.createElement("username"); //����һ����"username"���Ƶ�Element
		Element passwordElement = doc.createElement("password"); //����һ����"password"���Ƶ�Element
		Element test = doc.createElement("test");
		
		usernameElement.setTextContent(username); //���ø�Element���ı����ݵ�ֵ
		passwordElement.setTextContent(password); //���ø�Element���ı����ݵ�ֵ
		test.setTextContent("test111");
		firstHeader.appendChild(usernameElement); //��usernameElement��Ԫ�طŵ�firstHeader��
		firstHeader.appendChild(passwordElement); //��passwordElement��Ԫ�طŵ�firstHeader��
		firstHeader.appendChild(test);
		/**
		 * ����Ĵ���������һ������XML�ĵ�Ƭ��:
		 * <firstHeader>
		 * 		<username>username</username>
		 * 		<password>password</password>
		 * </firstHeader>
		 * 
		 */
				
		/*��Ӵ�����ͷ�ļ���ͷ�ļ��б���*/
		headers.add(new Header(new QName("testHeader"), firstHeader));
		
	}
	
}
