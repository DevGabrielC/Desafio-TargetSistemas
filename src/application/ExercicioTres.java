package src.application;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class ExercicioTres {

    public static void main(String[] args) {
        try {
            // Carregar arquivo XML
            File file = new File("dados.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("row");

            double menor = 0;
            double maior = 0;
            double soma = 0;
            int diasComFaturamento = 0;
            int diasAcimaMedia = 0;

            // Primeira passada para calcular soma e contar dias com faturamento
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());

                    if (valor > 0) {
                        diasComFaturamento++;
                        soma += valor;

                        if (valor < menor) {
                            menor = valor;
                        }
                        if (valor > maior) {
                            maior = valor;
                        }
                    }
                }
            }

            double media = soma / diasComFaturamento;

            // Segunda passada para contar dias acima da média
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());

                    if (valor > media) {
                        diasAcimaMedia++;
                    }
                }
            }

            System.out.printf(String.format("Menor valor de faturamento: R$%.2f%n", menor));
            System.out.printf(String.format("Maior valor de faturamento: R$%.2f%n", maior));
            System.out.printf(String.format("Número de dias com faturamento acima da média: %d", diasAcimaMedia));

        } catch (Exception e) {
            System.out.println("Erro ao processar o arquivo XML: " + e.getMessage());
        }
    }
}