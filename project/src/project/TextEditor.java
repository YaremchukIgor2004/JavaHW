package project;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Головний клас графічного текстового редактора.
 *
 * Розробник: Яремчук Ігор
 * Дата останнього патча: 30.11.2024
 * Час останнього патча: 22:17
 */
public class TextEditor extends JFrame {
    private JTextPane textPane; // Область для тексту.
    private JFileChooser fileChooser; // Діалог вибору файлів.

    /**
     * Конструктор для створення основного вікна текстового редактора.
     */
    public TextEditor() {
        // Налаштування вікна.
        setTitle("Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Ініціалізація текстової панелі.
        textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);

        // Налаштування меню.
        JMenuBar menuBar = new JMenuBar();

        // Меню "File".
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> openFile()); // Додати дію для відкриття файлу.
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> saveFile()); // Додати дію для збереження файлу.
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);

        // Меню "Tools".
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem analyzeTextItem = new JMenuItem("Analyze Text");
        analyzeTextItem.addActionListener(e -> analyzeText()); // Дія аналізу тексту.

        JMenuItem saveAsMarkdownItem = new JMenuItem("Save as Markdown");
        saveAsMarkdownItem.addActionListener(e -> saveAsMarkdown()); // Дія збереження у Markdown.

        JMenuItem saveAsHTMLItem = new JMenuItem("Save as HTML");
        saveAsHTMLItem.addActionListener(e -> saveAsHTML()); // Дія збереження у HTML.

        JMenuItem highlightSyntaxItem = new JMenuItem("Highlight Syntax");
        highlightSyntaxItem.addActionListener(e -> highlightSyntax()); // Дія підсвічування синтаксису.

        JMenuItem searchRegexItem = new JMenuItem("Search with Regex");
        searchRegexItem.addActionListener(e -> searchWithRegex()); // Дія пошуку за Regex.

        // Додавання пунктів до меню.
        toolsMenu.add(analyzeTextItem);
        toolsMenu.add(saveAsMarkdownItem);
        toolsMenu.add(saveAsHTMLItem);
        toolsMenu.add(highlightSyntaxItem);
        toolsMenu.add(searchRegexItem);
        menuBar.add(toolsMenu);

        // Додавання меню до вікна.
        setJMenuBar(menuBar);

        // Ініціалізація діалогу файлів.
        fileChooser = new JFileChooser();
        setVisible(true);
    }

    /**
     * Відкриває файл і відображає його в текстовій панелі.
     */
    private void openFile() {
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String content = FileHandler.readFile(file);
            textPane.setText(content); // Відображаємо вміст у текстовій панелі.
        }
    }

    /**
     * Зберігає вміст текстової панелі у файл.
     */
    private void saveFile() {
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            FileHandler.writeFile(file, textPane.getText());
            JOptionPane.showMessageDialog(this, "File saved: " + file.getName());
        }
    }

    /**
     * Зберігає вміст тексту у форматі Markdown.
     */
    private void saveAsMarkdown() {
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Formatter.saveAsMarkdown(textPane.getText(), file);
            JOptionPane.showMessageDialog(this, "Markdown saved: " + file.getName());
        }
    }

    /**
     * Зберігає вміст тексту у форматі HTML.
     */
    private void saveAsHTML() {
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Formatter.saveAsHTML(textPane.getText(), file);
            JOptionPane.showMessageDialog(this, "HTML saved: " + file.getName());
        }
    }

    /**
     * Аналізує текст і створює звіт.
     */
    private void analyzeText() {
        String report = TextAnalyzer.generateAnalysisReport(textPane.getText());
        File file = new File("analysis_report.txt");
        FileHandler.writeFile(file, report);
        JOptionPane.showMessageDialog(this, "Analysis report saved: analysis_report.txt");
    }

    /**
     * Застосовує підсвічування синтаксису на основі правил.
     */
    private void highlightSyntax() {
        File rulesFile = new File("resources/syntax-highlighting-rules.txt");
        if (!rulesFile.exists()) {
            JOptionPane.showMessageDialog(this, "Syntax highlighting rules not found.");
            return;
        }
        SyntaxHighlighter.applySyntaxHighlighting(textPane, rulesFile);
    }

    /**
     * Виконує пошук у тексті на основі регулярного виразу.
     */
    private void searchWithRegex() {
        String regex = JOptionPane.showInputDialog(this, "Enter Regex Pattern:");
        if (regex != null && !regex.isEmpty()) {
            String matches = RegexSearcher.findMatches(regex, textPane.getText());
            JOptionPane.showMessageDialog(this, matches, "Regex Search Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Запускає текстовий редактор.
     *
     * @param args аргументи командного рядка.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextEditor::new);
    }
}
