package Controlador;

import Modelo.*;
import java.awt.event.*;
import Vista.*;
import Vista.AdminVistas.*;
import java.util.ArrayList;
import javax.swing.*;

public class AdminVista implements ActionListener{
    private AltaUsuario aUsuario;
    private AltaAsignatura aAsignatura;
    private MatricularAlumno mAlumno;
    private Formulario form;
    private Administrador admin;
    private String tarea;

    // Constructor
    public AdminVista(Administrador admin) {
        this.admin = admin;
    }
    
    // Open Functions
    public void abrirUsuario(){
        tarea = "aUsuario";
        aUsuario = new AltaUsuario();
        aUsuario.setTitle("Formulario de administrador/AltaUsuario");
        aUsuario.setLocationRelativeTo(null);
        aUsuario.setVisible(true);
        aUsuario.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        aUsuario.getLabelEstado().setText("Preparado");
        
        
        aUsuario.getRadioAdmin().addActionListener(this);
        aUsuario.getRadioAlumn().addActionListener(this);
        aUsuario.getRadioProfe().addActionListener(this);
        
        aUsuario.getButtonAlta().addActionListener(this);
        aUsuario.getButtonBuscar().addActionListener(this);
        aUsuario.getButtonBaja().addActionListener(this);
        aUsuario.getButtonModificar().addActionListener(this);
        aUsuario.getButtonReturn().addActionListener(this);
    }
    
    public void abrirAsignatura(){
        tarea = "aAsignatura";
        aAsignatura = new AltaAsignatura();
        aAsignatura.setTitle("Formulario de administrador/AltaAsignatura");
        aAsignatura.setLocationRelativeTo(null);
        aAsignatura.setVisible(true);
        aAsignatura.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        aAsignatura.getLabelEstado().setText("Preparado");
        
        aAsignatura.getButtonAlta().addActionListener(this);
        aAsignatura.getButtonBuscar().addActionListener(this);
        aAsignatura.getButtonBaja().addActionListener(this);
        aAsignatura.getButtonModificar().addActionListener(this);
        aAsignatura.getButtonReturn().addActionListener(this);
    }
    
    public void abrirMatricular(){
        tarea = "mAlumno";
        mAlumno = new MatricularAlumno();
        mAlumno.setTitle("Formulario de administrador/MatricularAlumno");
        mAlumno.setLocationRelativeTo(null);
        mAlumno.setVisible(true);
        mAlumno.getLabelNombreUsuario().setText("Se ha conectado como Admin");
        mAlumno.getLabelEstado().setText("Preparado");
        
        mAlumno.getButtonMatricular().addActionListener(this);
        mAlumno.getButtonReturn().addActionListener(this);
    }
    
    // Listener Functions
    public void actionUsuario(ActionEvent ae){
        if (ae.getSource() == aUsuario.getButtonAlta()) {
            aUsuario.getLabelEstado().setText(aUsuario());
        }
        if (ae.getSource() == aUsuario.getButtonBuscar()) {
            aUsuario.getLabelEstado().setText(buUsuario());
        }
        if (ae.getSource() == aUsuario.getButtonBaja()) {
            aUsuario.getLabelEstado().setText(bUsuario());
        }
        if (ae.getSource() == aUsuario.getButtonModificar()) {
            aUsuario.getLabelEstado().setText(mUsuario());
        }
        
        if (ae.getSource() == aUsuario.getButtonReturn()) {
            aUsuario.getLabelEstado().setText("Bye bye!");
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.aUsuario.dispose();
        }
    }
    
    public void actionAsignatura(ActionEvent ae){
        if (ae.getSource() == aAsignatura.getButtonAlta()) {
            aAsignatura.getLabelEstado().setText(aAsignatura());
        }
        if (ae.getSource() == aAsignatura.getButtonBuscar()) {
            aAsignatura.getLabelEstado().setText(buAsignatura());
        }
        if (ae.getSource() == aAsignatura.getButtonBaja()) {
            aAsignatura.getLabelEstado().setText(bAsignatura());
        }
        if (ae.getSource() == aAsignatura.getButtonModificar()) {
            aAsignatura.getLabelEstado().setText(mAsignatura());
        }
        
        if (ae.getSource() == aAsignatura.getButtonReturn()) {
            aAsignatura.getLabelEstado().setText("Bye bye!");
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.aAsignatura.dispose();
        }
    }
    
    public void actionMalumno(ActionEvent ae){
        if (ae.getSource() == mAlumno.getButtonMatricular()) {
            mAlumno.getLabelEstado().setText(mAlumno());
        }
        
        if (ae.getSource() == mAlumno.getButtonReturn()) {
            mAlumno.getLabelEstado().setText("Bye bye!");
            form = new Formulario(admin);
            form.abrirInterfaz();
            this.mAlumno.dispose();
        }
    }
    
