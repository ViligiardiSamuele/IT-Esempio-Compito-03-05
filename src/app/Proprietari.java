package app;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Proprietari {
    static class Proprietario {
        //POJO CLASS
        private String nominativo, CF, targaAuto;
        public Proprietario(String nominativo, String CF, String targaAuto) {
            this.nominativo = nominativo;
            this.CF = CF;
            this.targaAuto = targaAuto;
        }

        public String getNominativo() {
            return nominativo;
        }

        public void setNominativo(String nominativo) {
            this.nominativo = nominativo;
        }

        public String getCF() {
            return CF;
        }

        public void setCF(String CF) {
            this.CF = CF;
        }

        public String getTargaAuto() {
            return targaAuto;
        }

        public void setTargaAuto(String targaAuto) {
            this.targaAuto = targaAuto;
        }
        @Override
        public String toString() {
            return  "Nominativo: " + nominativo +
                    " - CF: " + CF +
                    " - Targa Dell'auto: " + targaAuto;
        }
    }
    private List<Proprietario> proprietari;
    private JTextArea JTA_log;

    public Proprietari(JTextArea JTF_log) {
        this.proprietari = new ArrayList<Proprietario>();
        this.JTA_log = JTF_log;
    }
    public void addProprietario(Proprietario proprietario){
        //Aggiunta con controllo targa ripetuta e
        //notifica dell'errore
        for (Proprietario p : proprietari){
            if(p.getTargaAuto().equalsIgnoreCase(proprietario.getTargaAuto())){
                JOptionPane.showMessageDialog(
                        null,
                        "La targa è già stata registrata",
                        "Errore: Targa ripetuta",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }
        proprietari.add(proprietario);
        stampaLog();
    }
    public void stampaLog(){
        //Sovrascrive JTA_log
        StringBuilder SB_log = new StringBuilder();
        for(Proprietario p : proprietari){
            SB_log.append("--- N.").append(proprietari.indexOf(p) + 1).append(" ---\n");
            SB_log.append(" >Nominativo: ").append(p.getNominativo()).append("\n");
            SB_log.append(" >Codice Fiscale: ").append(p.getCF()).append("\n");
            SB_log.append(" >Targa dell'auto: ").append(p.getTargaAuto()).append("\n");
        }
        SB_log.append("  >Totale Proprietari: ").append(getProprietari().size());
        JTA_log.setText(SB_log.toString());
    }

    public List<Proprietario> getProprietari() {
        return proprietari;
    }
}
