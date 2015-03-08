package util;

import model.Answer;
import model.Question;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import vista.AddQuestionWindow;

public class HibernateHelper {

    private SessionFactory sesion;
    private AddQuestionWindow vista;

    public HibernateHelper() {
	sesion = SessionFactoryUtil.getSessionFactory();
    }

    public void addQuestion(int idQuestion, String QuestionTEXT, String category) {
	Session session = sesion.openSession();	
	System.out.println("sesion abierta");
	Transaction tx = session.beginTransaction();
	System.out.println("transaccion creada");
	Question question = new Question(idQuestion, QuestionTEXT, category, null, null);
	System.out.println("pregunta");
	session.save(question);
	System.out.println("pregunta insertada");
	tx.commit();
	System.out.println("commit");
	session.close();
    }

    public void addAnswer(int idAnswer, Question idQuestion, String text,
	    boolean iscorrect) {
	Session session = sesion.openSession();
	System.out.println("sesion abierta");
	Transaction tx = session.beginTransaction();
	System.out.println("transaccion creada");
	Answer answer = new Answer(idAnswer, idQuestion, text, iscorrect, null);
	System.out.println("respuesta");
	session.save(answer);
	tx.commit();
	session.close();
    }

    public Question getLastQuestion() {
	Session session = sesion.openSession();
	Query query = session.createQuery("from Question order by idQuestion DESC");
	Question last = (Question) query.uniqueResult();
	session.close();
	return last;
    }
    
    public Answer getLastAnswer(){
	Session session = sesion.openSession();
	Query query = session.createQuery("from Answer order by idAnswer DESC");
	Answer last = (Answer) query.uniqueResult();
	session.close();
	return last;
    }
}
