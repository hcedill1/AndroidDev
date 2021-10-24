package edu.asu.cidse.se.triviaproject.model;

public class Question {
    private String answer;
    private boolean answerTrue;

    public Question(){

    }

    public Question(String answer, boolean answerTrue) {
        this.answer = answer;
        this.answerTrue = answerTrue;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
    // we will be able to see the string representation of the field of the class
    //remember once you end up putting toString you dont have to use the dot operator in
    //order to call from another file, just print out the object.
    @Override
    public String toString() {
        return "Question{" +
                "answer='" + answer + '\'' +
                ", answerTrue=" + answerTrue +
                '}';
    }
}
