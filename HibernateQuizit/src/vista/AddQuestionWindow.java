package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.JCheckBox;

public class AddQuestionWindow {

    private JFrame frame;
    private JTextField textPregunta;
    private JTextField textResp_1;
    private JTextField textResp_2;
    private JTextField textResp_3;
    private JTextField textResp_4;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_4;
    private JLabel lblLaPregunta;
    private JLabel lblLasRespuestas;
    private JPanel panel_5;
    private JPanel panel_7;
    private JLabel lblNewLabel_2;
    private JTextField textCat;
    private JPanel panel_6;
    private JCheckBox chckbxCheckbox1;
    private JCheckBox chckbxCheckbox2;
    private JCheckBox chckbxCheckbox3;
    private JCheckBox checkBox4;
    private JButton btnInsertar;

    /**
     * Create the application.
     */
    public AddQuestionWindow() {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
	frame = new JFrame();
	frame.setBounds(100, 100, 614, 478);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new GridLayout(2, 0, 0, 0));

	JPanel panel = new JPanel();
	frame.getContentPane().add(panel);
	panel.setLayout(new GridLayout(7, 0, 0, 0));

	panel_3 = new JPanel();
	panel.add(panel_3);
	panel_3.setLayout(new BorderLayout(0, 0));

	lblLaPregunta = new JLabel("La pregunta");
	lblLaPregunta.setHorizontalAlignment(SwingConstants.LEFT);
	panel_3.add(lblLaPregunta);

	textPregunta = new JTextField();
	textPregunta.setToolTipText("");
	textPregunta.setHorizontalAlignment(SwingConstants.LEFT);
	panel.add(textPregunta);
	textPregunta.setColumns(10);

	panel_4 = new JPanel();
	panel.add(panel_4);
	panel_4.setLayout(new BorderLayout(0, 0));

	lblLasRespuestas = new JLabel("Las respuestas");
	panel_4.add(lblLasRespuestas);

	textResp_1 = new JTextField();
	textResp_1.setHorizontalAlignment(SwingConstants.LEFT);
	panel.add(textResp_1);

	textResp_2 = new JTextField();
	textResp_2.setHorizontalAlignment(SwingConstants.LEFT);
	panel.add(textResp_2);
	textResp_2.setColumns(10);

	textResp_3 = new JTextField();
	textResp_3.setHorizontalAlignment(SwingConstants.LEFT);
	panel.add(textResp_3);
	textResp_3.setColumns(10);

	textResp_4 = new JTextField();
	textResp_4.setHorizontalAlignment(SwingConstants.LEFT);
	textResp_4.setAlignmentY(Component.TOP_ALIGNMENT);
	panel.add(textResp_4);
	textResp_4.setColumns(10);

	JPanel panel_1 = new JPanel();
	frame.getContentPane().add(panel_1);
	panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

	panel_2 = new JPanel();
	panel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
	panel_1.add(panel_2);
	panel_2.setLayout(new GridLayout(3, 1, 0, 0));

	panel_5 = new JPanel();
	panel_2.add(panel_5);
	panel_5.setLayout(new GridLayout(0, 2, 0, 0));

	lblNewLabel_2 = new JLabel("Categoria");
	lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
	panel_5.add(lblNewLabel_2);

	textCat = new JTextField();
	panel_5.add(textCat);
	textCat.setColumns(10);

	panel_6 = new JPanel();
	panel_5.add(panel_6);
	GridBagLayout gbl_panel_6 = new GridBagLayout();
	gbl_panel_6.columnWidths = new int[] { 35, 35, 35, 45, 0, 35, 0, 0, 0,
		0 };
	gbl_panel_6.rowHeights = new int[] { 25, 0 };
	gbl_panel_6.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
		0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
	gbl_panel_6.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
	panel_6.setLayout(gbl_panel_6);

	chckbxCheckbox1 = new JCheckBox("1");
	GridBagConstraints gbc_chckbxCheckbox1 = new GridBagConstraints();
	gbc_chckbxCheckbox1.anchor = GridBagConstraints.NORTHWEST;
	gbc_chckbxCheckbox1.insets = new Insets(0, 0, 0, 5);
	gbc_chckbxCheckbox1.gridx = 0;
	gbc_chckbxCheckbox1.gridy = 0;
	panel_6.add(chckbxCheckbox1, gbc_chckbxCheckbox1);

	chckbxCheckbox2 = new JCheckBox("2");
	GridBagConstraints gbc_chckbxCheckbox2 = new GridBagConstraints();
	gbc_chckbxCheckbox2.anchor = GridBagConstraints.NORTHWEST;
	gbc_chckbxCheckbox2.insets = new Insets(0, 0, 0, 5);
	gbc_chckbxCheckbox2.gridx = 2;
	gbc_chckbxCheckbox2.gridy = 0;
	panel_6.add(chckbxCheckbox2, gbc_chckbxCheckbox2);

