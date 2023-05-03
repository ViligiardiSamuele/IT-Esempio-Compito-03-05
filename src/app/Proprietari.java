package app;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Proprietari {
     static class Proprietario {
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
                     "\n CF=" + CF +
                     "\n Targa Dell'auto: " + targaAuto;
         }
     }
    private List<Proprietario> proprietari;

    public Proprietari() {
        this.proprietari = new ArrayList<Proprietario>();
    }
    public void addProprietario(Proprietario proprietario){
        //Controllo targa ripetuta
        for (Proprietario p : proprietari){
            if(p.getTargaAuto().equalsIgnoreCase(proprietario.getTargaAuto())){
                JOptionPane.showMessageDialog(null,"La targa è già stata registrata", "Errore: Targa ripetuta",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        proprietari.add(proprietario);
    }

}
