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

    public List<Answer> getAnswerByIdQuestion(int id) {
	List<Answer> answers;
	Session session = sesion.openSession();
	Query query = session.createQuery("from Answer where idQuestion = "
		+ id);
	answers = query.list();
	session.close();
	return answers;
    }

    public void updateQuestion(int idQuestion, String QuestionTEXT, String category) {
	Question question = new Question();
	Session session = sesion.openSession();
	Transaction t = session.beginTransaction();
	Question questionNew = (Question) session.get(Question.class,
		question.getIdQuestion());
	questionNew.setIdQuestion(question.getIdQuestion());
	questionNew.setQuestionText(question.getQuestionText());
	questionNew.setCategory(question.getCategory());

	if (questionNew != null) {
	    session.update(questionNew);
	}
	t.commit();
	session.close();
    }

    public void updateAnswer(int idAnswer, Question idQuestion, String text,
	    boolean iscorrect) {
	Answer answer = new Answer();
	Session session = sesion.openSession();
	Transaction t = session.beginTransaction();
	Answer answerNew = (Answer) session.get(Answer.class,
		answer.getIdAnswer());
	answerNew.setIdAnswer(answer.getIdAnswer());
	answerNew.setAnswerText(answer.getAnswerText());
	answerNew.setQuestion(answer.getQuestion());
	answerNew.setIsCorrect(answer.getIsCorrect());

	if (answerNew != null) {
	    session.update(answerNew);
	}
	t.commit();
	session.close();
    }

    public void deleteQuestion(int id) {
	Session session = sesion.openSession();
	Transaction tx = session.beginTransaction();
	Question question = (Question) session.get(Question.class, (int) id);
	List<Answer> answer = getAnswerByIdQuestion(id);

	for (Answer a : answer) {
	    int idAnswer = a.getIdAnswer();
	    deleteAnswer(idAnswer);
	}
	if (question != null) {
	    session.delete(question);
	    tx.commit();
	}
	session.close();
    }

    public void deleteAnswer(int id) {
	Session session = sesion.openSession();
	Transaction tx = session.beginTransaction();
	Answer answer = (Answer) session.get(Answer.class, (int) id);
	if (answer != null) {
	    session.delete(answer);
	    tx.commit();
	}
	session.close();
    }
}
