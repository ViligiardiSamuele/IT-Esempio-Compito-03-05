package app;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private  JButton JB_add, JB_del;
    private JTextArea JTA_log;
    private Proprietari proprietari;
    public MainFrame() throws HeadlessException {
        super("Esempio compito");
        setLayout(new BorderLayout());
        JB_add = new JButton("Aggiungi proprietario");
        JB_add.addActionListener(e -> new AddForm(proprietari));
        JB_del = new JButton("Rimuovi proprietario");
        JB_del.addActionListener(e -> new DelForm(proprietari));
        JTA_log = new JTextArea();
        JTA_log.setEditable(false);
        proprietari = new Proprietari(JTA_log);
        JPanel JP_buttons = new JPanel(new GridLayout(1,2));
        JP_buttons.add(JB_add);
        JP_buttons.add(JB_del);
        add(JP_buttons, BorderLayout.SOUTH);
        add(new JScrollPane(JTA_log),BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(new Dimension(350,200));
        setResizable(false);
        setVisible(true);
    }

    public JTextArea getJTA_log() {
        return JTA_log;
    }
}
