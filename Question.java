 
/**
@file Question
@author Christopher Steinmuller
@date 2010-13-11
Description: implements class of the same name
Course: CS2700.01
Paws ID: cstein1
Programming Project #: 4
Instructor: Duncan
*/
package AutomatedExam;


public class Question {

    private String question;
    private String[] options;
    private int answer;
    private int tf;

    Question(String problem, String[] responces, int correct, int type)
    {
        question = problem;
        tf = type;
        answer = correct;
        options = responces;
    }

    public String getQuestion()
    {
        return question;
    }

    public String[] getOptions()
    {
        return options;
    }

    public int getAnswer()
    {
        return answer;
    }

    public int getTf()
    {
        return tf;
    }
}
