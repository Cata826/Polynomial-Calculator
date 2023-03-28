import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class CalcView extends JFrame {
    private final JTextField m_userInputTf = new JTextField(20);
    private final JTextField m_userInputTf1 = new JTextField(20);
    private final JTextField m_totalTf = new JTextField(20);
    private final JTextField m_totalTf1 = new JTextField(20);
    private final JButton m_addBtn = new JButton(" Adunare ");
    private final JButton m_multiplyBtn = new JButton(" Înmulțire");
    private final JButton m_scadere = new JButton(" Scădere ");

    private final JButton m_impartire = new JButton(" Împărțire");
    private final JButton m_impartire1 = new JButton("Restul");

    private final JButton m_derivare = new JButton(" Derivare ");
    private final JButton m_integrare = new JButton(" Integrare");
    private final JButton m_clearBtn = new JButton(" Șterge");
    private final CalcModel m_model;
    CalcView(CalcModel model) {
        m_model = model;
        m_model.setValue(CalcModel.INITIAL_VALUE);
        m_totalTf.setText(m_model.getValue());
        m_totalTf.setEditable(false);
        m_totalTf1.setText(m_model.getValue());
        m_totalTf1.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(new JLabel("Polinom1"));
        inputPanel.add(m_userInputTf);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(new JLabel("Polinom2"));
        inputPanel.add(m_userInputTf1);

        JPanel operatii = new JPanel();
        operatii.setLayout(new BoxLayout(operatii, BoxLayout.Y_AXIS));
        operatii.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        operatii.add(m_addBtn);
        operatii.add(m_multiplyBtn);
        operatii.add(m_scadere);
        operatii.add(m_impartire);
        operatii.add(m_impartire1);
        operatii.add(m_derivare);
        operatii.add(m_integrare);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        buttonPanel.add(m_clearBtn);

        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add(inputPanel);
        content.add(Box.createRigidArea(new Dimension(0, 10)));
        content.add(operatii);
        content.add(Box.createRigidArea(new Dimension(0, 10)));
        content.add(new JLabel("Total"));
        content.add(m_totalTf);
        content.add(Box.createRigidArea(new Dimension(0, 10)));
        content.add(buttonPanel);


        this.setContentPane(content);
        this.pack();
        this.setTitle("Calculator de polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    void reset() {
        m_totalTf.setText(CalcModel.INITIAL_VALUE);
    }
    String getUserInput() {
        return m_userInputTf.getText();
    }
    String getUserInput1() {
        return m_userInputTf1.getText();
    }
    void setTotal(String newTotal) {
        m_totalTf.setText(newTotal);
    }
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    void addMultiplyListener(ActionListener mal) {
        m_multiplyBtn.addActionListener(mal);
    }
    void addAddListener(ActionListener aal) {
        m_addBtn.addActionListener(aal);
    }
    void addSubstractListener(ActionListener aal) {m_scadere.addActionListener(aal);}
    void addImpartireListener(ActionListener aal) {m_impartire.addActionListener(aal);}
    void addRestListener(ActionListener aal) {m_impartire1.addActionListener(aal);}
    void addDerivareListener(ActionListener aal) {m_derivare.addActionListener(aal);}
    void addIntegrareListener(ActionListener aal) {m_integrare.addActionListener(aal);}
    void addClearListener(ActionListener cal) {
        m_clearBtn.addActionListener(cal);
    }
}
