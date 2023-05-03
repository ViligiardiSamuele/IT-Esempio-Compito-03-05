package app;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AddForm extends JFrame {
    private JButton JB_add, JB_clear;
    private JLabel JL_nominativo, JL_CF, JL_targa;
    private JTextField JTF_nominativo, JTF_CF, JTF_targa;
    public AddForm(Proprietari proprietari) throws HeadlessException {
        super("Aggiungi Proprietario");
            //INIT
        setLayout(new BorderLayout());

            //--- FORM SECTION ---
        //declaration of JLabels
        JL_nominativo = new JLabel("Nominativo");
        JL_CF = new JLabel("Codice Fiscale");
        JL_targa = new JLabel("Targa");
        //1.declaration of JTextFields
        //2.adding objects in one JPanel
        JTF_nominativo = new JTextField();
        JTF_CF = new JTextField();
        JTF_targa = new JTextField();
        JPanel JP_form = new JPanel(new GridLayout(3,2));
        JP_form.add(JL_nominativo);
        JP_form.add(JTF_nominativo);
        JP_form.add(JL_CF);
        JP_form.add(JTF_CF);
        JP_form.add(JL_targa);
        JP_form.add(JTF_targa);
            //--- END FORM SECTION ---

            //--- BUTTONS SECTION ---
        JB_add = new JButton("Aggiungi");
        JB_clear = new JButton("Pulisci");
        JPanel JP_buttons = new JPanel(new GridLayout(2,1));
        JP_buttons.add(JB_add);
        JP_buttons.add(JB_clear);
            //--- END BUTTON SECTION ---

            //--- ACTION LISTENERS
        JB_add.addActionListener(e -> {
            if(!(
                    JTF_nominativo.getText().trim().isEmpty() ||
                    JTF_CF.getText().trim().isEmpty() ||
                    JTF_targa.getText().trim().isEmpty()
            )){
                Proprietari.Proprietario p = new Proprietari.Proprietario(
                        JTF_nominativo.getText().trim().toLowerCase(),
                        JTF_CF.getText().trim().toLowerCase(),
                        JTF_targa.getText().trim().toLowerCase()
                );
                proprietari.addProprietario(p);
                AtomicInteger nAuto = new AtomicInteger();
                proprietari.getProprietari().forEach(x -> {
                    if(x.getCF().equalsIgnoreCase(p.getCF()))
                        nAuto.getAndIncrement();
                });
                if(nAuto.get() > 1)
                    JOptionPane.showMessageDialog(
                            null,
                            "" + p.getNominativo() + " ha " + nAuto.get() + " veicoli registrati",
                            "Numero auto di " + p.getNominativo(),
                            JOptionPane.INFORMATION_MESSAGE
                    );
            }
        });
        JB_clear.addActionListener(e -> {
            JTF_nominativo.setText("");
            JTF_CF.setText("");
            JTF_targa.setText("");
        });
            //--- END ACTION LISTENERS

            //--- FRAME SETTINGS
        //Disposition of JPanels
        add(JP_form,BorderLayout.CENTER);
        add(JP_buttons,BorderLayout.SOUTH);

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(350,200));
        setResizable(false);
        setVisible(true);
    }
}