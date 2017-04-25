import java.util.Vector;

/**
 * ���۲������ʵ��(concrete subject)
 * @author Xin
 *
 */
public class Doll implements Subject {
	
	private float price;
	
	//���۲������ӵ��һ�����й۲��Լ��Ķ�����б�
	private Vector<Observer> vector = new Vector<Observer>();
	
	public Doll(float price) {
		this.price = price;
	}

	@Override
	public void registerObserver(Observer observer) {
		vector.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		vector.remove(observer);
	}

	@Override
	public void notifyService() {
		for(Observer observer : vector) {
			observer.update(price);
		}
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
		notifyService();
	}
}
