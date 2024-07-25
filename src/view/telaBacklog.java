package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class telaBacklog {

    protected Shell shell;

    public static void main(String[] args) {
        try {
            telaBacklog window = new telaBacklog();
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
        shell.setText("Tela Backlog");
        
        Button btnCriarTarefa = new Button(shell, SWT.NONE);
        btnCriarTarefa.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent arg0) {
        	}
        });
        btnCriarTarefa.setBounds(48, 159, 75, 25);
        btnCriarTarefa.setText("Criar Tarefa");
        // Adicione os controles e widgets necessários para a telaBacklog
    }
}
