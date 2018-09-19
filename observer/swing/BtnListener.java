package design_mode.observer.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BtnListener implements ActionListener {//这就是具体的观察者

	@Override
	public void actionPerformed(ActionEvent e) {//在fireActionPerformed()中被回答
		System.out.println("click");//按钮单击时，由具体观察者处理业务
	}
	
	public static void main(String[] args) {
		JFrame p = new JFrame();
		JButton button = new JButton("Click Me");//新建具体主题
		button.addActionListener(new BtnListener());//在具体主题中，加入观察者
		p.add(button);
		p.pack();
		p.setVisible(true);
	}

}
