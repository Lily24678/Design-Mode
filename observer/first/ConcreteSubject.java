package design_mode.observer.first;

import java.awt.Event;
import java.util.Vector;


/**
 * 具体主题
 * 
 * @author lishangyun
 * @time 2018年9月19日上午10:01:29
 */
public class ConcreteSubject implements ISubject {
Vector<IObserver> observers=new Vector<>();
	@Override
	public void attach(IObserver observer) {
		observers.addElement(observer);
	}

	@Override
	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void inform() {
		Event event = new Event(observers, 0, observers);
		for (IObserver ob : observers) {
			ob.update(event);//注意，在这里通知观察者
		}
	}

}
