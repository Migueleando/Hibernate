package controler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import model.Answer;
import model.Question;
import util.HibernateHelper;
import vista.AddQuestionWindow;

public class Controlador {

    private HibernateHelper modelo;
    private AddQuestionWindow vista;

    public Controlador() {
	modelo = new HibernateHelper();
	vista = new AddQuestionWindow();
	cargarVista();
	addListenerBotonInsertar();
	addListenerBotonMostrar();
    }

    private void addListenerBotonInsertar() {
	vista.getBtnInsertar().addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (camposBlanco()) {
		    nuevaPregunta();
		    System.out.println("pregunta a�adida");
		    nuevaRespuesta();
		    System.out.println("respuesta a�adida");
		    limpiarCampos();
		    JOptionPane.showMessageDialog(null, "Datos Insertados!");
		}
	    }
	});
    }

    private void addListenerBotonMostrar() {
	vista.getBtnMostrar().addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (vista.getTextIdPregunta().getText().isEmpty()) {
		    JOptionPane.showMessageDialog(null,
			    "Introduce un Id para consultar!");
		} else {
		    String idQuestion = vista.getTextIdPregunta().getText();
		    int id = Integer.parseInt(idQuestion);
		    List<Answer> listaRespuestas = modelo
			    .getAnswerByIdQuestion(id);
		    Question question = modelo
			    .getQuestionByIdQuestion(idQuestion);

		    if (id <= modelo.getLastQuestion().getIdQuestion()) {
			vista.getTextPregunta().setText(question.toString());
			vista.getTextResp_1().setText(
				listaRespuestas.get(0).toString());
			vista.getTextResp_2().setText(
				listaRespuestas.get(1).toString());
			vista.getTextResp_3().setText(
				listaRespuestas.get(2).toString());
			vista.getTextResp_4().setText(
				listaRespuestas.get(3).toString());
			vista.getComboBox().addItem(
				question.getCategory().toString());
		    } else {
			JOptionPane.showMessageDialog(null,
				"No hay datos con ese ID");
		    }

		}

	    }
	});
    }

    private void addListenerBotonActualizar() {
	vista.getBtnActualizar().addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (camposBlanco()) {
		    String idQuestion;
		    String textQuestion, category;
		    idQuestion = vista.getTextIdPregunta().getText();
		    textQuestion = vista.getTextPregunta().getText();
		    category = vista.getComboBox().getToolTipText().toString();
		    int id = Integer.parseInt(idQuestion);
		    modelo.updateAnswer(modelo.getLastAnswer().getIdAnswer(),
			    modelo.getLastQuestion(), vista.getTextResp_1()
				    .getText(), vista.getChckbxCheckbox1()
				    .isSelected());
		    modelo.updateAnswer(modelo.getLastAnswer().getIdAnswer(),
			    modelo.getLastQuestion(), vista.getTextResp_2()
				    .getText(), vista.getChckbxCheckbox2()
				    .isSelected());
		    modelo.updateAnswer(modelo.getLastAnswer().getIdAnswer(),
			    modelo.getLastQuestion(), vista.getTextResp_3()
				    .getText(), vista.getChckbxCheckbox3()
				    .isSelected());
		    modelo.updateAnswer(modelo.getLastAnswer().getIdAnswer(),
			    modelo.getLastQuestion(), vista.getTextResp_4()
				    .getText(), vista.getCheckBox4()
				    .isSelected());
		    modelo.updateQuestion(id, textQuestion, category);

		}
	    }
	});
    }

    private void cargarVista() {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    vista.getFrame().setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public boolean camposBlanco() {
	if (vista.getComboBox().getToolTipText().isEmpty()
		|| vista.getTextPregunta().getText().isEmpty()
		|| vista.getTextResp_1().getText().isEmpty()
		|| vista.getTextResp_2().getText().isEmpty()
		|| vista.getTextResp_3().getText().isEmpty()
		|| vista.getTextResp_4().getText().isEmpty()) {
	    JOptionPane.showMessageDialog(null,
		    "Debe rellenar todos los campos");
	    return false;
	} else {
	    return true;
	}
    }

    // A�adir autom�ticamente el id de la pregunta a�adida
    public void nuevaPregunta() {
	int idQuestion;
	String textQuestion, category;
	idQuestion = modelo.getLastQuestion().getIdQuestion() + 1;
	textQuestion = vista.getTextPregunta().getText();
	category = vista.getComboBox().getToolTipText().toString();
	modelo.addQuestion(idQuestion, textQuestion, category);
    }

    // A�adir autom�ticamente el id de las respuestas a�adidas
    public void nuevaRespuesta() {
	modelo.addAnswer(modelo.getLastAnswer().getIdAnswer() + 1,
		modelo.getLastQuestion(), vista.getTextResp_1().getText(),
		vista.getChckbxCheckbox1().isSelected());
	modelo.addAnswer(modelo.getLastAnswer().getIdAnswer() + 1,
		modelo.getLastQuestion(), vista.getTextResp_2().getText(),
		vista.getChckbxCheckbox2().isSelected());
	modelo.addAnswer(modelo.getLastAnswer().getIdAnswer() + 1,
		modelo.getLastQuestion(), vista.getTextResp_3().getText(),
		vista.getChckbxCheckbox3().isSelected());
	modelo.addAnswer(modelo.getLastAnswer().getIdAnswer() + 1,
		modelo.getLastQuestion(), vista.getTextResp_4().getText(),
		vista.getCheckBox4().isSelected());
    }

    public void limpiarCampos() {
	vista.getTextPregunta().setText("");
	vista.getTextResp_1().setText("");
	vista.getTextResp_4().setText("");
	vista.getTextResp_2().setText("");
	vista.getTextResp_3().setText("");
	vista.getComboBox().setToolTipText("");
	vista.getChckbxCheckbox1().setSelected(false);
	vista.getChckbxCheckbox2().setSelected(false);
	vista.getChckbxCheckbox3().setSelected(false);
	vista.getCheckBox4().setSelected(false);
    }
}
