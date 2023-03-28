import java.awt.event.*;
public class CalcController {
    private final CalcModel  m_model;
    private final CalcView  m_view;
    CalcController(CalcModel model, CalcView view) {
        m_model = model;
        m_view  = view;
        view.addMultiplyListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
        view.addAddListener(new AddListener());
        view.addSubstractListener(new SubstractListener());
        view.addImpartireListener(new ImpartireListener());
        view.addRestListener(new RestListener());
        view.addDerivareListener(new DerivareListener());
        view.addIntegrareListener(new IntegrareListener());

    }
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                String userInput = m_view.getUserInput();
                String userInput1 = m_view.getUserInput1();
                m_model.multiplyBy(userInput,userInput1);
                m_view.setTotal(m_model.getValue());
        }
    }
    class DerivareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = m_view.getUserInput();
            m_model.derivare(userInput);
            m_view.setTotal(m_model.getValue());
        }
    }
    class RestListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = m_view.getUserInput();
            String userInput1= m_view.getUserInput1();
            m_model.impartire1(userInput,userInput1);
            m_view.setTotal(m_model.getValue());
        }
    }
    class IntegrareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = m_view.getUserInput();
            m_model.integrare(userInput);
            m_view.setTotal(m_model.getValue());
        }
    }
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
               String userInput = m_view.getUserInput();
               String userInput1= m_view.getUserInput1();
                m_model.addTo(userInput,userInput1);
                m_view.setTotal(m_model.getValue());
        }
    }
    class SubstractListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = m_view.getUserInput();
            String userInput1= m_view.getUserInput1();
            m_model.substract(userInput,userInput1);
            m_view.setTotal(m_model.getValue());
        }
    }
    class ImpartireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = m_view.getUserInput();
            String userInput1= m_view.getUserInput1();
            m_model.impartire(userInput,userInput1);
            m_view.setTotal(m_model.getValue());
        }
    }
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.reset();
        }
    }
}
