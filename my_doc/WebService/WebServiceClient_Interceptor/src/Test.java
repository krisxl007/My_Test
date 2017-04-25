import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;

import com.interceptor.MyInterceptor;
import com.webservice.TestWS;
import com.webserviceimpl.TestWSImpl;

public class Test {

	public static void main(String[] args) {
		
		/*new���õ���ʵ������*/
		TestWSImpl factory = new TestWSImpl();
		TestWS tws = factory.getTestWSImplPort();
		
		/*���ͻ������Out������*/
		Client client = ClientProxy.getClient(tws);
		client.getOutInterceptors().add(new MyInterceptor("xin","1234"));
		
		tws.hello();
	}

}
