package fr.coding.zip.copyXml;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class copyXml {

    Path destination;
     double nonbre =0 ;
     int nonbreInt =0;
     static  FileWriter mon_fichier;
     String value;
    String chemin = "/dimens.xml";
//    Path pa1 = Paths.get(String.valueOf( getClass().getResource("aaa.xml")));

    BufferedReader lecteurDeLigne = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/dimens.xml")));

    public copyXml(double nonbre , Path destination,int value) throws IOException {
        this.nonbre = nonbre;
        this.destination = destination;
        this.value = String.valueOf(value);

        Path filer = Paths.get(destination+"/aaa.xml");
        mon_fichier = new FileWriter(filer.toFile());

    }

    public copyXml(int nonbreInt , Path destination ,int value) throws IOException {
        this.nonbreInt = nonbreInt;
        this.destination = destination;
        this.value = String.valueOf(value);

//        mon_fichier = new FileWriter(String.valueOf( getClass().getResource("aaa.xml")));

        Path filer = Paths.get(destination+"/aaa.xml");
        mon_fichier = new FileWriter(filer.toFile());

    }

    public void demarerPourDooble() throws IOException {

        String lingne;

        while ( (lingne =lecteurDeLigne.readLine()) != null){

            modifLigne(lingne,nonbre);
        }
        lecteurDeLigne.close();
        mon_fichier.close();

        Path dossier = Paths.get(destination+"/values-sw"+value+"dp");
        Files.createDirectories(dossier);
        Path pa1 = Paths.get(destination+"/aaa.xml");
        Files.move(pa1, dossier.resolve("dimens.xml") , StandardCopyOption.REPLACE_EXISTING);
    }

    public void demarerPourDooble(String chemin) throws IOException {

        FileInputStream fichierALire = new FileInputStream(chemin);
        System.out.println(chemin);
        BufferedReader lecteurDeLigne = new BufferedReader(new InputStreamReader(fichierALire));

        String lingne;

        while ( (lingne =lecteurDeLigne.readLine()) != null){

            modifLigne(lingne,nonbre);
        }
        lecteurDeLigne.close();
        mon_fichier.close();

        Path dossier = Paths.get(destination+"/values-sw"+value+"dp");
        Files.createDirectories(dossier);
        Path pa1 = Paths.get(destination+"/aaa.xml");
        Files. move(pa1, dossier.resolve("dimens.xml") , StandardCopyOption.REPLACE_EXISTING);
    }

    private static void modifLigne(String ligne , double nbr) throws IOException {

        if(ligne.contains("p</")) {

            int positionChevron = ligne.indexOf(">");
            int endIndex = ligne.indexOf("p</");

            String debutDelaBalise = ligne.substring(0, positionChevron+1);
            String entreChevron = ligne.substring(positionChevron+1, endIndex-1);
            String finDeLaBalise = ligne.substring(endIndex-1,ligne.length());

            if (entreChevron.contains(".")) {
                double dimensDooble = Double.parseDouble(entreChevron) * nbr;
                entreChevron = String.valueOf(dimensDooble);
            } else {
                double dimens = Integer.parseInt(entreChevron) * nbr;
                entreChevron = String.valueOf(dimens);
            }

//            System.out.println(debutDelaBalise + "" +  entreChevron + "" + finDeLaBalise );

            String all = debutDelaBalise + "" +  entreChevron + "" + finDeLaBalise+"\n";

            String remplacer = ligne.replace(ligne,all);

            mon_fichier.append(remplacer);

        } else if(ligne.contains("x</")) {

            int positionChevron = ligne.indexOf(">");
            int endIndex = ligne.indexOf("x</");

            String debutDelaBalise = ligne.substring(0, positionChevron+1);
            String entreChevron = ligne.substring(positionChevron+1, endIndex-1);
            String finDeLaBalise = ligne.substring(endIndex-1,ligne.length());


            double dimens = Integer.parseInt(entreChevron) * nbr;
            entreChevron = String.valueOf(dimens);

//            System.out.println(debutDelaBalise + "" +  entreChevron + "" + finDeLaBalise );

            String all = debutDelaBalise + "" +  entreChevron + "" + finDeLaBalise+"\n";

            String remplacer = ligne.replace(ligne,all);

            mon_fichier.append(remplacer);

        } else {
//            System.out.println(ligne);
            mon_fichier.write(ligne+"\n");
        }
    }


    public void demarerPourInt() throws IOException {

        String lingne;

        while ( (lingne =lecteurDeLigne.readLine()) != null){

            modifLigne(lingne,nonbreInt);
        }
        lecteurDeLigne.close();
        mon_fichier.close();

        Path dossier = Paths.get(destination+"/values-sw"+value+"dp");
        Files.createDirectories(dossier);
        Path pa1 = Paths.get(destination+"/aaa.xml");
        Files.move(pa1, dossier.resolve("dimens.xml") , StandardCopyOption.REPLACE_EXISTING);
    }

    public void demarerPourInt(String chemin) throws IOException {

        FileInputStream fichierALire = new FileInputStream(chemin);
        System.out.println(chemin);
        BufferedReader lecteurDeLigne = new BufferedReader(new InputStreamReader(fichierALire));

        String lingne;

        while ( (lingne =lecteurDeLigne.readLine()) != null){

            modifLigne(lingne,nonbreInt);
        }
        lecteurDeLigne.close();
        mon_fichier.close();

        Path dossier = Paths.get(destination+"/values-sw"+value+"dp");
        Files.createDirectories(dossier);
        Path pa1 = Paths.get(destination+"/aaa.xml");
        Files.move(pa1, dossier.resolve("dimens.xml") , StandardCopyOption.REPLACE_EXISTING);
    }

    private static void modifLigne(String ligne , int nbr) throws IOException {

        if(ligne.contains("p</")) {

            int positionChevron = ligne.indexOf(">");
            int endIndex = ligne.indexOf("p</");

            String debutDelaBalise = ligne.substring(0, positionChevron+1);
            String entreChevron = ligne.substring(positionChevron+1, endIndex-1);
            String finDeLaBalise = ligne.substring(endIndex-1,ligne.length());

            if (entreChevron.contains(".")) {
                double dimensDooble = Double.parseDouble(entreChevron) * nbr;
                entreChevron = String.valueOf(dimensDooble);
            } else {
                int dimens = Integer.parseInt(entreChevron) * nbr;
                entreChevron = String.valueOf(dimens);
            }

            String all = debutDelaBalise + "" +  entreChevron + "" + finDeLaBalise+"\n";

            String remplacer = ligne.replace(ligne,all);

            mon_fichier.append(remplacer);

        } else if(ligne.contains("x</")) {

            int positionChevron = ligne.indexOf(">");
            int endIndex = ligne.indexOf("x</");

            String debutDelaBalise = ligne.substring(0, positionChevron+1);
            String entreChevron = ligne.substring(positionChevron+1, endIndex-1);
            String finDeLaBalise = ligne.substring(endIndex-1,ligne.length());


            double dimens = Integer.parseInt(entreChevron) * nbr;
            entreChevron = String.valueOf(dimens);

//            System.out.println(debutDelaBalise + "" +  entreChevron + "" + finDeLaBalise );

            String all = debutDelaBalise + "" +  entreChevron + "" + finDeLaBalise+"\n";

            String remplacer = ligne.replace(ligne,all);

            mon_fichier.append(remplacer);

        } else {
            mon_fichier.write(ligne+"\n");
        }
    }

}
