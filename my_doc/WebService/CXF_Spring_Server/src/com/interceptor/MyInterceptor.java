package com.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * �Զ���������ʱ��Ҫ�̳�AbstractPhaseInterceptor�����,���������׳�һ��Fault�쳣ʱ���Զ�ȡ������webservice��Դ
 * @author Xin
 *
 */
public class MyInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

	public MyInterceptor() {
		super(Phase.PRE_INVOKE); //�������������ڵ���webserviceǰ������
	}

	/**
	 * ʵ��һ����֤�û����������������
	 */
	@Override
	public void handleMessage(SoapMessage smg) throws Fault {
		
		System.out.println("��������������");
		
		List<Header> headers = smg.getHeaders(); //��ȡSOAP��Ϣ������ͷheader
		if(headers == null || headers.size() < 1) { //���û������ͷ
			throw new Fault(new IllegalArgumentException("û��Header��Ϣ"));
		}
		
		/*�����û����������Ƿ��ڵ�һ������ͷ��,�ֱ��username��password*/
		Header firstHeader = headers.get(0); //�õ���һ������ͷ
		Element ele = (Element) firstHeader.getObject(); //�õ���һ������ͷ�е�Ԫ��
		
		NodeList userNames = ele.getElementsByTagName("username"); //����ָ���������õ��ڵ��б�
		NodeList userPasswords = ele.getElementsByTagName("password"); //����ָ���������õ��ڵ��б�

		if(userNames.getLength() != 1) { //�ж��Ƿ�ֻ��һ����"username"��Ԫ��
			throw new Fault(new IllegalArgumentException("�û�����ʽ����ȷ"));
		}	
		
		if(userPasswords.getLength() != 1) { //�ж��Ƿ�ֻ��һ����"password"��Ԫ��
			throw new Fault(new IllegalArgumentException("�����ʽ����ȷ"));
		}
		
		String  username = userNames.item(0).getTextContent(); //�õ��ýڵ��б��е�һ���ڵ���ı�����
		String  password = userPasswords.item(0).getTextContent();
		
		if(!username.equals("xin") || !password.equals("1234")) { //ʵ����Ŀ��Ӧ��ѯ���ݿ���û��Ƿ���ʹ��webservice���ʸ�
			throw new Fault(new IllegalArgumentException("�û��������벻��ȷ,����ϵ����ȡ��ʹ���ʸ�"));
		}
	}

}
