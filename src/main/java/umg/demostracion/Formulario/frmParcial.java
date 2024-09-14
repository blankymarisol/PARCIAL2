package umg.demostracion.Formulario;

import umg.demostracion.DataBase.Model.ModeloTelefonico;
import umg.demostracion.DataBase.Service.ModeloTelefonicoService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmParcial extends JFrame {
    private JPanel FormularioParcial;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        frame.setContentPane(new frmParcial().FormularioParcial);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JLabel lblID;
    private JLabel lblMarca;
    private JLabel lbl;
    private JLabel lblSisOp;
    private JTextField textFieldID;
    private JTextField textFieldMarca;
    private JTextField textFieldModelo;
    private JTextField textFieldSisOp;
    private JButton buttonAgregar;
    private JButton buttonBuscarID;
    private JButton buttonActualizar;
    private JButton buttonEliminar;

    public frmParcial() {
        setContentPane(FormularioParcial);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        buttonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModeloTelefonico mt = new ModeloTelefonico();
                mt.setId(Integer.parseInt(textFieldID.getText()));
                mt.setMarca(textFieldMarca.getText());
                mt.setModelo(textFieldModelo.getText());
                mt.setSistemaOperativo(textFieldSisOp.getText());
                try{
                    new ModeloTelefonicoService().agregarModeloTelefonico(mt);
                    JOptionPane.showMessageDialog(null, "Modelo agregado exitosamente");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error al agregar Modelo" + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        buttonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(textFieldID.getUIClassID());
                    String marca = textFieldMarca.getText();
                    String modelo = textFieldModelo.getText();
                    String sisop = textFieldSisOp.getText();

                    ModeloTelefonico mt = new ModeloTelefonico(id, marca, modelo, sisop);
                    ModeloTelefonicoService mts = new ModeloTelefonicoService();

                    boolean actualizado = mts.actualizarModeloTelefonico(mt);

                    if (actualizado){
                        JOptionPane.showMessageDialog(null, "Modelo actualizado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar ModeloTelefonico");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar ModeloTelefonico");
                }
            }
        });
        buttonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
