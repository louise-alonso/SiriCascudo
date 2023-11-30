import excecoes.comanda.ComandaJaExisteException;
import excecoes.comanda.ComandaNaoExisteException;
import excecoes.comanda.ListaComandasVaziaException;
import excecoes.pedido.ListaPedidosVaziaException;
import excecoes.pedido.PedidoNaoExisteException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProgramaSiri {
    private static SiriCascudoList siriSystem = new SiriCascudoList();
    private static int numComanda = 0;

    public static void main(String[] args) {

        int escolha = -1;
        while (escolha != 2) {
            String[] opcoesIniciais = {"Pedidos",
                    "Comanda",
                    "Sair"};

            escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "SiriCascudoSystem",
                    0, JOptionPane.PLAIN_MESSAGE, null, opcoesIniciais, opcoesIniciais[0]);

            switch (escolha) {
                case 0:
                    int escolhaPedido = -1;
                    while (escolhaPedido != 3) {
                        String[] opcoesPedido = {"Registrar Pedido",
                                "Exibir Pedidos",
                                "Apagar Pedido",
                                "Voltar"};

                        escolhaPedido = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                                "SiriCascudoSystem/Pedidos",
                                0, JOptionPane.PLAIN_MESSAGE, null, opcoesPedido, opcoesPedido[0]);

                        switch (escolhaPedido) {
                            case 0:
                                registrarPedido();
                                break;
                            case 1:
                                try {
                                    exibirListaPedidos(siriSystem.listarPedidos());
                                } catch (ListaPedidosVaziaException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    int idASerApagado = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Insira o ID da comanda do pedido a ser apagado:"));

                                    if(siriSystem.apagarPedido(idASerApagado)){
                                        JOptionPane.showMessageDialog(null, "Pedido exluído com sucesso!");
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Dado inválido, por favor tente novamente!");
                                } catch (PedidoNaoExisteException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }break;
                        }
                    }
                    break;

                case 1:
                    int escolhaComanda = -1;
                    while (escolhaComanda != 3) {
                        String[] opcoesComanda = {"Registrar Comanda",
                                "Exibir Comandas",
                                "Apagar Comandas",
                                "Voltar"};

                        escolhaComanda = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                                "SiriCascudoSystem/Comandas",
                                0, JOptionPane.PLAIN_MESSAGE, null, opcoesComanda, opcoesComanda[0]);

                        switch (escolhaComanda) {
                            case 0:
                                registrarComanda();
                                break;

                            case 1:
                                try {
                                    exibirListaComandas(siriSystem.listarComandas());
                                } catch (ListaComandasVaziaException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }
                                break;
                            case 2:
                                try {
                                    int idASerApagado = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "Insira o ID da comanda a ser apagada:"));

                                    if(siriSystem.apagarComanda(idASerApagado)){
                                        JOptionPane.showMessageDialog(null, "Comanda exluída com sucesso!");
                                    }
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Dado inválido, por favor tente novamente!");
                                } catch (ComandaNaoExisteException e) {
                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                }break;
                        }
                    }
                    break;
            }
        }
    }

    private static void registrarPedido() {
        int escolhaHamburguer = -1;

        String[] opcoesHamburguer = {"Hamburguer de Siri",
                "Hamburguer-Cheddar de Siri ",
                "Frango de Siri",
                "Voltar"};

        escolhaHamburguer = JOptionPane.showOptionDialog(null, "Escolha uma opção:",
                "SiriCascudoSystem/Pedidos/Hamburguer",
                0, JOptionPane.PLAIN_MESSAGE, null, opcoesHamburguer, opcoesHamburguer[0]);

        if (escolhaHamburguer != 3) {
            Hamburguer hamburguerDoPedido = new Hamburguer();

            switch (escolhaHamburguer) {
                case 0:
                    hamburguerDoPedido = criarJanelaHamburguer("Hamburguer de Siri", CodigoPedido.HAMBURGUER);
                    break;
                case 1:
                    hamburguerDoPedido = criarJanelaHamburguer("Cheddar de Siri", CodigoPedido.HAMBURGUERCHEDDAR);
                    break;
                case 2:
                    hamburguerDoPedido = criarJanelaHamburguer("Frango de Siri", CodigoPedido.HAMBURGUERFRANGO);
                    break;
            }

            String[] cardapioBebidas = {"Coca-Cola",
                    "Guaraná-Antártica",
                    "Água",
                    "Suco de Laranja"};
            numComanda += 1;

            JComboBox<String> bebidaComboBox = new JComboBox<>(cardapioBebidas);
            JCheckBox comboCheckBox = new JCheckBox("Combo");

            JSpinner quantidadeSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 20, 1));
            JComponent editor = quantidadeSpinner.getEditor();
            if (editor instanceof JSpinner.DefaultEditor) {
                JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
                spinnerEditor.getTextField().setEditable(false);
            }

            JLabel numComandaLabel = new JLabel("Número da Comanda: " + numComanda);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            panel.add(new JLabel("Bebida: "));
            panel.add(bebidaComboBox);
            panel.add(comboCheckBox);
            panel.add(new JLabel("Quantidade: "));
            panel.add(quantidadeSpinner);
            panel.add(numComandaLabel);

            int result = JOptionPane.showConfirmDialog(null, panel, "Faça seu pedido",
                    JOptionPane.OK_CANCEL_OPTION);

            // Processamento dos dados ao clicar em "OK"
            if (result == JOptionPane.OK_OPTION) {
                String selectedBebida = (String) bebidaComboBox.getSelectedItem();
                boolean isCombo = comboCheckBox.isSelected();
                int quantidade = (int) quantidadeSpinner.getValue();

                Pedido pedido = new Pedido(hamburguerDoPedido, selectedBebida, isCombo, quantidade, numComanda);
                siriSystem.registrarPedido(pedido);
                JOptionPane.showMessageDialog(null, "Pedido registrado com sucesso!");
            }
        }
    }

    private static Hamburguer criarJanelaHamburguer(String titulo, CodigoPedido codigoPedido) {
        Hamburguer hamburguerCardapio = new Hamburguer(true, true, true, codigoPedido);

        JCheckBox alfaceCheckBox = new JCheckBox("Alface");
        JCheckBox tomateCheckBox = new JCheckBox("Tomate");
        JCheckBox cebolaCheckBox = new JCheckBox("Cebola");
        JLabel descricaoLabel = new JLabel(hamburguerCardapio.toString());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(alfaceCheckBox);
        panel.add(tomateCheckBox);
        panel.add(cebolaCheckBox);
        panel.add(descricaoLabel);

        alfaceCheckBox.setSelected(true);
        tomateCheckBox.setSelected(true);
        cebolaCheckBox.setSelected(true);

        int resultado = JOptionPane.showConfirmDialog(null, panel, titulo, JOptionPane.OK_CANCEL_OPTION);

        Hamburguer hamburguerPedido = new Hamburguer();
        // Processamento dos dados ao clicar em "OK"
        if (resultado == JOptionPane.OK_OPTION) {
            boolean isAlface = alfaceCheckBox.isSelected();
            boolean isTomate = tomateCheckBox.isSelected();
            boolean isCebola = cebolaCheckBox.isSelected();
            hamburguerPedido = new Hamburguer(isAlface, isTomate, isCebola, codigoPedido);
            JOptionPane.showMessageDialog(null, "Hamburguer escolhido:\n" + hamburguerPedido.toString());
        }
        return hamburguerPedido;
    }

    private static void exibirListaPedidos(List<Pedido> listaPedidos) {
        StringBuilder listaPedidosStr = new StringBuilder("-----------------------------------------------------------\n");
        for (Pedido pedido : listaPedidos) {
            listaPedidosStr.append("Pedido de Comanda: ").append(pedido.getNumComanda()).append("\n");
            listaPedidosStr.append(pedido.getHamburguer().toString()).append("\n");
            listaPedidosStr.append("Bebida: ").append(pedido.getBebida()).append("\n");
            listaPedidosStr.append("Quantidade: ").append(pedido.getQuantidade()).append("\n");
            listaPedidosStr.append("Valor do Pedido: ").append(pedido.calcularValorTotal()).append("\n");
            listaPedidosStr.append("-----------------------------------------------------------\n");
        }
        JOptionPane.showMessageDialog(null, listaPedidosStr.toString(), "Lista de Pedidos", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void registrarComanda() {

        ArrayList<Integer> listaIdPedidos = new ArrayList<>();
        for (Pedido pedido : siriSystem.getPedidos()) {
            listaIdPedidos.add(pedido.getNumComanda());
        }

        String[] tiposPagamento = {"Crédito", "Débito", "Pix"};

        JComboBox<Integer> idPedidosComboBox = new JComboBox<>(listaIdPedidos.toArray(new Integer[0]));
        JComboBox<String> pagamentoComboBox = new JComboBox<>(tiposPagamento);

        JLabel dataLabel = new JLabel("Data: " + new Date()); // Data do sistema

        JLabel numComandaLabel = new JLabel("Número da Comanda: " + numComanda);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("ID do Pedido: "));
        panel.add(idPedidosComboBox);
        panel.add(new JLabel("Tipo de pagamento: "));
        panel.add(pagamentoComboBox);
        panel.add(dataLabel);
        panel.add(numComandaLabel);

        int result = JOptionPane.showConfirmDialog(null, panel, "Registrar Comanda", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            int selectedIdPedido = (int) idPedidosComboBox.getSelectedItem();
            String selectedTipoPagamento = (String) pagamentoComboBox.getSelectedItem();
            String data = dataLabel.getText();
            Comanda comanda = new Comanda();
            for(Pedido p: siriSystem.getPedidos()){
                if(p.getNumComanda() == selectedIdPedido){
                    comanda = new Comanda(p,selectedTipoPagamento,data,selectedIdPedido);
                }
            }

            try{
                siriSystem.criarComanda(comanda);
                JOptionPane.showMessageDialog(null, "Comanda registrada com sucesso!");
            }catch(ComandaJaExisteException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }

    private static void exibirListaComandas(List<Comanda> listaComandas) {
        StringBuilder listaComandasStr = new StringBuilder("-----------------------------------------------------------\n");
        for (Comanda comanda : listaComandas) {
            listaComandasStr.append(comanda.toString()).append("\n");
            listaComandasStr.append("-----------------------------------------------------------\n");
        }
        JOptionPane.showMessageDialog(null, listaComandasStr.toString(), "Lista de Comandas", JOptionPane.INFORMATION_MESSAGE);
    }
}
