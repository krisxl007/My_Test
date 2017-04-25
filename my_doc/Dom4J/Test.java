import java.io.*;

import org.dom4j.*;

/**
 * ��Dom4J����װ�ͽ���XML���룬��Ҫһ��Document������������Ҫ����Element��Node
 * 	1.Element:����ǩ������<dog></dog>����һ��element
 *  2.Node:���ڵ����Ԫ�أ���������element�����ݣ���<dogName>pipi</dogName>
 * ������뽫����һ�����µ�XMLƬ�Σ�
    <MyRoot>
		<dog>
			<dogName>pipi</dogName>
			<dogColor>black</dogColor>
		</dog>
	
		<cat>
			<catName>mimi</catName>
			<catColor>white</catColor>
		</cat>
	</MyRoot>
 *
 * ���У�<MyRoot>��element�ĸ�����2���ֱ���<dog></dog>��<cat></cat>,Node����Ҳ��2.
 * 	          ��"dog"��element�ĸ�����myRoot.elements("dog").size() = 1,Node������2.  
 */
public class Test {

	public static void main(String[] args) throws Exception {
		
		FileWriter file = new FileWriter("test.xml");
		Document doc = DocumentHelper.createDocument();
		Element myRoot = doc.addElement("MyRoot");
		Element dog = myRoot.addElement("dog");
		Element cat = myRoot.addElement("cat");
		Element dogName = dog.addElement("dogName");
		Element dogColor = dog.addElement("dogColor");
		Element catName = cat.addElement("catName");
		Element catColor = cat.addElement("catColor");

		dogName.addText("pipi");
		dogColor.addText("black");
		catName.addText("mimi");
		catColor.addText("white");
		
		System.out.println("MyRoot��Node����Ϊ��" + myRoot.nodeCount());
		System.out.println("MyRoot��Element����Ϊ��" + myRoot.elements().size());
		System.out.println("dog��Node����Ϊ��" + dog.nodeCount());
		System.out.println("dog��Element����Ϊ��" + myRoot.elements("dog").size());
		
		doc.write(file);
		file.close();
	}

}
