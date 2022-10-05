package fr.coding.zip;

import fr.coding.zip.copyXml.copyXml;
import fr.coding.zip.model.chkboxAndValues;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class home extends JFrame {
    JFileChooser jfch_browse =new JFileChooser( FileSystemView.getFileSystemView().getHomeDirectory());
    ArrayList<chkboxAndValues> array_collect_default_value = new ArrayList<>();
    ArrayList<chkboxAndValues> array_collect_new_value_add = new ArrayList<>();
    JPanel panel_new_values_add = new JPanel();

    JCheckBox chkb_default_values_sw320dp = new JCheckBox("values-sw320dp (1*1.1)" ,true);
    JCheckBox chkb_default_values_sw480dp = new JCheckBox("values-sw480dp (1*1.6)",true);
    JCheckBox chkb_default_values_sw600dp = new JCheckBox("values-sw600dp (1*2)",true);
    JCheckBox chkb_default_values_sw720dp = new JCheckBox("values-sw720dp (1*2.4)",true);

    JCheckBox chkb_use_default_values;
    JTextField edit_source_file = new JTextField();
    JTextField edit_destination_file = new JTextField();
    JButton btn_find_file_source = new JButton("Browse");
    JLabel labl_file_name =new JLabel();


     home(){
        super.setTitle("Dimensions Scalable Android (values-sw...dp)");
        super.setContentPane(mainWindow());
        super.setSize(800, 450);
        super.setResizable(false);
        super.setLocationRelativeTo(null);

        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //popup fermer la fenetre
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int vard = JOptionPane.showConfirmDialog(home.this,"Do you want to close the window ?","close window",JOptionPane.YES_NO_OPTION);

                if (vard == JOptionPane.YES_OPTION) {
                    dispose();
                }else{
                    //do nothing
                }
            }
        });

        labl_file_name.setForeground(Color.red);
    }

    private  JPanel mainWindow(){

        JPanel  jpnl_mainWindow = new JPanel(new BorderLayout());
        jpnl_mainWindow.add(highSide(), BorderLayout.NORTH);
        jpnl_mainWindow.add(leftSide(), BorderLayout.WEST);
        jpnl_mainWindow.add(centerSide(), BorderLayout.CENTER);
        jpnl_mainWindow.add(lowSide(), BorderLayout.SOUTH);

        return jpnl_mainWindow;
    }

    private JPanel highSide() {

        JPanel  container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        JPanel  panel_source_file = new JPanel();
        panel_source_file.setBackground(Color.lightGray);
        JLabel lbl_souce =new JLabel("Source xml file  :");
        panel_source_file.add(lbl_souce);
        edit_source_file.setPreferredSize(new Dimension(500,30));
        panel_source_file.add(edit_source_file);
        btn_find_file_source.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jfch_browse.setDialogTitle("Selected xml file : ");
                //selected only file xml
                jfch_browse.setFileSelectionMode(JFileChooser.FILES_ONLY);

                jfch_browse.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter_extension = new FileNameExtensionFilter("file selected ", "xml");
                jfch_browse.addChoosableFileFilter(filter_extension);

                 int res = jfch_browse.showOpenDialog(null);

                 if (res == JFileChooser.APPROVE_OPTION) {
                     if(jfch_browse.getSelectedFile().isDirectory()){
//                         System.out.println("You have selected the following file : "+ jfch_browse.getSelectedFile());
                     }
                     File file = jfch_browse.getSelectedFile();
                     edit_source_file.setText(file.getAbsolutePath());
                 }

            }
        });
        panel_source_file.add(btn_find_file_source);

        JPanel  panel_destination_file = new JPanel();
        panel_destination_file.setBackground(Color.lightGray);
        JLabel label2 =new JLabel("Destination :");
        panel_destination_file.add(label2);
        edit_destination_file.setPreferredSize(new Dimension(500,30));
        panel_destination_file.add(edit_destination_file);
        JButton btn_set_destination = new JButton("Browse");
        btn_set_destination.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jfch_browse.setDialogTitle("Selected the destination folder : ");
                //selected only folder
                jfch_browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int res = jfch_browse.showOpenDialog(null);

                if (res == JFileChooser.APPROVE_OPTION) {
                    if(jfch_browse.getSelectedFile().isDirectory()){
//                        System.out.println("You have selected the following destination folder : "+ jfch_browse.getSelectedFile());
                    }
                    File file = jfch_browse.getSelectedFile();
                    edit_destination_file.setText(file.getAbsolutePath());
                }
            }
        });
        panel_destination_file.add(btn_set_destination);

        container.add(panel_source_file);
        container.add(panel_destination_file);

        return container;
    }

    private JScrollPane leftSide(){

        JPanel container_gauche = new JPanel();

        container_gauche.setLayout(new BoxLayout(container_gauche, BoxLayout.Y_AXIS));

        JPanel panel_default_value  = new JPanel();
        panel_default_value.setBackground(Color.lightGray);
        panel_default_value.setLayout(new BoxLayout(panel_default_value, BoxLayout.Y_AXIS));

        panel_new_values_add.setLayout(new BoxLayout(panel_new_values_add, BoxLayout.Y_AXIS));

        JButton btn_generate_chkb_selected = new JButton("generate all files select");
        btn_generate_chkb_selected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (chkb_use_default_values.isSelected()) {

                    if (edit_destination_file.getText().equals("")) {
                        labl_file_name.setForeground(Color.red);
                        labl_file_name.setText("Please select the destination folder !");
                    } else {

                        Path pa1j = Paths.get(edit_destination_file.getText());
                        generatedValuesSelected(pa1j,array_collect_default_value);

                        if (!array_collect_new_value_add.isEmpty()) {
                            generatedValuesSelected(pa1j,array_collect_new_value_add);
                        }
                    }
                }
                else if (!chkb_use_default_values.isSelected() && edit_destination_file.getText().equals("") || !chkb_use_default_values.isSelected() && edit_source_file.getText().equals("")) {
                    labl_file_name.setForeground(Color.red);
                    labl_file_name.setText("Please verify the destination folder or xml file source is specified !");
                }
                else {
                    Path pa_source = Paths.get(edit_source_file.getText());
                    Path pa1j = Paths.get(edit_destination_file.getText());

                    generatedValuesSelectedFromSourceFile(pa_source, pa1j ,array_collect_default_value);

                    if (!array_collect_new_value_add.isEmpty()) {
                        generatedValuesSelectedFromSourceFile(pa_source, pa1j ,array_collect_new_value_add);
                    }
                }

            }
        });
        container_gauche.add(btn_generate_chkb_selected);

        JButton btn_reset_new_values_add = new JButton("reset all new value add");
        btn_reset_new_values_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                array_collect_new_value_add.clear();
                panel_new_values_add.removeAll();

                labl_file_name.setForeground(Color.blue);
                labl_file_name.setText("All new values delete ");

                repaintAllJpanel();
            }
        });
        container_gauche.add(btn_reset_new_values_add);

        chkb_use_default_values = new JCheckBox("use default values" ,true);
        chkb_use_default_values.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {

                    JCheckBoxSelectedAndEnabled(chkb_default_values_sw320dp);
                    JCheckBoxSelectedAndEnabled(chkb_default_values_sw480dp);
                    JCheckBoxSelectedAndEnabled(chkb_default_values_sw600dp);
                    JCheckBoxSelectedAndEnabled(chkb_default_values_sw720dp);

                    editSourceFil_and_btnFindFileSource_DeSelectedAndDontEnabled(edit_source_file,btn_find_file_source);

                    repaintAllJpanel();
                }

                if (e.getStateChange() == ItemEvent.DESELECTED) {

                    JCheckBoxDeSelectedAndDontEnabled(chkb_default_values_sw320dp);
                    JCheckBoxDeSelectedAndDontEnabled(chkb_default_values_sw480dp);
                    JCheckBoxDeSelectedAndDontEnabled(chkb_default_values_sw600dp);
                    JCheckBoxDeSelectedAndDontEnabled(chkb_default_values_sw720dp);

                    edit_source_file.setEnabled(true);
                    btn_find_file_source.setEnabled(true);

                    repaintAllJpanel();
                }

            }
        });
        container_gauche.add(chkb_use_default_values);

        if (chkb_use_default_values.isSelected()) {

            editSourceFil_and_btnFindFileSource_DeSelectedAndDontEnabled(edit_source_file,btn_find_file_source);

            array_collect_default_value.add(new chkboxAndValues(chkb_default_values_sw320dp, 1.1 ,320));
            array_collect_default_value.add(new chkboxAndValues(chkb_default_values_sw480dp, 1.6,480));
            array_collect_default_value.add(new chkboxAndValues(chkb_default_values_sw600dp, 2,600));
            array_collect_default_value.add(new chkboxAndValues(chkb_default_values_sw720dp, 2.4,720));

            for (chkboxAndValues chkb : array_collect_default_value) {
                panel_default_value.add(chkb.getChkb());
            }

            container_gauche.add(panel_default_value);
            container_gauche.add(panel_new_values_add);

            repaintAllJpanel();
        }

        JScrollPane container_gauche_jScrollPane  = new JScrollPane(container_gauche);
        container_gauche_jScrollPane.setPreferredSize(new Dimension(200,0));
        return container_gauche_jScrollPane;
    }

    private JPanel centerSide(){

        JPanel container_droite = new JPanel();
        container_droite.setLayout(new GridLayout(5,1));

        JLabel labl_info_container_droite =new JLabel("Add new values :");
        container_droite.add(labl_info_container_droite);

        JPanel containt_panel_section1 = new JPanel();
        JLabel indice =new JLabel("Add value for the file name :" );
        containt_panel_section1.add(indice);
        JLabel lab_sw =new JLabel("values-sw");
        containt_panel_section1.add(lab_sw);
        JTextField edit_valueOf_file = new JTextField();
        edit_valueOf_file.setPreferredSize(new Dimension(50,25));
        containt_panel_section1.add(edit_valueOf_file);
        JLabel labl_dp =new JLabel("dp");
        containt_panel_section1.add(labl_dp);
        container_droite.add(containt_panel_section1);

        JPanel containt_panel_section2 = new JPanel();
        JLabel indice2 =new JLabel("Add factor for the value in the file :" );
        containt_panel_section2.add(indice2);
        JLabel lab_factor =new JLabel("factor = 1*");
        containt_panel_section2.add(lab_factor);
        JTextField edit_factorOf_file = new JTextField();
        edit_factorOf_file.setPreferredSize(new Dimension(50,25));
        containt_panel_section2.add(edit_factorOf_file);
        container_droite.add(containt_panel_section2);

        JButton btn_add_new_value = new JButton("add +");
        btn_add_new_value.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String title = lab_sw.getText() + edit_valueOf_file.getText() + labl_dp.getText();
                JCheckBox ch = new JCheckBox(title+" (1*"+edit_factorOf_file.getText()+")",true);

                labl_file_name.setForeground(Color.red);
                if (chkb_default_values_sw320dp.isSelected() && edit_valueOf_file.getText().equals("320") ) {
                    labl_file_name.setText("value is already defined by default ");
                }else if (chkb_default_values_sw480dp.isSelected() && edit_valueOf_file.getText().equals("480")) {
                labl_file_name.setText("value is already defined by default ");
                }else if (chkb_default_values_sw600dp.isSelected() && edit_valueOf_file.getText().equals("600") ) {
                    labl_file_name.setText("value is already defined by default ");
                }else if (chkb_default_values_sw720dp.isSelected() && edit_valueOf_file.getText().equals("720") ) {
                    labl_file_name.setText("value is already defined by default ");
                }
                else if (edit_valueOf_file.getText().equals("") || edit_factorOf_file.getText().equals("")) {
                    labl_file_name.setText("please verify (value) or (factor) is not omitted !");
                }else if (edit_valueOf_file.getText().contains(".")) {
                    labl_file_name.setText("please the name of value can't be a decimal or word!");
                } else{

                    if ( edit_factorOf_file.getText().contains(".")) {

                        try{
                            array_collect_new_value_add.add(new chkboxAndValues(ch, Double.parseDouble(edit_factorOf_file.getText()) , Integer.parseInt(edit_valueOf_file.getText())));
                            addNewValue(array_collect_new_value_add,edit_valueOf_file,edit_factorOf_file,title);
                        }catch (NumberFormatException NumberFormatException){
                            labl_file_name.setText("bad format insert: only (integer are accepted for values name) and (integer or decimals for factor...) ");
                        }

                    }else{

                        try{
                            array_collect_new_value_add.add(new chkboxAndValues(ch, Integer.parseInt(edit_factorOf_file.getText()) , Integer.parseInt(edit_valueOf_file.getText())));
                            addNewValue(array_collect_new_value_add,edit_valueOf_file,edit_factorOf_file,title);
                        }catch (NumberFormatException NumberFormatException){
                            labl_file_name.setText("bad format insert: only (integer are accepted for values name) and (integer or decimals for factor...) ");
                        }

                    }

                }

                repaintAllJpanel();
            }
        });

        container_droite.add(btn_add_new_value);
        container_droite.add(labl_file_name);
        return container_droite;
    }

    void addNewValue(ArrayList<chkboxAndValues> array , JTextField txtField_valueOf_file , JTextField txtField_factorOf_file, String title){

        for (chkboxAndValues info_chkb_add : array) {
            panel_new_values_add.add(info_chkb_add.getChkb());
        }

        txtField_valueOf_file.setText("");
        txtField_factorOf_file.setText("");
        labl_file_name.setForeground(Color.blue);
        labl_file_name.setText("Success add : "+title);

        repaintAllJpanel();
    }

    private JPanel lowSide(){

        JPanel container_bottom  = new JPanel();
        container_bottom.setBackground(Color.lightGray);

        JPanel container_bottom_left  = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labl_version =new JLabel("Version: 1.0 ");
        container_bottom_left.add(labl_version);

        JPanel container_bottom_rigth  = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel labl_creator =new JLabel("By Coding Zip { Drex } ");
        container_bottom_rigth.add(labl_creator);

        container_bottom.add(container_bottom_left);
        container_bottom.add(container_bottom_rigth);

        return container_bottom;
    }

    public void repaintAllJpanel(){
        home.super.revalidate();
        home.super.validate();
        home.super.repaint();
    }

    public void JCheckBoxSelectedAndEnabled(JCheckBox chkb){
        chkb.setSelected(true);
        chkb.setEnabled(true);
    }

    public void JCheckBoxDeSelectedAndDontEnabled(JCheckBox chkb){
        chkb.setSelected(false);
        chkb.setEnabled(false);
    }

    public void  editSourceFil_and_btnFindFileSource_DeSelectedAndDontEnabled(JTextField txtField,JButton btn){
        txtField.setText("");
        txtField.setEnabled(false);
        btn.setEnabled(false);
    }

    void generatedValuesSelected(Path pa1j , ArrayList<chkboxAndValues> array_collect_value_selected){
        try {
            for (chkboxAndValues chkbf : array_collect_value_selected) {

                //if the factor integer = 0 then it is a double
                if (chkbf.getChkb().isSelected() && chkbf.getFactorInt() == 0 ) {
                    //recover the factor double(double) => chkbf.getFactorDouble()
                    new copyXml( chkbf.getFactorDouble(), pa1j ,chkbf.getValue()).demarerPourDooble();

                }
                //if the factor double = 0 then it is integer
                else if (chkbf.getChkb().isSelected() && chkbf.getFactorDouble() == 0.0) {
                    //recover the factor integer(integer)  => chkbf.getFactorInt()
                    new copyXml( chkbf.getFactorInt() , pa1j ,chkbf.getValue()).demarerPourInt();
                }

            }

            labl_file_name.setForeground(Color.blue);
            labl_file_name.setText("Success all selected files have been added to the destination ");

        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    void generatedValuesSelectedFromSourceFile(Path pa_source, Path pa1j , ArrayList<chkboxAndValues> array_collect_value_selected){
        try {
            for (chkboxAndValues chkbf : array_collect_value_selected) {

                //if the factor integer = 0 then it is a double
                if (chkbf.getChkb().isSelected() && chkbf.getFactorInt() == 0 ) {
                    //recover the factor double(double) => chkbf.getFactorDouble()
                    new copyXml( chkbf.getFactorDouble(), pa1j ,chkbf.getValue()).demarerPourDooble(String.valueOf(pa_source));
                }
                //if the factor double = 0 then it is integer
                else if (chkbf.getChkb().isSelected() && chkbf.getFactorDouble() == 0.0) {
                    //recover the factor integer(integer)  => chkbf.getFactorInt()
                    new copyXml( chkbf.getFactorInt() , pa1j ,chkbf.getValue()).demarerPourInt(String.valueOf(pa_source));
                }

            }

            labl_file_name.setForeground(Color.blue);
            labl_file_name.setText("Success: all selected files have been added to the destination ");

        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
