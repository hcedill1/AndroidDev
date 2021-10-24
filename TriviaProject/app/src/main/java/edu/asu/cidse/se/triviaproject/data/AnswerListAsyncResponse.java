package edu.asu.cidse.se.triviaproject.data;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.asu.cidse.se.triviaproject.model.Question;

public interface AnswerListAsyncResponse {
    //this does not have a body, so whoever uses this has to make the body
    //this is a signal that will allow to grab information once when the work is done you pass.
    //the information whover is trying to use it.
    void processFinished(ArrayList<Question> questionArrayList);


}
