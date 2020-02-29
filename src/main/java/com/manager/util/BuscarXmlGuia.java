package com.manager.util;

import com.manager.entity.Guia;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.springframework.stereotype.Component;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Component
public class BuscarXmlGuia {

    public List<Guia> dadosGuia() {
        
        List<Guia> listGuia = new ArrayList<>();
        
        try {
            URL url = new URL("https://glosamax.zeroglosa.com.br/glosamax/arquivo/download?nome=glosamax_2018-02-15.xml&data=2018-02-15");
            URLConnection conn = url.openConnection();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document doc = builder.parse(conn.getInputStream());
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("row");
            
            Guia guia;
            
            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                guia = new Guia();
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element eElement = (Element) node;
                    
                    guia.setConvenio(eElement.getElementsByTagName("convenio").item(0).getTextContent());
                    Date data=new SimpleDateFormat("yyyy-MM-dd").parse(eElement.getElementsByTagName("data_pagamento").item(0).getTextContent());
                    guia.setDataPagamento(data);
                    guia.setNumeroProtocolo(eElement.getElementsByTagName("numero_protocolo").item(0).getTextContent());
                    guia.setMatricula(eElement.getElementsByTagName("matricula").item(0).getTextContent());
                    guia.setNome(eElement.getElementsByTagName("nome").item(0).getTextContent());
                    guia.setNgPrest(eElement.getElementsByTagName("ng_prest").item(0).getTextContent());
                    guia.setSenhaGuia(eElement.getElementsByTagName("senha_guia").item(0).getTextContent());
                    guia.setCodigoProduto(eElement.getElementsByTagName("codigo_produto").item(0).getTextContent());
                    guia.setDescricaoProduto(eElement.getElementsByTagName("descricao_produto").item(0).getTextContent());
                    guia.setValorApresentado(eElement.getElementsByTagName("valor_apresentado").item(0).getTextContent());
                    guia.setValorPago(new BigDecimal(eElement.getElementsByTagName("valor_pago").item(0).getTextContent()));
                    guia.setValorGlosa(new BigDecimal(eElement.getElementsByTagName("valor_glosa").item(0).getTextContent()));
                    guia.setDescricaoMotivo(eElement.getElementsByTagName("descricao_motivo").item(0).getTextContent());
                    guia.setCodigoMotivo(eElement.getElementsByTagName("codigo_motivo").item(0).getTextContent());
                    listGuia.add(guia);
                    //System.out.println("Employee id : " + eElement.getAttribute("id"));
                    //System.out.println("First Name : " + eElement.getElementsByTagName("convenio").item(0).getTextContent());
                    //System.out.println("Last Name : " + eElement.getElementsByTagName("data_pagamento").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("numero_protocolo").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("matricula").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("nome").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("ng_prest").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("senha_guia").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("codigo_produto").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("descricao_produto").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("valor_apresentado").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("valor_pago").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("valor_glosa").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("descricao_motivo").item(0).getTextContent());
                    //System.out.println("Location : " + eElement.getElementsByTagName("codigo_motivo").item(0).getTextContent());
                    //System.out.println("\n\n\n");

                }
            }
        } catch(DOMException | IOException | ParserConfigurationException | SAXException | ParseException e) {
            throw new RuntimeException(e);
        }
        return listGuia;
    }
}