    // Operation Functions
    public String aUsuario(){
        if (aUsuario.getRadioAdmin().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String email = aUsuario.getFieldEmail().getText();
            if (admin.altaUsuario(new Administrador(login,clave,email))) {
                return "Admin agregado";
            }else{
                return "Usuario ya está agregado o tiene datos erróneos";
            }
        }
        if (aUsuario.getRadioAlumn().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String nombre = aUsuario.getFieldNombre().getText();
            String apellidos = aUsuario.getFieldApellidos().getText();
            String nivel = aUsuario.getFieldNivel().getText();
            if (admin.altaUsuario(new Alumno(login,clave,nombre,apellidos),nivel)) {
                return "Alumno agregado";
            }else{
                return "Alumno ya está agregado o tiene datos erróneos";
            }
        }
        if (aUsuario.getRadioProfe().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String nombre = aUsuario.getFieldNombre().getText();
            String apellidos = aUsuario.getFieldApellidos().getText();
            String email = aUsuario.getFieldEmail().getText();
            int especialista = Integer.parseInt(aUsuario.getFieldEspecialista().getText());
            if (admin.altaUsuario(new Profesor(login, clave, nombre, apellidos, email, especialista))) {
                return "Profesor agregado";
            }else{
                return "Profesor ya está agregado o tiene datos erróneos";
            }
        }
        return "Ninguna operación hecha";
    }
    public String buUsuario(){
        if (aUsuario.getRadioAdmin().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Administrador buscado = admin.buscarAdmin(login);
            if (buscado.getId() == 0) {
                return "Administrador no encontrado";
            }
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldEmail().setText(buscado.getEmail());
            aUsuario.getFieldNombre().setText("");
            aUsuario.getFieldApellidos().setText("");
            aUsuario.getFieldNivel().setText("");
            aUsuario.getFieldEspecialista().setText("");
            if (buscado.getId() != 0) {
                return "Administrador encontrado";
            }
        }
        if (aUsuario.getRadioAlumn().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Alumno buscado = admin.buscarAlumn(login);
            if (buscado.getId() == 0) {
                return "Alumno no encontrado";
            }
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldNombre().setText(buscado.getNombre());
            aUsuario.getFieldApellidos().setText(buscado.getApellidos());
            aUsuario.getFieldNivel().setText(buscado.getNivel());
            aUsuario.getFieldEmail().setText("");
            aUsuario.getFieldEspecialista().setText("");
            if (buscado.getId() != 0) {
                return "Alumno encontrado";
            }
        }
        if (aUsuario.getRadioProfe().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Profesor buscado = admin.buscarProfe(login);
            if (buscado.getId() == 0) {
                return "Profesor no encontrado";
            }
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldNombre().setText(buscado.getNombre());
            aUsuario.getFieldApellidos().setText(buscado.getApellidos());
            aUsuario.getFieldEmail().setText(buscado.getEmail());
            aUsuario.getFieldEspecialista().setText(Integer.toString(buscado.getEspecialista()));
            aUsuario.getFieldNivel().setText("");
            if (buscado.getId() != 0) {
                return "Profesor encontrado";
            }
        }
        return "Ninguna operación hecha";
    }
    public String bUsuario(){
        if (aUsuario.getRadioAdmin().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Administrador buscado = admin.buscarAdmin(login);
            if (buscado.getId() == 0) {
                return "Administrador no encontrado";
            }
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldEmail().setText(buscado.getEmail());
            aUsuario.getFieldNombre().setText("");
            aUsuario.getFieldApellidos().setText("");
            aUsuario.getFieldNivel().setText("");
            aUsuario.getFieldEspecialista().setText("");
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar al usuario?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                admin.bajaUsuario(buscado.getId(), "administrador");
                return "Administrador eliminado";
            }else{
                return "Administrador no eliminado";
            }
        }
        if (aUsuario.getRadioAlumn().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Alumno buscado = admin.buscarAlumn(login);
            if (buscado.getId() == 0) {
                return "Alumno no encontrado";
            }
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldNombre().setText(buscado.getNombre());
            aUsuario.getFieldApellidos().setText(buscado.getApellidos());
            aUsuario.getFieldNivel().setText(buscado.getNivel());
            aUsuario.getFieldEmail().setText("");
            aUsuario.getFieldEspecialista().setText("");
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar al usuario?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                admin.bajaUsuario(buscado.getId(), "alumno");
                return "Alumno eliminado";
            }else{
                return "Alumno no eliminado";
            }
        }
        if (aUsuario.getRadioProfe().isSelected()) {
            String login = aUsuario.getFieldLogin().getText();
            Profesor buscado = admin.buscarProfe(login);
            if (buscado.getId() == 0) {
                return "Profesor no encontrado";
            }
            aUsuario.getFieldId().setText(Integer.toString(buscado.getId()));
            aUsuario.getFieldContrasena().setText(buscado.getContrasena());
            aUsuario.getFieldNombre().setText(buscado.getNombre());
            aUsuario.getFieldApellidos().setText(buscado.getApellidos());
            aUsuario.getFieldEmail().setText(buscado.getEmail());
            aUsuario.getFieldEspecialista().setText(Integer.toString(buscado.getEspecialista()));
            aUsuario.getFieldNivel().setText("");
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar al usuario?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                admin.bajaUsuario(buscado.getId(), "profesor");
                return "Profesor eliminado";
            }else{
                return "Profesor no eliminado";
            }
        }
        return "Ninguna operación hecha";
    }
    public String mUsuario(){
        if (aUsuario.getRadioAdmin().isSelected()) {
            int id = Integer.parseInt(aUsuario.getFieldId().getText());
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String email = aUsuario.getFieldEmail().getText();
            if (admin.modificarUsuario(new Administrador(id,login,clave,email,admin.getCon()))) {
                return "Administrador modificado";
            }else{
                return "Error al modificar, revise si los datos están correctos";
            }
        }
        if (aUsuario.getRadioAlumn().isSelected()) {
            int id = Integer.parseInt(aUsuario.getFieldId().getText());
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String nombre = aUsuario.getFieldNombre().getText();
            String apellidos = aUsuario.getFieldApellidos().getText();
            String nivel = aUsuario.getFieldNivel().getText();
            if (admin.modificarUsuario(new Alumno(id,login,clave,nombre,apellidos,admin.getCon()),nivel)) {
                return "Alumno modificado";
            }else{
                return "Error al modificar, revise si los datos están correctos";
            }
        }
        if (aUsuario.getRadioProfe().isSelected()) {
            int id = Integer.parseInt(aUsuario.getFieldId().getText());
            String login = aUsuario.getFieldLogin().getText();
            String clave = aUsuario.getFieldContrasena().getText();
            String nombre = aUsuario.getFieldNombre().getText();
            String apellidos = aUsuario.getFieldApellidos().getText();
            String email = aUsuario.getFieldEmail().getText();
            int especialista = Integer.parseInt(aUsuario.getFieldEspecialista().getText());
            if (admin.modificarUsuario(new Profesor(id,login, clave, nombre, apellidos, email, especialista,admin.getCon()))) {
                return "Profesor modificado";
            }else{
                return "Error al modificar, revise si los datos están correctos";
            }
        }
        return "Ninguna operación hecha";
    }
    
    public String aAsignatura(){
        int id = Integer.parseInt(aAsignatura.getFieldId().getText());
        String nombre = aAsignatura.getFieldNombre().getText();
        String nivel = aAsignatura.getFieldNivel().getText();
        String profesor = aAsignatura.getFieldProfesor().getText();
        if (admin.altaAsignatura(new Asignatura(id,nombre),nivel,profesor)) {
            return "Asignatura agregada";
        }else{
            return "Asignatura ya está agregada o tiene datos erróneos";
        }
    }
    public String buAsignatura(){
        String id = aAsignatura.getFieldId().getText();
        ArrayList<String> buscado = admin.buscarAsignatura(id);
        if (buscado.get(0) == "noA") {
            return "No existe la asignatura";
        }
        if (buscado.get(0) == "errA") {
            return "Error al buscar asignatura";
        }
        aAsignatura.getFieldId().setText(id);
        aAsignatura.getFieldNombre().setText(buscado.get(3));
        aAsignatura.getFieldNivel().setText(buscado.get(1));
        aAsignatura.getFieldProfesor().setText(buscado.get(2));
        return "Asignatura encontrada";
    }
    public String bAsignatura(){
        String id = aAsignatura.getFieldId().getText();
        ArrayList<String> buscado = admin.buscarAsignatura(id);
        if (buscado.get(0) == "noA") {
            return "No existe la asignatura";
        }
        if (buscado.get(0) == "errA") {
            return "Error al buscar asignatura";
        }
        aAsignatura.getFieldId().setText(id);
        aAsignatura.getFieldNombre().setText(buscado.get(3));
        aAsignatura.getFieldNivel().setText(buscado.get(1));
        aAsignatura.getFieldProfesor().setText(buscado.get(2));
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de querer eliminar la asignatura?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            admin.bajaAsignatura(Integer.parseInt(id));
            return "Asignatura eliminada";
        }else{
            return "Asignatura no eliminada";
        }
    }
    public String mAsignatura(){
        int id = Integer.parseInt(aAsignatura.getFieldId().getText());
        String nombre = aAsignatura.getFieldNombre().getText();
        String nivel = aAsignatura.getFieldNivel().getText();
        String profesor = aAsignatura.getFieldProfesor().getText();
        if (admin.modificarAsignatura(new Asignatura(id,nombre),nivel,profesor)) {
            return "Asignatura Modificada";
        }else{
            return "Error al modificar, revise si los datos están correctos";
        }
    }
    
    public String mAlumno(){
        String alumno_id = mAlumno.getFieldId().getText();
        String asignatura_id = mAlumno.getFieldAsignatura().getText();
        if (admin.matricularAlumno(alumno_id,asignatura_id)) {
            return "Alumno matriculado";
        }else{
            return "Alumno ya está matriculado o tiene datos erróneos";
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (tarea){
                case "aUsuario":
                    this.actionUsuario(ae);
                    break;
                case "aAsignatura":
                    this.actionAsignatura(ae);
                    break;
                case "mAlumno":
                    this.actionMalumno(ae);
                    break;
                default:
                    System.out.println("Graves problemas");
                    break;
        }
    }
}