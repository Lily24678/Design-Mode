package design_mode.observer.first;

public interface ISubject {
	void attach(IObserver observer);// 添加观察者

	void detach(IObserver observer);// 删除观察者

	void inform();// 通知所有观察者
}
