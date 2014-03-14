package edu.ycp.cs320.stocksimulation.client;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;

import edu.ycp.cs320.calculator.shared.IPublisher;
import edu.ycp.cs320.calculator.shared.ISubscriber;
import edu.ycp.cs320.calculator.shared.Operation;
import edu.ycp.cs320.calculator.shared.OperationType;
import edu.ycp.cs320.calculator.shared.PerformOperation;
import edu.ycp.cs320.calculator.shared.Result;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class OperationAndResultView extends Composite implements ISubscriber {
	private Result result;
	private Operation model;
	private PerformOperation controller;
	private ResultView resultView;
	private TextBox firstValueTextBox;
	private TextBox secondValueTextBox;
	
	public OperationAndResultView() {
		this.result = new Result();
		
		LayoutPanel panel = new LayoutPanel();
		initWidget(panel);

		this.resultView = new ResultView();
		resultView.setModel(result);
		panel.add(resultView);
		panel.setWidgetLeftWidth(resultView, 65.0, Unit.PX, 200.0, Unit.PX);
		panel.setWidgetTopHeight(resultView, 187.0, Unit.PX, 31.0, Unit.PX);
		
		InlineLabel nlnlblFirstValue = new InlineLabel("First value");
		panel.add(nlnlblFirstValue);
		panel.setWidgetLeftWidth(nlnlblFirstValue, 19.0, Unit.PX, 90.0, Unit.PX);
		panel.setWidgetTopHeight(nlnlblFirstValue, 31.0, Unit.PX, 18.0, Unit.PX);
		
		firstValueTextBox = new TextBox();
		panel.add(firstValueTextBox);
		panel.setWidgetLeftWidth(firstValueTextBox, 142.0, Unit.PX, 173.0, Unit.PX);
		panel.setWidgetTopHeight(firstValueTextBox, 19.0, Unit.PX, 34.0, Unit.PX);
		
		InlineLabel nlnlblSecondValue = new InlineLabel("Second Value");
		panel.add(nlnlblSecondValue);
		panel.setWidgetLeftWidth(nlnlblSecondValue, 19.0, Unit.PX, 90.0, Unit.PX);
		panel.setWidgetTopHeight(nlnlblSecondValue, 75.0, Unit.PX, 18.0, Unit.PX);
		
		secondValueTextBox = new TextBox();
		panel.add(secondValueTextBox);
		panel.setWidgetLeftWidth(secondValueTextBox, 142.0, Unit.PX, 173.0, Unit.PX);
		panel.setWidgetTopHeight(secondValueTextBox, 69.0, Unit.PX, 34.0, Unit.PX);
		
		Button btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				handleAdd();
			}
		});
		panel.add(btnAdd);
		panel.setWidgetLeftWidth(btnAdd, 346.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnAdd, 19.0, Unit.PX, 30.0, Unit.PX);
		
		Button btnSubtract = new Button("Subtract");
		panel.add(btnSubtract);
		panel.setWidgetLeftWidth(btnSubtract, 346.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnSubtract, 75.0, Unit.PX, 30.0, Unit.PX);
		
		Button btnMultiply = new Button("Multiply");
		panel.add(btnMultiply);
		panel.setWidgetLeftWidth(btnMultiply, 346.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnMultiply, 129.0, Unit.PX, 30.0, Unit.PX);
		
		Button btnDivide = new Button("Divide");
		panel.add(btnDivide);
		panel.setWidgetLeftWidth(btnDivide, 346.0, Unit.PX, 81.0, Unit.PX);
		panel.setWidgetTopHeight(btnDivide, 188.0, Unit.PX, 30.0, Unit.PX);
	}

	protected void handleAdd() {
		double first = Double.valueOf(firstValueTextBox.getText());
		double second = Double.valueOf(secondValueTextBox.getText());
		
		controller.setLeftValue(first);
		controller.setRightValue(second);
		controller.setOperationType(OperationType.ADD);
		controller.perform(result);
	}

	public void setModel(Operation model) {
		this.model = model;
		this.model.subscribe(Operation.Events.VALUE_OR_OPERATION_TYPE_CHANGED, this);
	}

	public void setController(PerformOperation controller) {
		this.controller = controller;
	}
	
	@Override
	public void eventOccurred(Object key, IPublisher publisher, Object hint) {
//		if (key == Operation.Events.VALUE_OR_OPERATION_TYPE_CHANGED) {
//			firstNumberTextBox.setText(String.valueOf(model.getFirst()));
//			secondNumberTextBox.setText(String.valueOf(model.getSecond()));
//		}
	}
}
