import javax.xml.ws.Endpoint;

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
		
		/*��Endpoint.publish()���������������������������ṩ�����url��webservice����*/
		Endpoint.publish("http://192.168.1.12/xin", tws);
		
		System.out.println("�ɹ�!!!");
	}

}
