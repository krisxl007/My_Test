/**
 * ���۲������Ľӿ�
 * @author Xin
 *
 */
public interface Subject {
	
	//ע��۲���
	public void registerObserver(Observer observer);
	
	//�Ƴ��۲���
	public void removeObserver(Observer observer);
	
	//������������仯ʱ֪ͨ���й۲���
	public void notifyService();
}
