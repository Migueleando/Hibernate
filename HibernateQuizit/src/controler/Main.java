package controler;

import model.Question;
import util.HibernateHelper;

public class Main {
    public static void main(String[] args) {
	
	new Controlador();
	/*
	HibernateHelper hibernateHelper = new HibernateHelper();
	System.out.println("Inserto una pregunta nueva");
	Question q = new Question (5, "¿Cuánto son 2 + 2?", "Matemáticas")
	hibernateHelper.addQuestion(q);
	Question question =  hibernateHelper.getLastQuestion();
	hibernateHelper.addAnswer(4, q, "4", true);
	hibernateHelper.addAnswer(5, q, "5", false);
	*/
    };
}
