package logic;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalculatorView extends Application {
	@FXML
	private Button btPlus;
	@FXML
	private Button btMinus;
	@FXML
	private Button btTimes;
	@FXML
	private Button btDivide;
	@FXML
	private Button btLog;
	@FXML
	private Button btEquals;

	@FXML
	private TextField tfNumber;
	@FXML
	private TextField tfResult;
	@FXML
	private Text info;

	private CalculatorBean bean = new CalculatorBean();
	private Status status = Status.FIRST;

	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Calculator.fxml"));
		Parent root;
		root = loader.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);

		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	@FXML
	public void btPlusController() {
		if (this.status.equals(Status.FIRST) && !(tfNumber.getText().isEmpty())) {
			this.status = Status.SECOND;
			bean.setOperation(Status.PLUS);
			bean.setFirstMember(Integer.parseInt(tfNumber.getText()));
			tfNumber.setText("");
			tfResult.setText(bean.getFirstMember() + "+");
		} else {
			info.setText("You have to insert the first number first!");
		}
	}

	@FXML
	public void btMinusController() {
		if (this.status.equals(Status.FIRST) && !(tfNumber.getText().isEmpty())) {
			this.status = Status.SECOND;
			bean.setOperation(Status.MINUS);
			bean.setFirstMember(Integer.parseInt(tfNumber.getText()));
			tfNumber.setText("");
			tfResult.setText(bean.getFirstMember() + "-");

		} else {
			info.setText("You have to insert the first number first!");
		}
	}

	@FXML
	public void btTimesController() {
		if (this.status.equals(Status.FIRST) && !(tfNumber.getText().isEmpty())) {
			this.status = Status.SECOND;
			bean.setOperation(Status.TIMES);
			bean.setFirstMember(Integer.parseInt(tfNumber.getText()));
			tfNumber.setText("");
			tfResult.setText(bean.getFirstMember() + "*");
		} else {
			info.setText("You have to insert the first number first!");
		}
	}

	@FXML
	public void btDivideController() {
		if (this.status.equals(Status.FIRST) && !(tfNumber.getText().isEmpty())) {
			this.status = Status.SECOND;
			bean.setOperation(Status.DIVIDE);
			bean.setFirstMember(Integer.parseInt(tfNumber.getText()));
			tfNumber.setText("");
			tfResult.setText(bean.getFirstMember() + "/");
		} else {
			info.setText("You have to insert the first number first!");
		}

	}

	@FXML
	public void btLogController() {
		if (this.status.equals(Status.FIRST) && !(tfNumber.getText().isEmpty())) {
			info.setText("Usage: first insert the Base, then the argument.");
			this.status = Status.SECOND;
			bean.setOperation(Status.LOG);
			bean.setFirstMember(Integer.parseInt(tfNumber.getText()));
			tfNumber.setText("");
			tfResult.setText("log" + bean.getFirstMember());
		} else {
			info.setText("Usage: first insert the Base, then the argument. \n You have to insert the first number first!");
		}

	}

	

	@FXML
	public void btEqualsController() {
		if (this.status.equals(Status.SECOND) && !(tfNumber.getText().isEmpty())) {
			bean.setSecondMember(Integer.parseInt(tfNumber.getText()));
			CalculatorController controller = new CalculatorController();
			Float result;
			try {
				result = controller.doOperations(bean);
				printResult(result);
			} catch (Exception e) {
				info.setText(e.getMessage());
			} finally {
				tfNumber.setText("");
				this.status = Status.FIRST;
			}
		} else {
			info.setText("You have to insert the second number first!");
		}

	}
	
	public void printResult(Float result) {
		String temp;
		if(bean.getOperation().equals(Status.LOG)) {
			temp = tfResult.getText()+"("+bean.getSecondMember()+")"+"=" + result;
		}else{
			temp = tfResult.getText() + bean.getSecondMember() + "=" + result;
		}
		tfResult.setText(temp);
	}

}