	chckbxCheckbox3 = new JCheckBox("3");
	GridBagConstraints gbc_chckbxCheckbox3 = new GridBagConstraints();
	gbc_chckbxCheckbox3.anchor = GridBagConstraints.NORTHWEST;
	gbc_chckbxCheckbox3.insets = new Insets(0, 0, 0, 5);
	gbc_chckbxCheckbox3.gridx = 4;
	gbc_chckbxCheckbox3.gridy = 0;
	panel_6.add(chckbxCheckbox3, gbc_chckbxCheckbox3);

	checkBox4 = new JCheckBox("4");
	GridBagConstraints gbc_checkBox4 = new GridBagConstraints();
	gbc_checkBox4.insets = new Insets(0, 0, 0, 5);
	gbc_checkBox4.anchor = GridBagConstraints.NORTHWEST;
	gbc_checkBox4.gridx = 7;
	gbc_checkBox4.gridy = 0;
	panel_6.add(checkBox4, gbc_checkBox4);

	panel_7 = new JPanel();
	panel_2.add(panel_7);
	panel_7.setLayout(new BorderLayout(0, 0));

	btnInsertar = new JButton("Insertar");
	panel_2.add(btnInsertar);
    }

    public JFrame getFrame() {
	return frame;
    }

    public void setFrame(JFrame frame) {
	this.frame = frame;
    }

    public JTextField getTextPregunta() {
	return textPregunta;
    }

    public void setTextPregunta(JTextField textPregunta) {
	this.textPregunta = textPregunta;
    }

    public JTextField getTextResp_1() {
	return textResp_1;
    }

    public void setTextResp_1(JTextField textResp_1) {
	this.textResp_1 = textResp_1;
    }

    public JTextField getTextResp_2() {
	return textResp_2;
    }

    public void setTextResp_2(JTextField textResp_2) {
	this.textResp_2 = textResp_2;
    }

    public JTextField getTextResp_3() {
	return textResp_3;
    }

    public void setTextResp_3(JTextField textResp_3) {
	this.textResp_3 = textResp_3;
    }

    public JTextField getTextResp_4() {
	return textResp_4;
    }

    public void setTextResp_4(JTextField textResp_4) {
	this.textResp_4 = textResp_4;
    }

    public JPanel getPanel_2() {
	return panel_2;
    }

    public void setPanel_2(JPanel panel_2) {
	this.panel_2 = panel_2;
    }

    public JPanel getPanel_3() {
	return panel_3;
    }

    public void setPanel_3(JPanel panel_3) {
	this.panel_3 = panel_3;
    }

    public JPanel getPanel_4() {
	return panel_4;
    }

    public void setPanel_4(JPanel panel_4) {
	this.panel_4 = panel_4;
    }

    public JLabel getLblLaPregunta() {
	return lblLaPregunta;
    }

    public void setLblLaPregunta(JLabel lblLaPregunta) {
	this.lblLaPregunta = lblLaPregunta;
    }

    public JLabel getLblLasRespuestas() {
	return lblLasRespuestas;
    }

    public void setLblLasRespuestas(JLabel lblLasRespuestas) {
	this.lblLasRespuestas = lblLasRespuestas;
    }

    public JPanel getPanel_5() {
	return panel_5;
    }

    public void setPanel_5(JPanel panel_5) {
	this.panel_5 = panel_5;
    }

    public JPanel getPanel_7() {
	return panel_7;
    }

    public void setPanel_7(JPanel panel_7) {
	this.panel_7 = panel_7;
    }

    public JLabel getLblNewLabel_2() {
	return lblNewLabel_2;
    }

    public void setLblNewLabel_2(JLabel lblNewLabel_2) {
	this.lblNewLabel_2 = lblNewLabel_2;
    }

    public JTextField getTextCat() {
	return textCat;
    }

    public void setTextCat(JTextField textCat) {
	this.textCat = textCat;
    }

    public JPanel getPanel_6() {
	return panel_6;
    }

    public void setPanel_6(JPanel panel_6) {
	this.panel_6 = panel_6;
    }

    public JCheckBox getChckbxCheckbox1() {
	return chckbxCheckbox1;
    }

    public void setChckbxCheckbox1(JCheckBox chckbxCheckbox1) {
	this.chckbxCheckbox1 = chckbxCheckbox1;
    }

    public JCheckBox getChckbxCheckbox2() {
	return chckbxCheckbox2;
    }

    public void setChckbxCheckbox2(JCheckBox chckbxCheckbox2) {
	this.chckbxCheckbox2 = chckbxCheckbox2;
    }

    public JCheckBox getChckbxCheckbox3() {
	return chckbxCheckbox3;
    }

    public void setChckbxCheckbox3(JCheckBox chckbxCheckbox3) {
	this.chckbxCheckbox3 = chckbxCheckbox3;
    }

    public JCheckBox getCheckBox4() {
	return checkBox4;
    }

    public void setCheckBox4(JCheckBox checkBox4) {
	this.checkBox4 = checkBox4;
    }

    public JButton getBtnInsertar() {
	return btnInsertar;
    }

    public void setBtnInsertar(JButton btnInsertar) {
	this.btnInsertar = btnInsertar;
    }
}
