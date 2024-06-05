import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
public class Fenetre extends JFrame{
    JLabel nomGroupLabel=new JLabel("nom groupe");
    JTextField nomGTextField=new JTextField(25);
    JTextField idTextField=new JTextField(25);
    JTextField nomTextField=new JTextField(25);
    JTextField prenomTextField=new JTextField(25);
    JTextField moyTextField=new JTextField(5);
    JTextField groupTextField=new JTextField(25);

    JLabel groupLabel=new JLabel("Groupe");
    JLabel idLabel=new JLabel("id");
    JLabel nomLabel=new JLabel("nom");
    JLabel prenomLabel=new JLabel("prenom");
    JLabel moyenneLabel=new JLabel("moyenne");
    JLabel premierJLabel=new JLabel("Premier groupe");
    JLabel MajLabel=new JLabel("Majeur");
    JButton creeButton=new JButton("Creer");
    JTextField premTextField=new JTextField(15);
    JTextField maJTextField=new JTextField(15);
    JButton ajoutButton=new JButton("Ajouter Eleve");
    JButton quitterButton=new JButton("Quitter");
    JComboBox<String> featureComboBox;


    public Fenetre(){
        this.setTitle("Gestion des moyennes");
        this.setSize(700,440);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pan=new JPanel(new GridLayout(7,2));
        featureComboBox = new JComboBox<>(new String[]{});

        pan.add(nomGroupLabel);
        pan.add(nomGTextField);
        pan.add(groupLabel);
        pan.add(featureComboBox);
        pan.add(idLabel); 
        pan.add(idTextField);
        pan.add(nomLabel);
        pan.add(nomTextField);
        pan.add(prenomLabel);
        pan.add(prenomTextField);
        pan.add(moyenneLabel);
        pan.add(moyTextField);
        JPanel pans=new JPanel(new GridLayout(4,1));
        pans.add(creeButton);
        pans.add(ajoutButton);
        pans.add(quitterButton);
        
        JPanel pane=new JPanel();
        pane.add(premierJLabel);
        pane.add(premTextField);

        pane.add(MajLabel);
        pane.add(maJTextField);
        this.add(pan,BorderLayout.WEST);
        this.add(pans,BorderLayout.EAST);
        this.add(pane,BorderLayout.SOUTH);
        this.setVisible(true);
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();

            }
        });

        creeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name= nomGTextField.getText();
                featureComboBox.addItem(name);     


            }
        });
        ajoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                String grop= (String) featureComboBox.getSelectedItem();
                int id=Integer.parseInt(idTextField.getText());
                String nom=nomTextField.getText();
                String prenom=premTextField.getText();
                float moy=Float.parseFloat(moyTextField.getText());
                Ecole eco=new Ecole();
                eco.Ajouter(grop);
                eco.AjouterEleve(grop, new Eleve(id,nom,prenom,moy));
                premTextField.setText(eco.Premier());
                maJTextField.setText(eco.Majeur());
                }catch(Exception er){
                    JOptionPane.showMessageDialog(pan,"inputs","erroe", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        
    }
    
}
