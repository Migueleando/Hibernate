package controler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.bind.ParseConversionEvent;

import model.Test;
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
    }

    private void addListenerBotonInsertar() {
	vista.getBtnInsertar().addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (camposBlanco()) {
		    System.out.println("no hay campos en blanco");
		    nuevaPregunta();
		    System.out.println("pregunta añadida");
		    nuevaRespuesta();
		    System.out.println("respuesta añadida");
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
	if (vista.getTextCat().getText().isEmpty()
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

    public void nuevaPregunta() {
	int idQuestion;
	String textQuestion, category;
	idQuestion = modelo.getLastQuestion().getIdQuestion() + 1;
	//System.out.println(idQuestion);
	textQuestion = vista.getTextPregunta().toString();
	//System.out.println(textQuestion);
	category = vista.getTextCat().toString();
	//System.out.println(category);
	modelo.addQuestion(idQuestion, textQuestion, category);
    }

    public void nuevaRespuesta() {
	modelo.addAnswer(modelo.getLastAnswer().getIdAnswer() + 1,
		modelo.getLastQuestion(), vista.getTextResp_1().toString(),
		vista.getChckbxCheckbox1().isSelected());
	modelo.addAnswer(modelo.getLastAnswer().getIdAnswer() + 1,
		modelo.getLastQuestion(), vista.getTextResp_2().toString(),
		vista.getChckbxCheckbox2().isSelected());
	modelo.addAnswer(modelo.getLastAnswer().getIdAnswer() + 1,
		modelo.getLastQuestion(), vista.getTextResp_3().toString(),
		vista.getChckbxCheckbox3().isSelected());
	modelo.addAnswer(modelo.getLastAnswer().getIdAnswer() + 1,
		modelo.getLastQuestion(), vista.getTextResp_4().toString(),
		vista.getCheckBox4().isSelected());
    }
}
