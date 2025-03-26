import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {

    private final Map<String, Double> TAXAS_CAMBIO = new HashMap<>();
    private JTextField campoValor;
    private JComboBox<String> comboMoedas;
    private JLabel labelResultado;

    public MainFrame() {
        super("Conversor de Moedas - By SilencioPz");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);

        adicionarPainelStatus();
        inicializarTaxas();
        initUI();
    }

    private void inicializarTaxas() {
            TAXAS_CAMBIO.put("Dólar", 5.20);
            TAXAS_CAMBIO.put("Euro", 5.60);
            TAXAS_CAMBIO.put("Libra", 7.36);
            TAXAS_CAMBIO.put("Yene", 0.038);
            TAXAS_CAMBIO.put("Dólar Australiano", 3.58);
            TAXAS_CAMBIO.put("Dólar Canadense", 3.97);
            TAXAS_CAMBIO.put("Franco Suíço", 6.44);
            TAXAS_CAMBIO.put("Yuan", 0.784);
            TAXAS_CAMBIO.put("Peso Argentino", 0.005);
            TAXAS_CAMBIO.put("Bitcoin",250000.00);
    }

    private void initUI() {
        JPanel painelPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        adicionarLogo(painelPrincipal, gbc);

        gbc.gridy = 1;
        adicionarPainelInput(painelPrincipal, gbc);

        gbc.gridy = 2;
        adicionarPainelMoedas(painelPrincipal, gbc);

        gbc.gridy = 3;
        adicionarPainelResultado(painelPrincipal, gbc);

        add(painelPrincipal);
    }

    private void adicionarLogo(JPanel painelPrincipal, GridBagConstraints gbc) {
        try {
            ImageIcon logoIcon = new ImageIcon(getClass().getResource("/images/silenciopz-logo-150.png"));
            JLabel logoLabel = new JLabel(logoIcon);
            logoLabel.setHorizontalAlignment(JLabel.CENTER);

            gbc.gridy = 0;
            painelPrincipal.add(logoLabel, gbc);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Logo não carregada: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adicionarPainelInput(JPanel painelPrincipal, GridBagConstraints gbc) {
        JPanel painelInput = new JPanel();
        configurarCores(painelInput);
        JLabel labelValor = new JLabel("Valor em BRL (R$):");
        labelValor.setFont(configurarFonte());

        campoValor = new JTextField(15);
        campoValor.setFont(configurarFonte());

        painelInput.add(labelValor);
        painelInput.add(campoValor);
        painelPrincipal.add(painelInput, gbc);
    }

    private void adicionarPainelMoedas(JPanel painelPrincipal, GridBagConstraints gbc) {
        JPanel painelMoedas = new JPanel();
        configurarCores(painelMoedas);
        comboMoedas = new JComboBox<>(TAXAS_CAMBIO.keySet().toArray(new String[0]));
        comboMoedas.setFont(configurarFonte());
        comboMoedas.setPreferredSize(new Dimension(300, 40));

        JLabel labelMoeda = new JLabel("Moeda Destino:");
        labelMoeda.setFont(configurarFonte());

        painelMoedas.add(labelMoeda);
        painelMoedas.add(comboMoedas);
        painelPrincipal.add(painelMoedas, gbc);
    }

    private void adicionarPainelResultado(JPanel painelPrincipal, GridBagConstraints gbc) {
        JPanel painelResultado = new JPanel();
        configurarCores(painelResultado);
        JButton botaoConverter = new JButton("Converter");
        botaoConverter.setFont(configurarFonte());

        labelResultado = new JLabel("Resultado aparecerá aqui...");
        labelResultado.setFont(configurarFonte());

        botaoConverter.addActionListener(e -> converterMoeda());

        painelResultado.add(botaoConverter);
        painelResultado.add(labelResultado);
        painelPrincipal.add(painelResultado, gbc);
    }

    private void converterMoeda() {
        try {
            double valorBRL = Double.parseDouble(campoValor.getText());
            String moedaDestino = (String) comboMoedas.getSelectedItem();
            double taxa = TAXAS_CAMBIO.get(moedaDestino);
            double valorConvertido = valorBRL / taxa;

            DecimalFormat df = new DecimalFormat("#,##0.0000");
            String resultado = df.format(valorBRL) + " BRL = " + df.format(valorConvertido) + " " + moedaDestino;
            labelResultado.setText(resultado);
        } catch (NumberFormatException ex) {
            labelResultado.setText("Erro: Digite um número válido!");
        }
    }

    private Font configurarFonte() {
        return new Font("Serif", Font.PLAIN, 25);
    }

    private void configurarCores(Component component) {
        component.setBackground(Color.BLACK);
        component.setForeground(Color.WHITE);

        if (component instanceof JComboBox) {
            JComboBox<?> combo = (JComboBox<?>) component;
            combo.setBackground(new Color(30, 30, 30)); // Cinza escuro pro combobox
            combo.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    setBackground(isSelected ? Color.DARK_GRAY : new Color(30, 30, 30));
                    setForeground(Color.WHITE);
                    return this;
                }
            });
        }

        if (component instanceof JButton) {
            JButton button = (JButton) component;
            button.setBackground(new Color(70, 70, 70)); // Cinza médio pro botão
            button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        }
    }

    private void adicionarPainelStatus() {
        JLabel labelStatus = new JLabel("Cotações de 25/03/2025.");
        labelStatus.setFont(new Font("Serif", Font.ITALIC, 25));
        labelStatus.setForeground(Color.YELLOW);
        add(labelStatus, BorderLayout.SOUTH);
    }

    // Método AUXILIAR para testes (não usar na interface)
    public double converterMoedaTeste(double valorBRL, String moedaDestino) {
        return valorBRL / TAXAS_CAMBIO.get(moedaDestino);
    }
}