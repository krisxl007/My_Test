
public class TestObserver {

	public static void main(String[] args) {
		//���ñ��۲��������޵ĳ�ʼ���۸�Ϊ9999
		Doll doll = new Doll(9999);
		System.out.println("���޵�ԭ��Ϊ: " + doll.getPrice());
		
		//���þ���۲��ߵ�����
		Person p1 = new Person("С��");
		Person p2 = new Person("С��");
		
		//ע�������۲���
		doll.registerObserver(p1);
		doll.registerObserver(p2);
		
		//��һ�ֽ���Ϊ8888
		doll.setPrice(8888);
		
		//�ڶ��ֽ���Ϊ7777
		doll.setPrice(7777);
		doll.removeObserver(p1); //С�ڹ��������ޣ���ȡ���۲�
		
		//�����ֽ���Ϊ6666
		doll.setPrice(6666);
	}

}
