package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;

public class DelForm extends JFrame {
    private JButton JB_del;
    private JLabel JL_CF;
    private JTextField JTF_CF;

    public DelForm(Proprietari proprietari) throws HeadlessException {
        super("Elimina proprietario");
            //INIT
        setLayout(new BorderLayout());
        JB_del = new JButton("Elimina");

            //--- FORM ---
        JL_CF = new JLabel("Codice Fiscale");
        JL_CF.setHorizontalAlignment(SwingConstants.CENTER);
        JTF_CF = new JTextField();
        JPanel JP_form = new JPanel(new GridLayout(2,1));
        JP_form.add(JL_CF);
        JP_form.add(JTF_CF);
            //--- END FORM ---

            //--- ACTION LISTENERS
        JB_del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtomicBoolean exist = new AtomicBoolean(false);
                //controllo dell'esistenza del proprietario con effettiva rimozione
                for (int i = 0; i < proprietari.getProprietari().size(); i++){
                    if (proprietari.getProprietari().get(i).getCF().equalsIgnoreCase(JTF_CF.getText().trim().toLowerCase())) {
                        proprietari.getProprietari().remove(proprietari.getProprietari().get(i));
                        exist.set(true);
                        proprietari.stampaLog();
                    }
                }
                if(exist.get()) //proprietario rimosso
                    JOptionPane.showMessageDialog(
                            null,
                            "Proprietario rimosso correttamente",
                            "Proprietario rimosso",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                else //proprietario inesistente
                    JOptionPane.showMessageDialog(
                        null,
                        "Proprietario inesistente, verifica la corretta dicitura del CF.",
                        "Proprietario inesistente",
                        JOptionPane.ERROR_MESSAGE
                    );
            }
        });
            //--- END ACTION LISTENERS

        //JFRAME SETTING
        add(JP_form, BorderLayout.CENTER);
        add(JB_del,BorderLayout.SOUTH);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(350,120));
        setResizable(false);
        setVisible(true);
    }
}
