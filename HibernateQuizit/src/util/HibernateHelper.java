package util;

import java.util.List;

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

    // Método que inserta nueva pregunta
    public void addQuestion(int idQuestion, String QuestionTEXT, String category) {
	Session session = sesion.openSession();
	Transaction tx = session.beginTransaction();
	Question question = new Question(idQuestion, QuestionTEXT, category,
		null, null);
	session.save(question);
	tx.commit();
	session.close();
    }

    // Método que inserta nueva respuesta
    public void addAnswer(int idAnswer, Question idQuestion, String text,
	    boolean iscorrect) {
	Session session = sesion.openSession();
	Transaction tx = session.beginTransaction();
	Answer answer = new Answer(idAnswer, idQuestion, text, iscorrect, null);
	session.save(answer);
	tx.commit();
	session.close();
    }

    // método que devuelve el id de la última pregunta añadida
    public Question getLastQuestion() {
	Session session = sesion.openSession();
	Query query = session
		.createQuery("from Question order by idQuestion DESC");
	query.setMaxResults(1);
	Question last = (Question) query.uniqueResult();
	session.close();
	return last;
    }

    // método que devuelve el id de la última respuesta añadida
    public Answer getLastAnswer() {
	Session session = sesion.openSession();
	Query query = session.createQuery("from Answer order by idAnswer DESC");
	query.setMaxResults(1);
	Answer last = (Answer) query.uniqueResult();
	session.close();
	return last;
    }

    public Question getQuestionByIdQuestion(String idQuestion) {
	Question question;
	Session session = sesion.openSession();
	Query query = session.createQuery("from Question where idQuestion = "
		+ idQuestion);
	question = (Question) query.uniqueResult();
	session.close();
	return question;

    }

    public List<Answer> getAnswerByIdQuestion (String idQuestion) {
	List<Answer> answers;
	Session session = sesion.openSession();
	Query query = session.createQuery("from Answer where idQuestion = "
		+ idQuestion);
	answers = query.list();
	session.close();
	return answers;
    }
}
