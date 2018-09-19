package design_mode.observer.first;

import java.awt.Event;

/**
 * 观察者接口
 * 
 * @author lishangyun
 * @time 2018年9月19日上午9:59:34
 */
public interface IObserver {
	void update(Event event);// 更新观察者
}
