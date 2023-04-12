import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoApp extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> todoList;
    private JTextField inputField;
    private JButton addButton;
    private JButton removeButton;

    public TodoApp() {
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 300));

        // Create list model and JList
        listModel = new DefaultListModel<>();
        todoList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(todoList);
        add(scrollPane, BorderLayout.CENTER);

        // Create input field and add button
        inputField = new JTextField();
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = inputField.getText();
                if (!item.isEmpty()) {
                    listModel.addElement(item);
                    inputField.setText("");
                }
            }
        });

        // Create remove button
        removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Create panel for input field and buttons
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        inputPanel.add(removeButton, BorderLayout.WEST);
        add(inputPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TodoApp();
            }
        });
    }
}
