package view;

import java.util.List; // Lista genérica de dados
import model.Sprint;
import banco.SprintBanco;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class telaProjeto {

    protected Shell shell;

    public static void main(String[] args) {
        try {
            telaProjeto window = new telaProjeto();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    protected void createContents() {
        shell = new Shell();
        shell.setSize(450, 300);
        shell.setText("SWT Application");
        
        Label lblProjetos = new Label(shell, SWT.NONE);
        lblProjetos.setBounds(190, 25, 55, 15);
        lblProjetos.setText("Projeto 1");
        
        // Usa o nome completo para evitar conflito
        org.eclipse.swt.widgets.List listSprint = new org.eclipse.swt.widgets.List(shell, SWT.BORDER);
        listSprint.setBounds(165, 59, 240, 174);
        
        Button btnBacklog = new Button(shell, SWT.NONE);
        btnBacklog.setBounds(51, 105, 75, 61);
        btnBacklog.setText("Backlog");
        
     // Adicionar o SelectionListener ao botão
        btnBacklog.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                openBacklogScreen();
            }
        });

        // Carregar os sprints do banco de dados
        SprintBanco sprintBanco = new SprintBanco();
        List<Sprint> sprints = sprintBanco.consultarProjeto(1);
        
        // Adicionar os sprints à lista
        for (Sprint sprint : sprints) {
            listSprint.add(sprint.getNomeSprint() + " - " + "\n" + sprint.getDataInicio() + "\n" + " a " + sprint.getDataFim());
        }
    }
    
    private void openBacklogScreen() {
        // Cria uma nova tela
        telaBacklog backlogScreen = new telaBacklog();
        backlogScreen.open();

        // Fecha a tela atual
        shell.dispose();
    }
}
