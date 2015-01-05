package scsms.jc.entity;

public class countOfValueAtQues {

	public countOfValueAtQues() {
		// TODO Auto-generated constructor stub
	}
private int count;
private String questionLabel;
private String result;
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getQuestionLabel() {
	return questionLabel;
}
public void setQuestionLabel(String questionLabel) {
	this.questionLabel = questionLabel;
}
public String getResult() {
	return result;
}
public void setResult(String result) {
	this.result = result;
}
public countOfValueAtQues(int count, String questionLabel, String result) {
	super();
	this.count = count;
	this.questionLabel = questionLabel;
	this.result = result;
}




}
