package edu.ycp.cs320.stocksimulation.client;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;

import edu.ycp.cs320.stocksimulation.shared.IPublisher;
import edu.ycp.cs320.stocksimulation.shared.ISubscriber;
import edu.ycp.cs320.stocksimulation.shared.Result;

public class ResultView extends Composite implements ISubscriber {
	private Result model;
	private InlineLabel label;
	
	public ResultView() {
		FlowPanel panel = new FlowPanel();
		
		this.label = new InlineLabel();
		this.label.setWidth("40px");
		panel.add(label);
		
		initWidget(panel);
	}
	
	public void setModel(Result model) {
		this.model = model;
		
		// Register to receive VALUE_CHANGED events
		this.model.subscribe(Result.Events.VALUE_CHANGED, this);
	}
	
	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
		if (key == Result.Events.VALUE_CHANGED) {
			label.setText(String.valueOf(model.getValue()));
		}
	}
}
